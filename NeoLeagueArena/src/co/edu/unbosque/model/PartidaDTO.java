package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@link PartidaDTO} es la encargada de establecer los atributos de una
 * partida. Esta clase es un DTO (Data Transfer Object) que se utiliza para
 * transferir datos entre diferentes capas de la aplicación.
 */
public class PartidaDTO implements Serializable{
	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el id de la partida.
	 */
	private int id;
	/**
	 * Esta instancia es la encargada de guardar el equipo 1 de la partida.
	 */
	private Equipo equipo1;
	/**
	 * Esta instancia es la encargada de guardar el equipo 2 de la partida.
	 */
	private Equipo equipo2;
	/**
	 * Esta instancia es la encargada de guardar el ganador de la partida.
	 */
	private Equipo ganador
	/**
	 * Esta instancia es la encargada de guardar el juego de la partida.
	 */;
	private String juego;
	/**
	 * Esta instancia es la encargada de guardar la fecha de la partida.
	 */
	private Date fecha;
	/**
	 * Esta instancia es la encargada de guardar el torneo al que pertenece la
	 * partida.
	 */
	private Torneo torneoAlQuePertenece;
	/**
	 * Constructor por defecto o vacio de la clase {@link PartidaDTO}.
	 */
	public PartidaDTO() {
	}
	/**
	 * Constructor de la clase {@link PartidaDTO} que recibe como parámetro el id, el
	 * equipo 1, el equipo 2, el ganador, el juego, la fecha y el torneo al que
	 * pertenece la partida.
	 *
	 * @param id
	 * @param equipo1
	 * @param equipo2
	 * @param ganador
	 * @param juego
	 * @param fecha
	 * @param torneoAlQuePertenece
	 */
	public PartidaDTO(int id, Equipo equipo1, Equipo equipo2, Equipo ganador, String juego, Date fecha,
			Torneo torneoAlQuePertenece) {
		super();
		this.id = id;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.ganador = ganador;
		this.juego = juego;
		this.fecha = fecha;
		this.torneoAlQuePertenece = torneoAlQuePertenece;
	}
	public PartidaDTO(int i, String string, String string2, String string3, String string4, Date date, String string5) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que retorna el id de la partida.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo que establece el id de la partida.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo que retorna el equipo 1 de la partida.
	 * @return equipo1
	 */
	public Equipo getEquipo1() {
		return equipo1;
	}
	/**
	 * Metodo que establece el equipo 1 de la partida.
	 * @param equipo1
	 */
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	/**
	 * Metodo que retorna el equipo 2 de la partida.
	 * @return equipo2
	 */
	public Equipo getEquipo2() {
		return equipo2;
	}
	/**
	 * Metodo que establece el equipo 2 de la partida.
	 * @param equipo2
	 */
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	/**
	 * Metodo que retorna el ganador de la partida.
	 * @return ganador
	 */
	public Equipo getGanador() {
		return ganador;
	}
	/**
	 * Metodo que establece el ganador de la partida.
	 * @param ganador
	 */
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	/**
	 * Metodo que retorna el juego de la partida.
	 * @return juego
	 */
	public String getJuego() {
		return juego;
	}
	/**
	 * Metodo que establece el juego de la partida.
	 * @param juego
	 */
	public void setJuego(String juego) {
		this.juego = juego;
	}
	/**
	 * Metodo que retorna la fecha de la partida.
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * Metodo que establece la fecha de la partida.
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * Metodo que retorna el torneo al que pertenece la partida.
	 * @return torneoAlQuePertenece
	 */
	public Torneo getTorneoAlQuePertenece() {
		return torneoAlQuePertenece;
	}
	/**
	 * Metodo que establece el torneo al que pertenece la partida.
	 * @param torneoAlQuePertenece
	 */
	public void setTorneoAlQuePertenece(Torneo torneoAlQuePertenece) {
		this.torneoAlQuePertenece = torneoAlQuePertenece;
	}
	/**
	 * Metodo que retorna una cadena de texto con los atributos de la partida.
	 * @return cadena de texto con los atributos de la partida
	 */
	@Override
	public String toString() {
		return "Partida [id=" + id + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", ganador=" + ganador
				+ ", juego=" + juego + ", fecha=" + fecha + "]";
	}
}