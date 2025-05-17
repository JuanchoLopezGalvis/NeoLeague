package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un correo electrónico es inválido.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class InvalidEmailException extends Exception {
    /**
     * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la clase InvalidEmailException.
	 * @param message El mensaje de error que describe la excepción.
	 */
	public InvalidEmailException(String message) {
        super(message);
    }
}