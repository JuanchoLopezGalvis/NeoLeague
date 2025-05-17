package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase {@link EquipoDTO} es la encargada de establecer los atributos de
 * un equipo. Esta clase es un DTO (Data Transfer Object) que se utiliza para
 * transferir datos entre diferentes capas de la aplicación.
 */
public class EquipoDTO implements Serializable{

	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el nombre del equipo.
	 */
	private String nombre;
	/**
	 * Esta instancia es la encargada de guardar los integrantes del equipo.
	 */
	private ArrayList<Jugador> integrantes;
	/**
	 * Esta instancia es la encargada de guardar el juego desempeñado por el equipo.
	 */
	private String juegoDesempeñado;
	/**
	 * Esta instancia es la encargada de guardar los torneos inscritos por el equipo.
	 */
	private ArrayList<Torneo> torneosInscritos;
	/**
	 * Esta instancia es la encargada de guardar las partidas jugadas por el equipo.
	 */
	private ArrayList<Partida> partidasJugadas;
	/**
	 * Constructor por defecto o vacio de la clase {@link EquipoDTO}.
	 */
	public EquipoDTO() {
	}
	/**
	 * Constructor de la clase {@link EquipoDTO} que recibe como parámetro el nombre, los integrantes, el juego desempeñado, los torneos inscritos y las partidas jugadas.
	 *
	 * @param nombre
	 * @param integrantes
	 * @param juegoDesempeñado
	 * @param torneosInscritos
	 * @param partidasJugadas
	 */
	public EquipoDTO(String nombre, ArrayList<Jugador> integrantes, String juegoDesempeñado,
			ArrayList<Torneo> torneosInscritos, ArrayList<Partida> partidasJugadas) {
		super();
		this.nombre = nombre;
		this.integrantes = integrantes;
		this.juegoDesempeñado = juegoDesempeñado;
		this.torneosInscritos = torneosInscritos;
		this.partidasJugadas = partidasJugadas;
	}
	/**
	 * Constructor de la clase {@link EquipoDTO} que recibe como parámetro el nombre y el juego desempeñado.
	 *
	 * @param nombre
	 * @param juegoDesempeñado
	 */
	public EquipoDTO(String nombre, String juegoDesempeñado) {
		super();
		this.nombre = nombre;
		this.juegoDesempeñado = juegoDesempeñado;
	}
	/**
	 * Metodo que retorna el nombre del equipo.
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que establece el nombre del equipo.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que retorna los integrantes del equipo.
	 * @return integrantes
	 */
	public ArrayList<Jugador> getIntegrantes() {
		return integrantes;
	}
	/**
	 * Metodo que establece los integrantes del equipo.
	 * @param integrantes
	 */
	public void setIntegrantes(ArrayList<Jugador> integrantes) {
		this.integrantes = integrantes;
	}
	/**
	 * Metodo que retorna el juego desempeñado por el equipo.
	 * @return juegoDesempeñado
	 */
	public String getJuegoDesempeñado() {
		return juegoDesempeñado;
	}
	/**
	 * Metodo que establece el juego desempeñado por el equipo.
	 * @param juegoDesempeñado
	 */
	public void setJuegoDesempeñado(String juegoDesempeñado) {
		this.juegoDesempeñado = juegoDesempeñado;
	}
	/**
	 * Metodo que retorna los torneos inscritos por el equipo.
	 * @return torneosInscritos
	 */
	public ArrayList<Torneo> getTorneosInscritos() {
		return torneosInscritos;
	}
	/**
	 * Metodo que establece los torneos inscritos por el equipo.
	 * @param torneosInscritos
	 */
	public void setTorneosInscritos(ArrayList<Torneo> torneosInscritos) {
		this.torneosInscritos = torneosInscritos;
	}
	/**
	 * Metodo que retorna las partidas jugadas por el equipo.
	 * @return partidasJugadas
	 */
	public ArrayList<Partida> getPartidasJugadas() {
		return partidasJugadas;
	}
	/**
	 * Metodo que establece las partidas jugadas por el equipo.
	 * @param partidasJugadas
	 */
	public void setPartidasJugadas(ArrayList<Partida> partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}
	/**
	 * Metodo que inscribe un jugador al equipo.
	 * @param jugador
	 * @param mensaje
	 */
	public void inscribirJugador(Jugador jugador, String mensaje) {
	    if (integrantes.size() < 10) {
	        integrantes.add(jugador);
	    } else {
	        throw new IllegalStateException(mensaje+ "(10)!");
	    }
	}
	/**
	 * Metodo que inscribe un torneo al equipo.
	 * @param torneo
	 * @param mensaje
	 */
	public void inscribirTorneo(Torneo torneo, String mensaje) {
	    if (torneosInscritos.size() < 10) {
	        torneosInscritos.add(torneo);
	    } else {
	        throw new IllegalStateException(mensaje+ "(10)!");
	    }
	}
	/**
	 * Metodo que registra una partida jugada por el equipo.
	 * @param partida
	 * @param mensaje
	 */
	public void registrarPartida(Partida partida, String mensaje) {
			partidasJugadas.add(partida);
	}
	/**
	 * Metodo que retorna una cadena de texto con la información del equipo.
	 * @return cadena de texto con la información del equipo
	 */
	@Override
	public String toString() {
		return nombre + ";" + "# Gamers" + integrantes.size() + ";" + juegoDesempeñado
				+ ";" + "# Torneos" + torneosInscritos.size() + ";" + "# Matches played" + partidasJugadas + "\n";
	}
}
