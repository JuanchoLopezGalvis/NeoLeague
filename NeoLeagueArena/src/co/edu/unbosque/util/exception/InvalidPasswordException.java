package co.edu.unbosque.util.exception;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando un correo electrónico es inválido.
 * Extiende la clase Exception para proporcionar información adicional sobre el error.
 */
public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}