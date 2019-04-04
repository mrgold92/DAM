package tema6.practica4;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OtraVentana extends JFrame {

	private static final long serialVersionUID = 1L;

	public OtraVentana() {

		setTitle("Segunda ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);

		Main.changeIcon(this, "hp.jpeg");
		setBackground(Color.white);
		initComponents();

		setVisible(true);
	}

	public void initComponents() {

		JPanel lamina = new JPanel();
		JLabel nivel = new JLabel("Texto creado", JLabel.CENTER);
		Color newColor = new Color(53, 103, 132);

		nivel.setForeground(Color.white);

		lamina.setLayout(new BorderLayout());
		lamina.setBackground(newColor);
		lamina.add(nivel);

		OtraVentana.this.add(lamina);

	}

}
