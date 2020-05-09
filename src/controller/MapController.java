package controller;


import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.shape.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.WekeAir;

public class MapController {

	private WekeAir wekete;
	
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

	private boolean originSelected;
	private boolean destinySelected;

	public void initialize() {
		
		wekete = new WekeAir();
		
		origin  = new Circle();
		destiny = new Circle();
		
		fillFligths();
	}

	private void fillFligths() {
		
		origin_box.getItems().addAll("Bogota","Quito","Brasilia","La Paz","Lima","Asuncion","Bs.As","Montevideo","Santiago"
				,"Guatemala","San Salvador","Tegucigalpa","Managua","San Jose","Panama","Belmopan","Caracas","Georgetown","Paramaribo"
				,"Cayena","Washington","Otawa","La Habana");
		
		destination_box.getItems().addAll("Bogota","Quito","Brasilia","La Paz","Lima","Asuncion","Bs.As","Montevideo","Santiago"
				,"Guatemala","San Salvador","Tegucigalpa","Managua","San Jose","Panama","Belmopan","Caracas","Georgetown","Paramaribo"
				,"Cayena","Washington","Otawa","La Habana");

//		ObservableList<Node> l = pane.getChildren();
//		
//		for(int i = 0; i< l.size();i++) {
//			Circle n = new Circle();
//			Node w = l.get(i);
//			if(n.getClass().equals(w)) {
//				String id = w.getId();
//				origin_box.getItems().add(id);
//				destination_box.getItems().add(id);
//			}
//		}
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

		this.originSelected = true;
		genericAlert("Origin", "Please select your origin node.");
	}
	
	public void selectDestiny() {

		this.destinySelected = true;
		genericAlert("Destiny", "Please select your destiny node.");
		
		
	}
	
	@FXML
    void search(ActionEvent event) {
		paintLine(origin, destiny);
		System.out.println("aaaa");
		System.out.println(origin.getLayoutX());
		System.out.println(destiny.getLayoutX());
    }
	
	public void genericAlert(String title, String context) {

		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle(title);
		a.setHeaderText("");
		a.setContentText(context);
		a.show();

	}
	
	

	void paintLine(Node e1, Node e2) {
		
		Line line = new Line();
<<<<<<< HEAD
		pane.getChildren().add(line);
=======
		
		pane.getChildren().add(line);
		
>>>>>>> ef31754dcf88ac3ad63ea35060105b71dc2e5320
		line.setStartX(e1.getLayoutX());
		line.setStartY(e1.getLayoutY());
		line.setEndX(e2.getLayoutX());
		line.setEndY(e2.getLayoutY());
		line.setFill(Color.AQUA);
		line.setStroke(Color.AQUA);
<<<<<<< HEAD
		line.setStrokeWidth(5);
=======
		line.setStrokeWidth(2);
>>>>>>> ef31754dcf88ac3ad63ea35060105b71dc2e5320
		line.setVisible(true);
		}
	}


