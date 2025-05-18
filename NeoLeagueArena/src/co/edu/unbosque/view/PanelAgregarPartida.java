package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import de.wannawork.jcalendar.JCalendarComboBox;

public class PanelAgregarPartida extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> equipo1;
	private JComboBox<String> equipo2;
	private JComboBox<String> datoJuego;
	private JCalendarComboBox fechaPartida;
	private BotonRedondeado btnAgregarPartida;
	private JComboBox<String> ganador;
	private JComboBox<String>torneosExistentes;

	/**
	 * Esta instancia es la encargada de guardar el fondo del panel.
	 */
	private Image fondo;



	public PanelAgregarPartida() {
		setSize(1280,720);
		setLayout(null);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondoAPartida.png")).getImage();
		equipo1 = new JComboBox<>();
		equipo2 = new JComboBox<>();
		String[] juegos = {"FIFA", "Rocket League", "Formula 1", "Gran Turismo"};
		datoJuego = new JComboBox<>(juegos);
		fechaPartida = new JCalendarComboBox();
		torneosExistentes = new JComboBox<>();
		btnAgregarPartida = new BotonRedondeado("Agregar Partida", 20, java.awt.Color.decode("#002d69"), java.awt.Color.black, java.awt.Color.WHITE, java.awt.Color.white, 1f);
		ganador = new JComboBox<>();
		torneosExistentes.setToolTipText("Torneos Existentes");
		equipo1.setToolTipText("Team 1");
		equipo2.setToolTipText("Team 2");
		datoJuego.setToolTipText("Game");
		ganador.setToolTipText("Winner");
		equipo1.setBackground(Color.white);
		equipo2.setBackground(Color.white);
		ganador.setBackground(Color.gray);
		ganador.setForeground(Color.white);
		datoJuego.setBackground(Color.white);

		equipo1.setBounds(180, 160, 250, 30);
		torneosExistentes.setBounds(10, 80, 130, 30);
		equipo2.setBounds(850, 160, 250, 30);
		datoJuego.setBounds(10, 45, 130, 30);
		fechaPartida.setBounds(10, 10, 130, 30);
		btnAgregarPartida.setBounds(490, 500, 250, 30);
		ganador.setBounds(490, 430, 250, 30);



		add(equipo1);
		add(equipo2);
		add(datoJuego);
		add(fechaPartida);
		add(btnAgregarPartida);
		add(ganador);
		add(torneosExistentes);
		



	}
	/**
	 * Este metodo se encarga de pintar el panel con el fondo.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (fondo != null) {
			g.drawImage(fondo, 0, 0, 1269, 660, this);
		} else {

		}
	}
	public JComboBox<String> getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(JComboBox<String> equipo1) {
		this.equipo1 = equipo1;
	}
	public JComboBox<String> getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(JComboBox<String> equipo2) {
		this.equipo2 = equipo2;
	}
	public JComboBox<String> getDatoJuego() {
		return datoJuego;
	}
	public void setDatoJuego(JComboBox<String> datoJuego) {
		this.datoJuego = datoJuego;
	}
	public JCalendarComboBox getFechaPartida() {
		return fechaPartida;
	}
	public void setFechaPartida(JCalendarComboBox fechaPartida) {
		this.fechaPartida = fechaPartida;
	}
	public BotonRedondeado getBtnAgregarPartida() {
		return btnAgregarPartida;
	}
	public void setBtnAgregarPartida(BotonRedondeado btnAgregarPartida) {
		this.btnAgregarPartida = btnAgregarPartida;
	}
	public JComboBox<String> getGanador() {
		return ganador;
	}
	public void setGanador(JComboBox<String> ganador) {
		this.ganador = ganador;
	}
	public JComboBox<String> getTorneosExistentes() {
		return torneosExistentes;
	}
	public void setTorneosExistentes(JComboBox<String> torneosExistentes) {
		this.torneosExistentes = torneosExistentes;
	}
	public Image getFondo() {
		return fondo;
	}
	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
