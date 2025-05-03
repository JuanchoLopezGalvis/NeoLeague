package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;

public class EntrenadorDAO implements OperacionDAO<EntrenadorDTO, Entrenador>{
	
	private ArrayList<Entrenador> listaEntrenadores;
	private final String TEXT_FILE_NAME = "coach.csv";
	private final String SERIAL_FILE_NAME = "coach.dat";
	
	public EntrenadorDAO() {
		listaEntrenadores = new ArrayList<Entrenador>();
		leerArchivoSerializado();
	}

	@Override
	public String showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EntrenadorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(EntrenadorDTO newData) {
		listaEntrenadores.add(DataMapper.EntrenadorDTOToEntrenador(newData));
		escribirArchivoTxt();
		escribirArchivoSerializado();
		return true;
	}

	@Override
	public boolean delete(EntrenadorDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entrenador find(Entrenador toFind) {
		Entrenador found = null;
		if (!listaEntrenadores.isEmpty()) {
			for (Entrenador entrenador : listaEntrenadores) {
				if (entrenador.getNombre().equals(toFind.getNombre())) {
					found = entrenador;
					break;
				}
			}
			return found;
		}
		return null;
	}

	@Override
	public boolean update(EntrenadorDTO previous, EntrenadorDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Entrenador> getListaEntrenadores() {
		return listaEntrenadores;
	}

	public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
		this.listaEntrenadores = listaEntrenadores;
	}
	
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Entrenador coach : listaEntrenadores) {
			contenido.append(coach.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEntrenadores);
	}
	public void leerArchivoSerializado() {
		listaEntrenadores = (ArrayList<Entrenador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		escribirArchivoSerializado();
		escribirArchivoTxt();
		if (listaEntrenadores == null ) {
			listaEntrenadores = new ArrayList<>();			
		}
		
	}
	
	

}
