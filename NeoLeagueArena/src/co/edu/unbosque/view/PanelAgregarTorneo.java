package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import de.wannawork.jcalendar.JCalendarComboBox;
public class PanelAgregarTorneo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCalendarComboBox datoFechaInicio, datoFechaFin; 
	private BotonRedondeado btnAgregar;
	private TextFieldRedondeado datoNombreTorneo;
	private JSpinner datoMaxEquipos;
	private JComboBox<String> datoFormatoTorneo;
	private JComboBox<String> datoJuego;
	private JLabel etiqueta0, etiqueta1;
	private Image fondo;
	    public PanelAgregarTorneo() {
	        setLayout(null);
	        setSize(1280, 720);
	        datoFechaInicio = new JCalendarComboBox();
	        btnAgregar = new BotonRedondeado("Crear", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
	        datoNombreTorneo = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
	        datoMaxEquipos = new JSpinner();
	        String[] juegos = {"FIFA", "Rocket League", "Formula1", "Gran Turismo"};
	        String[] formatos = {"Eliminación directa", "Fases grupales"};
	        datoJuego = new JComboBox<String>(juegos);
	        datoFormatoTorneo = new JComboBox<String>(formatos);
	        datoFechaFin = new JCalendarComboBox();
	        datoNombreTorneo.setToolTipText("Nombre del torneo");
	        datoJuego.setToolTipText("Juego");
	        datoFormatoTorneo.setToolTipText("Formato del torneo");
	        datoFechaInicio.setToolTipText("Fecha de inicio");
	        datoFechaFin.setToolTipText("Fecha de fin");
	        datoMaxEquipos.setToolTipText("Maximo de equipos");
	        datoJuego.setToolTipText("Juego");
	        datoFormatoTorneo.setToolTipText("Formato del torneo");
	        etiqueta1 = new JLabel("Fecha de fin");
	        etiqueta0 = new JLabel("Fecha de inicio");
	        fondo = new ImageIcon(getClass().getResource("/recursos/fondoATorneo.png")).getImage();
	        datoNombreTorneo.setBounds(250, 150, 200, 30);
	        datoJuego.setBounds(250, 200, 200, 30);
	        datoFechaInicio.setBounds(250, 250, 200, 30);
	        datoFechaFin.setBounds(250, 300, 200, 30);
	        datoFormatoTorneo.setBounds(250, 350, 200, 30);
	        datoMaxEquipos.setBounds(250, 400, 200, 30);
	        btnAgregar.setBounds(250, 450, 200, 30);
	        etiqueta0.setBounds(250, 230, 200, 30);
	        etiqueta1.setBounds(250, 270, 200, 30);
	        add(datoFechaInicio);
	        add(datoFechaFin);
	        add(btnAgregar);
	        add(datoNombreTorneo);
	        add(datoMaxEquipos);
	        add(datoFormatoTorneo);
	        add(datoJuego);
	        add(etiqueta0);
	        add(etiqueta1);
	    }
		/**
		 * Este metodo se encarga de pintar el panel con el fondo.
		 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (fondo != null) {
				g.drawImage(fondo, 0, 0, 1267, 700, this);
			} else {

			}
		}
}
