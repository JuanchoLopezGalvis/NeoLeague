package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.JComboBox;
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
	        datoNombreTorneo.setText("Nombre del torneo");
	        datoJuego.setToolTipText("Juego");
	        datoFormatoTorneo.setToolTipText("Formato del torneo");
	        datoNombreTorneo.setBounds(100, 100, 200, 30);
	        datoJuego.setBounds(100, 150, 200, 30);
	        datoFechaInicio.setBounds(100, 200, 200, 30);
	        datoFechaFin.setBounds(100, 250, 200, 30);
	        datoFormatoTorneo.setBounds(100, 300, 200, 30);
	        datoMaxEquipos.setBounds(100, 350, 200, 30);
	        btnAgregar.setBounds(100, 400, 200, 30);
	        add(datoFechaInicio);
	        add(datoFechaFin);
	        add(btnAgregar);
	        add(datoNombreTorneo);
	        add(datoMaxEquipos);
	        add(datoFormatoTorneo);
	        add(datoJuego);
	    }
}
