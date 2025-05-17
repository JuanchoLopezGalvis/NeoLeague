package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase representa un panel que permite actualizar la información de los objetos en la aplicación.
 * Contiene una tabla para mostrar los datos, un campo de texto para buscar y botones para realizar acciones.
 */
public class PanelActualizarEquipo extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el fondo del panel.
	 */
	private Image fondo;
	private	TextFieldRedondeado datoNombreEquipo;
	private JLabel etiquetaNombreEquipo;
	private BotonRedondeado btnActualizarEquipo;
	private JComboBox<String> equiposExistentes;
	public PanelActualizarEquipo() {
		setSize(1280,720);
		setLayout(null);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondoAEquipo.png")).getImage();
		datoNombreEquipo = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		btnActualizarEquipo = new BotonRedondeado("Actulizar Equipo", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		equiposExistentes = new JComboBox<>();
		etiquetaNombreEquipo = new JLabel("Nombre del equipo");
		etiquetaNombreEquipo.setForeground(Color.white);
		etiquetaNombreEquipo.setFont(new java.awt.Font("Arial", 1, 20));
		equiposExistentes.setBackground(Color.decode("#002d69"));
		equiposExistentes.setForeground(Color.white);
		datoNombreEquipo.setToolTipText("New Name");
		etiquetaNombreEquipo.setBounds(835, 200, 300, 30);
	    datoNombreEquipo.setBounds(800, 320, 250, 30);
	    equiposExistentes.setBounds(800, 260, 250, 30);
	    btnActualizarEquipo.setBounds(800, 380, 250, 30);
		add(datoNombreEquipo);
		add(btnActualizarEquipo);
		add(etiquetaNombreEquipo);
		add(equiposExistentes);
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
	public JLabel getEtiquetaNombreEquipo() {
		return etiquetaNombreEquipo;
	}
	public void setEtiquetaNombreEquipo(JLabel etiquetaNombreEquipo) {
		this.etiquetaNombreEquipo = etiquetaNombreEquipo;
	}
	public BotonRedondeado getBtnActualizarEquipo() {
		return btnActualizarEquipo;
	}
	public void setBtnActualizarEquipo(BotonRedondeado btnActualizarEquipo) {
		this.btnActualizarEquipo = btnActualizarEquipo;
	}
	public JComboBox<String> getEquiposExistentes() {
		return equiposExistentes;
	}
	public void setEquiposExistentes(JComboBox<String> equiposExistentes) {
		this.equiposExistentes = equiposExistentes;
	}

}