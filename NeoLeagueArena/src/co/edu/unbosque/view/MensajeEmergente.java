package co.edu.unbosque.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * La clase {@link MensajeEmergente} se encarga de mostrar mensajes emergentes
 * al usuario. Fue creada para facilitar la carga de las propiedades en los
 * mensajes emergentes que son vitales dentro del aplicativo y aun más que el
 * usuario los entienda.
 */
public class MensajeEmergente {

	/**
	 * Propiedades que contienen los mensajes emergentes.
	 */
	private static Properties propiedades = new Properties();

	/**
	 * Constructor de la clase {@link MensajeEmergente}. Carga las propiedades desde
	 * el archivo especificado.
	 * 
	 * @param direccionArchivo
	 */
	public static void cargarPropiedadesParaMensajesEmergentes(String direccionArchivo) {
		try {
			propiedades.load(new FileInputStream(new File(direccionArchivo)));
		} catch (FileNotFoundException e0) {
			e0.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra un mensaje emergente de tipo información.
	 * 
	 * @param llaveArchivoPropiedades
	 * @param tituloMensaje
	 */
	public static void mensajeNormal(String llaveArchivoPropiedades, String tituloMensaje) {
		JOptionPane.showMessageDialog(null, propiedades.getProperty(llaveArchivoPropiedades),
				propiedades.getProperty(tituloMensaje), JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mensajeNormalMasAlgo(String llaveArchivoPropiedades, String algoMas, String tituloMensaje) {
		JOptionPane.showMessageDialog(null, propiedades.getProperty(llaveArchivoPropiedades) + algoMas,
				propiedades.getProperty(tituloMensaje), JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra un mensaje emergente de tipo error.
	 * 
	 * @param llaveArchivoPropiedades
	 * @param tituloMensaje
	 */
	public static void mensajeError(String llaveArchivoPropiedades, String tituloMensaje) {
		JOptionPane.showMessageDialog(null, propiedades.getProperty(llaveArchivoPropiedades),
				propiedades.getProperty(tituloMensaje), JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un mensaje emergente de tipo advertencia.
	 * 
	 * @param llaveArchivoPropiedades
	 * @param tituloMensaje
	 */
	public static void mensajeAdvertencia(String llaveArchivoPropiedades, String tituloMensaje) {
		JOptionPane.showMessageDialog(null, propiedades.getProperty(llaveArchivoPropiedades),
				propiedades.getProperty(tituloMensaje), JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Muestra un mensaje emergente de tipo pregunta.
	 * 
	 * @param llaveArchivoPropiedades
	 * @param tituloMensaje
	 */
	public static void mensajeConfirmacion(String llaveArchivoPropiedades, String tituloMensaje) {
		JOptionPane.showConfirmDialog(null, propiedades.getProperty(llaveArchivoPropiedades),
				propiedades.getProperty(tituloMensaje), JOptionPane.YES_NO_OPTION);
	}

	/**
	 * Estrae el texto de una property.
	 * 
	 * @param llaveArchivoPropiedades
	 * @param tituloMensaje
	 */
	public static String obtenerMensaje(String llaveArchivoPropiedades) {
		return propiedades.getProperty(llaveArchivoPropiedades);
	}

}