package tema7.practica1;

public class Main {
	public static void main(String[] args) {

		boolean salida = false;
		do {
			try {
				Operaciones.Menu();
				salida = Operaciones.getSalida();

			} catch (Exception e) {
				System.out.println("Introduce solo n�meros.");
				salida = true;
			}

		} while (!salida);

	}
}