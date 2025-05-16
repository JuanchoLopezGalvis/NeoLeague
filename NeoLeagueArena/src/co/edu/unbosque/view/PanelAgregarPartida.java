package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelAgregarPartida extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el fondo del panel.
	 */
	private Image fondo;
	
	
	public PanelAgregarPartida() {
		fondo = new ImageIcon(getClass().getResource("/recursos/fondoAPartida.png")).getImage();
	}
	/**
	 * Este metodo se encarga de pintar el panel con el fondo.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (fondo != null) {
			g.drawImage(fondo, 0, 0, 1269, 660, this);
		} else {

		}
	}
}
