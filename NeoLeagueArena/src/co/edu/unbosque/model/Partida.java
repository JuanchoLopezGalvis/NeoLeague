package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class Partida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo ganador;
	private String juego;
	private Date fecha;
	
	public Partida() {
	}

	public Partida(int id, Equipo equipo1, Equipo equipo2, Equipo ganador, String juego, Date fecha) {
		super();
		this.id = id;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.ganador = ganador;
		this.juego = juego;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", ganador=" + ganador
				+ ", juego=" + juego + ", fecha=" + fecha + "]";
	}
	
	
	
}
