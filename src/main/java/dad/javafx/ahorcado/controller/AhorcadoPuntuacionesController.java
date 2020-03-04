package dad.javafx.ahorcado.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.ui.Puntuacion;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import javafx.fxml.Initializable;

public class AhorcadoPuntuacionesController implements Initializable {

	@FXML
	private BorderPane root;

	@FXML
	private ListView<Puntuacion> puntuacionesListView;
	
	//model 
	private ListProperty<Puntuacion> puntuaciones = new SimpleListProperty<Puntuacion>(FXCollections.observableArrayList());
	
	public AhorcadoPuntuacionesController() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AhorcadoPuntuacionesView.fxml"));
			loader.setController(this);
			loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//bindeos
		puntuacionesListView.setItems(puntuaciones.sorted((o1,o2) ->	
			(o1.getPuntuacion() < o2.getPuntuacion()) ? 1 : ((o1.getPuntuacion()>o2.getPuntuacion()) ? -1 : 0)		
				)); 

		
		
	}
	
	@FXML
	void onLimpiarAction(ActionEvent event) {
		puntuaciones.clear();
	}
	public BorderPane getView() {
		return root;
	}

	public final ListProperty<Puntuacion> puntuacionesProperty() {
		return this.puntuaciones;
	}
	

	public final ObservableList<Puntuacion> getPuntuaciones() {
		return this.puntuacionesProperty().get();
	}
	

	public final void setPuntuaciones(final ObservableList<Puntuacion> puntuaciones) {
		this.puntuacionesProperty().set(puntuaciones);
	}
	

}
