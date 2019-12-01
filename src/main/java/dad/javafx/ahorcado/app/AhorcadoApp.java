package dad.javafx.ahorcado.app;

import dad.javafx.ahorcado.clases.Persistente;
import dad.javafx.ahorcado.clases.Puntuacion;
import dad.javafx.ahorcado.controllers.rootController;
import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AhorcadoApp extends Application {
	
	private rootController controller;
	private ListProperty<String> palabras = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private ListProperty<Puntuacion> puntuaciones = new SimpleListProperty<Puntuacion>(FXCollections.observableArrayList());
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new rootController();
		//bindeos
		
		controller.getModel().palabrasProperty().bind(palabras);
		controller.getModel().puntuacionesProperty().bind(puntuaciones);
		
		Scene scene = new Scene(controller.getView(), 640, 480);

		primaryStage.setTitle("Ahorcado JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	@Override
	public void init() throws Exception {
		super.init();		
		palabras.addAll(Persistente.leerPalabras());	
		puntuaciones.addAll(Persistente.leePuntuaciones());
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		Persistente.guardarPalabras(palabras);
		Persistente.guardarPuntos(puntuaciones);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
