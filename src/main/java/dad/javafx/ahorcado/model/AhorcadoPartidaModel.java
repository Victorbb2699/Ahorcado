package dad.javafx.ahorcado.model;


import dad.javafx.ahorcado.ui.Puntuacion;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class AhorcadoPartidaModel {

	private ListProperty<String> palabras = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private StringProperty palabra = new SimpleStringProperty();
	private StringProperty oculta = new SimpleStringProperty();
	private StringProperty letras = new SimpleStringProperty();
	private StringProperty intento = new SimpleStringProperty();
	private IntegerProperty puntos = new SimpleIntegerProperty();
	private ObjectProperty<Image> imagen = new SimpleObjectProperty<Image>();
	private BooleanProperty terminado = new SimpleBooleanProperty();
	private BooleanProperty palabraTerminada = new SimpleBooleanProperty();
	private Puntuacion puntuacion = new Puntuacion();
	
	public Puntuacion getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Puntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}

	public final StringProperty palabraProperty() {
		return this.palabra;
	}
	
	public final String getPalabra() {
		return this.palabraProperty().get();
	}
	
	public final void setPalabra(final String palabra) {
		this.palabraProperty().set(palabra);
	}
	
	public final StringProperty letrasProperty() {
		return this.letras;
	}
	
	public final String getLetras() {
		return this.letrasProperty().get();
	}
	
	public final void setLetras(final String letras) {
		this.letrasProperty().set(letras);
	}
	
	

	public final ListProperty<String> palabrasProperty() {
		return this.palabras;
	}
	

	public final ObservableList<String> getPalabras() {
		return this.palabrasProperty().get();
	}
	

	public final void setPalabras(final ObservableList<String> palabras) {
		this.palabrasProperty().set(palabras);
	}

	public final StringProperty ocultaProperty() {
		return this.oculta;
	}
	

	public final String getOculta() {
		return this.ocultaProperty().get();
	}
	

	public final void setOculta(final String oculta) {
		this.ocultaProperty().set(oculta);
	}
	

	public final StringProperty intentoProperty() {
		return this.intento;
	}
	

	public final String getIntento() {
		return this.intentoProperty().get();
	}
	

	public final void setIntento(final String intento) {
		this.intentoProperty().set(intento);
	}
	

	public final ObjectProperty<Image> imagenProperty() {
		return this.imagen;
	}
	

	public final Image getImagen() {
		return this.imagenProperty().get();
	}
	

	public final void setImagen(final Image imagen) {
		this.imagenProperty().set(imagen);
	}

	public final IntegerProperty puntosProperty() {
		return this.puntos;
	}
	

	public final int getPuntos() {
		return this.puntosProperty().get();
	}
	

	public final void setPuntos(final int puntos) {
		this.puntosProperty().set(puntos);
	}

	public final BooleanProperty terminadoProperty() {
		return this.terminado;
	}
	

	public final boolean isTerminado() {
		return this.terminadoProperty().get();
	}
	

	public final void setTerminado(final boolean terminado) {
		this.terminadoProperty().set(terminado);
	}

	public final BooleanProperty palabraTerminadaProperty() {
		return this.palabraTerminada;
	}
	

	public final boolean isPalabraTerminada() {
		return this.palabraTerminadaProperty().get();
	}
	

	public final void setPalabraTerminada(final boolean palabraTerminada) {
		this.palabraTerminadaProperty().set(palabraTerminada);
	}
	
	
	
	

	
	
}
