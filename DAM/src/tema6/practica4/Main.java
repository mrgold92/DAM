package tema6.practica4;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {

	public static void changeIcon(JFrame ventana, String img) {
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("resources/"+img);
		ventana.setIconImage(icono);
	}
	
	public static void main(String[] args) {

		new Ventana();
	}

}
