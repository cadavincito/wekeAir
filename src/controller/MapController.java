package controller;

import java.util.ArrayList;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	 private ChoiceBox<String> origin_box;

	 @FXML
	 private ChoiceBox<String> destination_box;

	private boolean originSelected;
	private boolean destinySelected;

	public void initialize() {
		
		wekete = new WekeAir();
		
		origin  = new Circle();
		destiny = new Circle();
		
		origin_box.getItems().addAll("wikiti","Bogota","Quito","Brasilia");
		
		destination_box.getItems().addAll("wikiti","Bogota","Quito","Brasilia");

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
	
	public void genericAlert(String title, String context) {

		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle(title);
		a.setHeaderText("");
		a.setContentText(context);
		a.show();

	}

}
