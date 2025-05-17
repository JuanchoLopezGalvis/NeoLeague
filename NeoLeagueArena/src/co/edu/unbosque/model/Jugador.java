package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase {@link Jugador} es la encargada de establecer los atributos de un
 * jugador. Esta clase hereda de la clase {@link Usuario}.
 */
public class Jugador extends Usuario implements Serializable{
	
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
	 * Constructor por defecto o vacio de la clase {@link Jugador}.
	 */
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de la clase {@link Jugador} que recibe como parámetro la
	 * trayectoria competitiva, el juego de especialidad y los años de experiencia.
	 * 
	 * @param trayectoriaCompetitiva
	 * @param juegoEspecialidad
	 * @param anosDeExperiencia
	 */
	public Jugador(String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super();
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}
	/**
	 * Constructor de la clase {@link Jugador} que recibe como parámetro el nombre,
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
	public Jugador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}
	/**
	 * Constructor de la clase {@link Jugador} que recibe como parámetro el nombre,
	 * la contraseña, el correo, la edad, el país y la url de la foto.
	 * 
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 */
	public Jugador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que retorna la trayectoria competitiva de los jugadores.
	 * 
	 * @return trayectoriaCompetitiva
	 */
	public String getTrayectoriaCompetitiva() {
		return trayectoriaCompetitiva;
	}
	/**
	 * Metodo que establece la trayectoria competitiva de los jugadores.
	 * 
	 * @param trayectoriaCompetitiva
	 */
	public void setTrayectoriaCompetitiva(String trayectoriaCompetitiva) {
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
	}
	/**
	 * Metodo que retorna el juego de especialidad de los jugadores.
	 * 
	 * @return juegoEspecialidad
	 */
	public String getJuegoEspecialidad() {
		return juegoEspecialidad;
	}
	/**
	 * Metodo que establece el juego de especialidad de los jugadores.
	 * 
	 * @param juegoEspecialidad
	 */
	public void setJuegoEspecialidad(String juegoEspecialidad) {
		this.juegoEspecialidad = juegoEspecialidad;
	}
	/**
	 * Metodo que retorna los años de experiencia de los jugadores.
	 * 
	 * @return anosDeExperiencia
	 */
	public int getAnosDeExperiencia() {
		return anosDeExperiencia;
	}
	/**
	 * Metodo que establece los años de experiencia de los jugadores.
	 * 
	 * @param anosDeExperiencia
	 */
	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}
	/**
	 * Metodo que retorna una cadena de texto con los atributos de la clase
	 * {@link Jugador}.
	 * 
	 * @return cadena de texto con los atributos de la clase {@link Jugador}
	 */
	@Override
	public String toString() {
		return super.toString()+ trayectoriaCompetitiva + ";" + juegoEspecialidad + ";" + anosDeExperiencia + "\n";
	}
}
