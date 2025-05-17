package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;

import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PartidaDTO;

public class PartidaDAO implements OperacionDAO<PartidaDTO, Partida> {
	private ArrayList<Partida> listaPartidas;
	public PartidaDAO() {
		listaPartidas = new ArrayList<>();
	}	@Override
	public boolean showAll(JTable tabla) {
		// TODO Auto-generated method stub
		return false;
	}	@Override
	public ArrayList<PartidaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}	@Override
	public boolean add(PartidaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}	@Override
	public boolean delete(PartidaDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}	@Override
	public Partida find(Partida toFind) {
		// TODO Auto-generated method stub
		return null;
	}	@Override
	public boolean update(PartidaDTO previous, PartidaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(ArrayList<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

}
