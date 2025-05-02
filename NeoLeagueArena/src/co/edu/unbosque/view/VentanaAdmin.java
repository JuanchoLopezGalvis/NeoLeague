package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaAdmin extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu administrarGamer, administrarCouch;
	private JMenuItem mostrarGamers, mostrarCouchs, eliminarGamer, eliminarCouch;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VentanaAdmin() {
		setTitle("Window Admin");
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		menuBar = new JMenuBar();
		administrarGamer = new JMenu("Manage Gamers");
		administrarCouch = new JMenu("Manage Couchs");
		mostrarGamers = new JMenuItem("Show Gamers");
		mostrarCouchs = new JMenuItem("Show Couchs");
		eliminarGamer = new JMenuItem("Delete Gamer");
		eliminarCouch = new JMenuItem("Delete Couch");
		administrarGamer.add(mostrarGamers);
		administrarGamer.add(eliminarGamer);
		administrarCouch.add(mostrarCouchs);
		administrarCouch.add(eliminarCouch);
		menuBar.add(administrarGamer);
		menuBar.add(administrarCouch);
		setJMenuBar(menuBar);
		setVisible(true);
		
	}
	
	

}
