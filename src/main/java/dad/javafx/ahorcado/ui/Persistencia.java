package dad.javafx.ahorcado.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

	private static final File FICHEROPALABRAS = new File("palabras.txt");
	private static final File FICHEROPUNTUACIONES = new File("puntuaciones.txt");

	public static void guardarPalabras(List<String> datos) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEROPALABRAS, Charset.forName("UTF-8")));
			int i = 0;
			while (i != datos.size()) {
				bw.write(datos.get(i) + "\n");
				i++;
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> leerPalabras() {
		String aux = "";
		List<String> datos = new ArrayList<String>();
		try {	
			if (FICHEROPALABRAS.exists() && FICHEROPALABRAS.length()>0) {
				BufferedReader br = new BufferedReader(new FileReader(FICHEROPALABRAS, Charset.forName("UTF-8")));
				while ((aux = br.readLine()) != null) {
					datos.add(aux);
				}
				br.close();
			}else {
				BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEROPALABRAS, Charset.forName("UTF-8")));
				bw.write("Chuck Norris");
				datos.add("Chuck Norris");
				bw.close();		
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}

	public static void guardarPuntuaciones(List<Puntuacion> datos) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEROPUNTUACIONES, Charset.forName("UTF-8")));
			int i = 0;
			while (i != datos.size()) {
				bw.write(datos.get(i).getNombre() + "," + datos.get(i).getPuntuacion() + "\n");
				i++;
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Puntuacion> leerPuntuaciones() {	
		String aux = "";
		String[] aux2 = new String[2];
		List<Puntuacion> datos = new ArrayList<Puntuacion>();
		try {
			if(FICHEROPUNTUACIONES.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(FICHEROPUNTUACIONES, Charset.forName("UTF-8")));
				while ((aux = br.readLine()) != null) {
					aux2 = aux.split(",");
					datos.add(new Puntuacion(aux2[0], Integer.parseInt(aux2[1])));
				}
				br.close();		
			}else {
				FICHEROPUNTUACIONES.createNewFile();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}

}
