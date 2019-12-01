package dad.javafx.ahorcado.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PalabrasModel {
	
	private ListProperty<String> palabras = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private IntegerProperty seleccionado = new SimpleIntegerProperty();
	
	public final ListProperty<String> palabrasProperty() {
		return this.palabras;
	}
	
	public final ObservableList<String> getPalabras() {
		return this.palabrasProperty().get();
	}
	
	public final void setPalabras(final ObservableList<String> palabras) {
		this.palabrasProperty().set(palabras);
	}
	
	public final IntegerProperty seleccionadoProperty() {
		return this.seleccionado;
	}
	
	public final int getSeleccionado() {
		return this.seleccionadoProperty().get();
	}
	
	public final void setSeleccionado(final int seleccionado) {
		this.seleccionadoProperty().set(seleccionado);
	}
	
	

}
