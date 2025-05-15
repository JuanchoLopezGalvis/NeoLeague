package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaEntrenador extends JFrame{
	
	/**
	 * 			
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu gestionarEquipos, gestionarCuenta, gestionarTorneo, gestionarPartidas, estadisticas;
	private JMenuItem actualizarCuenta, crearEquipo, eliminarEquipo, modificarEquipo, verEquipos, inscribirTorneo, salirseTorneo, verTorneos, consultarPartida, verEstadisticasEquipos;
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
		eliminarEquipo = new JMenuItem("Eliminar Equipo");
		modificarEquipo = new JMenuItem("Modificar Equipo");
		verEquipos = new JMenuItem("Ver Equipos");
		inscribirTorneo = new JMenuItem("Inscribir Torneo");
		salirseTorneo = new JMenuItem("Salirse Torneo");
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
		gestionarEquipos.add(eliminarEquipo);
		gestionarEquipos.add(modificarEquipo);
		gestionarEquipos.add(verEquipos);
		gestionarCuenta.add(actualizarCuenta);
		gestionarTorneo.add(inscribirTorneo);
		gestionarTorneo.add(salirseTorneo);
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

	public JMenuItem getCrearEquipo() {
		return crearEquipo;
	}

	public void setCrearEquipo(JMenuItem crearEquipo) {
		this.crearEquipo = crearEquipo;
	}

	public JMenuItem getEliminarEquipo() {
		return eliminarEquipo;
	}

	public void setEliminarEquipo(JMenuItem eliminarEquipo) {
		this.eliminarEquipo = eliminarEquipo;
	}

	public JMenuItem getModificarEquipo() {
		return modificarEquipo;
	}

	public void setModificarEquipo(JMenuItem modificarEquipo) {
		this.modificarEquipo = modificarEquipo;
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

	public JMenuItem getSalirseTorneo() {
		return salirseTorneo;
	}

	public void setSalirseTorneo(JMenuItem salirseTorneo) {
		this.salirseTorneo = salirseTorneo;
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
