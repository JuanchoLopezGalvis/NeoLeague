package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaGamer extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu gestionarCuenta, gestionarTorneos, verPartidas, estadisticas;
	private JMenuItem actualizarCuenta, consultarTorneos, topGamers;
	private CardGamer cardGamer;

	public VentanaGamer() {
		setSize(1280,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Ventana Gamer");
		setLayout(null);
		menuBar = new JMenuBar();
		gestionarCuenta = new JMenu("Gestionar Cuenta");
		gestionarTorneos = new JMenu("Gestionar Torneos");
		verPartidas = new JMenu("Ver mis partidas");
		estadisticas = new JMenu("Estadisticas");
		menuBar.add(gestionarCuenta);
		menuBar.add(gestionarTorneos);
		menuBar.add(verPartidas);
		menuBar.add(estadisticas);
		actualizarCuenta = new JMenuItem("Actualizar mi cuenta");
		consultarTorneos = new JMenuItem("Consultar torneos");
		topGamers = new JMenuItem("Top Gamers");
		gestionarCuenta.add(actualizarCuenta);
		gestionarTorneos.add(consultarTorneos);
		estadisticas.add(topGamers);
		setJMenuBar(menuBar);
		cardGamer = new CardGamer();
		cardGamer.setBounds(0, 0, 1280, 720);
		add(cardGamer);
		setVisible(true);
	}



	public JMenu getGestionarCuenta() {
		return gestionarCuenta;
	}

	public void setGestionarCuenta(JMenu gestionarCuenta) {
		this.gestionarCuenta = gestionarCuenta;
	}

	public JMenu getGestionarTorneos() {
		return gestionarTorneos;
	}

	public void setGestionarTorneos(JMenu gestionarTorneos) {
		this.gestionarTorneos = gestionarTorneos;
	}

	public JMenu getVerPartidas() {
		return verPartidas;
	}

	public void setVerPartidas(JMenu verPartidas) {
		this.verPartidas = verPartidas;
	}

	public JMenu getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(JMenu estadisticas) {
		this.estadisticas = estadisticas;
	}

	public JMenuItem getActualizarCuenta() {
		return actualizarCuenta;
	}

	public void setActualizarCuenta(JMenuItem actualizarCuenta) {
		this.actualizarCuenta = actualizarCuenta;
	}

	public JMenuItem getConsultarTorneos() {
		return consultarTorneos;
	}

	public void setConsultarTorneos(JMenuItem consultarTorneos) {
		this.consultarTorneos = consultarTorneos;
	}


	public JMenuItem getTopGamers() {
		return topGamers;
	}

	public void setTopGamers(JMenuItem topGamers) {
		this.topGamers = topGamers;
	}

	public CardGamer getCardGamer() {
		return cardGamer;
	}

	public void setCardGamer(CardGamer cardGamer) {
		this.cardGamer = cardGamer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
