package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Torneo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String juego;
	private Date fechaInicio;
	private Date fechaFin;
	private String formato;
	private int maxEquipos;
	private long premio;
	private ArrayList<Equipo> listaEquiposInscritos;

	public Torneo() {
		// TODO Auto-generated constructor stub
	}
	public Torneo(String nombre, String juego, Date fechaInicio, Date fechaFin, String formato, int maxEquipos,
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

	
	public Torneo(String nombre, String juego, Date fechaInicio, Date fechaFin, String formato, int maxEquipos,
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getJuego() {
		return juego;
	}
	public void setJuego(String juego) {
		this.juego = juego;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public int getMaxEquipos() {
		return maxEquipos;
	}
	public void setMaxEquipos(int maxEquipos) {
		this.maxEquipos = maxEquipos;
	}
	public long getPremio() {
		return premio;
	}
	public void setPremio(long premio) {
		this.premio = premio;
	}
	public ArrayList<Equipo> getListaEquiposInscritos() {
		return listaEquiposInscritos;
	}
	public void setListaEquiposInscritos(ArrayList<Equipo> listaEquiposInscritos) {
		this.listaEquiposInscritos = listaEquiposInscritos;
	}
	public void inscribirEquipo(Equipo equipo, String mensaje) {
	    if (listaEquiposInscritos.size() < maxEquipos) {
	        listaEquiposInscritos.add(equipo);
	    } else {
	        throw new IllegalStateException(mensaje+ "(" + maxEquipos + ")!");
	    }
	}
	@Override
	public String toString() {
		return  nombre + ";" + juego + ";" + fechaInicio + ";"+ fechaFin + ";" + formato + ";" + maxEquipos + ";"+ premio+ ";" + "Equipos " + listaEquiposInscritos.size()  +"\n";
	}
	
	
}
