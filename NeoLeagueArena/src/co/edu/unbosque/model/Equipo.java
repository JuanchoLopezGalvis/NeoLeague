package co.edu.unbosque.model;

import java.io.Serializable;

public class Equipo implements Serializable{
	
	private int cantidadIntegrantes;
	
	private String juego;
	
	private String nombre;
	
	private int numTrofeos;

	public Equipo() {
		// TODO Auto-generated constructor stub
	}
	
	public Equipo(int cantidadIntegrantes, String juego, String nombre, int numTrofeos) {
		super();
		this.cantidadIntegrantes = cantidadIntegrantes;
		this.juego = juego;
		this.nombre = nombre;
		this.numTrofeos = numTrofeos;
	}

	public int getCantidadIntegrantes() {
		return cantidadIntegrantes;
	}

	public void setCantidadIntegrantes(int cantidadIntegrantes) {
		this.cantidadIntegrantes = cantidadIntegrantes;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumTrofeos() {
		return numTrofeos;
	}

	public void setNumTrofeos(int numTrofeos) {
		this.numTrofeos = numTrofeos;
	}

	@Override
	public String toString() {
		return "Equipo [cantidadIntegrantes=" + cantidadIntegrantes + ", juego=" + juego + ", nombre=" + nombre
				+ ", numTrofeos=" + numTrofeos + "]";
	}
	
	

}
