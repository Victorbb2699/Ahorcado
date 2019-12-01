package dad.javafx.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.clases.Puntuacion;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class PuntuacionesController implements Initializable {

	// model
	private ListProperty<Puntuacion> puntuaciones = new SimpleListProperty<Puntuacion>(
			FXCollections.observableArrayList());

	// view

	@FXML
	private HBox boxPuntuaciones;

	@FXML
	private ListView<Puntuacion> puntuacionesList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public HBox getView() {
		return boxPuntuaciones;
	}

	public PuntuacionesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PuntuacionesView.fxml"));
		loader.setController(this);
		loader.load();
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
