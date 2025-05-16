package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAgregarEquipo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el fondo del panel.
	 */
	private Image fondo;
	private	TextFieldRedondeado datoNombreEquipo;
	private JComboBox<String> datoJuego;
	private JLabel etiquetaNombreEquipo;
	private BotonRedondeado btnAgregarEquipo;
	public PanelAgregarEquipo() {
		setSize(1280,720);
		setLayout(null);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondoAEquipo.png")).getImage();
		datoNombreEquipo = new TextFieldRedondeado(Color.BLACK, Color.decode("#bbdefb"), 20, Color.BLACK, 1f);
		btnAgregarEquipo = new BotonRedondeado("Agregar Equipo", 20, Color.decode("#bbdefb"), Color.white, Color.BLACK, Color.BLACK, 1f);
		String[] juegos = {"FIFA", "Rocket League", "Formula 1", "Gran Turismo"};
		datoJuego = new JComboBox<>(juegos);
		etiquetaNombreEquipo = new JLabel("Nombre del equipo");
		etiquetaNombreEquipo.setForeground(Color.white);
		etiquetaNombreEquipo.setFont(new java.awt.Font("Arial", 1, 20));
		datoJuego.setToolTipText("Game");
		etiquetaNombreEquipo.setBounds(800, 200, 300, 30); 
	    datoNombreEquipo.setBounds(800, 240, 200, 30);    
	    datoJuego.setBounds(800, 300, 200, 30);            
	    btnAgregarEquipo.setBounds(800, 360, 200, 30);     
		add(datoNombreEquipo);
		add(datoJuego);
		add(btnAgregarEquipo);
		add(etiquetaNombreEquipo);
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
