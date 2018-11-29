package intelliGreen;

import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DesiredClass {
	VBox vbox = new VBox();
	VBox vbox2 = new VBox();
	GridPane grid = new GridPane();
	static ArrayList<Integer> desired = new ArrayList();
	Controller cntrl = new Controller();
	
	TextField temperature = new TextField();
	TextField Humidity = new TextField();
	TextField Moisture = new TextField();
	TextField pH = new TextField();
	TextField cO2 = new TextField();
	 
	Label lbl_temp = new Label("Desired Temperature:");
	Label lbl_humid = new Label("Desired Humidity:");
	Label lbl_mois = new Label("Desired Moisture:");
	Label lbl_pH = new Label("Desired pH:");
	Label lbl_cO2 = new Label("Desired CO2:");
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Please enter desired Values");
		lbl_temp.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_humid.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_mois.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_pH.setPadding(new Insets(5, 10, 2.5, 10));
		lbl_cO2.setPadding(new Insets(5, 10, 2.5, 10));
		
		
		vbox.getChildren().add(lbl_temp);
		vbox.getChildren().add(lbl_humid);
		vbox.getChildren().add(lbl_mois);
		vbox.getChildren().add(lbl_pH);
		vbox.getChildren().add(lbl_cO2);
		
		vbox2.getChildren().add(temperature);
		vbox2.getChildren().add(Humidity);
		vbox2.getChildren().add(Moisture);
		vbox2.getChildren().add(pH);
		vbox2.getChildren().add(cO2);
		
		Button rtnButton = new Button("Input Values");
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
		
		grid.add(vbox, 0, 0);
		grid.add(vbox2, 1, 0);
		rtnButton.setPadding(new Insets(10, 10, 10, 10));
		grid.add(rtnButton, 1, 1);
//		rtnButton.setOnAction(e -> cntrl.start(primaryStage));
		Scene scene = new Scene(grid, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static ArrayList<Integer> getDesired(){
		return desired;
	}
	


}
