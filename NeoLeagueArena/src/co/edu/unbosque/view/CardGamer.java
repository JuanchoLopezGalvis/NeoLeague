package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardGamer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	
	public CardGamer() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
	}
	
}
