package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;

public class TorneoDAO implements OperacionDAO<TorneoDTO, Torneo> {
	private final String TEXT_FILE_NAME = "torneo.csv";
	private final String SERIAL_FILE_NAME = "torneo.dat";
	private ArrayList<Torneo> listaTorneos;
	public TorneoDAO() {
		listaTorneos = new ArrayList<>();
		leerArchivoSerializado();
	}
	@Override
	public boolean showAll(JTable tabla) {
		if (listaTorneos.isEmpty()) {
			return false;
		}else {
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			modelo.setRowCount(0);
			for (Torneo torneo : listaTorneos) {
				int size = torneo.getListaEquiposInscritos().size();
				Object[] row = {torneo.getNombre(), torneo.getJuego(), torneo.getFechaInicio(), torneo.getFechaFin(), torneo.getFormato(), torneo.getMaxEquipos(), torneo.getPremio(), size};
				modelo.addRow(row);
			}
		}
		return true;
	}
	public boolean showEquipos(JTable tabla, Torneo t) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		if (t.getListaEquiposInscritos().isEmpty()) {
			modelo.setRowCount(0);
			return false;
		}else {
			modelo.setRowCount(0);
			for (Equipo equipo : t.getListaEquiposInscritos()) {
				if (equipo.getEntrenador() == null) {
					continue;
				}
				int integrantes = equipo.getIntegrantes().size();
				int torneos = equipo.getTorneosInscritos().size();
				int partidas = equipo.getPartidasJugadas().size();
				String entrenador = equipo.getEntrenador().getNombre();
				Object[] row = {equipo.getNombre(), integrantes, equipo.getJuegoDesempeñado(), torneos, entrenador, partidas, equipo.getPuntos()};
				modelo.addRow(row);
			}
		}
		return true;
	}

	@Override
	public ArrayList<TorneoDTO> getAll() {
		return null;
	}
	
	public void mostrarEquiposEnComboBox(JComboBox<String> comboBox, TorneoDTO torneoDTO) {
		Torneo torneo = find(DataMapper.TorneoDTOToTorneo(torneoDTO));
		if (torneo != null) {
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

	public void showOne(JTable table, Torneo toShow, String mensaje) {
		Torneo torneo = find(toShow);
		if (torneo != null) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			int size = torneo.getListaEquiposInscritos().size();
			Object[] row = {torneo.getNombre(), torneo.getJuego(), torneo.getFechaInicio(), torneo.getFechaFin(), torneo.getFormato(), torneo.getMaxEquipos(), torneo.getPremio(), size};
			modelo.addRow(row);
		}else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			Object[] row = {mensaje};
			modelo.addRow(row);
		}
	}

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
	
	public void asignarElementosAComboBox(JComboBox<String> comboBox) {
		comboBox.removeAllItems();
		for (Torneo torneo : listaTorneos) {
			comboBox.addItem(torneo.getNombre());
			comboBox.revalidate();
			comboBox.repaint();
		}
	}

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
	public ArrayList<Torneo> getListaTorneos() {
		return listaTorneos;
	}
	public void setListaTorneos(ArrayList<Torneo> listaTorneos) {
		this.listaTorneos = listaTorneos;
	}
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Torneo torneo : listaTorneos) {
			contenido.append(torneo.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTorneos);
	}
	public void leerArchivoSerializado() {
		listaTorneos = (ArrayList<Torneo>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaTorneos == null ) {
			listaTorneos = new ArrayList<>();
		}
	}
	
	


}
