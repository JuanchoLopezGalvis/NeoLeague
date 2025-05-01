package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardSignUp extends JPanel{
	
	private CrearAdmin crearAdmin;
	private CrearCouch crearCouch;
	private CrearGamer crearGamer;
	private CardLayout cardLayout;
	
	public CardSignUp() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		crearAdmin = new CrearAdmin();
		crearCouch = new CrearCouch();
		crearGamer = new CrearGamer();
		
		
		add(crearAdmin, "CrearAdmin");
		add(crearCouch, "CrearCouch");
		add(crearGamer, "CrearGamer");
		
	}
	/**
	 * Metodo que permite mostrar un panel en especifico
	 * @param panel
	 */
	public void mostrarPanel(String panel) {
		cardLayout.show(this, panel);
	}
	public CrearAdmin getCrearAdmin() {
		return crearAdmin;
	}
	public void setCrearAdmin(CrearAdmin crearAdmin) {
		this.crearAdmin = crearAdmin;
	}
	public CrearCouch getCrearCouch() {
		return crearCouch;
	}
	public void setCrearCouch(CrearCouch crearCouch) {
		this.crearCouch = crearCouch;
	}
	public CrearGamer getCrearGamer() {
		return crearGamer;
	}
	public void setCrearGamer(CrearGamer crearGamer) {
		this.crearGamer = crearGamer;
	}
	
	
}
