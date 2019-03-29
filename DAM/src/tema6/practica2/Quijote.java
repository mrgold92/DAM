package tema6.practica2;

/**
 * Clase principal que se encargar� de llamar a los m�todos que se encargan de
 * crear, escribir y leer ficheros.
 * 
 * @author David S.
 *
 */
public class Quijote {

	public static void main(String[] args) {

		// Rutas ficheros
		String fichero_original = "resources/Original.txt";
		String fichero = "resources/Quijote.txt";
		String quijote_lineas = "resources/Quijote_lineas.txt";

		// M�todos que escriben o leen ficheros.
		OperacionesFicheros.generarFichero(fichero, fichero_original);
		OperacionesFicheros.leerFicheroYescribir(fichero, quijote_lineas);
		OperacionesFicheros.leerFinal(quijote_lineas);

	}

}
