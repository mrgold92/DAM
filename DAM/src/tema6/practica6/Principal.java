package tema6.practica6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author david salazar
 *
 */
public class Principal extends JFrame {

	private static final long serialVersionUID = -614115542250806014L;
	private JPanel contentPane;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(646, 407);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(34, 95, 183));

		JButton btnEjercicio1 = new JButton("EJERCICIO 1");
		btnEjercicio1.setForeground(Color.WHITE);
		btnEjercicio1.setBackground(new Color(255, 165, 0));
		btnEjercicio1.setBounds(227, 122, 169, 42);
		btnEjercicio1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEjercicio1.setFocusable(false);
		contentPane.add(btnEjercicio1);

		JButton btnEjercicio2 = new JButton("EJERCICIO 2");
		btnEjercicio2.setForeground(Color.WHITE);
		btnEjercicio2.setBackground(new Color(255, 165, 0));
		btnEjercicio2.setBounds(227, 176, 169, 42);
		btnEjercicio2.setFocusable(false);
		btnEjercicio2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnEjercicio2);

		JLabel lblEjerciciosParaSubir = new JLabel("EJERCICIOS PARA SUBIR NOTA");
		lblEjerciciosParaSubir.setForeground(new Color(255, 255, 255));
		lblEjerciciosParaSubir.setHorizontalAlignment(SwingConstants.CENTER);
		lblEjerciciosParaSubir.setBounds(192, 72, 242, 29);
		contentPane.add(lblEjerciciosParaSubir);
		setVisible(true);

		// LLAMADA A ACCIONES

		acciones(btnEjercicio1, btnEjercicio2);

	}

	public void acciones(JButton btnEjercicio1, JButton btnEjercicio2) {
		btnEjercicio1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Ventana();

			}
		});

		btnEjercicio2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaRomano();

			}
		});
	}

}
