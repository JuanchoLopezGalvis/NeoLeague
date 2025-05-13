package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;

public class AdministradorDAO implements OperacionDAO<AdministradorDTO, Administrador>{

	private final String TEXT_FILE_NAME = "admin.csv";
	private final String SERIAL_FILE_NAME = "admin.dat";
	private ArrayList<Administrador> listaAdministradores;

	public AdministradorDAO() {
		listaAdministradores = new ArrayList<Administrador>();
		leerArchivoSerializado();
	}

	@Override
	public boolean showAll(JTable tabla) {
		StringBuilder sb = new StringBuilder();
		if (listaAdministradores.isEmpty()) {
			sb.append("There are no registered administrators.");
		} else {
			for (Administrador admin : listaAdministradores) {
				sb.append(admin.toString()).append("\n");
			}
		}
		return false;
	}

	@Override
	public ArrayList<AdministradorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(AdministradorDTO newData) {
		listaAdministradores.add(DataMapper.AdministradorDTOToAdministrador(newData));
		escribirArchivoTxt();
		escribirArchivoSerializado();
		return true;
	}

	@Override
	public boolean delete(AdministradorDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Administrador find(Administrador toFind) {
		Administrador found = null;
		if (!listaAdministradores.isEmpty()) {
			for (Administrador admin : listaAdministradores) {
				if (admin.getNombre().equals(toFind.getNombre())) {
					found = admin;
					break;
				}
			}
			return found;
		}
		return null;
	}

	@Override
	public boolean update(AdministradorDTO previous, AdministradorDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}
	
	public void escribirArchivoTxt() {
		StringBuilder contenido = new StringBuilder();
		for (Administrador admin : listaAdministradores) {
			contenido.append(admin.toString());
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaAdministradores);
	}
	public void leerArchivoSerializado() {
		listaAdministradores = (ArrayList<Administrador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaAdministradores == null ) {
			listaAdministradores = new ArrayList<>();			
		}
	}

}
