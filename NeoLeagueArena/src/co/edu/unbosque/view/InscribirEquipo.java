package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class InscribirEquipo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> equipos;
	private BotonRedondeado btnInscribir;
	
	public InscribirEquipo() {
		setSize(300, 200);
		setTitle("Inscribir Equipo");
		setLocationRelativeTo(null);
		setLayout(null);
		equipos = new JComboBox<>();
		btnInscribir = new BotonRedondeado("Inscribir", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		equipos.setBounds(40, 50, 200, 30);
		btnInscribir.setBounds(40, 100, 200, 30);
		equipos.setToolTipText("Teams");;
		add(equipos);
		add(btnInscribir);
	}
	
	public JComboBox<String> getEquipos() {
		return equipos;
	}

	public void setEquipos(JComboBox<String> equipos) {
		this.equipos = equipos;
	}

	public BotonRedondeado getBtnInscribir() {
		return btnInscribir;
	}

	public void setBtnInscribir(BotonRedondeado btnInscribir) {
		this.btnInscribir = btnInscribir;
	}


}
