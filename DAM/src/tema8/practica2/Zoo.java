package tema8.practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public Zoo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblZoolgico = new JLabel("ZOOL\u00D3GICO");
		lblZoolgico.setHorizontalAlignment(SwingConstants.CENTER);
		lblZoolgico.setBounds(239, 26, 83, 14);
		contentPane.add(lblZoolgico);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(84, 138, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(84, 162, 46, 14);
		contentPane.add(lblEdad);

		JLabel lblTipoDeComida = new JLabel("TIPO DE COMIDA");
		lblTipoDeComida.setBounds(84, 187, 84, 14);
		contentPane.add(lblTipoDeComida);

		JLabel lblCantidadDeComida = new JLabel("CANTIDAD DE COMIDA (KG)");
		lblCantidadDeComida.setBounds(84, 212, 154, 14);
		contentPane.add(lblCantidadDeComida);

		JLabel lblIdentificacin = new JLabel("IDENTIFICACI\u00D3N");
		lblIdentificacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdentificacin.setBounds(84, 113, 84, 14);
		contentPane.add(lblIdentificacin);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(247, 110, 163, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(247, 135, 163, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textEdad = new JTextField();
		textEdad.setBounds(247, 159, 163, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);

		textTipoComida = new JTextField();
		textTipoComida.setBounds(247, 184, 163, 20);
		contentPane.add(textTipoComida);
		textTipoComida.setColumns(10);

		textCantidadComida = new JTextField();
		textCantidadComida.setBounds(248, 209, 162, 20);
		contentPane.add(textCantidadComida);
		textCantidadComida.setColumns(10);

		btnAlta = new JButton("ALTA");

		btnAlta.setBounds(84, 304, 89, 23);
		contentPane.add(btnAlta);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(183, 304, 107, 23);
		contentPane.add(btnConsultar);

		JButton btnBaja = new JButton("BAJA");
		btnBaja.setBounds(300, 304, 89, 23);
		contentPane.add(btnBaja);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(399, 304, 89, 23);
		contentPane.add(btnEditar);

		JButton btnImportar = new JButton("IMPORTAR");
		btnImportar.setBounds(497, 22, 89, 23);
		contentPane.add(btnImportar);
		setVisible(true);

		alta();
		consulta();

	}

	public void alta() {

		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textNombre.getText();
				Integer edad = Integer.parseInt(textEdad.getText());
				String tipo_comida = textTipoComida.getText();
				int cantidad_c = Integer.parseInt(textCantidadComida.getText());
				Animales a = new Animales(nombre, edad, tipo_comida, cantidad_c);

				a.alta();

			}
		});
	}

	public void consulta() {

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				Integer edad = Integer.parseInt(textEdad.getText());

				Animales a = new Animales(nombre, edad);

				a.consultar();

				textID.setText(Integer.toString(a.getId()));
				textNombre.setText(a.getNombre());
				textEdad.setText(Integer.toString(a.getEdad()));
				textTipoComida.setText(a.getTipo_comida());
				textCantidadComida.setText(Integer.toString(a.getKg_comida()));

			}
		});

	}

}
