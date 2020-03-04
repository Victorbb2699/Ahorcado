package dad.javafx.ahorcado.controller;

import java.io.IOException;

import dad.javafx.ahorcado.model.AhorcadoRootModel;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;



public class AhorcadoRootController {
	
	private AhorcadoPalabrasController palabras;
	private AhorcadoPartidaController partida;
	private AhorcadoPuntuacionesController puntuaciones;
	
	private AhorcadoRootModel model;
	
	private TabPane panel;	
	
	public AhorcadoRootController() throws IOException {
		
		
		palabras = new AhorcadoPalabrasController();
		partida = new AhorcadoPartidaController();
		puntuaciones = new AhorcadoPuntuacionesController();
		model = new AhorcadoRootModel();
		
		panel = new TabPane();
		
		
		Tab firstpane = new Tab("Partida");
		firstpane.setContent(partida.getView());
		
		Tab secondpane = new Tab("Palabras");
		secondpane.setContent(palabras.getView());
		
		Tab thirdpane = new Tab("Puntuaciones");
		thirdpane.setContent(puntuaciones.getView());
	
		
		panel.getTabs().addAll(firstpane,secondpane,thirdpane);
		panel.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		
		//bindeos
		
		partida.getModel().terminadoProperty().addListener((o,ov,nv) -> {
			if(nv==true) {	
				puntuaciones.getPuntuaciones().add(partida.getModel().getPuntuacion());
			}
		});
		
		
		puntuaciones.puntuacionesProperty().bind(model.puntuacionesProperty());
		palabras.getModel().palabrasProperty().bind(model.palabrasProperty());
		partida.getModel().palabrasProperty().bind(model.palabrasProperty());
		
	}
	
	public AhorcadoRootModel getModel() {
		return model;
	}

	public TabPane getView() {
		return panel;
	}
		

}
