package tema6.practica4;

import javax.swing.JFrame;

public class OtraVentana extends JFrame {


	private static final long serialVersionUID = 1L;

	public OtraVentana() {
		setTitle("Segunda ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);

		Main.changeIcon(this,"hp.jpeg");
		setVisible(true);
	}

	
}
