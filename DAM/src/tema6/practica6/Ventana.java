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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author david salazar
 *
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = -5992161209784205527L;

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textTelefono;
	private final File RUTA = new File("Alumnos.txt");
	private final File directorio = new File("resources");

	public Ventana() {
		setTitle("Pr\u00E1ctica subir nota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(596, 437);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setBounds(260, 56, 65, 14);
		contentPane.add(labelNombre);

		textNombre = new JTextField();
		textNombre.setBounds(194, 81, 190, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel labelApellido = new JLabel("APELLIDOS");
		labelApellido.setBounds(260, 123, 96, 14);
		contentPane.add(labelApellido);

		textApellidos = new JTextField();
		textApellidos.setBounds(194, 148, 190, 20);
		contentPane.add(textApellidos);
		textApellidos.setColumns(10);

		JLabel labelTelefono = new JLabel("TEL\u00C9FONO");
		labelTelefono.setBounds(248, 200, 108, 14);
		contentPane.add(labelTelefono);

		textTelefono = new JTextField();
		textTelefono.setBounds(194, 226, 190, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		JLabel mensajes = new JLabel("");
		mensajes.setHorizontalAlignment(SwingConstants.CENTER);
		mensajes.setBounds(47, 333, 462, 43);

		contentPane.add(mensajes);

		// GUARDAR
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBounds(175, 300, 108, 23);
		acGuardar(btnNewButton, mensajes);
		contentPane.add(btnNewButton);

		// Mostrar
		JButton btnNewButton_1 = new JButton("Mostrar");
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setBounds(295, 300, 108, 23);
		acMostrar(btnNewButton_1, mensajes);
		contentPane.add(btnNewButton_1);

		setVisible(true);
	}

	public void acGuardar(JButton btnNewButton, JLabel mensajes) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!textNombre.getText().equals("") && !textApellidos.getText().equals("")
						&& !textTelefono.getText().equals("")) {

					String nombre = textNombre.getText();
					String apellidos = textApellidos.getText();
					String telefono = textTelefono.getText();
					addToFichero(nombre, apellidos, telefono, mensajes);
					textNombre.setText("");
					textApellidos.setText("");
					textTelefono.setText("");

				} else {
					mensajes.setOpaque(true);
					mensajes.setBackground(new Color(135, 36, 21));
					mensajes.setForeground(Color.white);
					mensajes.setText("Debes rellenar todos los campos");
				}
			}
		});
	}

	public void acMostrar(JButton btnNewButton_1, JLabel mensajes) {
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textTelefono.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Debes introducir un tel\u00e9fono");
				} else {
					String telefono = textTelefono.getText();
					buscarA(telefono, mensajes);
					textTelefono.setText("");
				}
			}
		});
	}

	public void addToFichero(String nombre, String apellidos, String telefono, JLabel mensajes) {

		BufferedWriter escritor;
		mensajes.setText("");
		String[] info = { nombre, apellidos, telefono };

		// creamos la carpeta "resources" si no existiera (dentro del proyecto, al nivel
		// de src)
		if (!directorio.exists()) {
			directorio.mkdir();
		}

		try {
			escritor = new BufferedWriter(new FileWriter(directorio + "/" + RUTA, true));

			for (String i : info) {
				escritor.write(i + " ");

			}

			escritor.write("\n");
			escritor.flush();
			escritor.close();

			JOptionPane.showMessageDialog(null, "Informaci\u00f3n guardada correctamente.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void buscarA(String telefono, JLabel mensaje) {

		BufferedReader lector;
		mensaje.setOpaque(false);
		mensaje.setText("");

		try {
			lector = new BufferedReader(new FileReader(directorio + "/" + RUTA));

			String linea, info = "";

			while ((linea = lector.readLine()) != null) {
				if (linea.contains(telefono)) {
					info = linea;

				} else {
					mensaje.setText("No hemos encontrado ning\u00fan registro.");
				}

			}

			mensaje.setText(info);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
