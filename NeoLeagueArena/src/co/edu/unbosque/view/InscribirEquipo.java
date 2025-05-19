package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Esta clase representa una ventana para inscribir un equipo en un torneo.
 * La ventana contiene un JComboBox para seleccionar el equipo a inscribir.
 * 
 * @author juan 
 */
public class InscribirEquipo extends JFrame {
	
	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 * Este valor se utiliza para verificar la compatibilidad entre la versión de la clase y la versión del objeto serializado.
	 * Si la versión de la clase ha cambiado, el proceso de deserialización puede fallar.
	 * En este caso, se ha asignado un valor único para la clase InscribirEquipo.
	 * Esto es importante para garantizar que la clase sea compatible con versiones anteriores y posteriores.
	 * Esto es especialmente útil cuando se realizan cambios en la clase, como agregar o eliminar campos.
	 * Esto ayuda a evitar problemas de compatibilidad al deserializar objetos.
	 * Es importante tener en cuenta que la serialVersionUID no es obligatoria, pero se recomienda utilizarla para evitar problemas de compatibilidad.

	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> equipos;
	private BotonRedondeado btnInscribir;
	
	/**
	 * Constructor de la clase {@link InscribirEquipo}.
	 * Inicializa la ventana y establece su tamaño, título y ubicación.
	 */
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
