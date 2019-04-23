package tema6.practica4;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaSinLamina extends JFrame {

	private static final long serialVersionUID = -1596971766711123314L;


	public VentanaSinLamina() {

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);
		

		JLabel formulario = new JLabel("Formulario");
		formulario.setBounds(250, 100, 200, 40);
		add(formulario);
		
		
		JLabel nombreEtiqueta = new JLabel("Introduce tu nombre");
		add(nombreEtiqueta);
		JTextField nombre = new JTextField();
		nombreEtiqueta.setBounds(100, 200, 200, 40);
		nombre.setBounds(300, 210, 200, 20);
		add(nombre);
		
		JLabel passEtiqueta = new JLabel("Introduce tu contraseña");
		add(passEtiqueta);
		
		passEtiqueta.setBounds(100, 240, 200, 40);
		JPasswordField pass = new JPasswordField(); 
		pass.setBounds(300, 250, 200, 20);
		add(pass);
		
		
		JLabel passEmail = new JLabel("Introduce tu email");
		add(passEmail);
		passEmail.setBounds(100, 280, 200, 40);
		JTextField email = new JTextField();
		email.setBounds(300, 290, 200, 20);
		add(email);
		
		
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
