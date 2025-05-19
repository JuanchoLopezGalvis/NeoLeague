package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Clase que representa el panel de inscripcion de torneos.
 * 
 * @version 1.0
 */
public class PanelInscribirTorneo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imagenFondo;
	private JComboBox<String> equipoInscribir;
	private JComboBox<String> torneoInscribir;
	private BotonRedondeado btnInscribir;
	public PanelInscribirTorneo() {
		setLayout(null);
		setSize(1280, 720);
		imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondoInscribirTorneo.png")).getImage();
		equipoInscribir = new JComboBox<String>();
		torneoInscribir = new JComboBox<String>();
		btnInscribir = new BotonRedondeado("Inscribir", 20, Color.DARK_GRAY, Color.black, Color.white, Color.white, 1f);
		equipoInscribir.setBackground(Color.DARK_GRAY);
		torneoInscribir.setBackground(Color.DARK_GRAY);
		equipoInscribir.setForeground(Color.white);
		torneoInscribir.setForeground(Color.white);
		equipoInscribir.setBounds(720, 250, 200, 30);
		torneoInscribir.setBounds(720, 300, 200, 30);
		btnInscribir.setBounds(720, 350, 200, 30);
		add(equipoInscribir);
		add(torneoInscribir);
		add(btnInscribir);
		
	}
	/**
	 * Metodo que se encarga de pintar la imagen de fondo del panel.
	 *
	 * @param g es el objeto de la clase Graphics.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 0, 0, 1269, 660, this);
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}
	public Image getImagenFondo() {
		return imagenFondo;
	}
	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	public JComboBox<String> getEquipoInscribir() {
		return equipoInscribir;
	}
	public void setEquipoInscribir(JComboBox<String> equipoInscribir) {
		this.equipoInscribir = equipoInscribir;
	}
	public JComboBox<String> getTorneoInscribir() {
		return torneoInscribir;
	}
	public void setTorneoInscribir(JComboBox<String> torneoInscribir) {
		this.torneoInscribir = torneoInscribir;
	}
	public BotonRedondeado getBtnInscribir() {
		return btnInscribir;
	}
	public void setBtnInscribir(BotonRedondeado btnInscribir) {
		this.btnInscribir = btnInscribir;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
