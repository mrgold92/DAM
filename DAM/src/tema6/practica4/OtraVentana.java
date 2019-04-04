package tema6.practica4;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OtraVentana extends JFrame {

	private static final long serialVersionUID = 1L;

	public OtraVentana() {

		setLayout(new GridBagLayout());
		setTitle("Segunda ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);

		Main.changeIcon(this, "hp.jpeg");

		initComponents();
		setVisible(true);
	}

	public void initComponents() {

		JPanel laminas = new JPanel();

		crearTexto(laminas);
		OtraVentana.this.add(laminas);

	}

	public void crearTexto(JPanel caja) {

		JLabel nivel = new JLabel();

		nivel.setText("Nuevo texto creado.");

		nivel.setBounds(100, 50, 50, 50);

		caja.add(nivel);

	}

}
