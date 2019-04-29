package tema6.practica5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class VentanaOrden extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JTextPane textIzquierdo;
	private JTextPane textDerecho;
	private JLabel lblDerecho;
	private JLabel lblRevs;

	public VentanaOrden() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		// componentes
		labels();
		botones();
		inputsTextos();

		setVisible(true);

		// eventos

		cambiarOrden();

	}

	public void botones() {
		btnIzquierda = new JButton("<");
		btnIzquierda.setBackground(Color.ORANGE);
		btnIzquierda.setForeground(Color.BLACK);
		btnIzquierda.setFocusable(false);
		btnIzquierda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIzquierda.setBounds(165, 91, 89, 23);
		contentPane.add(btnIzquierda);

		btnDerecha = new JButton(">");
		btnDerecha.setBackground(Color.ORANGE);
		btnDerecha.setFocusable(false);
		btnDerecha.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDerecha.setBounds(165, 147, 89, 23);
		contentPane.add(btnDerecha);
	}

	public void labels() {
		lblDerecho = new JLabel("Derecho");
		lblDerecho.setForeground(new Color(255, 255, 255));
		lblDerecho.setBounds(44, 91, 88, 14);
		contentPane.add(lblDerecho);

		lblRevs = new JLabel("Rev\u00E9s");
		lblRevs.setForeground(new Color(255, 255, 255));
		lblRevs.setBounds(288, 91, 88, 14);
		contentPane.add(lblRevs);
	}

	public void inputsTextos() {
		textIzquierdo = new JTextPane();
		textIzquierdo.setBounds(44, 116, 88, 20);
		contentPane.add(textIzquierdo);

		textDerecho = new JTextPane();
		textDerecho.setBounds(288, 116, 88, 20);
		contentPane.add(textDerecho);
	}

	public void cambiarOrden() {
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String texto = textIzquierdo.getText();

				String in = "";

				for (int i = texto.length() - 1; i >= 0; i--) {
					in = in + texto.charAt(i);

				}

				textDerecho.setText(in);
			}
		});

		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textDerecho.getText();

				String in = "";

				for (int i = texto.length() - 1; i >= 0; i--) {
					in = in + texto.charAt(i);

				}

				textIzquierdo.setText(in);

			}
		});
	}
}
