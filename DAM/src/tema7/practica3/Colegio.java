package tema7.practica3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Colegio {

	private static Scanner teclado = new Scanner(System.in);
	private String nombre;
	private String apellido1;
	private String apellido2;
	private static ArrayList<Colegio> alumnos = new ArrayList<Colegio>();
	private int clases;

	public Colegio(String nombre, String apellido1, String apellido2, int clase) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.clases = clase;
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

	public int getClases() {
		return clases;
	}

	public void setClases(int clases) {
		this.clases = clases;
	}

	public String mostrar() {
		return this.nombre + " " + this.apellido1 + " " + this.apellido2;
	}

	public static void begin() {
		int opcion, opcion2;
		String n, a1, a2;
		System.out.println("Dime el numero de clases");
		opcion = teclado.nextInt();
		System.out.println("Dime el numero de alumnos");
		opcion2 = teclado.nextInt();

		for (int i = 0; i < opcion; i++) {
			for (int j = 0; j < opcion2; j++) {
				System.out.println("Dime nombre del alumno " + j + " de la clase " + i);
				n = teclado.next();
				System.out.println("Dime apellido1 del alumno " + j + " de la clase " + i);
				a1 = teclado.next();
				System.out.println("Dime apellido2 del alumno " + j + " de la clase " + i);
				a2 = teclado.next();

				alumnos.add(new Colegio(n, a1, a2, i));
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

	public String mostrar(int p, String o) {
		if (o.equals("a")) {
			return alumnos.get(p).getApellido1() + " " + alumnos.get(p).getApellido2() + " "
					+ alumnos.get(p).getNombre();
		} else {
			return alumnos.get(p).getNombre() + " " + alumnos.get(p).getApellido1() + " "
					+ alumnos.get(p).getApellido2();
		}

	}

	public static void allStudents() {
		int opcion;
		System.out.println("�De qu� clase quieres saber sus alumnos?(1-" + alumnos.size() + ")");
		opcion = teclado.nextInt();
		System.out.println();

		if (opcion - 1 >= alumnos.size() || opcion - 1 < 0) {
			System.out.println("No existe esa clase.");
		} else {
			System.out.println("Alumnos de la clase " + opcion + ":");

			for (int j = 0; j < alumnos.size(); j++) {

				if (alumnos.get(j).getClases() == opcion - 1) {
					System.out.println(alumnos.get(j).mostrar(j, ""));
				}
			}

		}
	}

	public static void returnStudentClass() {

		String nombre, apellido1, apellido2, mensaje = "";
		System.out.println("Dime el nombre de un alumno.");
		nombre = teclado.next();
		System.out.println("Dime apellido del alumno");
		apellido1 = teclado.next();
		System.out.println("Dime apellido2 del alumno");
		apellido2 = teclado.next();
		for (int i = 0; i < alumnos.size(); i++) {

			if (alumnos.get(i).getNombre().equals(nombre) && alumnos.get(i).getApellido1().equals(apellido1)
					&& alumnos.get(i).getApellido2().equals(apellido2)) {
				mensaje = "El alumno " + nombre + " es de la clase " + (i + 1) + ".";

			}
		}

		if (mensaje == "") {
			System.out.println("No existe el alumno " + nombre + " " + apellido1 + " " + apellido2);
		} else {
			System.out.println(mensaje);
		}

	}

	public static void returSameSurname() {
		String opcion;
		int contador = 0;
		System.out.print("Dime un apellido:");
		opcion = teclado.next();

		for (int i = 0; i < alumnos.size(); i++) {

			if (alumnos.get(i).getApellido1().equals(opcion)) {

				System.out.println(alumnos.get(i).mostrar(i, ""));
				contador++;
			}

		}

		System.out.println("Hay " + contador + " alumnos con este apellido.");
	}

	public static void totalStudents() {

		System.out.println("Hay " + alumnos.size() + " alumnos en el centro.");
	}

	public static void StudentsByOrder() {
		String[] array = new String[alumnos.size()];
		for (int i = 0; i < alumnos.size(); i++) {

			array[i] = alumnos.get(i).mostrar(i, "a");
		}

		Arrays.sort(array);

		for (String a : array) {
			System.out.println(a);
		}
	}

}