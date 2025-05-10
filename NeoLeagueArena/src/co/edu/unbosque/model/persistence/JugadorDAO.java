package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;

public class JugadorDAO implements OperacionDAO<JugadorDTO, Jugador> {
	
	private final String TEXT_FILE_NAME = "gamer.csv";
	private final String SERIAL_FILE_NAME = "gamer.dat";
	private ArrayList<Jugador> listaJugadores;
	
	public JugadorDAO() {
		listaJugadores = new ArrayList<Jugador>();
		leerArchivoSerializado();
	}
	@Override
	public String showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<JugadorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(JugadorDTO newData) {
		listaJugadores.add(DataMapper.JugadorDTOToJugador(newData));
		escribirArchivoSerializado();
		escribirArchivoTxt();
		return true;
	}

	@Override
	public boolean delete(JugadorDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

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

	@Override
	public boolean update(JugadorDTO previous, JugadorDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Jugador jugador : listaJugadores) {
			contenido.append(jugador.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaJugadores);
	}
	public void leerArchivoSerializado() {
		listaJugadores = (ArrayList<Jugador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaJugadores == null ) {
			listaJugadores = new ArrayList<>();
		}
	}
	

}
