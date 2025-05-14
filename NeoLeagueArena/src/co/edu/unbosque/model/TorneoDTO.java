package co.edu.unbosque.model;

import java.util.Date;

public class TorneoDTO {

	private String nombre;
	private String juego;
	private Date fechaInicio;
	private Date fechaFin;
	private String formato;
	private int maxEquipos;
	private long premio;

	public TorneoDTO() {
		// TODO Auto-generated constructor stub
	}



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



	@Override
	public String toString() {
		return ";" + nombre + ";" + juego + ";" + fechaInicio + ";"+ fechaFin + ";" + formato + ";" + maxEquipos + "\n"+ premio+"\n";
	}
	
	
}
