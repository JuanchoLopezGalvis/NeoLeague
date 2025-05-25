package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Esta clase representa un panel que utiliza un CardLayout para mostrar diferentes
 * paneles en función de la selección del usuario. Permite cambiar entre diferentes
 * vistas de la interfaz de usuario.
 */
public class CardGamer extends JPanel{

	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel que contiene la vista para actualizar un jugador.
	 */
	private PanelActualizarJugador panelActualizarJugador;
	private PanelMostrarTorneo panelMostrarTorneo;
	/**
	 * CardLayout que permite cambiar entre diferentes paneles.
	 */
	private CardLayout cardLayout;
	/**
	 * Constructor de la clase {@link CardGamer}.
	 * Inicializa el CardLayout y agrega los diferentes paneles al contenedor.
	 */
	public CardGamer() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelActualizarJugador = new PanelActualizarJugador();
		panelMostrarTorneo = new PanelMostrarTorneo();
		add(panelActualizarJugador, "PanelActualizarJugador");
		add(panelMostrarTorneo, "PanelMostrarTorneo");
	}
	/**
	 * Este método permite mostrar un panel específico en función del nombre del panel.
	 * @param nombrePanel El nombre del panel que se desea mostrar.
	 */
	public void mostrarPanel(String nombrePanel) {
		cardLayout.show(this, nombrePanel);
	}
	/**
	 * Este método permite establecer el panel de actualización de jugador.
	 * @param panelActualizarJugador El panel de actualización de jugador a establecer.
	 */
	public void setPanelActualizarJugador(PanelActualizarJugador panelActualizarJugador) {
		this.panelActualizarJugador = panelActualizarJugador;
	}
	/**
	 * Este método permite obtener el panel de actualización de jugador.
	 * @return El panel de actualización de jugador.
	 */
	public PanelActualizarJugador getPanelActualizarJugador() {
		return panelActualizarJugador;
	}
	public PanelMostrarTorneo getPanelMostrarTorneo() {
		return panelMostrarTorneo;
	}
	public void setPanelMostrarTorneo(PanelMostrarTorneo panelMostrarTorneo) {
		this.panelMostrarTorneo = panelMostrarTorneo;
	}
	
}
