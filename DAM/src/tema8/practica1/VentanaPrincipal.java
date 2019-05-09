package tema8.practica1;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textPrecio;

	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 462);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoProducto = new JLabel("NUEVO PRODUCTO");
		lblNuevoProducto.setOpaque(true);
		lblNuevoProducto.setForeground(Color.white);
		lblNuevoProducto.setBackground(new Color(112, 128, 144));
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setBounds(219, 38, 172, 35);
		contentPane.add(lblNuevoProducto);
		
		JLabel lblIdproducto = new JLabel("ID_PRODUCTO");
		lblIdproducto.setBounds(102, 111, 93, 23);
		contentPane.add(lblIdproducto);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(102, 146, 76, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(102, 181, 76, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setBounds(102, 225, 93, 14);
		contentPane.add(lblObservaciones);
		
		JTextPane textObserva = new JTextPane();
		textObserva.setBounds(102, 250, 459, 82);
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
		btnConsultar.setBounds(102, 357, 118, 23);
		contentPane.add(btnConsultar);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.setBackground(new Color(154, 205, 50));
		btnInsertar.setBounds(236, 357, 99, 23);
		contentPane.add(btnInsertar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(178, 34, 34));
		btnEliminar.setBounds(345, 357, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(255, 127, 80));
		btnModificar.setBounds(460, 357, 101, 23);
		contentPane.add(btnModificar);
		
		btnConsultar.setForeground(Color.white);
		btnInsertar.setForeground(Color.white);
		btnEliminar.setForeground(Color.white);
		btnModificar.setForeground(Color.white);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 621, 21);
		contentPane.add(menuBar);
		
		JMenu btnFile = new JMenu("File");
		menuBar.add(btnFile);
		
		JMenuItem btnFileSalir = new JMenuItem("Salir");
		btnFileSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		btnFile.add(btnFileSalir);
		
		setVisible(true);
	}
}
