package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase {@link Administrador} es la encargada de establecer los atributos de un administrador.
 * Esta clase hereda de la clase {@link Usuario}.
 */
public class Administrador extends Usuario implements Serializable{
	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar el cargo específico del administrador.
	 */
	private String cargoEspecifico;

	/**
	 * Constructor por defecto o vacio de la clase {@link Administrador}.
	 */
	public Administrador() {
	}
	/**
	 * Constructor de la clase {@link Administrador} que recibe como parámetro el cargo específico del administrador.
	 * @param cargoEspecifico
	 */
	public Administrador(String cargoEspecifico) {
		super();
		this.cargoEspecifico = cargoEspecifico;
	}
	/**
	 * Constructor de la clase {@link Administrador} que recibe como parámetro el nombre, la contraseña, el correo, la edad, el país, la url de la foto y el cargo específico del administrador.
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 * @param cargoEspecifico
	 */
	public Administrador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String cargoEspecifico) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.cargoEspecifico = cargoEspecifico;
	}
	/**
	 * Constructor de la clase {@link Administrador} que recibe como parámetro el nombre, la contraseña, el correo, la edad, el país y la url de la foto del administrador.
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 */
	public Administrador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Método que retorna el cargo específico del administrador.
	 * @return cargoEspecifico
	 */
	public String getCargoEspecifico() {
		return cargoEspecifico;
	}
	/**
	 * Método que establece el cargo específico del administrador.
	 * @param cargoEspecifico
	 */
	public void setCargoEspecifico(String cargoEspecifico) {
		this.cargoEspecifico = cargoEspecifico;
	}
	/**
	 * Método que retorna una cadena de texto con la información del administrador.
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString() +  cargoEspecifico + "\n";
	}
}
