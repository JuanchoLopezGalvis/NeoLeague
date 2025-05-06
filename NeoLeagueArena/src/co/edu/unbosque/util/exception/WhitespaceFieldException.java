package co.edu.unbosque.util.exception;
/**
 * Esta clase representa una excepción personalizada que se lanza cuando un campo contiene solo espacios en blanco.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class WhitespaceFieldException extends Exception {

    public WhitespaceFieldException(String message) {
        super(message);
    }
}
