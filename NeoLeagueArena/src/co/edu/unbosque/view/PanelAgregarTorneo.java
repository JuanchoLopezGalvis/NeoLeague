package co.edu.unbosque.view;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import de.wannawork.jcalendar.JCalendarComboBox;






public class PanelAgregarTorneo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCalendarComboBox dateChooserInicio;

	    public PanelAgregarTorneo() {
	        setLayout(new GridLayout(5, 2));

	        // Campo de fecha inicio
	        add(new JLabel("Fecha Inicio:"));
	        dateChooserInicio = new JCalendarComboBox();
	        add(dateChooserInicio);

	        // Campo de fecha fin
	        // Botón para guardar
	        JButton btnGuardar = new JButton("Guardar");


	        setVisible(true);
	    }

	    

	    public static void main(String[] args) {
	        new PanelAgregarTorneo();
	    }
}
