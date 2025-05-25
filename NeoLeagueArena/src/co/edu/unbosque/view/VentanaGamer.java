package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * VentanaGamer es una clase que extiende de JFrame y representa la ventana
 * principal de la aplicación para el gamer.
 * 
 * @version 1.0
 */
public class VentanaGamer extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu gestionarCuenta, gestionarTorneos, estadisticas;
	private JMenuItem actualizarCuenta, consultarTorneos, topGamers;
	private CardGamer cardGamer;

	/**
	 * Este es el constructor de la clase {@link VentanaGamer} que se encarga de inicializar el panel principal y darle las caracteristicas a la ventana.
	 */
	public VentanaGamer() {
		setSize(1280,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Ventana Gamer");
		setLayout(null);
		menuBar = new JMenuBar();
		gestionarCuenta = new JMenu("Gestionar Cuenta");
		gestionarTorneos = new JMenu("Gestionar Torneos");
		estadisticas = new JMenu("Equipos");
		menuBar.add(gestionarCuenta);
		menuBar.add(gestionarTorneos);
		menuBar.add(estadisticas);
		actualizarCuenta = new JMenuItem("Actualizar mi cuenta");
		consultarTorneos = new JMenuItem("Consultar torneos");
		topGamers = new JMenuItem("Inscribir equipo");
		gestionarCuenta.add(actualizarCuenta);
		gestionarTorneos.add(consultarTorneos);
		estadisticas.add(topGamers);
		setJMenuBar(menuBar);
		cardGamer = new CardGamer();
		cardGamer.setBounds(0, 0, 1280, 720);
		add(cardGamer);
	}


	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return cardGamer
	 */

	public JMenu getGestionarCuenta() {
		return gestionarCuenta;
	}
	
	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param cardGamer
	 */

	public void setGestionarCuenta(JMenu gestionarCuenta) {
		this.gestionarCuenta = gestionarCuenta;
	}

	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return cardGamer
	 */
	public JMenu getGestionarTorneos() {
		return gestionarTorneos;
	}

	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param cardGamer
	 */
	public void setGestionarTorneos(JMenu gestionarTorneos) {
		this.gestionarTorneos = gestionarTorneos;
	}

	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return estadisticas
	 */
	public JMenu getEstadisticas() {
		return estadisticas;
	}

	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param JMenu estadisticas
	 */
	public void setEstadisticas(JMenu estadisticas) {
		this.estadisticas = estadisticas;
	}

	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return cardGamer
	 */
	
	public JMenuItem getActualizarCuenta() {
		return actualizarCuenta;
	}

	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param JMenuItem actualizarCuenta
	 */
	public void setActualizarCuenta(JMenuItem actualizarCuenta) {
		this.actualizarCuenta = actualizarCuenta;
	}

	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return consultarTorneos
	 */
	public JMenuItem getConsultarTorneos() {
		return consultarTorneos;
	}

	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param JMenuItem consultarTorneos
	 */
	public void setConsultarTorneos(JMenuItem consultarTorneos) {
		this.consultarTorneos = consultarTorneos;
	}
	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return topGamers
	 */

	public JMenuItem getTopGamers() {
		return topGamers;
	}

	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param JMenuItem topGamers
	 */
	public void setTopGamers(JMenuItem topGamers) {
		this.topGamers = topGamers;
	}

	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return cardGamer
	 */
	public CardGamer getCardGamer() {
		return cardGamer;
	}

	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param cardGamer
	 */
	public void setCardGamer(CardGamer cardGamer) {
		this.cardGamer = cardGamer;
	}

	/**
	 * Este metodo se encarga de obtener el serialVersionUID.
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
