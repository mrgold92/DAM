package tema8.practica1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Crud {

	private JTextField textID;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textDate;
	private JTextPane textObserva;
	private JComboBox<String> textCombo;
	private JLabel mensaje;
	private JMenuItem btnExportar;
	private JButton btnLimpiar;
	private JFrame frame;
	private JMenuItem salir;

	public Crud(JTextField textID, JTextField textNombre, JTextField textPrecio, JTextField textDate,
			JTextPane textObserva, JComboBox<String> textCombo, JLabel mensaje, JMenuItem btnExportar,
			JButton btnLimpiar, JFrame frame, JMenuItem salir) {

		this.textID = textID;
		this.textNombre = textNombre;
		this.textPrecio = textPrecio;
		this.textDate = textDate;
		this.textObserva = textObserva;
		this.textCombo = textCombo;
		this.mensaje = mensaje;
		this.btnExportar = btnExportar;
		this.btnLimpiar = btnLimpiar;
		this.frame = frame;
		this.salir = salir;
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
	 * M�todo que deja limpios todos los campos
	 */
	public void borrarCampos() {
		textID.setText("");
		textNombre.setText("");
		textPrecio.setText("");
		textObserva.setText("");
		cleanMensaje();
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

			if (resultado.next()) {
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
	 * Método que hace referencia al botón salir del menú. Cierra la ventana.
	 * 
	 * @param salir
	 */
	public void salir() {
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});

	}

	/**
	 * M�todo que inserta mensajes de error o informaci�n en la ventana
	 * 
	 * @param mensaje a mostrar
	 * @param error,  si se trata de un mensaje de error o no.
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
	 * M�todo que borra la visualizaci�n de mensajes en la ventana.
	 */
	public void cleanMensaje() {
		mensaje.setOpaque(false);
		mensaje.setText("");
	}

	/**
	 * Método que inserta nuevos registros
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

						if (result.next()) {
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
	 * Método que se encarga de borrar registros
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

						if (!r.next()) {
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
	 * Método que consulta registros en la BBDD y los muestra en la ventana.
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

						if (!r.next()) {
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

							System.out.println(precio);
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
	 * Método que elimina registros, preguntándote antes si quieres eliminarlos o
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

						if (!r.next()) {
							lanzarMensaje("No existe el registro para eliminar", true);

						} else {
							int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar el borrado?");

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

		btnExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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

				} catch (SQLException eq) {
					eq.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

	}
}
