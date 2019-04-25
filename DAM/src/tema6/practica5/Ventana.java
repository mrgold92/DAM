package tema6.practica5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -8795571265866607137L;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Práctica 5 tema 6");

		// botones & eventos
		initComponents();

		setVisible(true);
	}

	public void initComponents() {

		JLabel seleccion = new JLabel("Elige opción: ");
		seleccion.setBounds(190, 170, 230, 20);

		JButton copiar = new JButton("Copiar texto");
		copiar.setBounds(190, 200, 230, 20);
		copiar.setBackground(Color.darkGray);
		copiar.setForeground(Color.white);
		copiar.setFocusable(false);

		JButton generar = new JButton("Generar números");
		generar.setBounds(190, 230, 230, 20);
		generar.setBackground(Color.darkGray);
		generar.setForeground(Color.white);
		generar.setFocusable(false);

		JButton orden = new JButton("Cambiar orden letras");
		orden.setBounds(190, 260, 230, 20);
		orden.setBackground(Color.darkGray);
		orden.setForeground(Color.white);
		orden.setFocusable(false);

		JButton comida = new JButton("Comprobar ingredientes");
		comida.setBounds(190, 290, 230, 20);
		comida.setBackground(Color.darkGray);
		comida.setForeground(Color.white);
		comida.setFocusable(false);

		// eventos

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

		orden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaOrden();

			}
		});

		comida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaComida();

			}
		});

		add(seleccion);
		add(copiar);
		add(generar);
		add(orden);
		add(comida);
	}
}
