package co.edu.unbosque.model.persistence;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Clase que se encarga de manejar la creación, lectura y escritura de archivos
 * de texto y archivos serializados.
 * Esta clase permite crear una carpeta para almacenar los archivos,
 * Tendra la reponsabilidad de manejar la persistencia de los datos.
 *
 */
public class FileManager {

	/**
	 * La variable archivo de tipo File reperesenta el archivo que se va a crear,
	 * leer o escribir. tambien se usa para crear la carpeta donde se almacenaran los
	 * archivos.
	 */
	private static File archivo;
	/**
	 * La variable lectorArchivoTexto de tipo Scanner se usa para leer el archivo de
	 * texto.
	 */
	private static Scanner lectorArchivoTexto;
	/**
	 * La variable escritorArchivoTexto de tipo PrintWriter se usa para escribir en el
	 * archivo de texto.
	 */
	private static PrintWriter escritorArchivoTexto;
	/**
	 * La variable RUTA_CARPETA de tipo String representa la ruta de la carpeta que
	 * se va a crear.
	 */
	private static final String RUTA_CARPETA = "src/data";
	/**
	 * La variable fos de tipo FileOutputStream se usa para escribir en el archivo
	 * serializado.
	 * Encargado de la escritura de cualquier tipo de archivo (imágenes, documentos, etc.) a nivel de bytes.
	 */
	private static FileOutputStream fos;
	/**
	 * La variable oos de tipo ObjectOutputStream se usa para escribir en el archivo
	 * serializado.
	 */
	private static ObjectOutputStream oos;
	/**
	 * La variable fis de tipo FileInputStream se usa para leer el archivo
	 * serializado.
	 *Encargado de la lectura de cualquier tipo de archivo (imágenes, documentos, etc.) a nivel de bytes.
	 */
	private static FileInputStream fis;
	/**
	 * La variable ois de tipo ObjectInputStream se usa para leer el archivo
	 * serializado.
	 * La diferencia de este con el anterior es que este se encarga de la tarea de
	 * Encargado de recuperar objetos que fueron guardados con ObjectOutputStream.
	 */
	private static ObjectInputStream ois;
	/**
	 * Constructor de la clase FileManager.
	 * Este constructor se encarga de crear la carpeta donde se almacenaran los
	 * archivos.
	 */
	public static void crearCarpeta() {
		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		} else {
			System.out.println("La carpeta ya existe");
		}

	}
	/**
	 * Este metodo se encarga de escribir en un archivo de texto.
	 * @param nombreArchivo el nombre del archivo donde se va a escribir.
	 * @param contenido     el contenido que se va a escribir en el archivo.
	 */
	public static void escribirEnArchivoDeTexto(String nombreArchivo, String contenido) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorArchivoTexto = new PrintWriter(archivo);
			escritorArchivoTexto.println(contenido);
			escritorArchivoTexto.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo (escritura)");
			e.printStackTrace();
		}
	}
	/**
	 * Este metodo se encarga de leer un archivo de texto.
	 * @param nombreArchivo el nombre del archivo que se va a leer.
	 * @return el contenido del archivo.
	 */
	public static String leerArchivoDeTexto(String nombreArchivo) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorArchivoTexto = new Scanner(archivo);
			String contenido = "";
			while (lectorArchivoTexto.hasNext()) {
				contenido += lectorArchivoTexto.nextLine() + "\n";
			}
			lectorArchivoTexto.close();
			return contenido;
		} catch (IOException e) {
			System.out.println("Error al crear el archivo (lectura)");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Este metodo se encarga de escribir un objeto en un archivo serializado.
	 * @param nombreArchivo el nombre del archivo donde se va a escribir.
	 * @param contenido     el contenido que se va a escribir en el archivo.
	 */
	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido ){
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		}catch (IOException e) {
			System.out.println("Error en la escritura del archivo serializado");
			e.printStackTrace();
		}
	}
	/**
	 * Este metodo se encarga de leer un objeto de un archivo serializado.
	 * @param nombreArchivo el nombre del archivo que se va a leer.
	 * @return el contenido del archivo.
	 */
	public static Object leerArchivoSerializado(String nombreArchivo) {
		Object contenido = null;
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			fis.close();
			ois.close();
		}catch (IOException e) {
			System.out.println("Error al leer el archivo serializado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al obtener el contenido del archivo");
			e.printStackTrace();
		}
		return contenido;
	}
	/**
	 * Este metodo se encarga de leer una imagen desde el disco duro.
	 * @param panel el panel donde se va a mostrar el JFileChooser.
	 * @return void
	 */
	public static void leerImagen(JPanel panel, String userName) {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.getComponent(0).setBackground(new Color(0, 0, 0, 0));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
	    fileChooser.setFileFilter(filter);
	    fileChooser.setAcceptAllFileFilterUsed(false);

	    int result = fileChooser.showOpenDialog(panel);

	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();

	        try {
	            File imageUserDir = new File("imageUser");
	            if (!imageUserDir.exists()) {
	                imageUserDir.mkdir();
	            }
	            File destino = new File("imageUser/" + userName + selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".")));
	            Files.copy(
	                selectedFile.toPath(),
	                destino.toPath(),
	                StandardCopyOption.REPLACE_EXISTING
	            );

	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(panel,
	                "<html>Error saving image<br>Error al guardar la imagen</html>", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	    	JOptionPane.showMessageDialog(panel,
	            "<html>No image was selected<br>Imagen no seleccionada</html>", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	/**
	 * Este metodo se encarga de redimensionar una imagen que esta guardada en una ruta especifica.
	 * @param ruta la ruta de la imagen que se va a redimensionar.
	 * @param ancho el ancho de la imagen redimensionada.
	 * @param alto  el alto de la imagen redimensionada.
	 * @return la imagen redimensionada.
	 */
	public static ImageIcon graficarImagen(String ruta, int ancho, int alto) {
		ImageIcon icono = new ImageIcon(ruta);
		Image imagen = icono.getImage();
		ImageIcon iconoRedimensionado = new ImageIcon(imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return iconoRedimensionado;
	}
}

