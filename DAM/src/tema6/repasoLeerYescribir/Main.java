package tema6.repasoLeerYescribir;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        //rutas ficheros
        File texto = new File("resources/texto.txt");
        File ruta_img = new File("resources/foto.png");

        //llamada a métodos
        Operaciones.contarVocales(texto);
        Operaciones.crearYleer(texto);
        Operaciones.copiarimagen(ruta_img);
    }
}
