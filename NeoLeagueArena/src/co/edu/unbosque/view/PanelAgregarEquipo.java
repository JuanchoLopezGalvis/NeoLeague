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
		datoNombreEquipo = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		btnAgregarEquipo = new BotonRedondeado("Agregar Equipo", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		String[] juegos = {"FIFA", "Rocket League", "Formula 1", "Gran Turismo"};
		datoJuego = new JComboBox<>(juegos);
		etiquetaNombreEquipo = new JLabel("Nombre del equipo");
		etiquetaNombreEquipo.setForeground(Color.white);
		etiquetaNombreEquipo.setFont(new java.awt.Font("Arial", 1, 20));
		datoJuego.setToolTipText("Game");
		datoJuego.setBackground(Color.decode("#002d69"));
		datoJuego.setForeground(Color.white);
		etiquetaNombreEquipo.setBounds(835, 200, 300, 30);
	    datoNombreEquipo.setBounds(800, 260, 250, 30);
	    datoJuego.setBounds(800, 320, 250, 30);
	    btnAgregarEquipo.setBounds(800, 380, 250, 30);
		add(datoNombreEquipo);
		add(datoJuego);
		add(btnAgregarEquipo);
		add(etiquetaNombreEquipo);
	}
	/**
	 * Este metodo se encarga de pintar el panel con el fondo.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (fondo != null) {
			g.drawImage(fondo, 0, 0, 1269, 660, this);
		} else {

		}
	}
	public Image getFondo() {
		return fondo;
	}
	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}
	public TextFieldRedondeado getDatoNombreEquipo() {
		return datoNombreEquipo;
	}
	public void setDatoNombreEquipo(TextFieldRedondeado datoNombreEquipo) {
		this.datoNombreEquipo = datoNombreEquipo;
	}
	public JComboBox<String> getDatoJuego() {
		return datoJuego;
	}
	public void setDatoJuego(JComboBox<String> datoJuego) {
		this.datoJuego = datoJuego;
	}
	public JLabel getEtiquetaNombreEquipo() {
		return etiquetaNombreEquipo;
	}
	public void setEtiquetaNombreEquipo(JLabel etiquetaNombreEquipo) {
		this.etiquetaNombreEquipo = etiquetaNombreEquipo;
	}
	public BotonRedondeado getBtnAgregarEquipo() {
		return btnAgregarEquipo;
	}
	public void setBtnAgregarEquipo(BotonRedondeado btnAgregarEquipo) {
		this.btnAgregarEquipo = btnAgregarEquipo;
	}


}
