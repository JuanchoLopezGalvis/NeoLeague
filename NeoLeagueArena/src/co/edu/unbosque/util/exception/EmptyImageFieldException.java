package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un campo de imagen está vacío.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class EmptyImageFieldException extends Exception{
	
	public EmptyImageFieldException(String message) {
        super(message); // Almacena el mensaje en la excepción
    }
}
