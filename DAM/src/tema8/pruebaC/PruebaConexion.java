package tema8.pruebaC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.sql.Connection;

public class PruebaConexion {

	private static Statement e;

	public static void main(String[] args) {
		try {
			Connection conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/mitabla", "root", "");
			e = conec.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		buscarNombreUsuario();

	}

	public static void buscarNombreUsuario() {

		String query = "SELECT * FROM usuarios where id_usuario=1";
		try {
			ResultSet result = e.executeQuery(query);
			result.next();
			System.out.println(result.getString("nombre"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
