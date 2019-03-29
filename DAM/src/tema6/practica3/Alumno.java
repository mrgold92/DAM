package tema6.practica3;

import java.io.Serializable;

/**
 * Clase alumno preparada para que un objeto de su clase, pueda ser copiado en
 * un archivo gracias a la serialización.
 * 
 * @author david
 *
 */
public class Alumno implements Serializable {

	private static final long serialVersionUID = -8004149943747018653L;

	protected String nombre;
	protected String apellido;
	private static int numalumnos;
	protected static int notaMedia;

	/**
	 * constructor por defecto
	 */
	public Alumno() {
		this.nombre = "";
		this.apellido = "";
		numalumnos++;
	}

	/**
	 * Constructor que recibe parámetros
	 * 
	 * @param n
	 * @param ap
	 */
	Alumno(String n, String ap) {
		this.nombre = n;
		this.apellido = ap;
		numalumnos++;
	}

	/**
	 * constructor que recibe un objeto constructor copia
	 * 
	 * @param r
	 */
	Alumno(Alumno r) {
		this.nombre = r.getNombre();
		this.apellido = r.getApellido();
		numalumnos++;
	}

	// SETTERS & GETTERS

	/**
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param apellido
	 */

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return numero de alumnos
	 */
	public int getNumalumnos() {
		return this.numalumnos;
	}

	/**
	 * 
	 * @param numalumnos
	 */
	public void setNumalumnos(int numalumnos) {
		this.numalumnos = numalumnos;
	}

	// MÉTODOS
	/**
	 * Método que incrementa la variable notaMedia en 1.
	 */
	public void incrementar() {
		notaMedia++;
	}

	/**
	 * Método que llama al método incrementar
	 * 
	 * @see incrementar()
	 * @return notaMedia
	 */

	public int resultado() {

		this.incrementar();
		incrementar();

		return notaMedia;
	}
}
