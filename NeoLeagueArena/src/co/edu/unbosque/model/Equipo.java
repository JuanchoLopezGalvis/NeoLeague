package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Jugador> integrantes;
	private String juegoDesempeñado;
	private ArrayList<Torneo> torneosInscritos;
	private ArrayList<Partida> partidasJugadas;

	public Equipo() {
	}


	public Equipo(String nombre, ArrayList<Jugador> integrantes, String juegoDesempeñado,
			ArrayList<Torneo> torneosInscritos, ArrayList<Partida> partidasJugadas) {
		super();
		this.nombre = nombre;
		this.integrantes = integrantes;
		this.juegoDesempeñado = juegoDesempeñado;
		this.torneosInscritos = torneosInscritos;
		this.partidasJugadas = partidasJugadas;
	}


	public Equipo(String nombre, String juegoDesempeñado) {
		super();
		this.nombre = nombre;
		this.juegoDesempeñado = juegoDesempeñado;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Jugador> integrantes) {
		this.integrantes = integrantes;
	}


	public String getJuegoDesempeñado() {
		return juegoDesempeñado;
	}

	public void setJuegoDesempeñado(String juegoDesempeñado) {
		this.juegoDesempeñado = juegoDesempeñado;
	}

	public ArrayList<Torneo> getTorneosInscritos() {
		return torneosInscritos;
	}

	public void setTorneosInscritos(ArrayList<Torneo> torneosInscritos) {
		this.torneosInscritos = torneosInscritos;
	}

	public ArrayList<Partida> getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(ArrayList<Partida> partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}
	public void inscribirJugador(Jugador jugador, String mensaje) {
	    if (integrantes.size() < 10) {
	        integrantes.add(jugador);
	    } else {
	        throw new IllegalStateException(mensaje+ "(10)!");
	    }
	}
	public void inscribirTorneo(Torneo torneo, String mensaje) {
	    if (torneosInscritos.size() < 10) {
	        torneosInscritos.add(torneo);
	    } else {
	        throw new IllegalStateException(mensaje+ "(10)!");
	    }
	}
	public void registrarPartida(Partida partida, String mensaje) {
			partidasJugadas.add(partida);
	}
	@Override
	public String toString() {
		return nombre + ";" + "# Gamers" + integrantes.size() + ";" + juegoDesempeñado
				+ ";" + "# Torneos" + torneosInscritos.size() + ";" + "# Matches played" + partidasJugadas + "\n";
	}
	

}
