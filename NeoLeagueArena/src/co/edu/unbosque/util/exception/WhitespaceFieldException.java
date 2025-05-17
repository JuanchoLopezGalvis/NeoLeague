package co.edu.unbosque.util.exception;
/**
 * Esta clase representa una excepción personalizada que se lanza cuando un campo contiene solo espacios en blanco.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class WhitespaceFieldException extends Exception {
    /**
     * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la clase WhitespaceFieldException.
	 * @param message El mensaje de error que describe la excepción.
	 */
	public WhitespaceFieldException(String message) {
        super(message);
    }
}
