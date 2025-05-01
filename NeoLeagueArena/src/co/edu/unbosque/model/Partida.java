package co.edu.unbosque.model;

public class Partida {

	private int duracionMinTotal;
	
	private int duracionSetMin;
	
	private String juego;
	
	private int numParticipantes;
	
	private int set;

	public Partida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partida(int duracionMinTotal, int duracionSetMin, String juego, int numParticipantes, int set) {
		super();
		this.duracionMinTotal = duracionMinTotal;
		this.duracionSetMin = duracionSetMin;
		this.juego = juego;
		this.numParticipantes = numParticipantes;
		this.set = set;
	}

	public int getDuracionMinTotal() {
		return duracionMinTotal;
	}

	public void setDuracionMinTotal(int duracionMinTotal) {
		this.duracionMinTotal = duracionMinTotal;
	}

	public int getDuracionSetMin() {
		return duracionSetMin;
	}

	public void setDuracionSetMin(int duracionSetMin) {
		this.duracionSetMin = duracionSetMin;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Partida [duracionMinTotal=" + duracionMinTotal + ", duracionSetMin=" + duracionSetMin + ", juego="
				+ juego + ", numParticipantes=" + numParticipantes + ", set=" + set + "]";
	}
	
	
	
}
