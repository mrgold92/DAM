package tema6.practica1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que realiza todas las operaciones referentes a la lectura y escritura
 * de ficheros.
 * 
 * 
 * @author david
 *
 */
public class OperacionesFicheros {

	/**
	 * M�todo que se encarga de leer un arrayList de caracteres que forman un texto
	 * completo, se encarga de comprobar si un caracter del texto, es una vocal y de
	 * ser as�, qu� vocal es, aumentando su contador.
	 * 
	 * @param texto ArrayList<Character> que recibe cada caracter de un texto.
	 */

	public static void contarVocales(ArrayList<Character> texto) {
		char c = 0;
		int cA = 0, cE = 0, cI = 0, cO = 0, cU = 0;
		int total = 0;

		for (int i = 0; i < texto.size(); i++) {
			c = texto.get(i);

			switch (c) {
			case 'a':
			case 'A':
				cA++;
				break;
			case 'e':
			case 'E':
				cE++;
				break;
			case 'i':
			case 'I':
				cI++;
				break;
			case 'o':
			case 'O':
				cO++;
				break;
			case 'u':
			case 'U':
				cU++;
				break;
			default:
				break;
			}
		}

		total = cA + cE + cI + cO + cU;
		System.out.println("Hay " + total + " vocales en el texto, de las cuales:\n");
		System.out.println(cA + " son 'a'.");
		System.out.println(cE + " son 'e'.");
		System.out.println(cI + " son 'i'.");
		System.out.println(cO + " son 'o'.");
		System.out.println(cU + " son 'u'.");

	}

	public static void escribir(FileWriter fw, ArrayList<Character> texto) {

		try {
			for (int i = 0; i < texto.size(); i++) {
				fw.write(texto.get(i));
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leer(FileReader reader, ArrayList<Character> texto) {

		try {
			int c = reader.read();
			while (c != -1) {
				c = reader.read();
				texto.add((char) c);
			}
			reader.close();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * M�todo que lee una imagen y hacer una copia de la misma mediante bytes.
	 * 
	 * @param ruta_img
	 * @param nombre_imagen_copia
	 */
	public static void lYeBytes(String ruta_img, String nombre_imagen_copia) {

		// ArrayList<Integer> arrayDatos = new ArrayList<Integer>();

		try {

			BufferedInputStream lector = new BufferedInputStream(new FileInputStream(ruta_img));
			BufferedOutputStream ficherocopia = new BufferedOutputStream(
					new FileOutputStream("resources/" + nombre_imagen_copia));

			int bytes = 0;

			while ((bytes = lector.read()) != -1) {
				ficherocopia.write(bytes);
			}

			lector.close();
			ficherocopia.close();

			System.out.println("Archivo copiado");

//			boolean ar = false;
//
//			while (!ar) {
//				int c = lectura.read();
//
//				if (c != -1) {
//					arrayDatos.add(c);
//				} else {
//					ar = true;
//				}
//
//			}
//			lectura.close();
//
//			for (int i = 0; i < arrayDatos.size(); i++) {
//				ficherocopia.write(arrayDatos.get(i));
//			}
//			ficherocopia.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
