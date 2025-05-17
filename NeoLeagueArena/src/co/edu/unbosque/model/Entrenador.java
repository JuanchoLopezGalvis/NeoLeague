package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * La clase {@link Entrenador} es la encargada de establecer los atributos de
 * un entrenador. Esta clase hereda de la clase {@link Usuario}.
 */
public class Entrenador extends Usuario implements Serializable{
	
	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar la trayectoria profesional de los entrenadores. 
	 */
	private String trayectoriaProfesional;
	/**
	 * Esta instancia es la encargada de guardar la especialidad de entreno de los entrenadores.
	 */
	private String especialidadDeEntreno;
	/**
	 * Esta instancia es la encargada de guardar los años de entrenamiento de los entrenadores.
	 */
	private int AnosDeEntrenamiento;
	/**
	 * Constructor por defecto o vacio de la clase {@link Entrenador}.
	 */
	public Entrenador() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de la clase {@link Entrenador} que recibe como parámetro la
	 * trayectoria profesional, la especialidad de entreno y los años de
	 * entrenamiento.
	 * 
	 * @param trayectoriaProfesional
	 * @param especialidadDeEntreno
	 * @param anosDeEntrenamiento
	 */
	public Entrenador(String trayectoriaProfesional, String especialidadDeEntreno, int anosDeEntrenamiento) {
		super();
		this.trayectoriaProfesional = trayectoriaProfesional;
		this.especialidadDeEntreno = especialidadDeEntreno;
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}
	/**
	 * Constructor de la clase {@link Entrenador} que recibe como parámetro el
	 * nombre, la contraseña, el correo, la edad, el país, la url de la foto, la
	 * trayectoria profesional, la especialidad de entreno y los años de
	 * entrenamiento.
	 * 
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 * @param trayectoriaProfesional
	 * @param especialidadDeEntreno
	 * @param anosDeEntrenamiento
	 */
	public Entrenador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String trayectoriaProfesional, String especialidadDeEntreno, int anosDeEntrenamiento) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.trayectoriaProfesional = trayectoriaProfesional;
		this.especialidadDeEntreno = especialidadDeEntreno;
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}
	/**
	 * Constructor de la clase {@link Entrenador} que recibe como parámetro el
	 * nombre, la contraseña, el correo, la edad, el país y la url de la foto del
	 * entrenador.
	 * 
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 */
	public Entrenador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Método que retorna la trayectoria profesional del entrenador.
	 * 
	 * @return trayectoriaProfesional
	 */
	public String getTrayectoriaProfesional() {
		return trayectoriaProfesional;
	}
	/**
	 * Método que establece la trayectoria profesional del entrenador.
	 * 
	 * @param trayectoriaProfesional
	 */
	public void setTrayectoriaProfesional(String trayectoriaProfesional) {
		this.trayectoriaProfesional = trayectoriaProfesional;
	}
	/**
	 * Método que retorna la especialidad de entreno del entrenador.
	 * 
	 * @return especialidadDeEntreno
	 */
	public String getEspecialidadDeEntreno() {
		return especialidadDeEntreno;
	}
	/**
	 * Método que establece la especialidad de entreno del entrenador.
	 * 
	 * @param especialidadDeEntreno
	 */
	public void setEspecialidadDeEntreno(String especialidadDeEntreno) {
		this.especialidadDeEntreno = especialidadDeEntreno;
	}
	/**
	 * Método que retorna los años de entrenamiento del entrenador.
	 * 
	 * @return anosDeEntrenamiento
	 */
	public int getAnosDeEntrenamiento() {
		return AnosDeEntrenamiento;
	}
	/**
	 * Método que establece los años de entrenamiento del entrenador.
	 * 
	 * @param anosDeEntrenamiento
	 */
	public void setAnosDeEntrenamiento(int anosDeEntrenamiento) {
		AnosDeEntrenamiento = anosDeEntrenamiento;
	}
	/**
	 * Método que retorna una cadena de texto con la información del entrenador.
	 * 
	 * @return cadena de texto con la información del entrenador
	 */
	@Override
	public String toString() {
		return super.toString()+ trayectoriaProfesional + ";" + especialidadDeEntreno + ";" + AnosDeEntrenamiento + "\n";
	}
}