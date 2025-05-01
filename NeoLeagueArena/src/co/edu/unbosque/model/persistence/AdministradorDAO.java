package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;

public class AdministradorDAO implements OperacionDAO<AdministradorDTO, Administrador>{
	
	private ArrayList<Administrador> listaAdministradores;
	
	public AdministradorDAO() {
		listaAdministradores = new ArrayList<Administrador>();
	}

	@Override
	public String showAll() {
		StringBuilder sb = new StringBuilder();
		if (listaAdministradores.isEmpty()) {
			sb.append("There are no registered administrators.");
		} else {
			for (Administrador admin : listaAdministradores) {
				sb.append(admin.toString()).append("\n");
			}
		}
		return sb.toString();
	}

	@Override
	public ArrayList<AdministradorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(AdministradorDTO newData) {
		if (find(DataMapper.AdministradorDTOToAdministrador(newData)) == null) {
			listaAdministradores.add(DataMapper.AdministradorDTOToAdministrador(newData));
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(AdministradorDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Administrador find(Administrador toFind) {
		for (Administrador admin : listaAdministradores) {
			if (admin.getNombre() == toFind.getNombre()) {
				return admin;
			}
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

}
