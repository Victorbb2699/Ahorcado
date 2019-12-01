package dad.javafx.ahorcado.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Persistente {

	private static final File filePalabras = new File("palabras.txt");
	private static final File filePuntuaciones = new File("puntuaciones.txt");

	public static List<String> leerPalabras() {

		String palabra = "";
		List<String> palabras = new ArrayList<String>();

		try {
			if (filePalabras.exists() && filePalabras.length() > 0) {
				BufferedReader bf = new BufferedReader(new FileReader(filePalabras, Charset.forName("UTF-8")));
				while ((palabra = bf.readLine()) != null) {
					palabras.add(palabra);
				}
				bf.close();
			} else {
				BufferedWriter bw = new BufferedWriter(new FileWriter(filePalabras, Charset.forName("UTF-8")));
				bw.write("hangman");
				palabras.add("hangman");
				bw.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return palabras;
	}

	public static void guardarPalabras(List<String> palabras) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePalabras, Charset.forName("UTF-8")));

			for (int i = 0; i != palabras.size(); i++) {
				bw.write(palabras.get(i) + "\n");
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static List<Puntuacion> leePuntuaciones() {

		String nombre = "";
		String[] aux = new String[2];

		List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();

		try {
			if (filePuntuaciones.exists()) {
				BufferedReader bf = new BufferedReader(new FileReader(filePuntuaciones, Charset.forName("UTF-8")));
				while ((nombre = bf.readLine()) != null) {
					aux = nombre.split(",");
					puntuaciones.add(new Puntuacion(aux[0], Integer.parseInt(aux[1])));
				}
				bf.close();
			} else {
				filePuntuaciones.createNewFile();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return puntuaciones;

	}

	public static void guardarPuntos(List<Puntuacion> pts) {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(filePuntuaciones, Charset.forName("UTF-8")));
			int i = 0;
			while (i != pts.size()) {
				bw.write(pts.get(i).getNombre() + "," + pts.get(i).getPuntuacion() + "\n");
				i++;
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
