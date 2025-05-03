package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardSignUp extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CrearAdmin crearAdmin;
	private CrearCoach crearCoach;
	private CrearGamer crearGamer;
	private CardLayout cardLayout;
	
	public CardSignUp() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		crearAdmin = new CrearAdmin();
		crearCoach = new CrearCoach();
		crearGamer = new CrearGamer();
		
		
		add(crearAdmin, "CrearAdmin");
		add(crearCoach, "CrearCoach");
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
	public CrearCoach getCrearCoach() {
		return crearCoach;
	}
	public void setCrearCoach(CrearCoach crearCoach) {
		this.crearCoach = crearCoach;
	}
	public CrearGamer getCrearGamer() {
		return crearGamer;
	}
	public void setCrearGamer(CrearGamer crearGamer) {
		this.crearGamer = crearGamer;
	}
	
	
}
