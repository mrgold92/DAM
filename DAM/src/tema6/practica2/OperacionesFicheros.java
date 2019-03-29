package tema6.practica2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase encargada de realizar todas las operaciones necesarias para realizar
 * lecturas y escrituras de ficheros.
 * 
 * @author David S.
 *
 */
public class OperacionesFicheros {

	/**
	 * Dado un fichero con texto, este m�todo lee el contenido original y crea un
	 * fichero nuevo con el texto que hemos obtenido del fichero original.
	 * 
	 * @param fichero          Ruta del fichero nuevo.
	 * @param fichero_original Ruta del fichero original.
	 */
	public static void generarFichero(final String fichero, final String fichero_original) {
		BufferedReader frBuffer = null;
		FileWriter fw = null;

		try {

			frBuffer = new BufferedReader(new FileReader(fichero_original));
			fw = new FileWriter(fichero, true);

			String linea = frBuffer.readLine();

			while (linea != null) {

				fw.write(linea);
				linea = frBuffer.readLine();
			}

			fw.flush();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				fw.close();
				frBuffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Este m�todo lee un fichero y copia su contenido en otro fichero cambiando
	 * todos los puntos, punto y coma y comas por un salto de l�nea.
	 * 
	 * @param fichero        Ruta del fichero a leer.
	 * @param quijote_lineas Ruta del fichero a escribir o crear y escribir.
	 */
	public static void leerFicheroYescribir(final String fichero, final String quijote_lineas) {

		BufferedWriter fwBuffer = null;
		FileReader fr = null;
		int caracter = 0;
		char c = 0;

		try {

			fr = new FileReader(fichero);
			fwBuffer = new BufferedWriter(new FileWriter(quijote_lineas, true));

			while (caracter != -1) {
				caracter = fr.read();
				c = (char) caracter;

				if (c == '.' || c == ',' || c == ';' || c == '?') {
					fwBuffer.newLine();

				} else if (caracter != -1) {
					fwBuffer.write(c);
				}

			}

			fwBuffer.flush();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException eo) {
			System.err.println(eo.getMessage());
		} finally {
			try {
				fr.close();
				fwBuffer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * M�todo que lee un fichero por medio de Buffers.
	 * 
	 * @param quijote_lineas Ruta del fichero a leer.
	 */
	public static void leerFinal(final String quijote_lineas) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(quijote_lineas));
			String linea = br.readLine();

			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();

			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException eo) {
			System.err.println(eo.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
