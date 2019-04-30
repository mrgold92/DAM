package tema6.practica5;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 * Clase que dada unas opciones (platos), comprueba los ingredientes y de ser
 * correctos, nos muestra en pantalla un aviso.
 * 
 * @author david salazar
 *
 */

public class VentanaComida extends JFrame {

	private static final long serialVersionUID = -3881944398438116930L;

	public VentanaComida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(677, 326);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Ventana Comida");

		initComponentes();

		setVisible(true);
	}

	/**
	 * Configuración de todos los componentes que estarán dentro de la ventana.
	 */

	public void initComponentes() {

		JRadioButton boxCocido = new JRadioButton("Cocido");
		boxCocido.setBounds(202, 8, 80, 17);

		add(boxCocido);

		JRadioButton boxLentejas = new JRadioButton("Lentejas");
		boxLentejas.setBounds(286, 8, 96, 17);
		add(boxLentejas);

		JRadioButton boxJudias = new JRadioButton("Judías");
		boxJudias.setBounds(386, 8, 80, 17);
		add(boxJudias);

		JCheckBox checkLentejas = new JCheckBox("Lentejas");
		checkLentejas.setBounds(156, 88, 89, 17);

		add(checkLentejas);

		JCheckBox checkGarbanzos = new JCheckBox("Garbanzos");
		checkGarbanzos.setBounds(249, 88, 105, 17);

		add(checkGarbanzos);

		JCheckBox checkJudias = new JCheckBox("Jud�as");
		checkJudias.setBounds(354, 88, 89, 17);

		add(checkJudias);

		JCheckBox checkNuezMoscada = new JCheckBox("Nuez Moscada");
		checkNuezMoscada.setBounds(452, 88, 135, 17);

		add(checkNuezMoscada);

		JCheckBox checkChorizo = new JCheckBox("Chorizo");
		checkChorizo.setBounds(156, 118, 89, 17);

		add(checkChorizo);

		JCheckBox checkMorcilla = new JCheckBox("Morcilla");
		checkMorcilla.setBounds(249, 118, 89, 17);

		add(checkMorcilla);

		JCheckBox checkColorante = new JCheckBox("Colorante");
		checkColorante.setBounds(354, 118, 96, 17);

		add(checkColorante);

		JCheckBox checkLaurel = new JCheckBox("Laurel");
		checkLaurel.setBounds(452, 118, 89, 17);

		add(checkLaurel);

		JCheckBox checkCebolla = new JCheckBox("Cebolla");
		checkCebolla.setBounds(156, 143, 89, 17);

		add(checkCebolla);

		JCheckBox checkZanahoria = new JCheckBox("Zanahoria");
		checkZanahoria.setBounds(249, 143, 100, 17);

		add(checkZanahoria);

		JCheckBox checkPescado = new JCheckBox("Pescado");
		checkPescado.setBounds(354, 143, 89, 17);

		add(checkPescado);

		JCheckBox checkPimenton = new JCheckBox("Piment�n");
		checkPimenton.setBounds(452, 143, 100, 17);

		add(checkPimenton);

		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(240, 177, 114, 25);
		btnComprobar.setBackground(new Color(89, 168, 105));
		btnComprobar.setForeground(Color.white);
		add(btnComprobar);

		JLabel resultado = new JLabel("---");
		resultado.setBounds(250, 231, 230, 15);

		JButton borrarButton = new JButton("Borrar");
		borrarButton.setBounds(354, 177, 114, 25);
		borrar(borrarButton, this, resultado);
		borrarButton.setBackground(new Color(89, 168, 105));
		borrarButton.setForeground(Color.white);

		add(borrarButton);

		comprobar(resultado, btnComprobar, this);

		add(resultado);

	}

	/**
	 * M�todo que borra todas las opciones que pudieran estar marcadas.
	 * 
	 * @param borrarbtn
	 * @param frame
	 * @param resultado
	 */
	public void borrar(JButton borrarbtn, JFrame frame, JLabel resultado) {
		borrarbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Component[] componentes = frame.getContentPane().getComponents();
				ArrayList<JCheckBox> checks = new ArrayList<JCheckBox>();
				ArrayList<JRadioButton> opciones = new ArrayList<JRadioButton>();

				for (int i = 0; i < componentes.length; i++) {
					if (componentes[i] instanceof JCheckBox) {
						checks.add((JCheckBox) componentes[i]);
					}

					if (componentes[i] instanceof JRadioButton) {
						opciones.add((JRadioButton) componentes[i]);
					}

				}

				for (JRadioButton opcion : opciones) {
					opcion.setSelected(false);
				}

				for (JCheckBox check : checks) {
					check.setSelected(false);
				}

				resultado.setText("");

			}
		});
	}

	public void borrar(JFrame frame, JLabel resultado) {

		Component[] componentes = frame.getContentPane().getComponents();
		ArrayList<JCheckBox> checks = new ArrayList<JCheckBox>();
		ArrayList<JRadioButton> opciones = new ArrayList<JRadioButton>();

		for (int i = 0; i < componentes.length; i++) {
			if (componentes[i] instanceof JCheckBox) {
				checks.add((JCheckBox) componentes[i]);
			}

			if (componentes[i] instanceof JRadioButton) {
				opciones.add((JRadioButton) componentes[i]);
			}

		}

		for (JRadioButton opcion : opciones) {
			opcion.setSelected(false);
		}

		for (JCheckBox check : checks) {
			check.setSelected(false);
		}

		resultado.setText("");

	}

	/**
	 * Método que comprueba qué opción está seleccionada y después comprueba si
	 * las respuestas son correctas.
	 * 
	 * @param resultado
	 * @param coomprobar
	 * @param frame
	 */
	public void comprobar(JLabel resultado, JButton coomprobar, JFrame frame) {

		Component[] componentes = frame.getContentPane().getComponents();
		ArrayList<JCheckBox> checks = new ArrayList<JCheckBox>();
		ArrayList<JRadioButton> opciones = new ArrayList<JRadioButton>();

		for (int i = 0; i < componentes.length; i++) {
			if (componentes[i] instanceof JCheckBox) {
				checks.add((JCheckBox) componentes[i]);
			}

			if (componentes[i] instanceof JRadioButton) {
				opciones.add((JRadioButton) componentes[i]);
			}

		}

		coomprobar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int o = 0;
				for (JRadioButton opcion : opciones) {
					if (opcion.isSelected()) {
						o++;

					}
				}

				if (o >= 1) {
					int comprobaropciones = 0;

					if (opciones.get(0).isSelected()) {
						comprobaropciones = 0;

					} else if (opciones.get(1).isSelected()) {
						comprobaropciones = 1;

					} else if (opciones.get(2).isSelected()) {
						comprobaropciones = 2;

					}

					int c = 0;

					for (int i = 0; i < checks.size(); i++) {
						if (checks.get(i).isSelected()) {
							c++;
						}
					}

					switch (comprobaropciones) {
					case 0:

						if (c == 4) {
							if (checks.get(4).isSelected() && checks.get(5).isSelected() && checks.get(1).isSelected()
									&& checks.get(9).isSelected()) {
								resultado.setText("Correcto");
							} else {
								resultado.setText("Incorrecto");
							}

						} else {

							resultado.setText("Solo puedes elegir 4 opciones.");

						}

						break;
					case 1:

						if (c == 5) {
							if (checks.get(0).isSelected() && checks.get(4).isSelected() && checks.get(8).isSelected()
									&& checks.get(9).isSelected() && checks.get(11).isSelected()) {
								resultado.setText("Correcto");
							} else {
								resultado.setText("Incorrecto");
							}
						} else {
							resultado.setText("Solo puedes elegir 5 opciones.");
						}

						break;
					case 2:

						if (c == 6) {
							if (checks.get(2).isSelected() && checks.get(3).isSelected() && checks.get(6).isSelected()
									&& checks.get(4).isSelected() && checks.get(8).isSelected()) {
								resultado.setText("Correcto");
							} else {
								resultado.setText("Incorrecto");
							}
						} else {
							resultado.setText("Solo puedes elegir 6 opciones.");
						}

						break;

					default:
						resultado.setText("Inv�lido.");
						break;
					}

				} else {

					resultado.setText("Debes elegir un plato de comida.");

				}
			}

		});

	}

}