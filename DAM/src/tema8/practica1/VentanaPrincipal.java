package tema8.practica1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	 * Método que coloca todos los componentes en la ventana
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
		consultar(btnConsultar);
		btnConsultar.setBackground(new Color(0, 204, 102));
		btnConsultar.setBounds(99, 377, 132, 23);
		contentPane.add(btnConsultar);

		JButton btnInsertar = new JButton("INSERTAR");
		insertar(btnInsertar);

		btnInsertar.setBackground(new Color(154, 205, 50));
		btnInsertar.setBounds(222, 377, 103, 23);
		contentPane.add(btnInsertar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(178, 34, 34));
		btnEliminar.setBounds(315, 377, 103, 23);
		eliminar(btnEliminar);
		contentPane.add(btnEliminar);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(255, 127, 80));
		btnModificar.setBounds(407, 377, 132, 23);
		modificar(btnModificar);
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

		salir(btnFileSalir);

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

		mostrarIdDefecto(textID);

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
		limpiar();

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

		mostrarFechaActual();

		exportar();

		setVisible(true);
	}

	/**
	 * Acción del botón limpiar
	 */
	public void limpiar() {
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCampos();
			}
		});
	}

	/**
	 * Método que inserta mensajes de error o información en la ventana
	 * 
	 * @param mensaje a mostrar
	 * @param         error, si se trata de un mensaje de error o no.
	 */
	public void lanzarMensaje(String mensaje, boolean error) {

		if (error) {
			this.mensaje.setOpaque(true);
			this.mensaje.setBackground(new Color(216, 68, 60));
			this.mensaje.setForeground(Color.white);
			this.mensaje.setText(mensaje);
		} else {
			this.mensaje.setOpaque(true);
			this.mensaje.setBackground(new Color(67, 186, 63));
			this.mensaje.setForeground(Color.white);
			this.mensaje.setText(mensaje);
		}
	}

	/**
	 * Método que borra la visualización de mensajes en la ventana.
	 */
	public void cleanMensaje() {
		mensaje.setOpaque(false);
		mensaje.setText("");
	}

	/**
	 * Método que deja limpios todos los campos
	 */
	public void borrarCampos() {
		textID.setText("");
		textNombre.setText("");
		textPrecio.setText("");
		textObserva.setText("");
		mostrarIdDefecto(textID);
	}

	/**
	 * Muesta el id y la hora actual.
	 */

	public void mostrarPorDefecto() {
		mostrarIdDefecto(textID);
		mostrarFechaActual();
	}

	/**
	 * Poner fecha del día actual. La idea es que te muestre por defecto la fecha
	 * actual para que no tengas que ponerla a mano.
	 */

	public String mostrarFechaActual() {
		Date fechaHoy = new Date();
		String fechaF = new SimpleDateFormat("yyyy-MM-dd").format(fechaHoy);

		textDate.setText(fechaF);
		return fechaF;
	}

	/**
	 * Método que muestra el id del último producto en la BDDD.
	 * 
	 * @param textid_producto
	 */

	public void mostrarIdDefecto(JTextField textid_producto) {

		Conexion c = new Conexion();
		Statement sta = c.getSatatement();

		try {
			ResultSet resultado = sta
					.executeQuery("SELECT id_producto FROM productos ORDER BY id_producto DESC LIMIT 1 ");
			resultado.next();
			if (resultado.getRow() > 0) {
				String c1 = Integer.toString(resultado.getInt("id_producto"));
				textid_producto.setText(c1);
			} else {
				textid_producto.setText("1");
			}

			c.cerrarConexion(resultado);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * MÃ©todo que hace referencia al botÃ³n salir del menÃº. Cierra la ventana.
	 * 
	 * @param salir
	 */
	public void salir(JMenuItem salir) {
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}

	/**
	 * MÃ©todo que inserta nuevos registros
	 * 
	 * @param btnInsertar
	 */
	public void insertar(JButton btnInsertar) {
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cleanMensaje();
				Conexion c = new Conexion();
				Statement s = c.getSatatement();
				ResultSet result = null;

				try {

					if (!textID.getText().isEmpty() && !textNombre.getText().isEmpty()
							&& !textPrecio.getText().isEmpty() && !textDate.getText().isEmpty()
							&& !textObserva.getText().isEmpty()) {

						Integer id = Integer.parseInt(textID.getText());
						result = s.executeQuery("SELECT id_producto FROM productos WHERE id_producto=" + id);

						result.next();

						if (result.getRow() > 0) {
							lanzarMensaje("El producto ya existe.", true);

						} else {

							int combo = textCombo.getSelectedIndex();

							String nombre = textNombre.getText();
							Float precio = Float.parseFloat(textPrecio.getText());

							String fecha = textDate.getText();
							String ob = textObserva.getText();

							s.executeUpdate("INSERT INTO productos (nombre, precio, fecha, observaciones) " + "VALUES('"
									+ nombre + "', " + precio + ",STR_TO_DATE('" + fecha + "','%Y-%m-%d'),'" + ob
									+ "')");

							s.executeUpdate("INSERT INTO estado_productos VALUES(" + id + ", " + combo + ")");

							c.cerrarConexion();

							lanzarMensaje("Insertado correctamente.", false);

							borrarCampos();
							mostrarPorDefecto();

						}
						c.cerrarConexion(result);
					} else {

						lanzarMensaje("Debes rellenar todos los campos.", true);

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * MÃ©todo que se encarga de borrar registros
	 * 
	 * @param btnConsultar
	 */
	public void modificar(JButton btnModificar) {
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanMensaje();
				Conexion c = new Conexion();
				Statement sta = c.getSatatement();
				PreparedStatement prepare = null;
				ResultSet r = null;

				if (!textID.getText().isEmpty() && !textNombre.getText().isEmpty() && !textPrecio.getText().isEmpty()
						&& !textDate.getText().isEmpty() && !textObserva.getText().isEmpty()) {

					Integer id = Integer.parseInt(textID.getText());

					String update = "UPDATE productos INNER JOIN estado_productos ON productos.id_producto=estado_productos.id_producto SET productos.nombre=?, productos.precio=?, productos.fecha=?, productos.observaciones=?, estado_productos.nuevo=? "
							+ "WHERE productos.id_producto=" + id + " and estado_productos.id_producto=" + id;

					String query = "SELECT id_producto FROM productos WHERE id_producto=" + id;

					try {

						r = sta.executeQuery(query);

						r.next();
						if (r.getRow() < 1) {
							lanzarMensaje("No existe el registro para poder cambiarlo.", true);

						} else {
							prepare = c.getPreparedStatement(update);
							prepare.setString(1, textNombre.getText());
							prepare.setFloat(2, Float.parseFloat(textPrecio.getText()));
							prepare.setDate(3, java.sql.Date.valueOf(textDate.getText()));
							prepare.setString(4, textObserva.getText());
							prepare.setInt(5, textCombo.getSelectedIndex());
							prepare.executeUpdate();

							lanzarMensaje("Registro actualizado correctamente.", false);

							borrarCampos();
							mostrarPorDefecto();

						}

						if (r != null) {
							c.cerrarConexion(r);

						}

						if (prepare != null) {
							c.cerrarConexion(prepare);
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					lanzarMensaje("Debes rellenar todos los campos.", true);

				}
			}
		});
	}

	/**
	 * MÃ©todo que consulta registros en la BBDD y los muestra en la ventana.
	 * 
	 * @param btnConsultar
	 */

	public void consultar(JButton btnConsultar) {
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanMensaje();
				Conexion c = new Conexion();

				if (!textID.getText().isEmpty()) {

					String query = "SELECT id_producto FROM productos WHERE id_producto=?";
					PreparedStatement prepare = c.getPreparedStatement(query);

					String query2 = "SELECT * FROM productos, estado_productos WHERE productos.id_producto=? and estado_productos.id_producto=?";
					PreparedStatement prepare2 = c.getPreparedStatement(query2);

					try {

						prepare.setInt(1, Integer.parseInt(textID.getText()));

						ResultSet r = prepare.executeQuery();

						r.next();

						if (r.getRow() < 1) {
							lanzarMensaje("No existe el registro para consultar.", true);

						} else {

							prepare2.setInt(1, Integer.parseInt(textID.getText()));
							prepare2.setInt(2, Integer.parseInt(textID.getText()));

							ResultSet r2 = prepare2.executeQuery();

							String nombre = "", fecha = "", observa = "";
							int producto = 0;
							Float precio = null;

							while (r2.next()) {
								nombre = r2.getString("nombre");
								precio = r2.getFloat("precio");
								fecha = r2.getString("fecha");
								observa = r2.getString("observaciones");
								producto = r2.getInt("nuevo");
							}

							textNombre.setText(nombre);
							textDate.setText(fecha);
							textPrecio.setText(Float.toString(precio));
							textObserva.setText(observa);
							textCombo.setSelectedIndex(producto);

							if (prepare2 != null) {
								prepare2.close();

							}

						}

						c.cerrarConexion(r, prepare);

					} catch (NumberFormatException | SQLException e1) {

						e1.printStackTrace();
					}

				} else {
					lanzarMensaje("Debes rellenar el campo Id_ producto.", true);

				}
			}
		});
	}

	/**
	 * MÃ©todo que elimina registros, preguntÃ¡ndote antes si quieres eliminarlos o
	 * no.
	 * 
	 * @param btnEliminar
	 */

	public void eliminar(JButton btnEliminar) {
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cleanMensaje();
				Conexion c = new Conexion();

				if (!textID.getText().isEmpty()) {

					String query = "SELECT id_producto FROM productos WHERE id_producto=?";
					PreparedStatement prepare = c.getPreparedStatement(query);

					String deletequery = "DELETE p, e FROM productos p, estado_productos e WHERE p.id_producto=? and e.id_producto=?";
					PreparedStatement prepareDelete = c.getPreparedStatement(deletequery);

					Integer id = Integer.parseInt(textID.getText());
					try {
						prepare.setInt(1, id);
						ResultSet r = prepare.executeQuery();

						r.next();
						if (r.getRow() < 1) {
							JOptionPane.showMessageDialog(null, "No existe el registro para consultar.");

						} else {
							int opcion = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
									"¿Desea confirmar el borrado?");

							if (opcion == JOptionPane.YES_OPTION) {
								prepareDelete.setInt(1, id);
								prepareDelete.setInt(2, id);
								prepareDelete.executeUpdate();
								lanzarMensaje("Borrado correctamente", false);
								borrarCampos();
								mostrarPorDefecto();
							}

						}

						// cerrar conexiones
						if (r != null) {
							r.close();
						}
						c.cerrarConexion(prepare, prepareDelete);

					} catch (NumberFormatException e1) {

						e1.printStackTrace();
					} catch (SQLException e2) {

						e2.printStackTrace();
					}

				}
			}
		});

	}

	public void exportar() {

		btnExportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String fech = mostrarFechaActual();

				File archivo = new File("resources/Alumnos_(" + fech + ").txt");

				Conexion c = new Conexion();
				String query = "SELECT * FROM productos, estado_productos WHERE productos.id_producto=estado_productos.id_producto";
				Statement pr = c.getSatatement();

				ResultSet r;
				int id_producto = 0;
				String nombre = "", fecha, observaciones, estado = "";
				Float precio;
				int nuevo = 0;
				try {
					r = pr.executeQuery(query);

					BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));

					while (r.next()) {
						id_producto = r.getInt("id_producto");
						nombre = r.getString("nombre");
						fecha = r.getString("fecha");
						precio = r.getFloat("precio");
						observaciones = r.getString("observaciones");
						nuevo = r.getInt("nuevo");

						if (nuevo == 0) {
							estado = "Nuevo";
						} else {
							estado = "Segundamano";
						}

						escritor.write(id_producto + "," + nombre + "," + fecha + "," + precio + "," + observaciones
								+ "," + estado + ";\n");

					}
					escritor.flush();
					escritor.close();
					lanzarMensaje("Exportado correctamente", false);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

	}
}