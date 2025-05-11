package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaAdmin extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu administrarGamer, administrarCouch, administrarTorneos, administrarPartidas, administrarEquipo, reportes;
	private JMenuItem configurarNotificaciones, mostrarGamers, mostrarCouchs, eliminarGamer, eliminarCouch, eliminarTorneo, eliminarPartida, crearTorneo, crearPartida, mostrarTorneos, mostrarPartidas, actualizarTorneo, actualizarPartida, actualizarEquipo, eliminarEquipo, mostrarEquipos, analiytics;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VentanaAdmin() {
		setTitle("Window Admin");
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		menuBar = new JMenuBar();
		reportes = new JMenu("Reports");
		administrarGamer = new JMenu("Manage Gamers");
		administrarCouch = new JMenu("Manage Couchs");
		mostrarGamers = new JMenuItem("Show Gamers");
		mostrarCouchs = new JMenuItem("Show Couchs");
		eliminarGamer = new JMenuItem("Delete Gamer");
		eliminarCouch = new JMenuItem("Delete Couch");
		administrarTorneos = new JMenu("Manage Tournaments");
		administrarPartidas = new JMenu("Manage Matches");
		crearTorneo = new JMenuItem("Create Tournament");
		crearPartida = new JMenuItem("Create Match");
		mostrarTorneos = new JMenuItem("Show Tournaments");
		mostrarPartidas = new JMenuItem("Show Matches");
		actualizarTorneo = new JMenuItem("Update Tournament");
		actualizarPartida = new JMenuItem("Update Match");
		eliminarTorneo = new JMenuItem("Delete Tournament");
		eliminarPartida = new JMenuItem("Delete Match");
		administrarEquipo = new JMenu("Manage Teams");
		actualizarEquipo = new JMenuItem("Update Team");
		eliminarEquipo = new JMenuItem("Delete Team");
		mostrarEquipos = new JMenuItem("Show Teams");
		configurarNotificaciones = new JMenuItem("Configure Notifications");
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
		administrarTorneos.add(eliminarTorneo);
		administrarTorneos.add(configurarNotificaciones);
		administrarPartidas.add(crearPartida);
		administrarPartidas.add(mostrarPartidas);
		administrarPartidas.add(actualizarPartida);
		administrarPartidas.add(eliminarPartida);
		administrarGamer.add(mostrarGamers);
		administrarGamer.add(eliminarGamer);
		administrarCouch.add(mostrarCouchs);
		administrarCouch.add(eliminarCouch);
		administrarEquipo.add(actualizarEquipo);
		administrarEquipo.add(eliminarEquipo);
		administrarEquipo.add(mostrarEquipos);		
		reportes.add(analiytics);
		setJMenuBar(menuBar);
	}
	
	

}
