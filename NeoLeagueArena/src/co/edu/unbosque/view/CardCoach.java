package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardCoach extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelMostrar panelMostrar;
	private PanelActualizar panelActualizar;
	private PanelActualizarEntrenador panelActualizarEntrenador;
	private CardLayout cardLayout;
	private PanelAgregarEquipo panelAgregarEquipo;
	public CardCoach() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelMostrar = new PanelMostrar();
		panelActualizar = new PanelActualizar();
		panelAgregarEquipo = new PanelAgregarEquipo();
		panelActualizarEntrenador = new PanelActualizarEntrenador();
		
		add(panelAgregarEquipo, "PanelAgregarEquipo");
		add(panelActualizar, "PanelActualizar");
		add(panelMostrar, "PanelMostrar");
		add(panelActualizarEntrenador, "PanelActualizarEntrenador");
		
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
	public PanelMostrar getPanelMostrar() {
		return panelMostrar;
	}
	public void setPanelMostrar(PanelMostrar panelMostrar) {
		this.panelMostrar = panelMostrar;
	}
	public PanelActualizar getPanelActualizar() {
		return panelActualizar;
	}
	public void setPanelActualizar(PanelActualizar panelActualizar) {
		this.panelActualizar = panelActualizar;
	}
	public PanelActualizarEntrenador getPanelActualizarEntrenador() {
		return panelActualizarEntrenador;
	}
	public void setPanelActualizarEntrenador(PanelActualizarEntrenador panelActualizarEntrenador) {
		this.panelActualizarEntrenador = panelActualizarEntrenador;
	}
	
	
	
	
}
