package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un número está presente en una cadena.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class NumberInStringException extends Exception {
    public NumberInStringException(String message) {
        super(message);
    }
}
