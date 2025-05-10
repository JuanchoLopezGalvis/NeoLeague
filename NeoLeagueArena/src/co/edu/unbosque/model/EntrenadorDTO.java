package co.edu.unbosque.model;

import java.io.Serializable;

public class EntrenadorDTO extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String trayectoriaProfesional;
	
	private String especialidadDeEntreno;
	
	private int AnosDeEntrenamiento;
	
	public EntrenadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public EntrenadorDTO(String trayectoriaProfesional, String especialidadDeEntreno, int anosDeEntrenamiento) {
		super();
		this.trayectoriaProfesional = trayectoriaProfesional;
		this.especialidadDeEntreno = especialidadDeEntreno;
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}
	public EntrenadorDTO(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String trayectoriaProfesional, String especialidadDeEntreno, int anosDeEntrenamiento) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.trayectoriaProfesional = trayectoriaProfesional;
		this.especialidadDeEntreno = especialidadDeEntreno;
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}

	public EntrenadorDTO(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}

	public String getTrayectoriaProfesional() {
		return trayectoriaProfesional;
	}

	public void setTrayectoriaProfesional(String trayectoriaProfesional) {
		this.trayectoriaProfesional = trayectoriaProfesional;
	}

	public String getEspecialidadDeEntreno() {
		return especialidadDeEntreno;
	}

	public void setEspecialidadDeEntreno(String especialidadDeEntreno) {
		this.especialidadDeEntreno = especialidadDeEntreno;
	}

	public int getAnosDeEntrenamiento() {
		return AnosDeEntrenamiento;
	}

	public void setAnosDeEntrenamiento(int anosDeEntrenamiento) {
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}

	@Override
	public String toString() {
		return super.toString()+  trayectoriaProfesional + ";" + especialidadDeEntreno + ";" + AnosDeEntrenamiento + "\n";
	}
	
	
}