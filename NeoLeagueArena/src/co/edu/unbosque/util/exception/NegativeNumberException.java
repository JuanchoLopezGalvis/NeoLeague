package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un número es negativo.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}