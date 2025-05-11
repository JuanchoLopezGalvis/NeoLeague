package co.edu.unbosque.model;

import java.io.Serializable;

public class TorneoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String formato;
	
	private int numEquipos;
	
	private int numRondas;
	
	public TorneoDTO() {
		// TODO Auto-generated constructor stub
	}

	public TorneoDTO(String formato, int numEquipos, int numRondas) {
		super();
		this.formato = formato;
		this.numEquipos = numEquipos;
		this.numRondas = numRondas;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getNumEquipos() {
		return numEquipos;
	}

	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}

	public int getNumRondas() {
		return numRondas;
	}

	public void setNumRondas(int numRondas) {
		this.numRondas = numRondas;
	}

	@Override
	public String toString() {
		return "Torneo [formato=" + formato + ", numEquipos=" + numEquipos + ", numRondas=" + numRondas + "]";
	}
	
	
	
}
