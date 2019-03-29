package tema6.practica3;

/**
 * Clase principal del ejercicio3 del tema6 de programación, esta clase se
 * ecargará de llamar a todos los métodos necesarios para cumplir con los
 * objetivos de la práctica.
 * 
 * @author david s
 *
 */
public class Principal {

	public static void main(String[] args) {

		Alumno alum = new Alumno("David", "Salazar");
		Alumno[] alumnos = new Alumno[5];

		String fichero = "AlumnoCopia.obj";
		String directorio = "PruebaDirectorio";
		String carpetaLista = "bin";

		CopiasObjetos.crearCopiaObjeto(alum);
		System.out.println("-------------------");
		CopiasObjetos.crearCopiaArrayObjeto(alumnos);
		System.out.println("-------------------");
		CopiasObjetos.comprobarFile(fichero);
		System.out.println("-------------------");
		CopiasObjetos.listarFicherosDirectorios(carpetaLista);
		System.out.println("-------------------");
		CopiasObjetos.crearDirectorio(directorio);

	}

}
