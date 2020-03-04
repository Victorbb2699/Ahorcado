package dad.javafx.ahorcado;


import dad.javafx.ahorcado.controller.AhorcadoRootController;
import dad.javafx.ahorcado.ui.Persistencia;
import dad.javafx.ahorcado.ui.Puntuacion;
import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AhorcadoApp extends Application {
	
	
	//controllers
	private AhorcadoRootController App;
	
	//model
	
	private ListProperty<String> palabras = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private ListProperty<Puntuacion> puntuaciones = new SimpleListProperty<Puntuacion>(FXCollections.observableArrayList());
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		App = new AhorcadoRootController();
		
		//binds
		App.getModel().palabrasProperty().bind(palabras);
		App.getModel().puntuacionesProperty().bind(puntuaciones);
		
		Scene scene = new Scene(App.getView());
		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	@Override
	public void init() throws Exception {
		super.init();
		palabras.addAll(Persistencia.leerPalabras());	
		puntuaciones.addAll(Persistencia.leerPuntuaciones());
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		Persistencia.guardarPalabras(palabras.getValue());
		Persistencia.guardarPuntuaciones(puntuaciones.getValue());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
