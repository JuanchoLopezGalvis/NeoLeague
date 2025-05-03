package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *Este atributo es el encargado de guardar el nombre del usuario. 
	 */
	private String nombre;
	/**
	 * Este atributo es el encargado de guardar la contraseña del usuario.
	 */
	private String contrasena;
	/**
	 * Este atributo es el encargado de guardar el correo del usuario.
	 */
	private String correo;
	/**
	 * Este atributo es el encargado de guardar la edad del usuario.
	 */
	private int edad;
	
	/**
	 * Este atributo es el encargado de guardar el pais del usuario.
	 */
	private String pais;
	/**
	 * Este atributo es el encargado de guardar la url de la foto.
	 */
	private String urlFoto;
	/**
	 * Este es el constructor de la clase {@link Usuario} que no recibe nada.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Este es el constructor de la clase {@link Usuario} que recibe
	 * @param nombre
	 * @param contrasena
	 * @param correo
	 * @param edad
	 * @param pais
	 * @param urlFoto
	 */
	 public Usuario(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.correo = correo;
		this.edad = edad;
		this.pais = pais;
		this.urlFoto = urlFoto;
	}

	 /**
	  * Este metodo se encarga de obtener el nombre del usuario.
	  * @return nombre
	  */	public String getNombre() {
		  return nombre;
	  }
	/**
	 * Este metodo se encarga de establecer el nombre del usuario.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Este metodo se encarga de obtener la contraseña del usuario.
	 * @return contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * Este metodo se encarga de establecer la contraseña del usuario.
	 * @param contrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * Este metodo se encarga de obtener el correo del usuario.
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Este metodo se encarga de establecer el correo del usuario.
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Este metodo se encarga de obtener la edad del usuario.
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Este metodo se encarga de establecer la edad del usuario.
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * Este metodo se encarga de obtener la foto del usuario.
	 * @return urlFoto
	 */
	public String getUrlFoto() {
		return urlFoto;
	}
	/**
	 * Este metodo se encarga de establecer la foto del usuario.
	 * @param urlFoto
	 */
	public void setFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	/**
	 * Este metodo se encarga de obtener el pais del usuario.
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * Este metodo se encarga de establecer el pais del usuario.
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + ", correo=" + correo + ", edad=" + edad
				+ ", pais=" + pais + ", foto=" + urlFoto + "]";
	}
	
	
	
	

}
