package co.edu.unbosque.model;


public class Jugador extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String trayectoriaCompetitiva;
	
	private String juegoEspecialidad;
	
	private int anosDeExperiencia;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super();
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public Jugador(String nombre, String contrasena, String correo, int edad, String especialidad, String pais,
			String urlFoto, String trayectoriaCompetitiva, String juegoEspecialidad, int anosDeExperiencia) {
		super(nombre, contrasena, correo, edad, especialidad, pais, urlFoto);
		this.trayectoriaCompetitiva = trayectoriaCompetitiva;
		this.juegoEspecialidad = juegoEspecialidad;
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public Jugador(String nombre, String contrasena, String correo, int edad, String especialidad, String pais,
			String urlFoto) {
		super(nombre, contrasena, correo, edad, especialidad, pais, urlFoto);
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
		return super.toString()+ " Jugador [trayectoriaCompetitiva=" + trayectoriaCompetitiva + ", juegoEspecialidad=" + juegoEspecialidad
				+ ", anosDeExperiencia=" + anosDeExperiencia + "]";
	}
	
	

}
