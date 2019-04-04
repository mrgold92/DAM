package tema6.practica4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -8145180396011033947L;
	private JPanel contentPane;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());

		contentPane.add(crearBoton());
		Main.changeIcon(this, "descarga.png");
		setResizable(false);
		centrar();

		getIconImage();
		setVisible(true);
	}

	public JButton crearBoton() {
		JButton btnNuevaVentana = new JButton("Nueva ventana");
		btnNuevaVentana.setForeground(Color.WHITE);
		btnNuevaVentana.setBackground(SystemColor.desktop);
		btnNuevaVentana.setFocusPainted(false);
		btnNuevaVentana.setSize(200, 30);

		eventosBtn(btnNuevaVentana);

		return btnNuevaVentana;
	}

	public void eventosBtn(JButton btn) {

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.this.dispose();
				new OtraVentana();
			}
		});

	}

	public void centrar() {

		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tpantalla = pantalla.getScreenSize();
		int altura = tpantalla.height;
		int ancho = tpantalla.width;
		setSize(ancho, altura / 2);
		setLocation(ancho / altura ,altura / 4);

	}

}
