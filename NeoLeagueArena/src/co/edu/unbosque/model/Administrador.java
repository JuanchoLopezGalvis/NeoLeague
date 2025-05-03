package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase {@link Administrador} es la encargada de establecer los atributos de un administrador.
 * Esta clase hereda de la clase {@link Usuario}.
 */
public class Administrador extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta instancia es la encargada de guardar la contraseña de los administradores que para aumentar la seguridad del aplicativo 
	 * para que no cualquiera pueda administrar la información.
	 */
	private String cargoEspecifico;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	

	public Administrador(String cargoEspecifico) {
		super();
		this.cargoEspecifico = cargoEspecifico;
	}


	public Administrador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto,
			String cargoEspecifico) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		this.cargoEspecifico = cargoEspecifico;
	}

	public Administrador(String nombre, String contrasena, String correo, int edad, String pais, String urlFoto) {
		super(nombre, contrasena, correo, edad, pais, urlFoto);
		// TODO Auto-generated constructor stub
	}

	public String getCargoEspecifico() {
		return cargoEspecifico;
	}

	public void setCargoEspecifico(String cargoEspecifico) {
		this.cargoEspecifico = cargoEspecifico;
	}



	@Override
	public String toString() {
		return super.toString() +  cargoEspecifico + "\n";
	}
	
	
	
	
}
