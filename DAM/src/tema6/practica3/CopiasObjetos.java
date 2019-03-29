package tema6.practica3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase encarga de gestionar copias de objetos en ficheros, y además gestiona
 * directorios y ficheros.
 * 
 * @author david s
 *
 */
public class CopiasObjetos {

	/**
	 * Método que copia un objeto en un archivo para poder recuperarlo.
	 * 
	 * @param alum objeto de tipo alumno
	 */
	public static void crearCopiaObjeto(Alumno alum) {
		ObjectOutputStream salida = null;
		ObjectInputStream enter = null;

		System.out.println("Copiando y guardando objeto...");

		try {
			salida = new ObjectOutputStream(new FileOutputStream("resources/AlumnoCopia.obj"));

			salida.writeObject(alum);

			salida.close();
			enter = new ObjectInputStream(new FileInputStream("resources/AlumnoCopia.obj"));

			Alumno AlumnoCopia = (Alumno) enter.readObject();

			enter.close();

			System.out.println("Objeto guardado correctamente como AlumnoCopia.obj");
			System.out.println("Comprobando objeto...\nBuscando nombre...");
			System.out.println("Nombre: " + AlumnoCopia.getNombre());
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Método que genera un número aleatorio hasta un máximo.
	 * 
	 * @param numero límite máximo del número aleatorio.
	 * @return
	 */
	private static int aleatorios(int numero) {

		int aleatorio = (int) (Math.random() * numero);

		return aleatorio;
	}

	/**
	 * Método que crea un array de objetos alumnos y copia el array entero en un
	 * fichero.
	 * 
	 * @param alum objeto de tipo alumno
	 */
	public static void crearCopiaArrayObjeto(Alumno[] alum) {

		String[] nombres = { "Jorge", "Antonio", "Pepe", "David", "Lucía", "Lorena" };
		String[] apellidos = { "Lopez", "Sánchez", "Roca", "Salazar", "Gómez", "Garcés" };

		String nombre;
		String apellido;
		int j = 0;

		ObjectOutputStream salida = null;
		ObjectInputStream enter = null;

		System.out.println("Creando array de objetos....");
		for (int i = 0; i < alum.length; i++) {

			nombre = nombres[aleatorios(6)];
			apellido = apellidos[aleatorios(6)];

			alum[i] = new Alumno(nombre, apellido);
		}

		try {
			salida = new ObjectOutputStream(new FileOutputStream("resources/AlumnoArrayCopia.obj"));

			salida.writeObject(alum);

			salida.close();

			enter = new ObjectInputStream(new FileInputStream("resources/AlumnoArrayCopia.obj"));

			Alumno[] AlumnoCopia = (Alumno[]) enter.readObject();

			enter.close();

			System.out.println("Copia de arrays de objetos guardada correctamente como AlumnoArrayCopia.obj");

			for (Alumno alCopy : AlumnoCopia) {

				System.out.println("Nombre del alumno y apellidos " + ++j + ": " + alCopy.getNombre() + " "
						+ alCopy.getApellido());
			}

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Método que comprueba si un fichero existe y de ser así, comprueba si es un
	 * archivo o directorio y muestra su información.
	 * 
	 * @param fichero nombre del fichero a buscar.
	 */
	public static void comprobarFile(String fichero) {
		File archivo = new File("resources/" + fichero);

		System.out.println("Comprobando archivo...");
		if (archivo.exists()) {
			System.out.println("El fichero existe.");

			if (archivo.isFile()) {
				System.out.println("El fichero es un archivo.");
				System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
				System.out.println("¿Se puede escribir? " + archivo.canRead());
				System.out.println("¿Se puede ejecutar? " + archivo.canExecute());
				System.out.println("Tamaño del fichero: " + archivo.length() + " bytes");

			} else {
				System.out.println("El archivo es un directorio");
				System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
				System.out.println("¿Se puede escribir? " + archivo.canRead());
				System.out.println("¿Se puede ejecutar? " + archivo.canExecute());
				System.out.println("Tamaño del fichero: " + archivo.length() + " bytes");
			}
		} else {
			System.out.println("El fichero no existe.");
		}

	}

	/**
	 * Método que dado un directorio, lista todos sus directorios hijos y archivos.
	 * 
	 * @param busqueda
	 */
	public static void listarFicherosDirectorios(String busqueda) {
		File directorio = new File(busqueda);

		String[] lista = directorio.list();

		System.out.println("Buscando...");

		System.out.println("Lista de directorios y ficheros de la carpeta:");
		System.out.println(directorio.getName() + "/");
		for (String listaDyF : lista) {

			System.out.println("\t" + listaDyF);
		}
	}

	/**
	 * Método que dado un fichero, lo crea si no existe.
	 * 
	 * @param directorio nombre del directorio a crear.
	 */
	public static void crearDirectorio(String directorio) {

		File newDirectorio = new File("resources/" + directorio);

		System.out.println("Creando directorio...");
		newDirectorio.mkdir();
		System.out.println();

		if (newDirectorio.exists()) {
			System.out.println("Directorio creado correctamente.");
		} else {
			System.out.println("No se ha podido crear el directorio.");
		}

	}
}
