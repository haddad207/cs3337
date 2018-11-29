package intelliGreen;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputDisplay extends FlowPane{
	
	static ArrayList<Integer> desired = new ArrayList<Integer>();
	
	TextField temperature = new TextField();
	TextField Humidity = new TextField();
	TextField Moisture = new TextField();
	TextField pH = new TextField();
	TextField cO2 = new TextField();
	
	Label lbl_instructions = new Label("Input desired values for your IntelliGreen environment");
	Label lbl_temp = new Label("Temperature (deg F): ");
	Label lbl_humid = new Label("Humidity (%): ");
	Label lbl_moist = new Label("Soil Moisture (%): ");
	Label lbl_pH = new Label("Soil PH: ");
	Label lbl_cO2 = new Label("CO2 (ppm): ");
	Label lbl_empty = new Label("");
	
	VBox vbox_labels = new VBox();
	VBox vbox_desired = new VBox();

	GridPane grid = new GridPane();
	
	public InputDisplay() {
		setPadding(new Insets(10, 20, 20, 20));
		
		lbl_instructions.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_temp.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_humid.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_moist.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_pH.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_cO2.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_empty.setPadding(new Insets(5, 10, 2.5, 10));
		
		Button rtnButton = new Button("Input Values");
		rtnButton.setPadding(new Insets(5, 10, 2.5, 10));
		
		temperature.setPadding(new Insets(5, 10, 2.5, 10));
		Humidity.setPadding(new Insets(5, 10, 2.5, 10));
		Moisture.setPadding(new Insets(5, 10, 2.5, 10));
		pH.setPadding(new Insets(5, 10, 2.5, 10));
		cO2.setPadding(new Insets(5, 10, 2.5, 10));
		
		vbox_labels.getChildren().addAll(lbl_instructions, lbl_temp, lbl_humid, lbl_moist, lbl_pH, lbl_cO2);
		vbox_desired.getChildren().addAll(lbl_empty,temperature, Humidity, Moisture, pH, cO2);
		grid.add(vbox_labels, 0, 0);
		grid.add(vbox_desired, 1, 0);
		grid.add(rtnButton, 1, 1);
		
		rtnButton.setOnAction(e -> { 
			
			if(temperature.getText().length() > 0 && temperature.getText() != null)
				desired.add(Integer.parseInt(temperature.getText()));
				
			if(Humidity.getText().length() > 0 && Humidity.getText() != null)
				desired.add(Integer.parseInt(Humidity.getText()));
				
			if(Moisture.getText().length() > 0 && Moisture.getText() != null)
				desired.add(Integer.parseInt(Moisture.getText()));
				
			if(pH.getText().length() > 0 && pH.getText() != null)
				desired.add(Integer.parseInt(pH.getText()));
				
			if(cO2.getText().length() > 0 && cO2.getText() != null)
				desired.add(Integer.parseInt(cO2.getText()));
			
			
			
			final Node source = (Node) e.getSource();
			final Stage stage = (Stage) source.getScene().getWindow();
			stage.close();
			
			Display.setLbl_desiredTemp(desired.get(0));
			Display.setLbl_desiredHumid(desired.get(1));
			Display.setLbl_desiredMoisture(desired.get(2));
			Display.setLbl_desiredPH(desired.get(3));
			Display.setLbl_desiredCO2(desired.get(4));
			
			Controller.desired = desired;
			
		});

		
		getChildren().add(grid);
	}
	public static ArrayList<Integer> getDesired(){
		return desired;
	}

}