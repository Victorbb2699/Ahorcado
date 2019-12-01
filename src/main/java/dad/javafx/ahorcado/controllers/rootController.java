package dad.javafx.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.model.rootModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.fxml.Initializable;

public class rootController implements Initializable {

	// model
	rootModel model = new rootModel();

	// controllers
	PartidaController controllerPartida;
	PalabrasController controllerPalabras;
	PuntuacionesController controllerPuntuaciones;

	// view
	
	private TabPane root;

	

	public rootController() throws IOException {

		controllerPalabras = new PalabrasController();
		controllerPartida = new PartidaController();
		controllerPuntuaciones = new PuntuacionesController();
		
		Tab tab = new Tab("Partida");
		tab.setContent(controllerPartida.getView());
		
		Tab tab2 = new Tab("Palabras");
		tab2.setContent(controllerPalabras.getView());
		
		Tab tab3 = new Tab("Puntuaciones");
		tab3.setContent(controllerPuntuaciones.getView());
		
		root.getTabs().addAll(tab,tab2,tab3);	
		root.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// bindeos
		controllerPartida.getModel().terminadoProperty().addListener((o,ov,nv) -> {
			if(nv==true) {	
				controllerPuntuaciones.getPuntuaciones().add(controllerPartida.getModel().getPts());
			}
		});
		
		controllerPuntuaciones.puntuacionesProperty().bind(model.puntuacionesProperty());
		controllerPalabras.getModel().palabrasProperty().bind(model.palabrasProperty());
		controllerPartida.getModel().palabrasProperty().bind(model.palabrasProperty());
	}

	public TabPane getView() {
		return root;
	}

	public rootModel getModel() {
		return model;
	}

}
