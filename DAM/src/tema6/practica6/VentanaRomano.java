package tema6.practica6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author david salazar
 *
 */
public class VentanaRomano extends JFrame {

	private static final long serialVersionUID = 3791124849805687885L;
	private JPanel contentPane;
	private JTextField textoIzquierda;
	private JTextField textoDerecha;
	private JButton btnParaDerecha;
	private JButton btnParaIzquierda;
	private JLabel mensaje;

	private final File DIRECTORIO = new File("resources");
	private final File RUTA = new File("resources/romanos.txt");

	public VentanaRomano() {
		crearFichero();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(570, 389);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelIzquierda = new JLabel("Romano");
		labelIzquierda.setBounds(80, 123, 58, 15);
		contentPane.add(labelIzquierda);

		JLabel lblDerecha = new JLabel("Decimal");
		lblDerecha.setBounds(351, 123, 58, 15);
		contentPane.add(lblDerecha);

		textoIzquierda = new JTextField();
		textoIzquierda.setBounds(80, 150, 124, 27);
		contentPane.add(textoIzquierda);
		textoIzquierda.setColumns(10);

		textoDerecha = new JTextField();
		textoDerecha.setColumns(10);
		textoDerecha.setBounds(351, 150, 124, 27);
		contentPane.add(textoDerecha);

		btnParaDerecha = new JButton(">");
		btnParaDerecha.setBounds(255, 118, 48, 25);
		contentPane.add(btnParaDerecha);

		btnParaIzquierda = new JButton("<");
		btnParaIzquierda.setBounds(255, 183, 48, 25);
		contentPane.add(btnParaIzquierda);
		setVisible(true);

		mensaje = new JLabel("");
		mensaje.setBounds(45, 254, 469, 65);
		contentPane.add(mensaje);

		// Llamada a acciones
		acciones(btnParaIzquierda, btnParaDerecha);
	}

	public void crearFichero() {

		BufferedWriter escritor = null;

		if (!DIRECTORIO.exists()) {
			DIRECTORIO.mkdir();
		}

		if (!RUTA.exists()) {
			try {
				RUTA.createNewFile();
				escritor = new BufferedWriter(new FileWriter(RUTA, true));
				for (int i = 1; i <= 3999; i++) {
					escritor.write(i + " " + convertirRomano(i) + "\n");
				}

				escritor.flush();
				escritor.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public String convertirRomano(int numero) {
		int i, miles, centenas, decenas, unidades;
		String romano = "";
		// obtenemos cada cifra del número
		miles = numero / 1000;
		centenas = numero / 100 % 10;
		decenas = numero / 10 % 10;
		unidades = numero % 10;

		// millar
		for (i = 1; i <= miles; i++) {
			romano = romano + "M";
		}

		// centenas
		if (centenas == 9) {
			romano = romano + "CM";
		} else if (centenas >= 5) {
			romano = romano + "D";
			for (i = 6; i <= centenas; i++) {
				romano = romano + "C";
			}
		} else if (centenas == 4) {
			romano = romano + "CD";
		} else {
			for (i = 1; i <= centenas; i++) {
				romano = romano + "C";
			}
		}

		// decenas
		if (decenas == 9) {
			romano = romano + "XC";
		} else if (decenas >= 5) {
			romano = romano + "L";
			for (i = 6; i <= decenas; i++) {
				romano = romano + "X";
			}
		} else if (decenas == 4) {
			romano = romano + "XL";
		} else {
			for (i = 1; i <= decenas; i++) {
				romano = romano + "X";
			}
		}

		// unidades
		if (unidades == 9) {
			romano = romano + "IX";
		} else if (unidades >= 5) {
			romano = romano + "V";
			for (i = 6; i <= unidades; i++) {
				romano = romano + "I";
			}
		} else if (unidades == 4) {
			romano = romano + "IV";
		} else {
			for (i = 1; i <= unidades; i++) {
				romano = romano + "I";
			}
		}
		return romano;
	}

	public void acciones(JButton btnParaIzquierda, JButton btnParaDerecha) {

		btnParaIzquierda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedReader lector;

				try {
					lector = new BufferedReader(new FileReader(RUTA));

					String linea, info = "";

					while ((linea = lector.readLine()) != null) {

						int posicion = linea.indexOf(" ");

						String numero = linea.substring(0, posicion);
						String romano = linea.substring(posicion + 1);

						if (textoDerecha.getText().equals(numero)) {
							info = romano;

						}

					}

					if (info.equals("")) {
						mensaje.setText("No se han encontrado resultados.");
					} else {
						mensaje.setText("");
						textoIzquierda.setText(info);
					}

				} catch (IOException ea) {

					ea.printStackTrace();
				}
			}
		});

		btnParaDerecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String textoIz = textoIzquierda.getText().toUpperCase();
				;
				BufferedReader lector;

				try {
					lector = new BufferedReader(new FileReader(RUTA));

					String linea, info = "";

					while ((linea = lector.readLine()) != null) {

						int posicion = linea.indexOf(" ");

						String numero = linea.substring(0, posicion);
						String romano = linea.substring(posicion + 1);

						if (textoIz.equals(romano)) {
							info = numero;

						}

					}

					if (info.equals("")) {
						mensaje.setText("No se han encontrado resultados.");
					} else {
						mensaje.setText("");
						textoDerecha.setText(info);
					}

				} catch (IOException ea) {

					ea.printStackTrace();
				}
			}
		});
	}

}
