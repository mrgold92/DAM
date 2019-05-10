package tema8.practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class Conexion {

	private Statement sta;
	private Connection conn;
	private PreparedStatement prepared;

	public Conexion() {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
			sta = conn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Statement getSatatement() {
		return sta;
	}

	/**
	 * Devuelve la conexión de un PreparedStatement.
	 * 
	 * @param String query
	 * @return PreparedStatement
	 */
	public PreparedStatement getPreparedStatement(String query) {

		try {
			prepared = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prepared;

	}

	/**
	 * Cierra conexión de un Statament
	 */
	public void cerrarConexion() {
		try {
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

	/**
	 * Cierra conexión de un Resulset
	 * 
	 * @param ResulSet resultado
	 */

	public void cerrarConexion(ResultSet resultado) {
		try {
			resultado.close();
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cierra conexión de una sentencia PrepareStament
	 * 
	 * @param PreparedStatament prepare
	 */
	public void cerrarConexion(PreparedStatement prepare) {
		try {
			conn.close();
			prepare.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Cierra conexion de un Resulset y un PrepareStatement
	 * 
	 * @param ResulSet          resultado
	 * @param PreparedStatament prepare
	 */

	public void cerrarConexion(ResultSet resultado, PreparedStatement prepare) {
		try {
			prepare.close();
			resultado.close();
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void cerrarConexion(PreparedStatement prepare1, PreparedStatement prepare2) {
		try {
			prepare1.close();
			prepare2.close();
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
