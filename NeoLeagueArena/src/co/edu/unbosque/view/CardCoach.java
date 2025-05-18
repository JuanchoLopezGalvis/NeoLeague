package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;
/**
 * Esta clase representa un panel que utiliza un CardLayout para mostrar diferentes
 * paneles en función de la selección del usuario. Permite cambiar entre diferentes
 * vistas de la interfaz de usuario.
 */
public class CardCoach extends JPanel{

	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Este es la instacia del panel de mostrar.
	 */
	private PanelMostrar panelMostrar;
	/**
	 * panelMostrar es una instancia de {@link PanelActualizarEquipo} que permite actualizar la información.
	 */
	private PanelActualizarEquipo panelActualizarEquipo;
	/**
	 * panelAgregarTorneo es una instancia de {@link PanelActualizarEntrenador} que permite actualizar la información de un entrenador.
	 */
	private PanelActualizarEntrenador panelActualizarEntrenador;
	/**
	 * Este atributo es el encargado de guardar el CardLayout.
	 * Que permite cambiar entre diferentes paneles.
	 */
	private CardLayout cardLayout;
	/**
	 * panelAgregarEquipo es una instancia de {@link PanelAgregarEquipo} que permite agregar un nuevo equipo.
	 */
	private PanelAgregarEquipo panelAgregarEquipo;
	private PanelInscribirTorneo panelInscribirTorneo;
	/**
	 * Constructor de la clase {@link CardCoach}.
	 * Inicializa el CardLayout y agrega los diferentes paneles al contenedor.
	 */
	public CardCoach() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelMostrar = new PanelMostrar();
		panelActualizarEquipo = new PanelActualizarEquipo();
		panelAgregarEquipo = new PanelAgregarEquipo();
		panelActualizarEntrenador = new PanelActualizarEntrenador();
		panelInscribirTorneo = new PanelInscribirTorneo();
		add(panelInscribirTorneo, "PanelInscribirTorneo");
		add(panelAgregarEquipo, "PanelAgregarEquipo");
		add(panelActualizarEquipo, "PanelActualizarEquipo");
		add(panelMostrar, "PanelMostrar");
		add(panelActualizarEntrenador, "PanelActualizarEntrenador");
	}
	/**
	 * Este método permite mostrar un panel específico en función del nombre del panel.
	 * @param nombrePanel El nombre del panel que se desea mostrar.
	 */
	public void mostrarPanel(String nombrePanel) {
		cardLayout.show(this, nombrePanel);
	}
	/**
	 * Este metodo se encarga de obtener el panel de agregar equipo.
	 * @return el panel de agregar equipo.
	 */
	public PanelAgregarEquipo getPanelAgregarEquipo() {
		return panelAgregarEquipo;
	}
	/**
	 * Este metodo se encarga de setear el panel de agregar equipo.
	 * @param panelAgregarEquipo el panel de agregar equipo.
	 */
	public void setPanelAgregarEquipo(PanelAgregarEquipo panelAgregarEquipo) {
		this.panelAgregarEquipo = panelAgregarEquipo;
	}
	/**
	 * Este metodo se encarga de obtener el panel de mostrar.
	 * @return el panel de mostrar.
	 */
	public PanelMostrar getPanelMostrar() {
		return panelMostrar;
	}
	/**
	 * Este metodo se encarga de setear el panel de mostrar.
	 * @param panelMostrar el panel de mostrar.
	 */
	public void setPanelMostrar(PanelMostrar panelMostrar) {
		this.panelMostrar = panelMostrar;
	}
	/**
	 * Este metodo se encarga de obtener el panel de actualizar.
	 * @return el panel de actualizar.
	 */
	public PanelActualizarEquipo getPanelActualizar() {
		return panelActualizarEquipo;
	}
	/**
	 * Este metodo se encarga de setear el panel de actualizar.
	 * @param panelActualizarEquipo el panel de actualizar.
	 */
	public void setPanelActualizar(PanelActualizarEquipo panelActualizarEquipo) {
		this.panelActualizarEquipo = panelActualizarEquipo;
	}
	/**
	 * Este metodo se encarga de obtener el panel de actualizar entrenador.
	 * @return el panel de actualizar entrenador.
	 */
	public PanelActualizarEntrenador getPanelActualizarEntrenador() {
		return panelActualizarEntrenador;
	}
	/**
	 * Este metodo se encarga de setear el panel de actualizar entrenador.
	 * @param panelActualizarEntrenador el panel de actualizar entrenador.
	 */
	public void setPanelActualizarEntrenador(PanelActualizarEntrenador panelActualizarEntrenador) {
		this.panelActualizarEntrenador = panelActualizarEntrenador;
	}
}