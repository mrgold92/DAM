package tema7.practica1;

import java.util.Scanner;

public class Operaciones {

	private static Scanner teclado = new Scanner(System.in);
	private static boolean salida = false;

	public static boolean getSalida() {
		return salida;
	}

	public static void Menu() {
		int opcion;

		System.out.println("Elige un ejercicio:");
		System.out.println();
		System.out.println(
				"1. Array del 1 al 50 y m�ltiplos de 10.\n" + "2. Array bidemensional con valores por el usuario.\n"
						+ "3. Array de tama�o dado por panatalla y rellene n�meros aleatorios.");

		opcion = teclado.nextInt();

		if (opcion > 3 || opcion < 1) {
			System.out.println("Debes introducir un n�mero del 1 al 3");
		} else {
			switch (opcion) {
			case 1:
				System.out.println();
				ejercicio1();
				break;
			case 2:
				System.out.println();
				ejercicio2();
				break;
			case 3:
				System.out.println();
				ejercicio3();
				break;
			default:
				System.out.println("Introduce valores del 1 al 3");
				break;

			}

		}

		salir();

	}

	public static void ejercicio1() {
		// CREAMOS E INICIALIZAMOS EL ARRAY
		int[] numeros = new int[50];

		// RECORREMOS EL ARRAY, PONIENDO EN CADA �NDICE
		// UN N�MERO CONSECUTIVO HASTA LLEGAR AL 50.
		for (int i = 0; i < numeros.length; i++) {

			numeros[i] = i + 1;

			if (numeros[i] % 10 == 0) {
				System.out.println(numeros[i] + " es m�ltiplo de 10.");
			}

		}
	}

	public static void ejercicio2() {
		// CREAMOS EL ARRAY BIDIMENSIONAL
		int[][] numeros = new int[2][3];
		int usuario;

		// LLENAMOS EL ARRAY CON LOS N�MEROS QUE
		// PEDIMOS AL USUARIO
		for (int i = 0; i < numeros.length; i++) {

			for (int j = 0; j < numeros[i].length; j++) {
				System.out.println("Dime un n�mero");
				usuario = teclado.nextInt();
				numeros[i][j] = usuario;
			}
		}
		System.out.println();

		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				System.out.print(numeros[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void ejercicio3() {
		int opcion, aleatorio, mayor = 0;

		// PEDIMOS AL USUARIO LA DIMENSI�N DEL ARRAY
		System.out.println("Dime el tama�o del array:");
		opcion = teclado.nextInt();

		// LE ASIGNAMOS AL ARRAY ESA DIMENSI�N
		int[] array = new int[opcion];

		// GENERAMOS UN NUMERO ALEATORIO DE 1 A 100,
		// SE LO ASINGAMOS AL ARRAY
		// Y PREGUNTAMOS CU�L ES MAYOR
		for (int i = 0; i < array.length; i++) {
			aleatorio = (int) (Math.random() * 100) + 1;
			array[i] = aleatorio;
			System.out.println("En la posici�n " + i + " guardamos: " + array[i]);
			if (array[i] > mayor) {
				mayor = array[i];
			}
		}

		// IMPRIMIMOS EL N�MERO MAYOR
		System.out.println("El n�mero mayor es: " + mayor);
	}

	public static void salir() {
		int opcion;
		System.out.println();
		System.out.println("�Quieres salir(1) o empezar de nuevo(2)?");
		opcion = teclado.nextInt();

		if (opcion > 2 || opcion < 1) {
			salir();
		} else {
			if (opcion == 1) {
				System.out.println("�Hasta pronto!");
				salida = true;
			} else {
				salida = false;
			}
		}

	}
}