package co.edu.unbosque.model.persistence;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;

public class JugadorDAO implements OperacionDAO<JugadorDTO, Jugador> {

	private final String TEXT_FILE_NAME = "gamer.csv";
	private final String SERIAL_FILE_NAME = "gamer.dat";
	private ArrayList<Jugador> listaJugadores;

	public JugadorDAO() {
		listaJugadores = new ArrayList<>();
		leerArchivoSerializado();
	}
	@Override
	public boolean showAll(JTable table) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		if (listaJugadores.isEmpty()) {
			modelo.setRowCount(0);
			return false;
		}else {
			modelo.setRowCount(0);
			for (Jugador jugador : listaJugadores) {
				ImageIcon icon = FileManager.graficarImagen(jugador.getUrlFoto(), 80, 80);
				Object[] row = {jugador.getNombre(), jugador.getContrasena(), jugador.getCorreo(), jugador.getEdad(), jugador.getPais(), jugador.getTrayectoriaCompetitiva(), jugador.getJuegoEspecialidad(), jugador.getAnosDeExperiencia(), icon};
				modelo.addRow(row);
			}
		}
		return true;
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
		Jugador jugador = find(DataMapper.JugadorDTOToJugador(toDelete));
		if (jugador != null) {
			listaJugadores.remove(jugador);
			escribirArchivoTxt();
			escribirArchivoSerializado();
			return true;
		}
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
	public void showOne(JTable table, Jugador toShow, String mensaje) {
		Jugador jugador = find(toShow);
		if (jugador != null) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			ImageIcon icon = FileManager.graficarImagen(jugador.getUrlFoto(), 80, 80);
			Object[] row = {jugador.getNombre(), jugador.getContrasena(), jugador.getCorreo(), jugador.getEdad(), jugador.getPais(), jugador.getTrayectoriaCompetitiva(), jugador.getJuegoEspecialidad(), jugador.getAnosDeExperiencia(), icon};
			modelo.addRow(row);
		}else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			Object[] row = {mensaje};
			modelo.addRow(row);
		}
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
