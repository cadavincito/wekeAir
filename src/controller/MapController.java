package controller;

import java.util.ArrayList;
import java.util.Observable;

import exceptions.RouteNotSelectedException;
import javafx.scene.shape.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.City;
import model.WekeAir;

public class MapController {

	private WekeAir wekete;

	@FXML
	Pane pane;
	@FXML
	Circle origin;
	@FXML
	Circle destiny;

	
	private int fast = 0;
	
	@FXML
	private Button searchButton;

	@FXML
	private Label origin_box;

	@FXML
	private Label destination_box;

	private boolean originSelected;
	private boolean destinySelected;

	public void initialize() {

		wekete = new WekeAir();

		origin = new Circle();
		destiny = new Circle();

		fillFligths();
	}

	private void fillFligths() {

//		origin_box.getItems().addAll("Bogota", "Quito", "Brasilia", "La Paz", "Lima", "Asuncion", "Bs.As", "Montevideo",
//				"Santiago", "Guatemala", "San Salvador", "Tegucigalpa", "Managua", "San Jose", "Panama", "Belmopan",
//				"Caracas", "Georgetown", "Paramaribo", "Cayena", "Washington", "Otawa", "La Habana");
//
//		destination_box.getItems().addAll("Bogota", "Quito", "Brasilia", "La Paz", "Lima", "Asuncion", "Bs.As",
//				"Montevideo", "Santiago", "Guatemala", "San Salvador", "Tegucigalpa", "Managua", "San Jose", "Panama",
//				"Belmopan", "Caracas", "Georgetown", "Paramaribo", "Cayena", "Washington", "Otawa", "La Habana");

	}

	public void clicked(MouseEvent e) {

		String id = ((Circle) e.getSource()).getId();
		System.out.println(id);

		if (originSelected == true) {

			this.originSelected = false;
			origin.setFill(Color.RED);

			origin = (Circle) e.getSource();
			origin.setFill(Color.GREEN);
			
			origin_box.setText(origin.getId());

		}

		if (destinySelected == true) {

			this.destinySelected = false;
			destiny.setFill(Color.RED);

			destiny = (Circle) e.getSource();
			destiny.setFill(Color.GREEN);
			
			destination_box.setText(destiny.getId());

		}

	}

	public void origin() {

		origin.setOnMouseClicked(e -> {
			System.out.println("a");
		});
	}

	public void selectOrigin() {

		this.originSelected = true;
		genericAlert("Origin", "Please select your origin node.");
	}

	public void selectDestiny() {

		this.destinySelected = true;
		genericAlert("Destiny", "Please select your destiny node.");

	}

	@FXML
	void findCheapestFlight(ActionEvent event) {
		
		
		try {

			eraseRoutePaths();
			this.fast = 2;

			if (origin.getId() != null && destiny.getId() != null) {

				ArrayList<City> path = this.wekete.cheapestPath(origin.getId(), destiny.getId());

				String message = "";
				
				for (int i = 0; i < path.size() - 1; i++) {

					paintLine(circleId(path.get(i).getName()), circleId(path.get(i + 1).getName()));
					
					message +="["+path.get(i).getName()+" , "+path.get(i + 1).getName()+"]\n";
				}
				
				message+="\n"+"Cost: $"+this.wekete.cheapestPathCost(origin.getId(), destiny.getId());
				
				
				
				genericAlert("Route", message);
				
			} else {

				throw new RouteNotSelectedException("cheapest");
			}
		
			
		} catch (RouteNotSelectedException e) {

			genericAlert("Error", e.getMessage());

		}
	}

