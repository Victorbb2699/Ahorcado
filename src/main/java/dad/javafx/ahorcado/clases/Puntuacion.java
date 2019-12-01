package dad.javafx.ahorcado.clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Puntuacion {

	private StringProperty nombre = new SimpleStringProperty();
	private IntegerProperty puntuacion = new SimpleIntegerProperty();

	public Puntuacion() {

		nombre.set("");
		puntuacion.set(0);

	}

	public Puntuacion(String nombre, Integer punt) {
		this.nombre.set(nombre);
		puntuacion.set(punt);
	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final IntegerProperty puntuacionProperty() {
		return this.puntuacion;
	}

	public final int getPuntuacion() {
		return this.puntuacionProperty().get();
	}

	public final void setPuntuacion(final int puntuacion) {
		this.puntuacionProperty().set(puntuacion);
	}

}
