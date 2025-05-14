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
		setResizable(false);
		setTitle("Ventana Entrenador");
		setLayout(null);
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
		add(cardCoach);
		setVisible(true);
	}
	
}
