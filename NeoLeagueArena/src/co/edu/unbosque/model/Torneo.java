package co.edu.unbosque.model;

import java.util.Date;

public class Torneo {

	private String nombre;
	private String juego;
	private Date fechaInicio;
	private Date fechaFin;
	private String formato;
	private int maxEquipos;

	public Torneo() {
		// TODO Auto-generated constructor stub
	}

	public Torneo(String nombre, String juego, Date fechaInicio, Date fechaFin, String formato, int maxEquipos) {
		this.nombre = nombre;
		this.juego = juego;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.formato = formato;
		this.maxEquipos = maxEquipos;
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

	@Override
	public String toString() {
		return ";" + nombre + ";" + juego + ";" + fechaInicio + ";"+ fechaFin + ";" + formato + ";" + maxEquipos + "\n";
	}
	
	
}
