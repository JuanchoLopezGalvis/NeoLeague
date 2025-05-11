package co.edu.unbosque.controller;

import java.awt.Image;
import java.util.regex.Pattern;

import co.edu.unbosque.util.exception.EmptyImageFieldException;
import co.edu.unbosque.util.exception.EmptyNumberFieldException;
import co.edu.unbosque.util.exception.EmptyStringFieldException;
import co.edu.unbosque.util.exception.InvalidEmailException;
import co.edu.unbosque.util.exception.InvalidPasswordException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.NumberInStringException;
import co.edu.unbosque.util.exception.WhitespaceFieldException;

public class ExceptionChecker {

    // Verificar si un número es negativo
	/**
	 * Verifica si un número es negativo y lanza una excepción si lo es.
	 * @param number
	 * @param errorMesage
	 * @throws NegativeNumberException
	 */
    public static void checkNegativeNumber(int number, String errorMesage) throws NegativeNumberException {
        if (number <= 0 ) {
            throw new NegativeNumberException(errorMesage);
        }
    }

    // Verificar si un String contiene números
    	/**
    	 * Verifica si un String contiene números y lanza una excepción si lo hace.
    	 * @param text
    	 * @param errorMessage
    	 * @throws NumberInStringException
    	 */
    public static void checkNumberInString(String text, String errorMessage) throws NumberInStringException {
        if (text.matches(".*\\d.*")) {
            throw new NumberInStringException(errorMessage);
        }
    }

    // Verificar si un campo numérico está vacío
    	/**
		 * Verifica si un campo numérico está vacío y lanza una excepción si lo está.
		 * @param values
		 * @throws EmptyNumberFieldException
		 */
    public static void checkNumberField(Number... values) throws EmptyNumberFieldException {
        for (Number value : values) {
            if (value == null) {
                throw new EmptyNumberFieldException("Error.");
            }
        }
        
    }


    // Verificar si un campo de texto está vacío
    	/**
    	 * Verifica si un campo de texto está vacío y lanza una excepción si lo está.
    	 * @param word
    	 * @param errorMessage
    	 * @throws EmptyStringFieldException
    	 */
    public static void checkStringField(String word, String errorMessage) throws EmptyStringFieldException {
        if (word == null || word.trim().isEmpty()) { 
            throw new EmptyStringFieldException(errorMessage);
        }
    }

    // Verificar si la imagen está vacía
    	/**
		 * Verifica si la imagen está vacía y lanza una excepción si lo está.
		 * @param image
		 * @param mensaje
		 * @throws EmptyImageFieldException
		 */
    public static void checkImageField(Image image, String mensaje) throws EmptyImageFieldException {
        if (image == null) {
            throw new EmptyImageFieldException(mensaje);
        }
    }

    // Verificar si la contraseña cumple con los requisitos
    	/**
		 * Verifica si la contraseña cumple con los requisitos y lanza una excepción si no lo hace.
		 * @param password
		 * @param errorMessage
		 * @throws InvalidPasswordException
		 */
    public static void checkPasswordField(String password, String errorMessage) throws InvalidPasswordException {
   	 String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!*_\\-]).{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);

        if (!pattern.matcher(password).matches()) {
            throw new InvalidPasswordException( errorMessage);
        }
    }
 
    // Verificar si el campo contiene espacios en blanco
    	/**
    	 * Verifica si el campo contiene espacios en blanco y lanza una excepción si lo hace.
    	 * @param value
    	 * @param errorMessage
    	 * @throws WhitespaceFieldException
    	 */
        public static void checkWhitespace(String value, String errorMessage) throws WhitespaceFieldException {
            if (value.contains(" ")) {
                throw new WhitespaceFieldException(errorMessage);
            }
        }
        // Verificar si el campo de correo electrónico es válido
        		/**
        		 * Verifica si el campo de correo electrónico es válido y lanza una excepción si no lo es.
        		 * @param email
        		 * @param errorMessage
        		 * @throws InvalidEmailException
        		 */
        public static void checkEmailField(String email, String errorMessage) throws InvalidEmailException {
            String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@(gmail\\.com|Hotmail\\.com|unbosque\\.edu\\.co)$";
            Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

            if (!pattern.matcher(email).matches()) {
                throw new InvalidEmailException(errorMessage);
            }
            }

}
