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
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.City;
import model.WekeAir;

public class MapController {

	private WekeAir wekete;
	
	private Line line;
	
	private boolean routeDisplayed;

	@FXML
	Pane pane;
	@FXML
	Circle origin;
	@FXML
	Circle destiny;

	@FXML
	private Button searchButton;

	@FXML
	private ChoiceBox<String> origin_box;

	@FXML
	private ChoiceBox<String> destination_box;

	@FXML
	private RadioButton matrixRadioButton;

	@FXML
	private RadioButton listRadioButton;

	private boolean originSelected;
	private boolean destinySelected;

	public void initialize() {

		wekete = new WekeAir();

		origin = new Circle();

		destiny = new Circle();

		routeDisplayed = false;

		fillFligths();
	}

	private void fillFligths() {

		origin_box.getItems().addAll("Bogota", "Quito", "Brasilia", "La Paz", "Lima", "Asuncion", "Bs.As", "Montevideo",
				"Santiago", "Guatemala", "San Salvador", "Tegucigalpa", "Managua", "San Jose", "Panama", "Belmopan",
				"Caracas", "Georgetown", "Paramaribo", "Cayena", "Washington", "Otawa", "La Habana");

		destination_box.getItems().addAll("Bogota", "Quito", "Brasilia", "La Paz", "Lima", "Asuncion", "Bs.As",
				"Montevideo", "Santiago", "Guatemala", "San Salvador", "Tegucigalpa", "Managua", "San Jose", "Panama",
				"Belmopan", "Caracas", "Georgetown", "Paramaribo", "Cayena", "Washington", "Otawa", "La Habana");

	}

	public void clicked(MouseEvent e) {

		String id = ((Circle) e.getSource()).getId();
		System.out.println(id);

		if (originSelected == true) {

			this.originSelected = false;
			origin.setFill(Color.RED);

			origin = (Circle) e.getSource();
			origin.setFill(Color.GREEN);

		}

		if (destinySelected == true) {

			this.destinySelected = false;
			destiny.setFill(Color.RED);

			destiny = (Circle) e.getSource();
			destiny.setFill(Color.GREEN);

		}

	}

	public void origin() {

		origin.setOnMouseClicked(e -> {
			System.out.println("a");
		});
	}

	public void selectOrigin() {
		AudioClip sound=new AudioClip("file:resources/sounds/ClickOn.mp3");
		sound.play();
		this.originSelected = true;
		genericAlert("Origin",
				"Please select your origin node.\nBy clicking it on the map or selecting it from the menu");
	}

	public void selectDestiny() {
		AudioClip sound=new AudioClip("file:resources/sounds/ClickOn.mp3");
		sound.play();
		this.destinySelected = true;
		genericAlert("Destiny",
				"Please select your destiny node. \nBy clicking it on the map or selecting it from the menu");

	}

	@FXML
	void findCheapestFlight(ActionEvent event) {
		
		AudioClip sound=new AudioClip("file:resources/sounds/ClickOn.mp3");
		sound.play();
		
		try {
		
			if(originSelected && destinySelected) {
				
				ArrayList<City> path = this.wekete.cheapestPath(origin.getId(), destiny.getId());

				for (int i = 0; i < path.size() - 1; i++) {

					paintLine(circleId(path.get(i).getName()), circleId(path.get(i + 1).getName()));
				}
			}
			else {
				
				throw new RouteNotSelectedException("cheapest");
			}
			
		}
		catch(RouteNotSelectedException e) {
		
			genericAlert("Error", e.getMessage());
			
		}
	}

	

	public Circle circleId(String id) {

		boolean stop = false;
		Circle res = null;

		for (int i = 0; i < pane.getChildren().size() && !stop; i++) {

			if (pane.getChildren().get(i) instanceof Circle) {

				System.out.println(id + " = " + pane.getChildren().get(i).getId());

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
		//style
//		DialogPane dialogPane = a.getDialogPane();
//		dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		dialogPane.getStyleClass().add("dialog");
		a.setTitle(title);
		a.setHeaderText("");
		a.setContentText(context);
		a.initOwner(pane.getScene().getWindow());
		// Remove default ButtonTypes
		a.getButtonTypes().clear();
		ButtonType accept = new ButtonType("accept");
		a.getButtonTypes().addAll(accept);

		a.show();

	}

	void paintLine(Node e1, Node e2) {
		
		line = new Line();

		pane.getChildren().add(line);
		
		line.setStartX(e1.getLayoutX());
		line.setStartY(e1.getLayoutY());
		line.setEndX(e2.getLayoutX());
		line.setEndY(e2.getLayoutY());
		line.setFill(Color.AQUA);
		line.setStroke(Color.AQUA);

		line.setStrokeWidth(3);

	}

	private void resetRoute() {
		System.out.println("limpia");
		// pane.getChildren().remove(line);

//		line.setStartX(0.0f);
//		line.setStartY(0.0f);
//		line.setEndX(0.0f);
//		line.setEndY(0.0f);

		// pane.getChildren().add(line);
	}

	    // if the user chooses this option
		// the information of the graph must
		// be managed using an adjacencyMatrix
		@FXML
		void listImplementation(ActionEvent event) {
			
			
			if (matrixRadioButton.isSelected()) {
				matrixRadioButton.setSelected(false);
			}

			// TODO
		}

		// if the user chooses this option
		// the information of the graph must
		// be managed using an adjacencyMatrix
		@FXML
		void matrixImplementation(ActionEvent event) {
		
			
			if (listRadioButton.isSelected()) {
				listRadioButton.setSelected(false);
			}

			// TODO
		}
	
}
