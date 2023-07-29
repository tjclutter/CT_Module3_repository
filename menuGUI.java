package com.example;
//import statements
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//create menuGUI class that inherits from the application class
public class menuGUI extends Application{
	//override the start method
	@Override
	public void start(Stage applicationStage) {
		
		//set title of application
		applicationStage.setTitle("GUI with menu");
		
		//create menu items and assign names to them
		MenuItem item1 = new MenuItem("Print date/time");
		MenuItem item2 = new MenuItem("write to file");
		MenuItem item3 = new MenuItem("change background");
		MenuItem item4 = new MenuItem("exit program");
		
		//create textfield and menuButton
		TextField textField = new TextField();
		MenuButton menubutton = new MenuButton("options", null, item1, item2, item3, item4);
		 
		//create hbox with menuButton as parameter
		HBox hbox = new HBox(menubutton);

		//create and customize gridPane
		GridPane pane = new GridPane();
		pane.setMinSize(400, 400);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);

		//add hbox and textfield to the gridPane
		pane.add(hbox, 0, 0);
		pane.add(textField, 0, 1);

		//add the pane to the scene then the scene to the stage
		Scene scene = new Scene(pane, 200, 100);
		applicationStage.setScene(scene);
		//displays stage to user
		applicationStage.show();
	

		//customize action event when user presses item1 from menu
		item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){

				//get the local date and time and display in the textField 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				textField.setText(dtf.format(now));
			}
		} );

		//customize action event when user presses item2 from menu
		item2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				//try and catch used to handle exceptions
				try {
				
				// create file object referencing new file log.txt	
				File file = new File("log.txt");
				//create FileWriter object to add text in the textField to file
				FileWriter writer = new FileWriter(file);
				writer.write(textField.getText());

				//close the file
				writer.close();
				} catch (IOException e){
					System.out.println("error writing to file");
				}


			}
		} );

		//customize action event when user presses item3 in menu
		item3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				
				//define Random variable and set to Random object
				Random rand = new Random();
				//define string variable
				String greenShade = null;

				//get random integer between 0 and 20 inclusive
				int n = rand.nextInt(21);
				//use random integer to pick random shade of green
				switch (n) {
					case 1:
						greenShade = "#ffffff";
						break;
					case 2:
						greenShade = "#e6ffe6";
						break;
					case 3:
						greenShade = "#ccffcc";
						break;
					case 4:
						greenShade = "b3ffb3";
						break;
					case 5:
						greenShade = "#99ff99";
						break;
					case 6:
						greenShade = "#80ff80";
						break;
					case 7:
						greenShade = "#66ff66";
						break;
					case 8:
						greenShade = "#4dff4d";
						break;
					case 9:
						greenShade = "#33ff33";
						break;
					case 10:
						greenShade = "#1aff1a";
						break;
					case 11: 
						greenShade = "#00ff00";
						break;
					case 12:
						greenShade = "#00e600";
						break;
					case 13:
						greenShade = "#00cc00";
						break;
					case 14: 
						greenShade = "#00b300";
						break;
					case 15: 
						greenShade = "#009900";
						break;
					case 16:
						greenShade = "#0088000";
						break;
					case 17:
						greenShade = "#006600";
						break;
					case 18:
						greenShade = "#004d00";
						break;
					case 19:
						greenShade = "#003300";
						break;
					case 20:
						greenShade = "#001a00";
						break;
				}
				//change the background color of gridPane to random shade of green
				pane.setStyle("-fx-background-color: " + greenShade);
			}
		} );

		//customize action event when user clicks menu item4
		item4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				//close stage which ends program
				applicationStage.close();
			}
		} );

		

			
				
		
	}
	//launch program using Main class
	public static void main(String[] args) {
		launch(args);
	}
}
