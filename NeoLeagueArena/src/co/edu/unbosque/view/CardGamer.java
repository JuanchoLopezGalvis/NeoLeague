package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardGamer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelActualizarJugador panelActualizarJugador;
	private CardLayout cardLayout;
	
	public CardGamer() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelActualizarJugador = new PanelActualizarJugador();
		add(panelActualizarJugador, "PanelActualizarJugador");
		
		
	}

	public PanelActualizarJugador getPanelActualizarJugador() {
		return panelActualizarJugador;
	}

	public void setPanelActualizarJugador(PanelActualizarJugador panelActualizarJugador) {
		this.panelActualizarJugador = panelActualizarJugador;
	}
	
	public void mostrarPanel(String nombrePanel) {
		cardLayout.show(this, nombrePanel);
	}
	
}
