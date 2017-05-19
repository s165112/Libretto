package it.polito.tdp.libretto;
	
import it.polito.tdp.libretto.model.LibrettoModel;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		//	metodo statico	
		//	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Libretto.fxml"));
			// vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			BorderPane root = (BorderPane)loader.load();
			// controller
			LibrettoController controller = loader.getController();
			// model
			LibrettoModel model = new LibrettoModel();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
