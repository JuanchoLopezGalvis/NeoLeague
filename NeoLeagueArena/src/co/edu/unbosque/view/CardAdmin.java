package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;
/**
 * Esta clase representa un panel que utiliza un CardLayout para mostrar diferentes
 * paneles en función de la selección del usuario. Permite cambiar entre diferentes
 * vistas de la interfaz de usuario.
 */
public class CardAdmin extends JPanel{

	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * cardLayout es una instancia de CardLayout que permite cambiar entre diferentes paneles.
	 */
	private CardLayout cardLayout;
	/**
	 * panelMostrar es una instancia de PanelMostrar que muestra información sobre los torneos.
	 */
	private PanelMostrar panelMostrar;
	/**
	 * panelAgregarTorneo es una instancia de PanelAgregarTorneo que permite agregar un nuevo torneo.
	 */
	private PanelAgregarTorneo panelAgregarTorneo;
	/**
	 * panelAgregarPartida es una instancia de PanelAgregarPartida que permite agregar una nueva partida.
	 */
	private PanelAgregarPartida panelAgregarPartida;
	/**
	 * panelInforme es una instancia de PanelInforme que muestra informes sobre los torneos.
	 */
	private PanelInforme panelInforme;
	/**
	 * panelActualizarEquipo es una instancia de PanelActualizarEquipo que permite actualizar la información de un torneo.
	 */
	private PanelActualizarEquipo panelActualizarEquipo;
	/**
	 * panelActualizarTorneo es una instancia de PanelActualizarTorneo que permite actualizar la información de un torneo.
	 */
	private PanelActualizarTorneo panelActualizarTorneo;
	/**
	 * panelMostrarTorneo es una instancia de PanelMostrarTorneo que muestra información sobre los torneos.
	 */
	private PanelMostrarTorneo panelMostrarTorneo;
	/**
	 * Constructor de la clase {@link CardAdmin}.
	 * Inicializa el CardLayout y agrega los diferentes paneles al contenedor.
	 */
	public CardAdmin() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelMostrar = new PanelMostrar();
		panelAgregarTorneo = new PanelAgregarTorneo();
		panelAgregarPartida = new PanelAgregarPartida();
		panelInforme = new PanelInforme();
		panelActualizarTorneo = new PanelActualizarTorneo();
		panelActualizarEquipo = new PanelActualizarEquipo();
		panelMostrarTorneo = new PanelMostrarTorneo();
		add(panelAgregarTorneo, "PanelAgregarTorneo");
		add(panelMostrarTorneo, "PanelMostrarTorneo");
		add(panelActualizarTorneo, "PanelActualizarTorneo");
		add(panelInforme, "PanelInforme");
		add(panelActualizarEquipo, "PanelActualizarEquipo");
		add(panelAgregarPartida, "PanelAgregarPartida");
		add(panelMostrar, "PanelMostrar");
	}
	/**
	 * Cambia el panel visible en función del nombre del panel proporcionado.
	 * @param nombrePanel El nombre del panel que se desea mostrar.
	 */
	public void mostrarPanel(String nombrePanel) {
		cardLayout.show(this, nombrePanel);
	}
	/**
	 * Metodo que retorna el panel de mostrar.
	 * @return panelMostrar
	 */
	public PanelMostrar getPanelMostrar() {
		return panelMostrar;
	}
	/**
	 * Metodo que asigna el panel de mostrar.
	 * @param panelMostrar
	 */
	public void setPanelMostrar(PanelMostrar panelMostrar) {
		this.panelMostrar = panelMostrar;
	}
	/**
	 * Metodo que retorna el panel de agregar torneo.
	 * @return panelAgregarTorneo
	 */
	public PanelAgregarTorneo getPanelAgregarTorneo() {
		return panelAgregarTorneo;
	}
	/**
	 * Metodo que asigna el panel de agregar torneo.
	 * @param panelAgregarTorneo
	 */
	public void setPanelAgregarTorneo(PanelAgregarTorneo panelAgregarTorneo) {
		this.panelAgregarTorneo = panelAgregarTorneo;
	}
	/**
	 * Metodo que retorna el panel de agregar partida.
	 * @return panelAgregarPartida
	 */
	public PanelAgregarPartida getPanelAgregarPartida() {
		return panelAgregarPartida;
	}
	/**
	 * Metodo que asigna el panel de agregar partida.
	 * @param panelAgregarPartida
	 */
	public void setPanelAgregarPartida(PanelAgregarPartida panelAgregarPartida) {
		this.panelAgregarPartida = panelAgregarPartida;
	}
	/**
	 * Metodo que retorna el panel de informe.
	 * @return panelInforme
	 */
	public PanelInforme getPanelInforme() {
		return panelInforme;
	}
	/**
	 * Metodo que asigna el panel de informe.
	 * @param panelInforme
	 */
	public void setPanelInforme(PanelInforme panelInforme) {
		this.panelInforme = panelInforme;
	}
	/**
	 * Metodo que retorna el panel de actualizar.
	 * @return panelActualizarEquipo
	 */
	public PanelActualizarEquipo getPanelActualizar() {
		return panelActualizarEquipo;
	}
	/**
	 * Metodo que asigna el panel de actualizar.
	 * @param panelActualizarEquipo
	 */
	public void setPanelActualizar(PanelActualizarEquipo panelActualizarEquipo) {
		this.panelActualizarEquipo = panelActualizarEquipo;
	}
	/**
	 * Metodo que retorna el panel de actualizar torneo.
	 * @return panelActualizarTorneo
	 */
	public PanelActualizarTorneo getPanelActualizarTorneo() {
		return panelActualizarTorneo;
	}
	/**
	 * Metodo que asigna el panel de actualizar torneo.
	 * @param panelActualizarTorneo
	 */
	public void setPanelActualizarTorneo(PanelActualizarTorneo panelActualizarTorneo) {
		this.panelActualizarTorneo = panelActualizarTorneo;
	}
	/**
	 * Metodo que retorna el panel de actualizar equipo.
	 * @return panelActualizarEquipo
	 */
	public PanelActualizarEquipo getPanelActualizarEquipo() {
		return panelActualizarEquipo;
	}
	/**
	 * Metodo que asigna el panel de actualizar equipo.
	 * @param panelActualizarEquipo
	 */
	public void setPanelActualizarEquipo(PanelActualizarEquipo panelActualizarEquipo) {
		this.panelActualizarEquipo = panelActualizarEquipo;
	}
	/**
	 * Metodo que retorna el panel de mostrar torneo.
	 * @return panelMostrarTorneo
	 */
	public PanelMostrarTorneo getPanelMostrarTorneo() {
		return panelMostrarTorneo;
	}
	/**
	 * Metodo que asigna el panel de mostrar torneo.
	 * @param panelMostrarTorneo
	 */
	public void setPanelMostrarTorneo(PanelMostrarTorneo panelMostrarTorneo) {
		this.panelMostrarTorneo = panelMostrarTorneo;
	}
	
}