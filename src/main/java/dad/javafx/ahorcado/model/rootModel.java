package dad.javafx.ahorcado.model;

import dad.javafx.ahorcado.clases.Puntuacion;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class rootModel {

	private ListProperty<String> palabras = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private ListProperty<Puntuacion> puntuaciones = new SimpleListProperty<Puntuacion>(
			FXCollections.observableArrayList());

	public final ListProperty<String> palabrasProperty() {
		return this.palabras;
	}

	public final ObservableList<String> getPalabras() {
		return this.palabrasProperty().get();
	}

	public final void setPalabras(final ObservableList<String> palabras) {
		this.palabrasProperty().set(palabras);
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
