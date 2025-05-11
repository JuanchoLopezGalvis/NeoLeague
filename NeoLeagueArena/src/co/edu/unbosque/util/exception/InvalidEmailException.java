package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un correo electrónico es inválido.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class InvalidEmailException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String message) {
        super(message);
    }
}