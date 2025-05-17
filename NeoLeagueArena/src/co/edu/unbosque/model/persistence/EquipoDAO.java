package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.Torneo;

public class EquipoDAO implements OperacionDAO<EquipoDTO, Equipo> {
	private final String TEXT_FILE_NAME = "equipo.csv";
	private final String SERIAL_FILE_NAME = "equipo.dat";
	private ArrayList<Equipo> listaEquipos;
	
	public EquipoDAO() {
		listaEquipos = new ArrayList<Equipo>();
		leerArchivoSerializado();
	}
	
	@Override
	public boolean showAll(JTable tabla) {
		if (listaEquipos.isEmpty()) {
			return false;
		}else {
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			modelo.setRowCount(0);
			for (Equipo equipo : listaEquipos) {
				int integrantes = equipo.getIntegrantes().size();
				int torneos = equipo.getTorneosInscritos().size();
				int partidas = equipo.getPartidasJugadas().size();
				Object[] row = {equipo.getNombre(), integrantes, equipo.getJuegoDesempeñado(), torneos, partidas};
				modelo.addRow(row);
			}
		}
		return true;
	}

	@Override
	public ArrayList<EquipoDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public boolean delete(EquipoDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

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

	@Override
	public boolean update(EquipoDTO previous, EquipoDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Equipo equipo : listaEquipos) {
			contenido.append(equipo.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEquipos);
	}
	public void leerArchivoSerializado() {
		listaEquipos = (ArrayList<Equipo>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaEquipos == null ) {
			listaEquipos = new ArrayList<>();
		}
	}
	
}
