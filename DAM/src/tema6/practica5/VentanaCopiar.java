package tema6.practica5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCopiar extends JFrame {

	private static final long serialVersionUID = -2865617436551724851L;

	public VentanaCopiar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600, 500);
		setLayout(null);
		setLocationRelativeTo(null);

		// textos y botones
		initComponents();

		setVisible(true);

	}

	public void initComponents() {
		JLabel etiquetaCopiar = new JLabel("Texto a copiar");

		etiquetaCopiar.setBounds(100, 100, 100, 20);

		JTextField copiar = new JTextField();
		copiar.setBounds(100, 130, 100, 20);

		JLabel etiquetaCopiado = new JLabel("Texto copiado");
		etiquetaCopiado.setBounds(350, 100, 100, 20);
		JTextField copiado = new JTextField();
		copiado.setBounds(350, 130, 100, 20);

		JButton copiarbtn = new JButton("Copiar");
		copiarbtn.setBounds(230, 190, 100, 30);
		copiarbtn.setBackground(Color.darkGray);
		copiarbtn.setForeground(Color.white);

		copiarTexto(copiarbtn, copiar, copiado);

		add(etiquetaCopiar);
		add(etiquetaCopiado);
		add(copiar);
		add(copiado);
		add(copiarbtn);

	}

	public void copiarTexto(JButton button, JTextField copiar, JTextField panelCopiado) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (copiar.getText().equals("")) {
					panelCopiado.setText("Introduce texto");
				} else {
					String texto = copiar.getText();
					panelCopiado.setText(texto);
				}

			}
		});
	}

}
