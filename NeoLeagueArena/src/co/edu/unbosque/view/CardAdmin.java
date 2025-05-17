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
	private PanelAgregarPartida panelAgregarPartida;
	private PanelActualizarPartida panelActualizarPartida;
	private PanelInforme panelInforme;
	private PanelActualizar panelActualizar;
	
	public CardAdmin() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		panelMostrar = new PanelMostrar();
		panelAgregarTorneo = new PanelAgregarTorneo();
		panelAgregarPartida = new PanelAgregarPartida();
		panelActualizarPartida = new PanelActualizarPartida();
		panelInforme = new PanelInforme();
		panelActualizar = new PanelActualizar();
		add(panelInforme, "PanelInforme");
		add(panelAgregarTorneo, "PanelAgregarTorneo");
		add(panelMostrar, "PanelMostrar");
		add(panelAgregarPartida, "PanelAgregarPartida");
		add(panelActualizarPartida, "PanelActualizarPartida");
		add(panelActualizar, "PanelActualizar");
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
	public PanelAgregarPartida getPanelAgregarPartida() {
		return panelAgregarPartida;
	}
	public void setPanelAgregarPartida(PanelAgregarPartida panelAgregarPartida) {
		this.panelAgregarPartida = panelAgregarPartida;
	}
	public PanelActualizarPartida getPanelActualizarPartida() {
		return panelActualizarPartida;
	}
	public void setPanelActualizarPartida(PanelActualizarPartida panelActualizarPartida) {
		this.panelActualizarPartida = panelActualizarPartida;
	}
	public PanelInforme getPanelInforme() {
		return panelInforme;
	}
	public void setPanelInforme(PanelInforme panelInforme) {
		this.panelInforme = panelInforme;
	}
	public PanelActualizar getPanelActualizar() {
		return panelActualizar;
	}
	public void setPanelActualizar(PanelActualizar panelActualizar) {
		this.panelActualizar = panelActualizar;
	}
	
	
	
}
