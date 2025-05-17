package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un número está presente en una cadena.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class NumberInStringException extends Exception {
    /**
     * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la clase NumberInStringException.
	 * @param message El mensaje de error que describe la excepción.
	 */
	public NumberInStringException(String message) {
        super(message);
    }
}
