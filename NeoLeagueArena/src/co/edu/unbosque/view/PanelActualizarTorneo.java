package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

import de.wannawork.jcalendar.JCalendarComboBox;

public class PanelActualizarTorneo extends JPanel{
	/**
	 *
	 *
	 * Esta clase representa un panel que permite actualizar la información de los torneos en la aplicación.
	 * Contiene campos para ingresar datos, un botón para actualizar y un combo box para seleccionar torneos existentes.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCalendarComboBox datoFechaInicio, datoFechaFin;
	private BotonRedondeado btnActualizar;
	private TextFieldRedondeado datoNombreTorneo;
	private JSpinner datoMaxEquipos, recompensa;
	private JLabel etiqueta0, etiqueta1;
	private JComboBox<String> torneosExistentes;
	private Image fondo;
	    public PanelActualizarTorneo() {
	        setLayout(null);
	        setSize(1280, 720);
	        datoFechaInicio = new JCalendarComboBox();
	        torneosExistentes = new JComboBox<>();
	        btnActualizar = new BotonRedondeado("Actualizar", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
	        datoNombreTorneo = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
	        datoMaxEquipos = new JSpinner();
	        recompensa = new JSpinner();
	        datoFechaFin = new JCalendarComboBox();
	        datoNombreTorneo.setToolTipText("Nombre del torneo");
	        datoMaxEquipos.setToolTipText("Maximo de equipos");
	        etiqueta1 = new JLabel("Fecha de fin");
	        etiqueta0 = new JLabel("Fecha de inicio");
	        etiqueta1.setForeground(Color.white);
	        etiqueta0.setForeground(Color.white);
	        etiqueta0.setFont(new java.awt.Font("Arial", 1, 12));
	        etiqueta1.setFont(new java.awt.Font("Arial", 1, 12));
	        fondo = new ImageIcon(getClass().getResource("/recursos/fondoATorneo.png")).getImage();
	        recompensa.setToolTipText("Recompensa");
	        bloquearSpinner(datoMaxEquipos, 0, 1, Color.decode("#002d69"), Color.white);
	        bloquearSpinner(recompensa, 0, 1, Color.decode("#002d69"), Color.white);
	        torneosExistentes.setBackground(Color.decode("#002d69"));
	        torneosExistentes.setForeground(Color.white);
	        torneosExistentes.setToolTipText("Cup to edit");
	        torneosExistentes.setBounds(250, 170, 200, 30);
	        datoNombreTorneo.setBounds(250, 225, 200, 30);
	        datoFechaInicio.setBounds(250, 285, 200, 30);
	        datoFechaFin.setBounds(250, 335, 200, 30);
	        datoMaxEquipos.setBounds(250, 385, 200, 30);
	        recompensa.setBounds(250, 435, 200, 30);
	        btnActualizar.setBounds(250, 485, 200, 30);
	        etiqueta0.setBounds(250, 260, 200, 30);
	        etiqueta1.setBounds(250, 310, 200, 30);
	        add(datoFechaInicio);
	        add(datoFechaFin);
	        add(btnActualizar);
	        add(datoNombreTorneo);
	        add(datoMaxEquipos);
	        add(etiqueta0);
	        add(etiqueta1);
	        add(recompensa);
	        add(torneosExistentes);
	    }
		/**
		 * Este metodo se encarga de bloquear el spinner y de establecer el color del fondo y del texto.
		 * @param spinner el spinner que se va a bloquear.
		 * @param minimo el valor minimo que puede tener el spinner.
		 * @param stepSize el tamaño del paso del spinner.
		 * @param color1 el color del fondo del spinner.
		 * @param color2 el color del texto del spinner.
		 */
		public void bloquearSpinner(JSpinner spinner, int minimo, int stepSize, Color color1, Color color2) {
			spinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setBackground(color1);
			((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setForeground(color2);
			JFormattedTextField txt = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
			NumberFormatter formatter = (NumberFormatter) txt.getFormatter();
			formatter.setAllowsInvalid(false);
			formatter.setMinimum(0);
		}
		/**
		 * Este metodo se encarga de pintar el panel con el fondo.
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (fondo != null) {
				g.drawImage(fondo, 0, 0, 1267, 700, this);
			} else {

			}
		}
		public JCalendarComboBox getDatoFechaInicio() {
			return datoFechaInicio;
		}
		public void setDatoFechaInicio(JCalendarComboBox datoFechaInicio) {
			this.datoFechaInicio = datoFechaInicio;
		}
		public JCalendarComboBox getDatoFechaFin() {
			return datoFechaFin;
		}
		public void setDatoFechaFin(JCalendarComboBox datoFechaFin) {
			this.datoFechaFin = datoFechaFin;
		}
		public BotonRedondeado getBtnActualizar() {
			return btnActualizar;
		}
		public void setBtnActualizar(BotonRedondeado btnActualizar) {
			this.btnActualizar = btnActualizar;
		}
		public TextFieldRedondeado getDatoNombreTorneo() {
			return datoNombreTorneo;
		}
		public void setDatoNombreTorneo(TextFieldRedondeado datoNombreTorneo) {
			this.datoNombreTorneo = datoNombreTorneo;
		}
		public JSpinner getDatoMaxEquipos() {
			return datoMaxEquipos;
		}
		public void setDatoMaxEquipos(JSpinner datoMaxEquipos) {
			this.datoMaxEquipos = datoMaxEquipos;
		}
		public JSpinner getRecompensa() {
			return recompensa;
		}
		public void setRecompensa(JSpinner recompensa) {
			this.recompensa = recompensa;
		}
		public JLabel getEtiqueta0() {
			return etiqueta0;
		}
		public void setEtiqueta0(JLabel etiqueta0) {
			this.etiqueta0 = etiqueta0;
		}
		public JLabel getEtiqueta1() {
			return etiqueta1;
		}
		public void setEtiqueta1(JLabel etiqueta1) {
			this.etiqueta1 = etiqueta1;
		}
		public Image getFondo() {
			return fondo;
		}
		public void setFondo(Image fondo) {
			this.fondo = fondo;
		}
		public JComboBox<String> getTorneosExistentes() {
			return torneosExistentes;
		}
		public void setTorneosExistentes(JComboBox<String> torneosExistentes) {
			this.torneosExistentes = torneosExistentes;
		}


}
