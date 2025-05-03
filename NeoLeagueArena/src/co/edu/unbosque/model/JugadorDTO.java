package co.edu.unbosque.model;

import java.io.Serializable;

public class JugadorDTO extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String trayectoriaCompetitiva;
	
	private String juegoEspecialidad;
	
	private int anosDeExperiencia;
	
	public JugadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public JugadorDTO(String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super();
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public JugadorDTO(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public JugadorDTO(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}

	public String getTrayectoriaCompetitiva() {
		return trayectoriaCompetitiva;
	}

	public void setTrayectoriaCompetitiva(String trayectoriaCompetitiva) {
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
	}

	public String getJuegoEspecialidad() {
		return juegoEspecialidad;
	}

	public void setJuegoEspecialidad(String juegoEspecialidad) {
		this.juegoEspecialidad = juegoEspecialidad;
	}

	public int getAnosDeExperiencia() {
		return anosDeExperiencia;
	}

	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}

	@Override
	public String toString() {
		return super.toString() + trayectoriaCompetitiva + ";" + juegoEspecialidad + ";" + anosDeExperiencia + "\n";
	}
	
	

}
