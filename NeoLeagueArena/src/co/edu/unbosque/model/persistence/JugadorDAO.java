package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;

/**
 * Clase JugadorDAO que implementa la interfaz OperacionDAO para realizar
 * operaciones CRUD sobre objetos de tipo Jugador.
 * 
 * @author Juan Pablo Garcia
 */
public class JugadorDAO implements OperacionDAO<JugadorDTO, Jugador> {
	/**
	 * Atributos de la clase JugadorDAO.
	 * 
	 */
	private final String TEXT_FILE_NAME = "gamer.csv";
	/**
	 * Nombre del archivo serializado.
	 */

	private final String SERIAL_FILE_NAME = "gamer.dat";
	/**
	 * Lista de jugadores.
	 */
	private ArrayList<Jugador> listaJugadores;

	/**
	 * Constructor de la clase JugadorDAO.
	 * 
	 * 
	 */
	public JugadorDAO() {
		listaJugadores = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
	 * Método que muestra todos los jugadores en una tabla.
	 * 
	 * @param table JTable donde se mostrarán los jugadores.
	 * @return true si se muestran jugadores, false si no hay jugadores.
	 */
	@Override
	public boolean showAll(JTable table) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		if (listaJugadores.isEmpty()) {
			modelo.setRowCount(0);
			return false;
		} else {
			modelo.setRowCount(0);
			for (Jugador jugador : listaJugadores) {
				ImageIcon icon = FileManager.graficarImagen(jugador.getUrlFoto(), 80, 80);
				Object[] row = { jugador.getNombre(), jugador.getContrasena(), jugador.getCorreo(), jugador.getEdad(),
						jugador.getPais(), jugador.getTrayectoriaCompetitiva(), jugador.getJuegoEspecialidad(),
						jugador.getAnosDeExperiencia(), icon };
				modelo.addRow(row);
			}
		}
		return true;
	}

	/**
	 * Método que obtiene todos los jugadores.
	 * 
	 * @return ArrayList de objetos JugadorDTO.
	 * 
	 */
	@Override
	public ArrayList<JugadorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Método que agrega un nuevo jugador a la lista de jugadores.
	 * 
	 * @param newData JugadorDTO que se va a agregar.
	 * @return true si se agrega el jugador, false si no se puede agregar.
	 * 
	 */
	@Override
	public boolean add(JugadorDTO newData) {
		listaJugadores.add(DataMapper.JugadorDTOToJugador(newData));
		escribirArchivoSerializado();
		escribirArchivoTxt();
		return true;
	}

	/**
	 * Método que elimina un jugador de la lista de jugadores.
	 * 
	 * @param toDelete JugadorDTO que se va a eliminar.
	 * @return true si se elimina el jugador, false si no se puede eliminar.
	 * 
	 */
	@Override
	public boolean delete(JugadorDTO toDelete) {
		Jugador jugador = find(DataMapper.JugadorDTOToJugador(toDelete));
		if (jugador != null) {
			listaJugadores.remove(jugador);
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	/**
	 * Método que busca un jugador en la lista de jugadores.
	 * 
	 * @param toFind JugadorDTO que se va a buscar.
	 * @return Jugador encontrado o null si no se encuentra.
	 */
	@Override
	public Jugador find(Jugador toFind) {
		Jugador found = null;
		if (!listaJugadores.isEmpty()) {
			for (Jugador jugador : listaJugadores) {
				if (jugador.getNombre().equals(toFind.getNombre())) {
					found = jugador;
					break;
				}
			}
			return found;
		}
		return null;
	}

	/**
	 * Método que muestra un jugador en una tabla.
	 * 
	 * @param table   JTable donde se mostrará el jugador.
	 * @param toShow  JugadorDTO que se va a mostrar.
	 * @param mensaje Mensaje a mostrar si no se encuentra el jugador.
	 */
	public void showOne(JTable table, Jugador toShow, String mensaje) {
		Jugador jugador = find(toShow);
		if (jugador != null) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			ImageIcon icon = FileManager.graficarImagen(jugador.getUrlFoto(), 80, 80);
			Object[] row = { jugador.getNombre(), jugador.getContrasena(), jugador.getCorreo(), jugador.getEdad(),
					jugador.getPais(), jugador.getTrayectoriaCompetitiva(), jugador.getJuegoEspecialidad(),
					jugador.getAnosDeExperiencia(), icon };
			modelo.addRow(row);
		} else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			Object[] row = { mensaje };
			modelo.addRow(row);
		}
	}

	/**
	 * Método que actualiza un jugador en la lista de jugadores.
	 * 
	 * @param previous JugadorDTO que se va a actualizar.
	 * @param newData  JugadorDTO con los nuevos datos.
	 * @return true si se actualiza el jugador, false si no se puede actualizar.
	 */
	@Override
	public boolean update(JugadorDTO previous, JugadorDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Método que obtiene el nombre del archivo de texto.
	 * 
	 * @return Nombre del archivo de texto.
	 */
	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	/**
	 * Método que establece la lista de jugadores.
	 * 
	 * @param listaJugadores ArrayList de objetos Jugador.
	 */
	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	/**
	 * Método que obtiene el nombre del archivo serializado.
	 * 
	 * @return Nombre del archivo serializado.
	 */
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Jugador jugador : listaJugadores) {
			contenido.append(jugador.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}

	/**
	 * Método que obtiene el nombre del archivo serializado.
	 * 
	 * @return Nombre del archivo serializado.
	 */
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaJugadores);
	}

	/**
	 * Método que lee el archivo serializado.
	 * 
	 * @return ArrayList de objetos Jugador.
	 */
	public void leerArchivoSerializado() {
		listaJugadores = (ArrayList<Jugador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaJugadores == null) {
			listaJugadores = new ArrayList<>();
		}
	}

}
