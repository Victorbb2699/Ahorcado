package dad.javafx.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.model.PalabrasModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

public class PalabrasController implements Initializable {

	// model

	PalabrasModel model = new PalabrasModel();

	// view

	@FXML
	private GridPane gridPalabras;

	@FXML
	private ListView<String> PalabrasListView;

	@FXML
	private Button quitarButton;

	@FXML
	private Button añadirButton;

	@FXML
	void onAñadirAction(ActionEvent event) {

		Optional<String> result;

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Añadir palabra");
		dialog.setHeaderText("Añadir palabra");
		dialog.setContentText("Introuzca una palabra: ");
		result = dialog.showAndWait();

		model.getPalabras().addAll(result.get());
	}

	@FXML
	void onQuitarAction(ActionEvent event) {
		model.palabrasProperty().remove(model.getSeleccionado());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// bindeos

		quitarButton.disableProperty().bind(model.seleccionadoProperty().isEqualTo(-1));
		PalabrasListView.itemsProperty().bind(model.palabrasProperty());
		model.seleccionadoProperty().bind(PalabrasListView.getSelectionModel().selectedIndexProperty());

	}

	public PalabrasController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palabrasView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public GridPane getView() {
		return gridPalabras;
	}

	public PalabrasModel getModel() {
		return model;
	}
}
