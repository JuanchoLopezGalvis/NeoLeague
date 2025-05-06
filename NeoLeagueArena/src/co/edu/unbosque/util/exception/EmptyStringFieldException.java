package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un campo de texto está vacío.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class EmptyStringFieldException extends Exception {
    public EmptyStringFieldException(String message) {
        super(message); // Almacena el mensaje en la excepción
    }
}
