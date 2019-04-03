package tema6.practica4;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	public void crearVentana() {

		setTitle("Primera ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 650);
		setLocationRelativeTo(null);
		//setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setResizable(false);
		changeIcon();
		setVisible(true);

	}

	public void otraVentana() {

		setTitle("Segunda ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centrar();
		changeIcon();
		setVisible(true);
	}

	public void centrar() {

		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tpantalla = pantalla.getScreenSize();
		int altura = tpantalla.height;
		int ancho = tpantalla.width;
		setSize(ancho, altura / 2);
		setLocation(ancho / altura, altura / 4);

	}

	public void changeIcon() {
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("resources/descarga.png");
		setIconImage(icono);
	}

	public static void main(String[] args) {

		Principal ventana = new Principal();

		ventana.crearVentana();
		ventana.otraVentana();

	}

}
