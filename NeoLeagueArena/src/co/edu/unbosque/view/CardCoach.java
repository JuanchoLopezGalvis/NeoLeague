package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardCoach extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private PanelAgregarEquipo panelAgregarEquipo;
	public CardCoach() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelAgregarEquipo = new PanelAgregarEquipo();
		add(panelAgregarEquipo, "PanelAgregarEquipo");
	}
	public void mostrarPanel(String nombrePanel) {
		cardLayout.show(this, nombrePanel);
	}
	public PanelAgregarEquipo getPanelAgregarEquipo() {
		return panelAgregarEquipo;
	}
	public void setPanelAgregarEquipo(PanelAgregarEquipo panelAgregarEquipo) {
		this.panelAgregarEquipo = panelAgregarEquipo;
	}
	
}
