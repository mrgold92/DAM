package tema6.practica5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -8795571265866607137L;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		
		//botones & eventos
		initComponents();
		
		setVisible(true);
	}
	
	public void initComponents() {
		
		
		JButton copiar = new JButton("Copiar texto");
		copiar.setBounds(190, 200, 200, 20);
		copiar.setBackground(Color.darkGray);
		copiar.setForeground(Color.white);
		copiar.setFocusable(false);
		
		JButton generar = new JButton("Generar números");
		generar.setBounds(190, 230, 200, 20);
		generar.setBackground(Color.darkGray);
		generar.setForeground(Color.white);
		generar.setFocusable(false);
		
		JButton orden = new JButton("Cambiar orden letras");
		orden.setBounds(190, 260, 200, 20);
		orden.setBackground(Color.darkGray);
		orden.setForeground(Color.white);
		orden.setFocusable(false);
		
		JButton comida = new JButton("Comprobar ingredientes");
		comida.setBounds(190, 290, 200, 20);
		comida.setBackground(Color.darkGray);
		comida.setForeground(Color.white);
		comida.setFocusable(false);
		
		
		
		//eventos
		
		copiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaCopiar();
				
			}
		});
		
		
		generar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaPrimitiva();
				
			}
		});
		
		
		
		add(copiar);
		add(generar);
		add(orden);
		add(comida);
	}
}
