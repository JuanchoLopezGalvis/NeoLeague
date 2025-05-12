package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardAdmin extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	
	public CardAdmin() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
	}
}
