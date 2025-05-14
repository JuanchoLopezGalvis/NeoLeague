package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Jugador;

public class EntrenadorDAO implements OperacionDAO<EntrenadorDTO, Entrenador>{
	
	private ArrayList<Entrenador> listaEntrenadores;
	private final String TEXT_FILE_NAME = "coach.csv";
	private final String SERIAL_FILE_NAME = "coach.dat";
	
	public EntrenadorDAO() {
		listaEntrenadores = new ArrayList<Entrenador>();
		leerArchivoSerializado();
	}

	@Override
	public boolean showAll(JTable table) {
		if (listaEntrenadores.isEmpty()) {
			return false;
		}else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);
			for (Entrenador entrenador : listaEntrenadores) {
				ImageIcon icon = FileManager.graficarImagen(entrenador.getUrlFoto(), 80, 80);
				Object[] row = {entrenador.getNombre(), entrenador.getContrasena(), entrenador.getCorreo(), entrenador.getEdad(), entrenador.getPais(), entrenador.getTrayectoriaProfesional(), entrenador.getEspecialidadDeEntreno(), entrenador.getAnosDeEntrenamiento(), icon};
				modelo.addRow(row);
			}
		}
		return false;
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
				}else {
					continue;
				}
			}
			return found;
		}
		return null;
	}
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
		if (listaEntrenadores == null ) {
			listaEntrenadores = new ArrayList<>();			
		}
		
	}

	

}
