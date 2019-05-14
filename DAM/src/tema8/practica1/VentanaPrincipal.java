package tema8.practica1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author David Salazar
 *
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 4599291663601838614L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textDate;
	private JTextPane textObserva;
	private JLabel mensaje;
	private JButton btnLimpiar;
	private JComboBox<String> textCombo;
	private JMenuItem btnExportar;

	public VentanaPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 503);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		initComponentes();

	}

	/**
	 * M�todo que coloca todos los componentes en la ventana
	 */
	public void initComponentes() {

		JLabel lblNuevoProducto = new JLabel("PRODUCTOS");
		lblNuevoProducto.setOpaque(true);
		lblNuevoProducto.setForeground(Color.white);
		lblNuevoProducto.setBackground(new Color(51, 102, 204));
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setBounds(102, 24, 456, 49);
		contentPane.add(lblNuevoProducto);

		JLabel lblIdproducto = new JLabel("ID_PRODUCTO");
		lblIdproducto.setBounds(102, 111, 129, 23);
		contentPane.add(lblIdproducto);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(102, 146, 76, 14);
		contentPane.add(lblNombre);

		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(102, 181, 76, 14);
		contentPane.add(lblPrecio);

		JLabel lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setBounds(99, 245, 132, 14);
		contentPane.add(lblObservaciones);

		textObserva = new JTextPane();
		textObserva.setBounds(99, 270, 459, 82);
		contentPane.add(textObserva);

		textID = new JTextField();
		textID.setBounds(280, 111, 197, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(280, 142, 197, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBounds(280, 177, 197, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		JButton btnConsultar = new JButton("CONSULTAR");

		btnConsultar.setBackground(new Color(0, 204, 102));
		btnConsultar.setBounds(99, 377, 132, 23);
		contentPane.add(btnConsultar);

		JButton btnInsertar = new JButton("INSERTAR");

		btnInsertar.setBackground(new Color(154, 205, 50));
		btnInsertar.setBounds(222, 377, 103, 23);
		contentPane.add(btnInsertar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(178, 34, 34));
		btnEliminar.setBounds(315, 377, 103, 23);

		contentPane.add(btnEliminar);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(255, 127, 80));
		btnModificar.setBounds(407, 377, 132, 23);

		contentPane.add(btnModificar);

		btnConsultar.setForeground(Color.white);
		btnInsertar.setForeground(Color.white);
		btnEliminar.setForeground(Color.white);
		btnModificar.setForeground(Color.white);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(51, 102, 153));
		menuBar.setBounds(0, 0, 637, 25);
		contentPane.add(menuBar);

		JMenu btnFile = new JMenu("File");
		btnFile.setForeground(new Color(255, 255, 255));
		btnFile.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(btnFile);

		JMenuItem btnFileSalir = new JMenuItem("Salir");
		btnFileSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		btnFile.add(btnFileSalir);

		btnExportar = new JMenu("Exportar");

		btnExportar.setForeground(Color.WHITE);
		menuBar.add(btnExportar);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(102, 218, 58, 15);
		contentPane.add(lblFecha);

		textDate = new JTextField();
		textDate.setBounds(280, 209, 197, 19);
		contentPane.add(textDate);
		textDate.setColumns(10);

		mensaje = new JLabel("");
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje.setBounds(99, 412, 441, 25);
		contentPane.add(mensaje);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBackground(new Color(51, 102, 204));
		btnLimpiar.setBounds(473, 69, 85, 36);
		btnLimpiar.setFocusable(false);
		contentPane.add(btnLimpiar);

		// cursores
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInsertar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		textCombo = new JComboBox<String>();
		textCombo.addItem("Nuevo");
		textCombo.addItem("Segunda mano");
		textCombo.setBounds(280, 242, 197, 20);
		contentPane.add(textCombo);

		setVisible(true);

		Crud crud = new Crud(textID, textNombre, textPrecio, textDate, textObserva, textCombo, mensaje, btnExportar,
				btnLimpiar, this, btnFileSalir);
		crud.consultar(btnConsultar);
		crud.eliminar(btnEliminar);
		crud.insertar(btnInsertar);
		crud.modificar(btnModificar);
		crud.mostrarPorDefecto();
		crud.limpiar();
		crud.exportar();

		crud.salir();
	}

}