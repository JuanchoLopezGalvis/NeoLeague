package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un campo de texto está vacío.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class EmptyStringFieldException extends Exception {
    /**
     * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la clase EmptyStringFieldException.
	 * @param message El mensaje de error que describe la excepción.
	 */
	public EmptyStringFieldException(String message) {
        super(message); // Almacena el mensaje en la excepción
    }
}
