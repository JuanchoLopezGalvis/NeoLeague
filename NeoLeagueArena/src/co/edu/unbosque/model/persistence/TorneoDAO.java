package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;

public class TorneoDAO implements OperacionDAO<TorneoDTO, Torneo> {
	private final String TEXT_FILE_NAME = "torneo.csv";
	private final String SERIAL_FILE_NAME = "torneo.dat";
	private ArrayList<Torneo> listaTorneos;
	public TorneoDAO() {
		listaTorneos = new ArrayList<Torneo>();
		leerArchivoSerializado();
	}
	@Override
	public boolean showAll(JTable tabla) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<TorneoDTO> getAll() {
		return null;
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

	@Override
	public boolean delete(TorneoDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Torneo find(Torneo toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(TorneoDTO previous, TorneoDTO newData) {
		// TODO Auto-generated method stub
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
