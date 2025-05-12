package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardCoach extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	
	public CardCoach() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
	}

}
