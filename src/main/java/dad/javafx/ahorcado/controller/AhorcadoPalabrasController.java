package dad.javafx.ahorcado.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.model.AhorcadoPalabrasModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AhorcadoPalabrasController implements Initializable{


	    @FXML
	    private BorderPane root;

	    @FXML
	    private VBox botonera;

	    @FXML
	    private Button anadirButton;

	    @FXML
	    private Button quitarButton;

	    @FXML
	    private ListView<String> listaListView;
	    
	    private AhorcadoPalabrasModel model = new AhorcadoPalabrasModel();
	    
	    public AhorcadoPalabrasModel getModel() {
			return model;
		}

		public AhorcadoPalabrasController() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AhorcadoPalabrasView.fxml"));
			loader.setController(this);
			loader.load();
		}
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	
	    	//binds
	    	
	    	quitarButton.disableProperty().bind(model.seleccionadoProperty().isEqualTo(-1));
	    	listaListView.itemsProperty().bind(model.palabrasProperty());
	    	
	    	model.seleccionadoProperty().bind(listaListView.getSelectionModel().selectedIndexProperty());
	    	
	    	
		}
	    
	    public BorderPane getView() {
	    	return root;
	    }
	    

	    @FXML
	    void onAnadirAction(ActionEvent event) {
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

		
	
}
