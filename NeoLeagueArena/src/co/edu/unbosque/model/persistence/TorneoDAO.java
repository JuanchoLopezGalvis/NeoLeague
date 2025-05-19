package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;
/**
 * Clase TorneoDAO que implementa la interfaz OperacionDAO para manejar la
 * persistencia de los torneos.
 */
public class TorneoDAO implements OperacionDAO<TorneoDTO, Torneo> {
	private final String TEXT_FILE_NAME = "torneo.csv";
	private final String SERIAL_FILE_NAME = "torneo.dat";
	private ArrayList<Torneo> listaTorneos;
/**
 * Constructor de la clase TorneoDAO que inicializa la lista de torneos y
 * carga los torneos desde el archivo serializado.
 * 
 * 
 */
	public TorneoDAO() {
		listaTorneos = new ArrayList<>();
		leerArchivoSerializado();
	}
/**
 * Método que muestra todos los torneos en una tabla.
 * 
 * @param tabla la tabla donde se mostrarán los torneos.
 * 
 * 
 */
	@Override
	public boolean showAll(JTable tabla) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		if (listaTorneos.isEmpty()) {
			modelo.setRowCount(0);
			return false;
		} else {
			modelo.setRowCount(0);
			for (Torneo torneo : listaTorneos) {
				int size = torneo.getListaEquiposInscritos().size();
				Object[] row = { torneo.getNombre(), torneo.getJuego(), torneo.getFechaInicio(), torneo.getFechaFin(),
						torneo.getFormato(), torneo.getMaxEquipos(), torneo.getPremio(), size };
				modelo.addRow(row);
			}
		}
		return true;
	}

	/**
	 * Método que muestra los equipos inscritos en un torneo en una tabla.
	 * 
	 * @param tabla la tabla donde se mostrarán los equipos.
	 * @param t     el torneo del cual se mostrarán los equipos.
	 * 
	 * 
	 */
	public boolean showEquipos(JTable tabla, Torneo t) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		if (t.getListaEquiposInscritos().isEmpty()) {
			modelo.setRowCount(0);
			return false;
		} else {
			modelo.setRowCount(0);
			for (Equipo equipo : t.getListaEquiposInscritos()) {
				if (equipo.getEntrenador() == null) {
					continue;
				}
				int integrantes = equipo.getIntegrantes().size();
				int torneos = equipo.getTorneosInscritos().size();
				int partidas = equipo.getPartidasJugadas().size();
				String entrenador = equipo.getEntrenador().getNombre();
				Object[] row = { equipo.getNombre(), integrantes, equipo.getJuegoDesempeñado(), torneos, entrenador,
						partidas, equipo.getPuntos() };
				modelo.addRow(row);
			}
		}
		return true;
	}
	/**
	 * Método que muestra los equipos inscritos en un torneo en una tabla.
	 * 
	 * @param tabla la tabla donde se mostrarán los equipos.
	 * @param t     el torneo del cual se mostrarán los equipos.
	 * 
	 * 
	 */

	@Override
	public ArrayList<TorneoDTO> getAll() {
		return null;
	}

	/**
	 * Método que muestra los equipos inscritos en un torneo en un JComboBox.
	 * 
	 * @param comboBox el JComboBox donde se mostrarán los equipos.
	 * @param torneoDTO el torneo del cual se mostrarán los equipos.
	 * @param y        un entero que indica si se debe mostrar el mensaje de
	 *                 "Seleccione un equipo".
	 * 
	 */
	public void mostrarEquiposEnComboBox(JComboBox<String> comboBox, TorneoDTO torneoDTO, int y) {
		if (listaTorneos.isEmpty()) {
			comboBox.removeAllItems();
		}
		Torneo torneo = find(DataMapper.TorneoDTOToTorneo(torneoDTO));
		if (torneo != null) {
			if (y==1) {
				comboBox.removeAllItems();
				comboBox.addItem("");
				if (torneo.getListaEquiposInscritos() != null) {
					for (Equipo equipo : torneo.getListaEquiposInscritos()) {
						comboBox.addItem(equipo.getNombre());
					}
				}

				comboBox.revalidate();
				comboBox.repaint();
			}else {
				comboBox.removeAllItems();
				if (torneo.getListaEquiposInscritos() != null) {
					for (Equipo equipo : torneo.getListaEquiposInscritos()) {
						comboBox.addItem(equipo.getNombre());
					}
				}

				comboBox.revalidate();
				comboBox.repaint();
			}

		}
	}
	/**
	 * Método que añade los equipos inscritos en un torneo en un JComboBox.
	 * 
	 * @param comboBox el JComboBox donde se mostrarán los equipos.
	 * @param torneoDTO el torneo del cual se mostrarán los equipos.
	 * @param y        un entero que indica si se debe mostrar el mensaje de
	 *                 "Seleccione un equipo".
	 * 
	 */

	@Override
	public boolean add(TorneoDTO newData) {
		if (newData.getListaEquiposInscritos() == null) {
			newData.setListaEquiposInscritos(new ArrayList<>());
		}
		Torneo torneo = DataMapper.TorneoDTOToTorneo(newData);
		listaTorneos.add(torneo);
		escribirArchivoSerializado();
		escribirArchivoTxt();
		return true;
	}
	/**
	 * Método que muestra un torneo en una tabla.
	 * 
	 * @param table   la tabla donde se mostrará el torneo.
	 * @param toShow  el torneo a mostrar.
	 * @param mensaje el mensaje a mostrar si no se encuentra el torneo.
	 * 
	 */

	public void showOne(JTable table, Torneo toShow, String mensaje) {
		Torneo torneo = find(toShow);
		if (torneo != null) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			int size = torneo.getListaEquiposInscritos().size();
			Object[] row = { torneo.getNombre(), torneo.getJuego(), torneo.getFechaInicio(), torneo.getFechaFin(),
					torneo.getFormato(), torneo.getMaxEquipos(), torneo.getPremio(), size };
			modelo.addRow(row);
		} else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			Object[] row = { mensaje };
			modelo.addRow(row);
		}
	}

	/**
	 * Método que muestra un torneo en una tabla.
	 * 
	 * @param table   la tabla donde se mostrará el torneo.
	 * @param toShow  el torneo a mostrar.
	 * @param mensaje el mensaje a mostrar si no se encuentra el torneo.
	 * 
	 */
	@Override
	public boolean delete(TorneoDTO toDelete) {
		Torneo torneo = find(DataMapper.TorneoDTOToTorneo(toDelete));
		if (torneo != null) {
			listaTorneos.remove(torneo);
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	/**
	 * Método que busca un torneo en la lista de torneos.
	 * 
	 * @param toFind el torneo a buscar.
	 * @return el torneo encontrado o null si no se encuentra.
	 * 
	 */
	@Override
	public Torneo find(Torneo toFind) {
		Torneo found = null;
		if (!listaTorneos.isEmpty()) {
			for (Torneo torneo : listaTorneos) {
				if (torneo.getNombre().equals(toFind.getNombre())) {
					found = torneo;
					break;
				}
			}
			return found;
		}
		return null;
	}

	/**
	 * Método que asigna los torneos a un JComboBox.
	 * 
	 * @param comboBox el JComboBox donde se mostrarán los torneos.
	 * 
	 */
	public void asignarElementosAComboBox(JComboBox<String> comboBox) {
		if (listaTorneos.isEmpty()) {
			comboBox.removeAllItems();
		}
		comboBox.removeAllItems();
		for (Torneo torneo : listaTorneos) {
			comboBox.addItem(torneo.getNombre());
			comboBox.revalidate();
			comboBox.repaint();
		}
	}

	/**
	 * Método que actualiza un torneo en la lista de torneos.
	 * 
	 * @param previous el torneo a actualizar.
	 * @param newData  los nuevos datos del torneo.
	 * @return true si se actualiza correctamente, false si no se encuentra el
	 *         torneo.
	 * 
	 */
	@Override
	public boolean update(TorneoDTO previous, TorneoDTO newData) {
		Torneo torneo = find(DataMapper.TorneoDTOToTorneo(previous));
		if (torneo != null) {
			torneo.setNombre(newData.getNombre());
			torneo.setFechaInicio(newData.getFechaInicio());
			torneo.setFechaFin(newData.getFechaFin());
			torneo.setMaxEquipos(newData.getMaxEquipos());
			torneo.setPremio(newData.getPremio());
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	/**
	 * Método que obtiene la lista de torneos.
	 * 
	 * @return la lista de torneos.
	 * 
	 */
	
	public ArrayList<Torneo> getListaTorneos() {
		return listaTorneos;
	}

	/**
	 * Método que asigna la lista de torneos.
	 * 
	 * @param listaTorneos la lista de torneos a asignar.
	 * 
	 */
	public void setListaTorneos(ArrayList<Torneo> listaTorneos) {
		this.listaTorneos = listaTorneos;
	}

	/**
	 * Método que escribe la lista de torneos en un archivo de texto.
	 * 
	 */
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Torneo torneo : listaTorneos) {
			contenido.append(torneo.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}

	/**
	 * Método que escribe la lista de torneos en un archivo serializado.
	 * 
	 */
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTorneos);
	}

	/**
	 * Método que lee la lista de torneos desde un archivo serializado.
	 * 
	 */
	public void leerArchivoSerializado() {
		listaTorneos = (ArrayList<Torneo>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaTorneos == null) {
			listaTorneos = new ArrayList<>();
		}
	}

}
