package tema6.practica5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrimitiva extends JFrame{

	
	private static final long serialVersionUID = 1L;

	public VentanaPrimitiva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600, 500);
		setLayout(null);
		setLocationRelativeTo(null);

		// textos y botones
		componentes();

		setVisible(true);
	}
	
	public void componentes() {
		JTextField tn1 = new JTextField();
		JTextField tn2= new JTextField();
		JTextField tn3 = new JTextField();
		JTextField tn4 = new JTextField();
		JTextField tn5 = new JTextField();
		JTextField tn6 = new JTextField();
		JLabel complementario = new JLabel("Complementario");
		JButton generar = new JButton("Generar");
		
		tn1.setBounds(100, 100, 30, 20);
		tn2.setBounds(130, 100, 30, 20);
		tn3.setBounds(160, 100, 30, 20);
		tn4.setBounds(190, 100, 30, 20);
		tn5.setBounds(220, 100, 30, 20);
		
		
		complementario.setBounds(300, 80, 100, 10);
		tn6.setBounds(300, 100, 30, 20);
		
		generar.setBounds(340,100, 100, 20);
		
		add(tn1);
		add(tn2);
		add(tn3);
		add(tn4);
		add(tn5);
		add(complementario);
		add(tn6);
		add(generar);
		
		
	}
}
