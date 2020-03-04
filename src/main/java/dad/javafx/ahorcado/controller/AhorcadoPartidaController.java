package dad.javafx.ahorcado.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.model.AhorcadoPartidaModel;
import dad.javafx.ahorcado.ui.Puntuacion;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

public class AhorcadoPartidaController implements Initializable {
	
		//VIEW
	
	  	@FXML
	    private BorderPane root;

	    @FXML
	    private HBox BottomHBox;

	    @FXML
	    private TextField IntentoTextField;

	    @FXML
	    private Button LetraButton;

	    @FXML
	    private Button ResolverButton;

	    @FXML
	    private VBox centerVBox;

	    @FXML
	    private ImageView palabraImage;

	    @FXML
	    private Label palabra;

	    @FXML
	    private Label letras;

	    @FXML
	    private HBox topHBox;

	    @FXML
	    private Label puntuacionLabel;
	    
	    //model
	    AhorcadoPartidaModel model = new AhorcadoPartidaModel();
	    ArrayList<Image> imagenes = new ArrayList<Image>();
	    int imagen=1;
	    
	    public AhorcadoPartidaModel getModel() {
			return model;
		}
	    
	    public AhorcadoPartidaController() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AhorcadoPartidaView.fxml"));
			loader.setController(this);
			loader.load();
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			LetraButton.setDefaultButton(true);
			
			model.setLetras("");
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/1.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/2.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/3.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/4.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/5.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/6.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/7.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/8.png")));
			imagenes.add(new Image(getClass().getResourceAsStream("/hangman/9.png")));
			
			
			
			//binds
			
			letras.textProperty().bind(model.letrasProperty());
			
			Bindings.bindBidirectional(puntuacionLabel.textProperty(),model.puntosProperty(), new NumberStringConverter());
			
			palabraImage.imageProperty().bind(model.imagenProperty());
			
			palabra.textProperty().bind(model.ocultaProperty());
			model.intentoProperty().bind(IntentoTextField.textProperty());
			
			root.sceneProperty().addListener((o,ov,nv) -> {
				generarPalabra();
			});
			
			model.palabraTerminadaProperty().addListener((o,ov,nv) -> {
				if(nv) {
					model.setPalabraTerminada(false);
					generarPalabra();
					model.setLetras("");
				}
			});
			
			
			
		}
		
		
		
		public void reset () {
			model.setTerminado(false);
			model.setPuntuacion(new Puntuacion("",0));
			model.setPuntos(0);
			imagen=1;
			model.setImagen(imagenes.get(0));
			model.setLetras("");
			generarPalabra();
		}
		
		public BorderPane getView() {
			return root;
		}
		
		@FXML
		void onLetraButtonAction(ActionEvent event) {	
			

			if (!model.getIntento().equals("") && !model.getLetras().contains(model.getIntento())) {
				if (model.getPalabra().contains(model.getIntento())) {
					char letra = model.getIntento().charAt(0);
					model.setLetras(model.getLetras()+letra+" ");
					int i = 0;
					String aux = "";
					while (i != model.getPalabra().length()) {
						if (model.getPalabra().charAt(i) == letra) {
							aux += letra;
							model.setPuntos(model.getPuntos()+1);
						} else if (model.getOculta().charAt(i) != '_') {
							aux += model.getOculta().charAt(i);
						} else {
							aux += "_";
						}
						i++;
					}
					model.setOculta(aux);
				} else {
					if(imagen==8) {
						model.setImagen(imagenes.get(imagen));
						TextInputDialog dialog = new TextInputDialog();
						dialog.setTitle("Ahorcado");
						dialog.setHeaderText("¡Ha terminado la partida!");
						dialog.setContentText("Introduce tu nombre:");
						Optional<String> result = dialog.showAndWait();
						model.setPuntuacion(new Puntuacion(result.get(),model.getPuntos()));
						
						model.setTerminado(true);
						reset();		
					}else {
						model.setImagen(imagenes.get(imagen));
						imagen++;
					}
					
				} 
			}
			IntentoTextField.clear();
			
		}

		@FXML
		void onResolverButtonAction(ActionEvent event) {
			if(model.getIntento().equals(model.getPalabra())) {
			
				
				model.setPalabraTerminada(true);

			}
			IntentoTextField.clear();
		}
		
		private void generarPalabra() {
			model.setPalabra(model.getPalabras().get((int)(Math.random()*model.getPalabras().size())));
			String aux="";
			for (int i = 0; i < model.getPalabra().length(); i++) {
				if(model.getPalabra().charAt(i)==' ')
					aux+=" ";
				else
					aux+="_";
			}
			model.setOculta(aux);
		}
}
