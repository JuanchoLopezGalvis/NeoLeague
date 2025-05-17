package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * La clase {@link TorneoDTO} es la encargada de establecer los atributos de un
 * torneo. Esta clase es un DTO (Data Transfer Object) que se utiliza para
 * transferir datos entre diferentes capas de la aplicación.
 */
public class TorneoDTO implements Serializable{

	/**
	 * La serialVersionUID es un identificador único que se utiliza en la
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el nombre del torneo.
	 */
	private String nombre;
	/**
	 * Esta instancia es la encargada de guardar el juego del torneo.
	 */
	private String juego;
	/**
	 * Esta instancia es la encargada de guardar la fecha de inicio del torneo.
	 */
	private Date fechaInicio;
	/**
	 * Esta instancia es la encargada de guardar la fecha de fin del torneo.
	 */
	private Date fechaFin;
	/**
	 * Esta instancia es la encargada de guardar el formato del torneo.
	 */
	private String formato;
	/**
	 * Esta instancia es la encargada de guardar el maximo de equipos del torneo.
	 */
	private int maxEquipos;
	/**
	 * Esta instancia es la encargada de guardar el premio del torneo.
	 */
	private long premio;
	/**
	 * Esta instancia es la encargada de guardar la lista de equipos inscritos en el
	 * torneo.
	 */
	private ArrayList<Equipo> listaEquiposInscritos;
	/**
	 * Constructor por defecto o vacio de la clase {@link TorneoDTO}.
	 */
	public TorneoDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de la clase {@link TorneoDTO} que recibe como parámetro el nombre, el
	 * juego, la fecha de inicio, la fecha de fin, el formato, el maximo de equipos y
	 * el premio.
	 * 
	 * @param nombre
	 * @param juego
	 * @param fechaInicio
	 * @param fechaFin
	 * @param formato
	 * @param maxEquipos
	 * @param premio
	 */
	public TorneoDTO(String nombre, String juego, Date fechaInicio, Date fechaFin, String formato, int maxEquipos,
			long premio) {
		super();
		this.nombre = nombre;
		this.juego = juego;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.formato = formato;
		this.maxEquipos = maxEquipos;
		this.premio = premio;
	}
	/**
	 * Constructor de la clase {@link TorneoDTO} que recibe como parámetro el nombre, el
	 * juego, la fecha de inicio, la fecha de fin, el formato, el maximo de equipos y
	 * el premio.
	 * 
	 * @param nombre
	 * @param juego
	 * @param fechaInicio
	 * @param fechaFin
	 * @param formato
	 * @param maxEquipos
	 * @param premio
	 * @param listaEquiposInscritos
	 */
	public TorneoDTO(String nombre, String juego, Date fechaInicio, Date fechaFin, String formato, int maxEquipos,
			long premio, ArrayList<Equipo> listaEquiposInscritos) {
		super();
		this.nombre = nombre;
		this.juego = juego;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.formato = formato;
		this.maxEquipos = maxEquipos;
		this.premio = premio;
		this.listaEquiposInscritos = listaEquiposInscritos;
	}
	/**
	 * Metodo que retorna el nombre del torneo.
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que establece el nombre del torneo.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que retorna el juego del torneo.
	 * @return juego
	 */
	public String getJuego() {
		return juego;
	}
	/**
	 * Metodo que establece el juego del torneo.
	 * @param juego
	 */
	public void setJuego(String juego) {
		this.juego = juego;
	}
	/**
	 * Metodo que retorna la fecha de inicio del torneo.
	 * @return fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * Metodo que establece la fecha de inicio del torneo.
	 * @param fechaInicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * Metodo que retorna la fecha de fin del torneo.
	 * @return fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * Metodo que establece la fecha de fin del torneo.
	 * @param fechaFin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * Metodo que retorna el formato del torneo.
	 * @return formato
	 */
	public String getFormato() {
		return formato;
	}
	/**
	 * Metodo que establece el formato del torneo.
	 * @param formato
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}
	/**
	 * Metodo que retorna el maximo de equipos del torneo.
	 * @return maxEquipos
	 */
	public int getMaxEquipos() {
		return maxEquipos;
	}
	/**
	 * Metodo que establece el maximo de equipos del torneo.
	 * @param maxEquipos
	 */
	public void setMaxEquipos(int maxEquipos) {
		this.maxEquipos = maxEquipos;
	}
	/**
	 * Metodo que retorna el premio del torneo.
	 * @return premio
	 */
	public long getPremio() {
		return premio;
	}
	/**
	 * Metodo que establece el premio del torneo.
	 * @param premio
	 */
	public void setPremio(long premio) {
		this.premio = premio;
	}
	/**
	 * Metodo que retorna la lista de equipos inscritos en el torneo.
	 * @return listaEquiposInscritos
	 */
	public ArrayList<Equipo> getListaEquiposInscritos() {
		return listaEquiposInscritos;
	}
	/**
	 * Metodo que establece la lista de equipos inscritos en el torneo.
	 * @param listaEquiposInscritos
	 */
	public void setListaEquiposInscritos(ArrayList<Equipo> listaEquiposInscritos) {
		this.listaEquiposInscritos = listaEquiposInscritos;
	}
	/**
	 * Metodo que inscribe un equipo en el torneo.
	 * @param equipo
	 * @param mensaje
	 */
	public void inscribirEquipo(Equipo equipo, String mensaje) {
	    if (listaEquiposInscritos.size() < maxEquipos) {
	        listaEquiposInscritos.add(equipo);
	    } else {
	        throw new IllegalStateException(mensaje+ "(" + maxEquipos + ")!");
	    }
	}
	/**
	 * Metodo que retorna una cadena de texto con la información del torneo.
	 * @return cadena de texto con la información del torneo
	 */
	@Override
	public String toString() {
		return  nombre + ";" + juego + ";" + fechaInicio + ";"+ fechaFin + ";" + formato + ";" + maxEquipos + ";"+ premio+ ";" + "Equipos " + listaEquiposInscritos.size()  +"\n";
	}
}