package UI_XML;

import java.io.FileInputStream;
import java.io.IOException;

import businessLogic.OfferedCourse;
import businessLogic.Profile;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	FXMLLoader loader= new FXMLLoader();
	@Override
	public void start(Stage primaryStage) {
		try {

			String fxmlDocPath= "src\\UI_XML\\Login.fxml";
			FileInputStream fxmlStream= new FileInputStream(fxmlDocPath);
			AnchorPane root=  (AnchorPane) loader.load(fxmlStream);

			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root,944,698);
			//scene.getStylesheets().add(getClass( ).getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		
		launch(args);
	}


	public void goToNextScreen(Stage currentStage, String path)  throws IOException  {

		String fxmlDocPath = path;
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);

		Scene scene = new Scene(pane,944,698);
		currentStage.setScene(scene);
		currentStage.show();

			
	}



}
