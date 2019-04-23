package tema6.practica4;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *  Clase que crea una ventana y coloca los componentes directamente en el JFrame.
 * @author david salazar
 *
 */
public class VentanaSinLamina extends JFrame {

	private static final long serialVersionUID = -1596971766711123314L;


	/**
	 * Constructor
	 */
	public VentanaSinLamina() {

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);
		

		JLabel formulario = new JLabel("Formulario");
		formulario.setBounds(250, 100, 200, 40);
		add(formulario);
		
		//Etiqueta con el texto de  introducir nombre
		JLabel nombreEtiqueta = new JLabel("Introduce tu nombre");
		add(nombreEtiqueta);
		//Introducir nombre
		JTextField nombre = new JTextField();
		nombreEtiqueta.setBounds(100, 200, 200, 40);
		nombre.setBounds(300, 210, 200, 20);
		add(nombre);
		
		//Etiqueta con el texto de introducir contraseña
		JLabel passEtiqueta = new JLabel("Introduce tu contraseña");
		add(passEtiqueta);
		
		//Introducir password.
		passEtiqueta.setBounds(100, 240, 200, 40);
		JPasswordField pass = new JPasswordField(); 
		pass.setBounds(300, 250, 200, 20);
		add(pass);
		
		//Etiqueta con el texto de introducir email.
		JLabel passEmail = new JLabel("Introduce tu email");
		add(passEmail);
		passEmail.setBounds(100, 280, 200, 40);
		
		//Introducir email.
		JTextField email = new JTextField();
		email.setBounds(300, 290, 200, 20);
		add(email);
		
		//Boton para registrarse
		JButton registro = new JButton("Registrarse");
		registro.setBounds(100, 325, 120, 20);
		registro.setBackground(Color.DARK_GRAY);
		registro.setForeground(Color.white);
		add(registro);
		
		

		setSize(600, 600);
		setLocationRelativeTo(null);

		setVisible(true);

	}

}
