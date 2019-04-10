package tema6.practica1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase principal del tema 6 de programaci�n. Se encargar�n de leer y escribir
 * sobre los ficheros guardados en resources/
 * 
 * @author david
 *
 */
public class LecturaFicheros {

	/**
	 * Método principal de la aplicaci�n.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String nombreFichero = "resources/prueba1.txt";
		String nombreFichero2 = "resources/prueba2.txt";
		String ruta_imagen = "resources/Desert.jpg";
		String nombre_imagen_copia = "ImagenCopia.jpg";

		FileReader reader = new FileReader(nombreFichero);
		FileWriter fw = new FileWriter(nombreFichero2, true);
		ArrayList<Character> texto = new ArrayList<Character>();

		OperacionesFicheros.leer(reader, texto);
		OperacionesFicheros.contarVocales(texto);
		OperacionesFicheros.escribir(fw, texto);
		OperacionesFicheros.lYeBytes(ruta_imagen, nombre_imagen_copia);

	}

}
