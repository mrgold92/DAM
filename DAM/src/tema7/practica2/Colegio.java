package tema7.practica2;


import java.util.Arrays;
import java.util.Scanner;

public class Colegio {

	private static Scanner teclado = new Scanner(System.in);
	private String nombre;
	private String apellido1;
	private String apellido2;
	private static Colegio[][] alumnos;
	private static int clases, alum;

	public Colegio(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String mostrar() {
		return this.nombre + " " + this.apellido1 + " " + this.apellido2;
	}

	public static void begin() {
		int opcion, opcion2;
		String n, a1, a2;
		System.out.println("Dime el numero de clases");
		opcion = teclado.nextInt();
		clases = opcion;
		System.out.println("Dime el numero de alumnos");
		opcion2 = teclado.nextInt();
		alum = opcion2;
		alumnos = new Colegio[opcion][opcion2];

		for (int i = 0; i < opcion; i++) {
			for (int j = 0; j < opcion2; j++) {
				System.out.println("Dime nombre del alumno " + j + " de la clase " + i);
				n = teclado.next();
				System.out.println("Dime apellido1 del alumno " + j + " de la clase " + i);
				a1 = teclado.next();
				System.out.println("Dime apellido2 del alumno " + j + " de la clase " + i);
				a2 = teclado.next();

				alumnos[i][j] = new Colegio(n, a1, a2);
				teclado.nextLine();

			}
		}

		menu();
	}

	public static void menu() {
		int opcion;
		System.out.println("Elige una opci�n:");
		System.out.println("1) Sacar por pantalla todos los alumnos de una clase.\n"
				+ "2) Sacar por pantalla a qu� clase pertenece 1 alumno.\n"
				+ "3) Sacar por pantalla cu�ntos alumnos hay con el mismo apellido.\n"
				+ "4) Sacar por pantalla cu�ntos alumnos hay en total.\n"
				+ "5) Sacar por pantalla todos los alumnos ordenados.");
		opcion = teclado.nextInt();

		switch (opcion) {
		case 1:
			System.out.println();
			allStudents();
			break;
		case 2:
			System.out.println();
			returnStudentClass();
			break;
		case 3:
			System.out.println();
			returSameSurname();
			break;
		case 4:
			System.out.println();
			totalStudents();
			break;
		case 5:
			System.out.println();
			StudentsByOrder();
			break;
		default:
			System.out.println("Elige un n�mero del 1 al 5.");
			break;
		}
	}

	public static void allStudents() {
		int opcion;
		System.out.println("�De qu� clase quieres saber sus alumnos?");
		opcion = teclado.nextInt();
		System.out.println();

		if (opcion > alumnos.length) {
			System.out.println("No existe esa clase. Introduce valores del 1 al " + (alumnos.length) + ".");
		} else {
			System.out.println("Alumnos de la clase " + opcion + ":");

			for (int j = 0; j < alumnos[opcion - 1].length; j++) {

				System.out.println(alumnos[opcion - 1][j].mostrar());
			}

		}
	}

	public static void returnStudentClass() {
		int alumno = 0;

		String nombre, mensaje = "";
		System.out.println("Dime el nombre de un alumno.");
		nombre = teclado.next();
		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {
				if (alumnos[i][j].getNombre().equals(nombre)) {
					alumno = i;
					mensaje = "El alumno " + nombre + " es de la clase " + alumno + ".";
				}
			}
		}

		if (mensaje == "") {
			System.out.println("No existe el alumno " + nombre);
		} else {
			System.out.println(mensaje);
		}

	}

	public static void returSameSurname() {
		String surname, opcion;
		int contador = 0;
		System.out.print("Dime un apellido:");
		opcion = teclado.next();

		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {

				surname = alumnos[i][j].getApellido1();

				if (surname.equals(opcion)) {
					contador++;
					System.out.println(alumnos[i][j].mostrar());
				}

			}

		}

		System.out.println("Hay " + contador + " alumnos con este apellido.");
	}

	public static void totalStudents() {
		int alumno = 0;
		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {
				alumno++;
			}
		}
		System.out.println("Hay " + alumno + " alumnos en el centro.");
	}

	public static void StudentsByOrder() {
		String[] array = new String[clases * alum];
		int c = 0;
		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < alumnos[i].length; j++) {
				array[c] = alumnos[i][j].getApellido1() + " " + alumnos[i][j].getApellido2() + ", "
						+ alumnos[i][j].getNombre();
				c++;
			}
		}
		Arrays.sort(array);
		for (String a : array) {
			System.out.println(a);
		}

	}
}
