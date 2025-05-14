package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaGamer extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu gestionarCuenta, gestionarTorneos, verPartidas, estadisticas;
	private JMenuItem actualizarCuenta, consultarTorneos, resultadosTorneos, topGamers;
	private CardGamer cardGamer;
	
	public VentanaGamer() {
		setSize(1280,720);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("Ventana Gamer");
		setLayout(null);
		menuBar = new JMenuBar();
		gestionarCuenta = new JMenu("Gestionar Cuenta");
		gestionarTorneos = new JMenu("Gestionar Torneos");
		verPartidas = new JMenu("Ver mis partidas");
		estadisticas = new JMenu("Estadisticas");
		menuBar.add(gestionarCuenta);
		menuBar.add(gestionarTorneos);
		menuBar.add(verPartidas);
		menuBar.add(estadisticas);
		actualizarCuenta = new JMenuItem("Actualizar mi cuenta");
		consultarTorneos = new JMenuItem("Consultar torneos");
		resultadosTorneos = new JMenuItem("Resultados torneos");
		topGamers = new JMenuItem("Top Gamers"); 
		gestionarCuenta.add(actualizarCuenta);
		gestionarTorneos.add(consultarTorneos);
		gestionarTorneos.add(resultadosTorneos);
		estadisticas.add(topGamers);
		setJMenuBar(menuBar);
		cardGamer = new CardGamer();
		add(cardGamer);
		setVisible(true);
	}


}
