package tema6.practica5;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase que transforma un texto a su texto del revés.
 * 
 * @author david salazar
 *
 */
public class VentanaOrden extends JFrame {

	private static final long serialVersionUID = -2949479038856503031L;

	public VentanaOrden() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(677, 326);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Ventana Orden");

		initComponentes();

		setVisible(true);
	}

	/**
	 * Método que inicia todos mis componentes.
	 */
	public void initComponentes() {
		JLabel etiquetaDerecha = new JLabel("Derecho");
		etiquetaDerecha.setBounds(151, 85, 66, 15);

		JLabel etiquetaIzquierda = new JLabel("Revés");
		etiquetaIzquierda.setBounds(396, 85, 66, 15);

		JTextField textoIzquierdo = new JTextField();
		textoIzquierdo.setBounds(151, 112, 124, 19);

		JTextField textoDerecho = new JTextField();
		textoDerecho.setBounds(396, 112, 124, 19);
		add(textoDerecho);

		JButton btnIzquierdo = new JButton("<");
		btnIzquierdo.setForeground(SystemColor.text);
		btnIzquierdo.setBackground(SystemColor.desktop);
		btnIzquierdo.setBounds(308, 80, 44, 25);

		// llamada a la acción del botón izquierdo
		delderecho(btnIzquierdo, textoDerecho, textoIzquierdo);

		JButton btnDerecho = new JButton(">");
		btnDerecho.setForeground(SystemColor.text);
		btnDerecho.setBackground(SystemColor.desktop);

		btnDerecho.setBounds(308, 129, 44, 25);

		// llamada a la acción del botón derecho
		delreves(btnDerecho, textoDerecho, textoIzquierdo);

		add(etiquetaDerecha);
		add(etiquetaIzquierda);
		add(textoIzquierdo);
		add(textoDerecho);
		add(btnIzquierdo);
		add(btnDerecho);

	}

	/**
	 * 
	 * @param JButton    btnIzquierdo
	 * @param JTextField textoDerecho
	 * @param JTextField textoIzquierdo
	 */

	public void delderecho(JButton btnIzquierdo, JTextField textoDerecho, JTextField textoIzquierdo) {
		btnIzquierdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textoDerecho.getText();
				String in = "";

				for (int i = texto.length() - 1; i >= 0; i--) {
					in = in + texto.charAt(i);

				}
				textoIzquierdo.setText(in);
			}
		});
	}

	/**
	 * 
	 * @param JButton    btnDerecho
	 * @param JTextField textoDerecho
	 * @param JTextField textoIzquierdo
	 */
	public void delreves(JButton btnDerecho, JTextField textoDerecho, JTextField textoIzquierdo) {
		btnDerecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textoIzquierdo.getText();
				String in = "";

				for (int i = texto.length() - 1; i >= 0; i--) {
					in = in + texto.charAt(i);

				}
				textoDerecho.setText(in);
			}
		});
	}
}
