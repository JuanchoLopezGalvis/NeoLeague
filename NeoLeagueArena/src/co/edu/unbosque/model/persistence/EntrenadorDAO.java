package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;

/**
 * Clase EntrenadorDAO
 * Esta clase se encarga de manejar la persistencia de los datos de los entrenadores.
 * Implementa la interfaz OperacionDAO para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 * Utiliza un ArrayList para almacenar los entrenadores y un archivo CSV para guardar los datos.
 * También utiliza un archivo serializado para guardar y cargar la lista de entrenadores.
 */
public class EntrenadorDAO implements OperacionDAO<EntrenadorDTO, Entrenador>{

	private ArrayList<Entrenador> listaEntrenadores;
	private final String TEXT_FILE_NAME = "coach.csv";
	private final String SERIAL_FILE_NAME = "coach.dat";

	/**
	 * Constructor de la clase EntrenadorDAO
	 * Inicializa la lista de entrenadores y carga los datos desde el archivo serializado.
	 */
	public EntrenadorDAO() {
		listaEntrenadores = new ArrayList<>();
		leerArchivoSerializado();
	}
/**
	 * showAll
	 * Muestra todos los entrenadores en la tabla.
	 * @param table la tabla donde se mostrarán los entrenadores.
	 * @return true si se mostraron los entrenadores, false en caso contrario.
	 */
	@Override
	public boolean showAll(JTable table) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		if (listaEntrenadores.isEmpty()) {
			modelo.setRowCount(0);
			return false;
		}else {
			modelo.setRowCount(0);
			for (Entrenador entrenador : listaEntrenadores) {
				ImageIcon icon = FileManager.graficarImagen(entrenador.getUrlFoto(), 80, 80);
				Object[] row = {entrenador.getNombre(), entrenador.getContrasena(), entrenador.getCorreo(), entrenador.getEdad(), entrenador.getPais(), entrenador.getTrayectoriaProfesional(), entrenador.getEspecialidadDeEntreno(), entrenador.getAnosDeEntrenamiento(), icon};
				modelo.addRow(row);
			}
		}
		return false;
	}
/**
	 * getAll
	 * Obtiene la lista de entrenadores.
	 * @return la lista de entrenadores.
	 */
	@Override
	public ArrayList<EntrenadorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
/**
	 * method add
	 * Agrega un nuevo entrenador a la lista de entrenadores.
	 * @param newData el nuevo entrenador a agregar.
	 * @return true si se agregó correctamente, false en caso contrario.
	 */
	@Override
	public boolean add(EntrenadorDTO newData) {
		listaEntrenadores.add(DataMapper.EntrenadorDTOToEntrenador(newData));
		escribirArchivoTxt();
		escribirArchivoSerializado();
		return true;
	}
/**
	 * delete
	 * Elimina un entrenador de la lista de entrenadores.
	 * @param toDelete el entrenador a eliminar.
	 * @return true si se eliminó correctamente, false en caso contrario.
	 */
	@Override
	public boolean delete(EntrenadorDTO toDelete) {
		Entrenador entrenador = find(DataMapper.EntrenadorDTOToEntrenador(toDelete));
		if (entrenador != null) {
			listaEntrenadores.remove(entrenador);
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		}else {
			return false;
		}
	}
/**
	 * find
	 * Busca un entrenador en la lista de entrenadores.
	 * @param toFind el entrenador a buscar.
	 * @return el entrenador encontrado o null si no se encuentra.
	 */
	@Override
	public Entrenador find(Entrenador toFind) {
		Entrenador found = null;
		if (!listaEntrenadores.isEmpty()) {
			for (Entrenador entrenador : listaEntrenadores) {
				if (entrenador.getNombre().equals(toFind.getNombre())) {
					found = entrenador;
					break;
				}else {
					continue;
				}
			}
			return found;
		}
		return null;
	}
	/**
	 * showOne
	 * Muestra un entrenador en la tabla.
	 * @param table la tabla donde se mostrará el entrenador.
	 * @param toShow el entrenador a mostrar.
	 * @param mensaje el mensaje a mostrar si no se encuentra el entrenador.
	 */
	public void showOne(JTable table, Entrenador toShow, String mensaje) {
		Entrenador entrenador = find(toShow);
		if (entrenador != null) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			ImageIcon icon = FileManager.graficarImagen(entrenador.getUrlFoto(), 80, 80);
			Object[] row = {entrenador.getNombre(), entrenador.getContrasena(), entrenador.getCorreo(), entrenador.getEdad(), entrenador.getPais(), entrenador.getTrayectoriaProfesional(), entrenador.getEspecialidadDeEntreno(), entrenador.getAnosDeEntrenamiento(), icon};
			modelo.addRow(row);
		}else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			Object[] row = {mensaje};
			modelo.addRow(row);
		}
	}
/**
	 * update
	 * Actualiza un entrenador en la lista de entrenadores.
	 * @param previous el entrenador a actualizar.
	 * @param newData el nuevo entrenador con los datos actualizados.
	 * @return true si se actualizó correctamente, false en caso contrario.
	 */
	@Override
	public boolean update(EntrenadorDTO previous, EntrenadorDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}
/**
	 * getListaEntrenadores
	 * Obtiene la lista de entrenadores.
	 * @return la lista de entrenadores.
	 */
	public ArrayList<Entrenador> getListaEntrenadores() {
		return listaEntrenadores;
	}
/**
	 * setListaEntrenadores
	 * Establece la lista de entrenadores.
	 * @param listaEntrenadores la nueva lista de entrenadores.
	 */
	public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
		this.listaEntrenadores = listaEntrenadores;
	}
/**
	 * escribirArchivoTxt
	 * Escribe el contenido de la lista de entrenadores en un archivo de texto.
	 * El formato del archivo es CSV.
	 * Cada entrenador se escribe en una línea con los siguientes campos:
	 * nombre, contrasena, correo, edad, pais, trayectoria profesional, especialidad de entreno, anos de entrenamiento.
	 * Cada campo está separado por una coma.
	 * El archivo se llama coach.csv y se encuentra en la carpeta de archivos.
	 * @throws IOException si ocurre un error al escribir el archivo.
	 * @throws FileNotFoundException si no se encuentra el archivo.
	 * @throws Exception si ocurre un error al escribir el archivo.
	 * @throws NullPointerException si la lista de entrenadores es nula.
	 */
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Entrenador coach : listaEntrenadores) {
			contenido.append(coach.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
/**
	 * Constructor de la clase EntrenadorDAO
	 * Inicializa la lista de entrenadores y carga los datos desde el archivo serializado.
	 * @param listaEntrenadores lista de entrenadores a inicializar
	 */
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEntrenadores);
	}
	/**
	 * Constructor de la clase EntrenadorDAO
	 * Inicializa la lista de entrenadores y carga los datos desde el archivo serializado.
	 * @param listaEntrenadores lista de entrenadores a inicializar
	 */
	public void leerArchivoSerializado() {
		listaEntrenadores = (ArrayList<Entrenador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaEntrenadores == null ) {
			listaEntrenadores = new ArrayList<>();
		}

	}
	
	



}
