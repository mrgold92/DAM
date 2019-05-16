package tema8.practica2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Zoo extends JFrame {

	private static final long serialVersionUID = -6558803116086110484L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textTipoComida;
	private JTextField textCantidadComida;
	private JButton btnAlta;
	private JButton btnConsultar;
	private JButton btnBaja;
	private JLabel mensaje;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnImportar;

	public Zoo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLabel lblZoolgico = new JLabel("ZOOL\u00D3GICO");
		lblZoolgico.setHorizontalAlignment(SwingConstants.CENTER);
		lblZoolgico.setBounds(239, 26, 201, 14);
		contentPane.add(lblZoolgico);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(84, 138, 194, 14);
		contentPane.add(lblNombre);

		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(84, 162, 194, 14);
		contentPane.add(lblEdad);

		JLabel lblTipoDeComida = new JLabel("TIPO DE COMIDA");
		lblTipoDeComida.setBounds(84, 187, 194, 14);
		contentPane.add(lblTipoDeComida);

		JLabel lblCantidadDeComida = new JLabel("CANTIDAD DE COMIDA (KG)");
		lblCantidadDeComida.setBounds(84, 212, 194, 14);
		contentPane.add(lblCantidadDeComida);

		JLabel lblIdentificacin = new JLabel("IDENTIFICACI\u00D3N");
		lblIdentificacin.setBounds(84, 113, 194, 14);
		contentPane.add(lblIdentificacin);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(284, 107, 258, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(284, 132, 258, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textEdad = new JTextField();
		textEdad.setBounds(284, 156, 258, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);

		textTipoComida = new JTextField();
		textTipoComida.setBounds(284, 181, 258, 20);
		contentPane.add(textTipoComida);
		textTipoComida.setColumns(10);

		textCantidadComida = new JTextField();
		textCantidadComida.setBounds(285, 206, 257, 20);
		contentPane.add(textCantidadComida);
		textCantidadComida.setColumns(10);

		btnAlta = new JButton("ALTA");
		btnAlta.setForeground(new Color(255, 255, 255));
		btnAlta.setBackground(new Color(46, 139, 87));

		btnAlta.setBounds(106, 304, 89, 23);
		contentPane.add(btnAlta);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(244, 164, 96));
		btnConsultar.setBounds(221, 304, 132, 23);
		contentPane.add(btnConsultar);

		btnBaja = new JButton("BAJA");
		btnBaja.setForeground(new Color(255, 255, 255));
		btnBaja.setBackground(new Color(178, 34, 34));
		btnBaja.setBounds(380, 304, 89, 23);
		contentPane.add(btnBaja);

		btnEditar = new JButton("EDITAR");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(0, 139, 139));
		btnEditar.setBounds(504, 304, 89, 23);
		contentPane.add(btnEditar);

		btnImportar = new JButton("IMPORTAR");
		btnImportar.setBounds(541, 22, 136, 23);
		contentPane.add(btnImportar);

		mensaje = new JLabel("");
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje.setBounds(106, 339, 487, 47);
		contentPane.add(mensaje);
		setVisible(true);

		Animales a = new Animales(mensaje);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBackground(new Color(0, 51, 51));
		btnBorrar.setFocusable(false);
		btnBorrar.setBounds(28, 22, 113, 23);
		contentPane.add(btnBorrar);

		// ACCIONES
		alta(a);
		consulta(a);
		baja(a);
		modificar(a);
		borrar();
		subir(a);

	}

	public void borrar() {
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombre.setText("");
				textCantidadComida.setText("");
				textID.setText("");
				textTipoComida.setText("");
				textEdad.setText("");
				mensaje.setOpaque(false);
				mensaje.setText("");
			}
		});
	}

	public void alta(Animales a) {

		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textNombre.getText().equals("") || textEdad.getText().equals("") || textTipoComida.equals("")
						|| textCantidadComida.getText().equals("")) {
					mensaje.setOpaque(true);
					mensaje.setBackground(new Color(163, 66, 55));
					mensaje.setForeground(Color.white);
					mensaje.setText("Debes rellenar todos los campos");
				} else {

					String nombre = textNombre.getText();
					Integer edad = Integer.parseInt(textEdad.getText());
					String tipo_comida = textTipoComida.getText();
					int cantidad_c = Integer.parseInt(textCantidadComida.getText());

					a.setNombre(nombre);
					a.setEdad(edad);
					a.setTipo_comida(tipo_comida);
					a.setKg_comida(cantidad_c);

					a.alta();
				}

			}
		});
	}

	public void consulta(Animales a) {

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (textNombre.getText().equals("") || textEdad.getText().equals("")) {
					mensaje.setOpaque(true);
					mensaje.setBackground(Color.red);
					mensaje.setForeground(Color.white);
					mensaje.setText("Introduce el nombre y la edad");

				} else {
					String nombre = textNombre.getText();
					Integer edad = Integer.parseInt(textEdad.getText());
					a.setNombre(nombre);
					a.setEdad(edad);

					if (a.consultar()) {
						textID.setText(Integer.toString(a.getId()));
						textNombre.setText(a.getNombre());
						textEdad.setText(Integer.toString(a.getEdad()));
						textTipoComida.setText(a.getTipo_comida());
						textCantidadComida.setText(Integer.toString(a.getKg_comida()));
					}
				}

			}
		});

	}

	public void baja(Animales a) {
		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textNombre.getText();
				Integer edad = Integer.parseInt(textEdad.getText());

				a.setNombre(nombre);
				a.setEdad(edad);

				a.baja();
			}
		});
	}

	public void modificar(Animales a) {

		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				Integer edad = Integer.parseInt(textEdad.getText());
				String tipo_comida = textTipoComida.getText();
				int cantidad_c = Integer.parseInt(textCantidadComida.getText());

				a.setNombre(nombre);
				a.setEdad(edad);
				a.setKg_comida(cantidad_c);
				a.setTipo_comida(tipo_comida);

				a.modificar();

			}
		});
	}

	public void subir(Animales a) {
		btnImportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LeerFichero fichero = new LeerFichero(new File("resources/zoo.json"));
				textNombre.setText(fichero.getNombre());
				textEdad.setText(Integer.toString(fichero.getEdad()));
				textTipoComida.setText(fichero.getTipo_comida());
				textCantidadComida.setText(Integer.toString(fichero.getCantidad_comida()));

				a.setNombre(fichero.getNombre());
				a.setEdad(fichero.getEdad());
				a.setTipo_comida(fichero.getTipo_comida());
				a.setKg_comida(fichero.getCantidad_comida());

				a.alta();
			}
		});
	}
}
