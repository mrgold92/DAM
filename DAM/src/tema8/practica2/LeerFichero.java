package tema8.practica2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerFichero {

	private String nombre;
	private int edad;
	private String tipo_comida;
	private int cantidad_comida;

	public LeerFichero(File ruta) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = (JSONObject) parser.parse(new FileReader(ruta));
			JSONObject ob = (JSONObject) obj;

			atributos(ob);

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
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

	public int getCantidad_comida() {
		return cantidad_comida;
	}

	public void setCantidad_comida(int cantidad_comida) {
		this.cantidad_comida = cantidad_comida;
	}

	public void atributos(JSONObject obj) {

		String nombre = (String) obj.get("nombre");
		String tipo_comida = (String) obj.get("tipo_comida");
		long edad = (long) obj.get("edad");
		long cantidad_comida = (long) obj.get("cantidad_comida");

		this.nombre = nombre;
		this.tipo_comida = tipo_comida;
		this.edad = (int) edad;
		this.cantidad_comida = (int) cantidad_comida;

	}
}
