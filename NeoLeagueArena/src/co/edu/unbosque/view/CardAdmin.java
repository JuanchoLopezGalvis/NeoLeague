package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardAdmin extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private PanelMostrar panelMostrar;
	private PanelAgregarTorneo panelAgregarTorneo;
	
	public CardAdmin() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelMostrar = new PanelMostrar();
		panelAgregarTorneo = new PanelAgregarTorneo();
		add(panelMostrar, "PanelMostrar");
		add(panelAgregarTorneo, "PanelAgregarTorneo");
	}
	public void mostrarPanel(String nombrePanel) {
		cardLayout.show(this, nombrePanel);
	}
	public PanelMostrar getPanelMostrar() {
		return panelMostrar;
	}
	public void setPanelMostrar(PanelMostrar panelMostrar) {
		this.panelMostrar = panelMostrar;
	}
	public PanelAgregarTorneo getPanelAgregarTorneo() {
		return panelAgregarTorneo;
	}
	public void setPanelAgregarTorneo(PanelAgregarTorneo panelAgregarTorneo) {
		this.panelAgregarTorneo = panelAgregarTorneo;
	}
	
}
