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
	private JMenu gestionarEquipos, gestionarCuenta, gestionarTorneo;
	private JMenuItem actualizarCuenta, crearEquipo, verEquipos, inscribirTorneo,verTorneos;
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
		crearEquipo = new JMenuItem("Crear Equipo");

		verEquipos = new JMenuItem("Mostrar y eliminar equipos");
		inscribirTorneo = new JMenuItem("Inscribir Torneo");
		verTorneos = new JMenuItem("Ver Torneos");
		actualizarCuenta = new JMenuItem("Actualizar Cuenta");
		menuBar.add(gestionarEquipos);
		menuBar.add(gestionarCuenta);
		menuBar.add(gestionarTorneo);
		gestionarEquipos.add(crearEquipo);
		gestionarEquipos.add(verEquipos);
		gestionarCuenta.add(actualizarCuenta);
		gestionarTorneo.add(inscribirTorneo);
		gestionarTorneo.add(verTorneos);
		setJMenuBar(menuBar);
		cardCoach = new CardCoach();
		cardCoach.setBounds(0, 0, 1280, 720);
		add(cardCoach);
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


	public JMenuItem getCrearEquipo() {
		return crearEquipo;
	}

	public void setCrearEquipo(JMenuItem crearEquipo) {
		this.crearEquipo = crearEquipo;
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

	public CardCoach getCardCoach() {
		return cardCoach;
	}

	public void setCardCoach(CardCoach cardCoach) {
		this.cardCoach = cardCoach;
	}




}
