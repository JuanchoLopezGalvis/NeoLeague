package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;
/**
 * Esta clase representa un panel que utiliza un CardLayout para mostrar diferentes
 * paneles en función de la selección del usuario. Permite cambiar entre diferentes
 * vistas de la interfaz de usuario.
 */
public class CardSignUp extends JPanel{
	
	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * cardLayout es una instancia de CardLayout que permite cambiar entre diferentes paneles.
	 */
	private CardLayout cardLayout;
	/**
	 * crearAdmin es una instancia de CrearAdmin que permite crear un nuevo administrador.
	 */
	private CrearAdmin crearAdmin;
	/**
	 * crearCoach es una instancia de CrearCoach que permite crear un nuevo entrenador.
	 */
	private CrearCoach crearCoach;
	/**
	 * crearGamer es una instancia de CrearGamer que permite crear un nuevo jugador.
	 */
	private CrearGamer crearGamer;
	/**
	 * Constructor de la clase {@link CardSignUp}.
	 * Inicializa el CardLayout y agrega los diferentes paneles al contenedor.
	 */
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
	/**
	 * Este método permite establecer el panel de creación de administrador.
	 * @param crearAdmin El panel de creación de administrador a establecer.
	 */
	public CrearAdmin getCrearAdmin() {
		return crearAdmin;
	}
	/**
	 * Este método permite obtener el panel de creación de administrador.
	 * @return El panel de creación de administrador.
	 */
	public void setCrearAdmin(CrearAdmin crearAdmin) {
		this.crearAdmin = crearAdmin;
	}
	/**
	 * Este método permite establecer el panel de creación de entrenador.
	 * @param crearCoach El panel de creación de entrenador a establecer.
	 */
	public CrearCoach getCrearCoach() {
		return crearCoach;
	}
	/**
	 * Este método permite obtener el panel de creación de entrenador.
	 * @return El panel de creación de entrenador.
	 */
	public void setCrearCoach(CrearCoach crearCoach) {
		this.crearCoach = crearCoach;
	}
	/**
	 * Este método permite establecer el panel de creación de jugador.
	 * @param crearGamer El panel de creación de jugador a establecer.
	 */
	public CrearGamer getCrearGamer() {
		return crearGamer;
	}
	/**
	 * Este método permite obtener el panel de creación de jugador.
	 * @return El panel de creación de jugador.
	 */
	public void setCrearGamer(CrearGamer crearGamer) {
		this.crearGamer = crearGamer;
	}
}
