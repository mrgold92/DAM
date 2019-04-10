package tema6.repasoLeerYescribir;

import java.io.*;

/**
 * @author david salazar
 * @version 1.0
 */
public class Operaciones {

    /**
     * Método que dada la ruta de un fichero, comprueba cuántas vocales tiene,
     * leyendo caracter a caracter
     *
     * @param ruta
     */
    public static void contarVocales(File ruta) {

        FileReader lector;

        try {
            lector = new FileReader(ruta);

            int caracter = lector.read();
            int a = 0, e = 0, i = 0, o = 0, u = 0;

            while (caracter != -1) {

                switch ((char) caracter) {
                    case 'a':
                    case 'A':
                        a++;
                        break;
                    case 'e':
                    case 'E':
                        e++;
                        break;
                    case 'i':
                    case 'I':
                        i++;
                        break;
                    case 'o':
                    case 'O':
                        o++;
                        break;
                    case 'u':
                    case 'U':
                        u++;
                        break;
                }
                caracter = lector.read();
            }
            lector.close();

            System.out.println("Hay " + a + " a en el texto");
            System.out.println("Hay " + e + " e en el texto");
            System.out.println("Hay " + i + " i en el texto");
            System.out.println("Hay " + o + " o en el texto");
            System.out.println("Hay " + u + " u en el texto");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que lee un fichero y copia su contenido linea a linea
     *
     * @param ruta
     */
    public static void crearYleer(File ruta) {

        BufferedReader lector;
        FileWriter escritor = null;
        String linea = "";
        try {

            lector = new BufferedReader(new FileReader(ruta));
            escritor = new FileWriter("resources/texto2.txt", true);
            while ((linea = lector.readLine()) != null) {

                escritor.write(linea);
            }

            lector.close();
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que lee una imagen y la copia en otro fichero byte a byte
     *
     * @param ruta_img
     */
    public static void copiarimagen(File ruta_img) {

        BufferedInputStream entrada;
        BufferedOutputStream salida;

        try {
            entrada = new BufferedInputStream(new FileInputStream(ruta_img));
            salida = new BufferedOutputStream(new FileOutputStream("resources/img2.png"));
            int bites = 0;
            while ((bites = entrada.read()) != -1) {

                salida.write(bites);
            }

            entrada.close();
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}