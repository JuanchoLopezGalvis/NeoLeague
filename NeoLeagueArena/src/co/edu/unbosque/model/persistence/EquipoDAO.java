 package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;

/**
 * Clase que se encarga de manejar la persistencia de los datos de los equipos.
 * Esta clase implementa la interfaz OperacionDAO y permite realizar operaciones
 * CRUD sobre los equipos.
 */
public class EquipoDAO implements OperacionDAO<EquipoDTO, Equipo> {
	private final String TEXT_FILE_NAME = "equipo.csv";
	private final String SERIAL_FILE_NAME = "equipo.dat";
	private ArrayList<Equipo> listaEquipos;

	public EquipoDAO() {
		listaEquipos = new ArrayList<>();
		leerArchivoSerializado();
	}

	/**
	 * Constructor de la clase EquipoDAO
	 * Inicializa la lista de equipos y carga los datos desde el archivo serializado.
	 * @param listaEquipos lista de equipos a inicializar
	 */
	@Override
	public boolean showAll(JTable tabla) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		if (listaEquipos.isEmpty()) {
			modelo.setRowCount(0);
			return false;
		}else {
			modelo.setRowCount(0);
			for (Equipo equipo : listaEquipos) {
				if (equipo.getEntrenador() == null) {
					continue;
				}
				int integrantes = equipo.getIntegrantes().size();
				int torneos = equipo.getTorneosInscritos().size();
				int partidas = equipo.getPartidasJugadas().size();
				String entrenador = equipo.getEntrenador().getNombre();
				Object[] row = {equipo.getNombre(), integrantes, equipo.getJuegoDesempeñado(), torneos, entrenador, partidas};
				modelo.addRow(row);
			}
		}
		return true;
	}
	
	
	/**
	 * Constructor de la clase EquipoDAO
	 * Inicializa la lista de equipos y carga los datos desde el archivo serializado.
	 * @param listaEquipos lista de equipos a inicializar
	 */
	public void showOne(JTable table, Equipo toShow, String mensaje) {
		Equipo equipo = find(toShow);
		if (equipo != null && equipo.getEntrenador() != null) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			int integrantes = equipo.getIntegrantes().size();
			int torneos = equipo.getTorneosInscritos().size();
			int partidas = equipo.getPartidasJugadas().size();
			String entrenador = equipo.getEntrenador().getNombre();
			Object[] row = {equipo.getNombre(), integrantes, equipo.getJuegoDesempeñado(), torneos, entrenador, partidas};
			modelo.addRow(row);
		}else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			Object[] row = {mensaje};
			modelo.addRow(row);
		}
	}
	
	/**
	 * Constructor de la clase EquipoDAO
	 * Inicializa la lista de equipos y carga los datos desde el archivo serializado.
	 * @param listaEquipos lista de equipos a inicializar
	 */
	@Override
	public ArrayList<EquipoDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Constructor de la clase EquipoDAO
	 * Inicializa la lista de equipos y carga los datos desde el archivo serializado.
	 * @param listaEquipos lista de equipos a inicializar
	 */
	public void asignarElmentosCombos(JComboBox<String> comboBox) {
		comboBox.removeAllItems();
		for (Equipo equipo : listaEquipos) {
			comboBox.addItem(equipo.getNombre());
			comboBox.revalidate();
			comboBox.repaint();
		}
	}
/** 
 * add 
 * Agrega un nuevo equipo a la lista de equipos.
 * @param newData el equipo a agregar
 * @return true si se agregó el equipo, false si ya existe
 * @throws Exception si ocurre un error al agregar el equipo
 * 
 */
	@Override
	public boolean add(EquipoDTO newData) {
		if (newData.getTorneosInscritos() == null && newData.getIntegrantes() == null && newData.getPartidasJugadas() == null) {
			newData.setTorneosInscritos(new ArrayList<>());
			newData.setIntegrantes(new ArrayList<>());
			newData.setPartidasJugadas(new ArrayList<>());
		}
		Equipo equipo = DataMapper.EquipoDTOToEquipo(newData);
		listaEquipos.add(equipo);
		escribirArchivoSerializado();
		escribirArchivoTxt();
		return true;
	}
/**
 * delete
 * Elimina un equipo de la lista de equipos.	
 * @param toDelete el equipo a eliminar
 * @return true si se eliminó el equipo, false si no se encontró
 */
	@Override
	public boolean delete(EquipoDTO toDelete) {
		Equipo equipo = find(DataMapper.EquipoDTOToEquipo(toDelete));
		if (equipo != null) {
			listaEquipos.remove(equipo);
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	/** 
	 * find
	 * Busca un equipo en la lista de equipos.
	 * @param toFind el equipo a buscar
	 * @return el equipo encontrado, o null si no se encontró
	 */
	@Override
	public Equipo find(Equipo toFind) {
		Equipo found = null;
		if (!listaEquipos.isEmpty()) {
			for (Equipo equipo : listaEquipos) {
				if (equipo.getNombre().equals(toFind.getNombre())) {
					found = equipo;
					break;
				}
			}
			return found;
		}
		return null;
	}
/**
 * update	
 * Actualiza un equipo en la lista de equipos.
 * @param previous el equipo a actualizar
 * @param newData los nuevos datos del equipo
 * @return true si se actualizó el equipo, false si no se encontró
 */
	@Override
	public boolean update(EquipoDTO previous, EquipoDTO newData) {
		Equipo found = find(DataMapper.EquipoDTOToEquipo(previous));
		if (found != null) {
			found.setNombre(newData.getNombre());
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}
/**
 * 
 * @return listaEquipos
 * Devuelve la lista de equipos
 * @param listaEquipos la lista de equipos a establecer
 */
	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}
/**
 * setListaEquipos
 * Establece la lista de equipos.
 * @param listaEquipos la lista de equipos a establecer
 * @return listaEquipos
 * Devuelve la lista de equipos
 */
	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	/**
	 * escribirArchivoTxt
	 * Escribe la lista de equipos en un archivo de texto.
	 */
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Equipo equipo : listaEquipos) {
			contenido.append(equipo.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	/**
	 * escribirArchivoSerializado 
	 * Escribe la lista de equipos en un archivo serializado.
	 * @param listaEquipos la lista de equipos a establecer
	 * @return listaEquipos
	 * Devuelve la lista de equipos
	 */
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEquipos);
	}
	/**
	 * leerArchivoSerializado
	 * Lee la lista de equipos desde un archivo serializado.
	 * @param listaEquipos la lista de equipos a establecer
	 * @return listaEquipos
	 * Devuelve la lista de equipos
	 */
	public void leerArchivoSerializado() {
		listaEquipos = (ArrayList<Equipo>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaEquipos == null ) {
			listaEquipos = new ArrayList<>();
		}
	}

}
