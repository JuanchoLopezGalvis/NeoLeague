package co.edu.unbosque.model;


public class Entrenador extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String trayectoriaProfesional;
	
	private String especialidadDeEntreno;
	
	private int AnosDeEntrenamiento;
	
	public Entrenador() {
		// TODO Auto-generated constructor stub
	}

	public Entrenador(String trayectoriaProfesional, String especialidadDeEntreno, int anosDeEntrenamiento) {
		super();
		this.trayectoriaProfesional = trayectoriaProfesional;
		this.especialidadDeEntreno = especialidadDeEntreno;
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}
	
	public Entrenador(String nombre, String contrasena, String correo, int edad, String especialidad, String pais,
			String urlFoto, String trayectoriaProfesional, String especialidadDeEntreno, int anosDeEntrenamiento) {
		super(nombre, contrasena, correo, edad, especialidad, pais, urlFoto);
		this.trayectoriaProfesional = trayectoriaProfesional;
		this.especialidadDeEntreno = especialidadDeEntreno;
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}

	public Entrenador(String nombre, String contrasena, String correo, int edad, String especialidad, String pais,
			String urlFoto) {
		super(nombre, contrasena, correo, edad, especialidad, pais, urlFoto);
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
		return super.toString()+  " Entrenador [trayectoriaProfesional=" + trayectoriaProfesional + ", especialidadDeEntreno="
				+ especialidadDeEntreno + ", AnosDeEntrenamiento=" + AnosDeEntrenamiento + "]";
	}
	
	
}