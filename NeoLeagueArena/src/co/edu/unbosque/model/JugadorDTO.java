package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase {@link JugadorDTO} es la encargada de establecer los atributos de un
 * jugador. Esta clase hereda de la clase {@link Usuario}. Esta clase es un DTO (Data Transfer Object) que se utiliza para
 * transferir datos entre diferentes capas de la aplicación.
 */
public class JugadorDTO extends Usuario implements Serializable{

	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar la trayectoria competitiva de los
	 * jugadores.
	 */
	private String trayectoriaCompetitiva;
	/**
	 * Esta instancia es la encargada de guardar el juego de especialidad de los
	 * jugadores.
	 */
	private String juegoEspecialidad;
	/**
	 * Esta instancia es la encargada de guardar los años de experiencia de los
	 * jugadores.
	 */
	private int anosDeExperiencia;
	/**
	 * Constructor por defecto o vacio de la clase {@link JugadorDTO}.
	 */
	public JugadorDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de la clase {@link JugadorDTO} que recibe como parámetro la
	 * trayectoria competitiva, el juego de especialidad y los años de experiencia.
	 *
	 * @param trayectoriaCompetitiva
	 * @param juegoEspecialidad
	 * @param anosDeExperiencia
	 */
	public JugadorDTO(String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super();
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}
	/**
	 * Constructor de la clase {@link JugadorDTO} que recibe como parámetro el nombre,
	 * la contraseña, el correo, la edad, el país, la url de la foto, la trayectoria
	 * competitiva, el juego de especialidad y los años de experiencia.
	 *
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 * @param trayectoriaCompetitiva
	 * @param juegoEspecialidad
	 * @param anosDeExperiencia
	 */
	public JugadorDTO(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}
	/**
	 * Constructor de la clase {@link JugadorDTO} que recibe como parámetro el nombre,
	 * la contraseña, el correo, la edad, el país, la url de la foto.
	 *
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 */
	public JugadorDTO(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que retorna la trayectoria competitiva del jugador.
	 * @return trayectoriaCompetitiva
	 */
	public String getTrayectoriaCompetitiva() {
		return trayectoriaCompetitiva;
	}
	/**
	 * Metodo que establece la trayectoria competitiva del jugador.
	 * @param trayectoriaCompetitiva
	 */
	public void setTrayectoriaCompetitiva(String trayectoriaCompetitiva) {
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
	}
	/**
	 * Metodo que retorna el juego de especialidad del jugador.
	 * @return juegoEspecialidad
	 */
	public String getJuegoEspecialidad() {
		return juegoEspecialidad;
	}
	/**
	 * Metodo que establece el juego de especialidad del jugador.
	 * @param juegoEspecialidad
	 */
	public void setJuegoEspecialidad(String juegoEspecialidad) {
		this.juegoEspecialidad = juegoEspecialidad;
	}
	/**
	 * Metodo que retorna los años de experiencia del jugador.
	 * @return anosDeExperiencia
	 */
	public int getAnosDeExperiencia() {
		return anosDeExperiencia;
	}
	/**
	 * Metodo que establece los años de experiencia del jugador.
	 * @param anosDeExperiencia
	 */
	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}
	/**
	 * Metodo que retorna la cadena de texto con los atributos del jugador.
	 * @return cadena de texto con los atributos del jugador.
	 */
	@Override
	public String toString() {
		return super.toString() + trayectoriaCompetitiva + ";" + juegoEspecialidad + ";" + anosDeExperiencia + "\n";
	}
}