	@FXML
	void findFastestFlight(ActionEvent event) {

		eraseRoutePaths();

		try {

			if (origin.getId() != null && destiny.getId() != null) {

				ArrayList<City> path = this.wekete.fastestPath(origin.getId(), destiny.getId());

				String message = "";
			
				for (int i = 0; i < path.size() - 1; i++) {

					paintLine(circleId(path.get(i).getName()), circleId(path.get(i + 1).getName()));
					
					message +="["+path.get(i).getName()+" , "+path.get(i + 1).getName()+"]\n";
				}
				
				message+="\n"+"Cost: $"+this.wekete.fastesPathCost(origin.getId(), destiny.getId());
				
				this.fast = 1;
				
				genericAlert("Route", message);
				
			} else {

				throw new RouteNotSelectedException("fastest");
			}

		} catch (RouteNotSelectedException e) {

			genericAlert("Error", e.getMessage());

		}
	}

	public Circle circleId(String id) {

		boolean stop = false;
		Circle res = null;

		for (int i = 0; i < pane.getChildren().size() && !stop; i++) {

			if (pane.getChildren().get(i) instanceof Circle) {

				if (pane.getChildren().get(i).getId().equals(id)) {

					res = (Circle) pane.getChildren().get(i);
					res.setFill(Color.YELLOW);
					stop = true;
				}

			}

		}

		return res;
	}

	public void genericAlert(String title, String context) {

		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle(title);
		a.setHeaderText("");
		a.setContentText(context);
		a.show();

	}

	private void paintLine(Node e1, Node e2) {

		Line line = new Line();

		pane.getChildren().add(line);

		line.setStartX(e1.getLayoutX());
		line.setStartY(e1.getLayoutY());
		line.setEndX(e2.getLayoutX());
		line.setEndY(e2.getLayoutY());
		line.setFill(Color.AQUA);
		line.setStroke(Color.AQUA);

		line.setStrokeWidth(5);
		line.setStrokeWidth(2);

		line.setStrokeWidth(5);

		line.setStrokeWidth(2);

		line.setVisible(true);
	}

	@FXML
	void eraseRoute() {

		fast = 0;
		Circle temp = null;

		try {

			if ((pane.getChildren().size() > 35) || (origin.getId() != null && destiny.getId() != null)) {

				if (pane.getChildren().size() > 35)
					pane.getChildren().remove(35, pane.getChildren().size());
				else
					throw new RouteNotSelectedException(33);
			} else
				throw new RouteNotSelectedException(33);

			for (int i = 0; i < pane.getChildren().size(); i++) {

				if (pane.getChildren().get(i) instanceof Circle) {
					temp = (Circle) (pane.getChildren().get(i));
					temp.setFill(Color.RED);
				}
			}

		} catch (RouteNotSelectedException e) {

			genericAlert("Error", e.getMessage());
		}

	}

	private void eraseRoutePaths() {

		Circle temp = null;

		try {
			if (origin.getId() != null && destiny.getId() != null) {

				if ((pane.getChildren().size() > 35))
					pane.getChildren().remove(35, pane.getChildren().size());
				else
					throw new RouteNotSelectedException(33);

				for (int i = 0; i < pane.getChildren().size(); i++) {

					if (pane.getChildren().get(i) instanceof Circle) {
						temp = (Circle) (pane.getChildren().get(i));
						temp.setFill(Color.RED);
					}
				}
			}

		} catch (RouteNotSelectedException e) {

		}

	}
	
	
	@FXML 
	void buy(ActionEvent e) {
		
		try {
			if(fast != 0) {
				this.wekete.addFlight(origin.getId(), destiny.getId(), fast);
				
				String temp = "";
				
				if(fast == 1)
					temp = "fast";
				else
					temp = "cheap";
					
				this.wekete.save();
				
				genericAlert("Ticket information", "You just bought a "+temp+" ticket from "+origin.getId()+" to "+destiny.getId());
			}
			else
				throw new RouteNotSelectedException(3);
		}
		catch(RouteNotSelectedException exc) {
			
			genericAlert("Error", exc.getMessage());
		}
	}

	
	@FXML
	void changeImplementation() {
		genericAlert("Implementation", this.wekete.changeImplementation());;
	}
}
