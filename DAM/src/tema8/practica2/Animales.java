package tema8.practica2;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Animales {

	private int id;
	private String nombre;
	private int edad;
	private String tipo_comida;
	private int kg_comida;
	private Connection con;
	private JLabel mensaje;

	public Animales(JLabel mensaje) {

		this.mensaje = mensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTipo_comida() {
		return tipo_comida;
	}

	public void setTipo_comida(String tipo_comida) {
		this.tipo_comida = tipo_comida;
	}

	public int getKg_comida() {
		return kg_comida;
	}

	public void setKg_comida(int kg_comida) {
		this.kg_comida = kg_comida;
	}

	// métodos

	public void lanzarMensaje(String mensaje, boolean error) {

		if (error) {
			this.mensaje.setOpaque(true);
			this.mensaje.setBackground(new Color(163, 66, 55));
			this.mensaje.setForeground(Color.white);
			this.mensaje.setText(mensaje);
		} else {
			this.mensaje.setOpaque(true);
			this.mensaje.setBackground(new Color(68, 140, 44));
			this.mensaje.setForeground(Color.white);
			this.mensaje.setText(mensaje);
		}

	}

	public Connection conectar() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public void setOpaque() {
		mensaje.setText("");
		mensaje.setOpaque(false);
	}

	public int getId() {
		con = conectar();

		PreparedStatement query;

		try {
			query = con.prepareStatement("SELECT id FROM animales where nombre=? and edad=?");
			query.setString(1, nombre);
			query.setInt(2, edad);

			ResultSet resultado = query.executeQuery();

			if (!resultado.next()) {
				lanzarMensaje("No hemos enconrado el código con ese nombre y edad", true);
			} else {
				id = resultado.getInt("id");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;

	}

	public void alta() {
		setOpaque();
		try {

			con = conectar();
			PreparedStatement query = con.prepareStatement("SELECT id FROM animales WHERE nombre=? and edad=? ");
			query.setString(1, nombre);
			query.setInt(2, edad);
			query.executeQuery();

			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				lanzarMensaje("Ya existe el animal en la Base de Datos.", true);

			} else {

				PreparedStatement query2 = con
						.prepareStatement("INSERT INTO animales (nombre, edad, tipo_comida)  VALUES(?,?,?)");

				query2.setString(1, nombre);
				query2.setInt(2, edad);
				query2.setString(3, tipo_comida);

				query2.executeUpdate();

				PreparedStatement query3 = con.prepareStatement("INSERT INTO cantidades (cantidad_comida) VALUES(?)");
				query3.setInt(1, kg_comida);

				query3.executeUpdate();
				query.close();
				query2.close();
				query3.close();
				con.close();

				lanzarMensaje("Registrado correctamente", false);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean consultar() {
		setOpaque();
		con = conectar();
		boolean re = false;

		try {
			PreparedStatement query = con.prepareStatement("SELECT id FROM animales WHERE nombre=? AND edad=?");
			query.setString(1, nombre);
			query.setInt(2, edad);

			ResultSet resultado = query.executeQuery();

			if (!resultado.next()) {

				re = false;

			} else {

				PreparedStatement query2 = con.prepareStatement(
						"SELECT * FROM animales a, cantidades c WHERE  nombre=? and edad =? and a.id=c.id");
				query2.setString(1, nombre);
				query2.setInt(2, edad);
				
				ResultSet resultado2 = query2.executeQuery();

				while (resultado2.next()) {

					id = resultado2.getInt("id");
					nombre = resultado2.getString("nombre");
					edad = resultado2.getInt("edad");
					tipo_comida = resultado2.getString("tipo_comida");
					kg_comida = resultado2.getInt("cantidad_comida");

					re = true;
				}
				resultado2.close();
				query2.close();

			}
			resultado.close();
			query.close();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (!re) {
			lanzarMensaje("No existe este registro", true);

		}
		return re;

	}

	public void baja() {
		setOpaque();
		con = conectar();
		try {
			PreparedStatement query = con.prepareStatement("SELECT id FROM animales WHERE nombre=? AND edad=?");
			query.setString(1, nombre);
			query.setInt(2, edad);

			ResultSet resultado = query.executeQuery();

			if (!resultado.next()) {
				lanzarMensaje("No existe este registro", true);

			} else {

				int opcion = JOptionPane.showConfirmDialog(null, "�Quiere borrarlo definitivamente?");

				if (opcion == JOptionPane.YES_OPTION) {
					PreparedStatement query2 = con.prepareStatement("DELETE FROM animales WHERE id=" + getId());
					PreparedStatement query3 = con.prepareStatement("DELETE FROM cantidades WHERE id=" + getId());
					query2.executeUpdate();
					query3.executeUpdate();
					lanzarMensaje("Eliminado correctamente", false);
				} else {
					lanzarMensaje("Cancelado borrado", false);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificar() {
		setOpaque();
		con = conectar();
		try {

			if (!nombre.equals("")) {

				PreparedStatement query = con.prepareStatement("SELECT id FROM animales WHERE nombre=? ");
				query.setString(1, nombre);

				ResultSet resultado = query.executeQuery();

				if (!resultado.next()) {
					lanzarMensaje("No existe este registro", true);

				} else {

					PreparedStatement query2 = con
							.prepareStatement("UPDATE  animales SET nombre=?, edad=?, tipo_comida=? WHERE id=?");

					query2.setString(1, nombre);
					query2.setInt(2, edad);
					query2.setString(3, tipo_comida);
					query2.setInt(4, getId());

					query2.executeUpdate();

					PreparedStatement query3 = con.prepareStatement(
							"UPDATE  cantidades SET cantidad_comida=" + kg_comida + " where id=" + getId());
					query3.executeUpdate();
					lanzarMensaje("Actualizado correctamente", false);

				}
			} else {
				lanzarMensaje("Debes introducir el campo nombre", true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
