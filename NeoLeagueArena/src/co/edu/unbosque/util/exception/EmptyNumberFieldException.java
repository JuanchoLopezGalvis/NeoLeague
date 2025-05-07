package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un campo de número está vacío.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class EmptyNumberFieldException extends Exception {
    public EmptyNumberFieldException(String message) {
        super(message);
    }
}
