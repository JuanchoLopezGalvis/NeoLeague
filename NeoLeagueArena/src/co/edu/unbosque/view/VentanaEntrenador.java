package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * VentanaEntrenador es una clase que extiende de JFrame y representa la ventana
 * principal de la aplicación para el entrenador.
 * 
 * @version 1.0
 */
public class VentanaEntrenador extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu gestionarEquipos, gestionarCuenta, gestionarTorneo, gestionarPartidas, estadisticas;
	private JMenuItem actualizarCuenta, crearEquipo, ActualizarEquipo, verEquipos, inscribirTorneo,verTorneos, consultarPartida, verEstadisticasEquipos;
	private CardCoach cardCoach;

	public VentanaEntrenador() {
		setSize(1280,720);
		setLocationRelativeTo(null);
		setTitle("Ventana Entrenador");
		setLayout(null);
		setResizable(false);
		menuBar = new JMenuBar();
		gestionarEquipos = new JMenu("Gestionar Equipos");
		gestionarCuenta = new JMenu("Gestionar Cuenta");
		gestionarTorneo = new JMenu("Gestionar Torneos");
		gestionarPartidas = new JMenu("Partidas");
		estadisticas = new JMenu("Estadisticas");
		crearEquipo = new JMenuItem("Crear Equipo");

		ActualizarEquipo = new JMenuItem("actualizar Equipo");
		verEquipos = new JMenuItem("Mostrar y eliminar equipos");
		inscribirTorneo = new JMenuItem("Inscribir Torneo");
		verTorneos = new JMenuItem("Ver Torneos");
		consultarPartida = new JMenuItem("Consultar Partida");
		verEstadisticasEquipos = new JMenuItem("Ver Estadisticas Equipos");
		actualizarCuenta = new JMenuItem("Actualizar Cuenta");
		menuBar.add(gestionarEquipos);
		menuBar.add(gestionarCuenta);
		menuBar.add(gestionarTorneo);
		menuBar.add(gestionarPartidas);
		menuBar.add(estadisticas);
		gestionarEquipos.add(crearEquipo);
		gestionarEquipos.add(ActualizarEquipo);
		gestionarEquipos.add(verEquipos);
		gestionarCuenta.add(actualizarCuenta);
		gestionarTorneo.add(inscribirTorneo);
		gestionarTorneo.add(verTorneos);
		gestionarPartidas.add(consultarPartida);
		estadisticas.add(verEstadisticasEquipos);
		setJMenuBar(menuBar);
		cardCoach = new CardCoach();
		cardCoach.setBounds(0, 0, 1280, 720);
		add(cardCoach);
		setVisible(true);
	}

	public JMenuItem getActualizarCuenta() {
		return actualizarCuenta;
	}

	public void setActualizarCuenta(JMenuItem actualizarCuenta) {
		this.actualizarCuenta = actualizarCuenta;
	}

	public JMenu getGestionarEquipos() {
		return gestionarEquipos;
	}

	public void setGestionarEquipos(JMenu gestionarEquipos) {
		this.gestionarEquipos = gestionarEquipos;
	}

	public JMenu getGestionarCuenta() {
		return gestionarCuenta;
	}

	public void setGestionarCuenta(JMenu gestionarCuenta) {
		this.gestionarCuenta = gestionarCuenta;
	}

	public JMenu getGestionarTorneo() {
		return gestionarTorneo;
	}

	public void setGestionarTorneo(JMenu gestionarTorneo) {
		this.gestionarTorneo = gestionarTorneo;
	}

	public JMenu getGestionarPartidas() {
		return gestionarPartidas;
	}

	public void setGestionarPartidas(JMenu gestionarPartidas) {
		this.gestionarPartidas = gestionarPartidas;
	}

	public JMenu getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(JMenu estadisticas) {
		this.estadisticas = estadisticas;
	}

	public JMenuItem getCrearEquipo() {
		return crearEquipo;
	}

	public void setCrearEquipo(JMenuItem crearEquipo) {
		this.crearEquipo = crearEquipo;
	}



	public JMenuItem getActualizarEquipo() {
		return ActualizarEquipo;
	}

	public void setActualizarEquipo(JMenuItem actualizarEquipo) {
		ActualizarEquipo = actualizarEquipo;
	}

	public JMenuItem getVerEquipos() {
		return verEquipos;
	}

	public void setVerEquipos(JMenuItem verEquipos) {
		this.verEquipos = verEquipos;
	}

	public JMenuItem getInscribirTorneo() {
		return inscribirTorneo;
	}

	public void setInscribirTorneo(JMenuItem inscribirTorneo) {
		this.inscribirTorneo = inscribirTorneo;
	}
	public JMenuItem getVerTorneos() {
		return verTorneos;
	}

	public void setVerTorneos(JMenuItem verTorneos) {
		this.verTorneos = verTorneos;
	}

	public JMenuItem getConsultarPartida() {
		return consultarPartida;
	}

	public void setConsultarPartida(JMenuItem consultarPartida) {
		this.consultarPartida = consultarPartida;
	}

	public JMenuItem getVerEstadisticasEquipos() {
		return verEstadisticasEquipos;
	}

	public void setVerEstadisticasEquipos(JMenuItem verEstadisticasEquipos) {
		this.verEstadisticasEquipos = verEstadisticasEquipos;
	}

	public CardCoach getCardCoach() {
		return cardCoach;
	}

	public void setCardCoach(CardCoach cardCoach) {
		this.cardCoach = cardCoach;
	}




}
