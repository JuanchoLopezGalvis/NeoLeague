package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/** * VentanaAdmin es una clase que extiende de JFrame y representa la ventana
 * principal de la aplicación para el administrador.
 * 
 * @version 1.0
 */
public class VentanaAdmin extends JFrame{

	private JMenuBar menuBar;
	private JMenu administrarGamer, administrarCouch, administrarTorneos, administrarPartidas, administrarEquipo, reportes;
	private JMenuItem  torneoAnalitycs, mostrarGamers, mostrarCoachs, crearTorneo, crearPartida, mostrarTorneos, actualizarTorneo, actualizarEquipo,  mostrarEquipos, analiytics;
	private CardAdmin cardAdmin;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public VentanaAdmin() {
		setTitle("Window Admin");
		setSize(1280,720);
		setLocationRelativeTo(null);
		setLayout(null);
		menuBar = new JMenuBar();
		reportes = new JMenu("Reports");
		administrarGamer = new JMenu("Manage Gamers");
		administrarCouch = new JMenu("Manage Couchs");
		mostrarGamers = new JMenuItem("Show Gamers");
		mostrarCoachs = new JMenuItem("Show Couchs");
		administrarTorneos = new JMenu("Manage Tournaments");
		administrarPartidas = new JMenu("Manage Matches");
		crearTorneo = new JMenuItem("Create Tournament");
		crearPartida = new JMenuItem("Create Match");
		mostrarTorneos = new JMenuItem("Show Tournaments");
		torneoAnalitycs = new JMenuItem("Analitycs");
		actualizarTorneo = new JMenuItem("Update Tournament");
		administrarEquipo = new JMenu("Manage Teams");
		actualizarEquipo = new JMenuItem("Update Team");
		mostrarEquipos = new JMenuItem("Show Teams");
		analiytics = new JMenuItem("Analytics");
		menuBar.add(administrarGamer);
		menuBar.add(administrarCouch);
		menuBar.add(administrarEquipo);
		menuBar.add(administrarTorneos);
		menuBar.add(administrarPartidas);
		menuBar.add(reportes);
		administrarTorneos.add(crearTorneo);
		administrarTorneos.add(mostrarTorneos);
		administrarTorneos.add(actualizarTorneo);
		administrarTorneos.add(torneoAnalitycs);
		administrarPartidas.add(crearPartida);
		administrarGamer.add(mostrarGamers);
		administrarCouch.add(mostrarCoachs);
		administrarEquipo.add(actualizarEquipo);
		administrarEquipo.add(mostrarEquipos);
		reportes.add(analiytics);
		setJMenuBar(menuBar);
		cardAdmin = new CardAdmin();
		cardAdmin.setBounds(0, 0, 1280, 720);
		add(cardAdmin);
		setVisible(true);
	}
	public JMenu getAdministrarCouch() {
		return administrarCouch;
	}
	public void setAdministrarCouch(JMenu administrarCouch) {
		this.administrarCouch = administrarCouch;
	}
	public JMenu getReportes() {
		return reportes;
	}
	public void setReportes(JMenu reportes) {
		this.reportes = reportes;
	}

	public JMenuItem getMostrarGamers() {
		return mostrarGamers;
	}
	public void setMostrarGamers(JMenuItem mostrarGamers) {
		this.mostrarGamers = mostrarGamers;
	}
	public JMenuItem getMostrarCoachs() {
		return mostrarCoachs;
	}
	public void setMostrarCoachs(JMenuItem mostrarCoachs) {
		this.mostrarCoachs = mostrarCoachs;
	}
	public JMenuItem getCrearTorneo() {
		return crearTorneo;
	}
	public void setCrearTorneo(JMenuItem crearTorneo) {
		this.crearTorneo = crearTorneo;
	}
	public JMenuItem getCrearPartida() {
		return crearPartida;
	}
	public void setCrearPartida(JMenuItem crearPartida) {
		this.crearPartida = crearPartida;
	}
	public JMenuItem getMostrarTorneos() {
		return mostrarTorneos;
	}
	public void setMostrarTorneos(JMenuItem mostrarTorneos) {
		this.mostrarTorneos = mostrarTorneos;
	}
	public JMenuItem getActualizarTorneo() {
		return actualizarTorneo;
	}
	public void setActualizarTorneo(JMenuItem actualizarTorneo) {
		this.actualizarTorneo = actualizarTorneo;
	}
	public JMenuItem getActualizarEquipo() {
		return actualizarEquipo;
	}
	public void setActualizarEquipo(JMenuItem actualizarEquipo) {
		this.actualizarEquipo = actualizarEquipo;
	}
	public JMenuItem getMostrarEquipos() {
		return mostrarEquipos;
	}
	public void setMostrarEquipos(JMenuItem mostrarEquipos) {
		this.mostrarEquipos = mostrarEquipos;
	}
	public CardAdmin getCardAdmin() {
		return cardAdmin;
	}
	public void setCardAdmin(CardAdmin cardAdmin) {
		this.cardAdmin = cardAdmin;
	}
	public JMenu getAdministrarGamer() {
		return administrarGamer;
	}
	public void setAdministrarGamer(JMenu administrarGamer) {
		this.administrarGamer = administrarGamer;
	}
	public JMenu getAdministrarTorneos() {
		return administrarTorneos;
	}
	public void setAdministrarTorneos(JMenu administrarTorneos) {
		this.administrarTorneos = administrarTorneos;
	}
	public JMenu getAdministrarPartidas() {
		return administrarPartidas;
	}
	public void setAdministrarPartidas(JMenu administrarPartidas) {
		this.administrarPartidas = administrarPartidas;
	}
	public JMenu getAdministrarEquipo() {
		return administrarEquipo;
	}
	public void setAdministrarEquipo(JMenu administrarEquipo) {
		this.administrarEquipo = administrarEquipo;
	}
	public JMenuItem getAnaliytics() {
		return analiytics;
	}
	public void setAnaliytics(JMenuItem analiytics) {
		this.analiytics = analiytics;
	}
	public JMenuItem getTorneoAnalitycs() {
		return torneoAnalitycs;
	}
	public void setTorneoAnalitycs(JMenuItem torneoAnalitycs) {
		this.torneoAnalitycs = torneoAnalitycs;
	}




}
