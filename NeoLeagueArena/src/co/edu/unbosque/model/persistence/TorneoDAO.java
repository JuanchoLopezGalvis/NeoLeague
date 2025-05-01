package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;

public class TorneoDAO implements OperacionDAO<TorneoDTO, Torneo> {
	private ArrayList<Torneo> listaTorneos;
	public TorneoDAO() {
		listaTorneos = new ArrayList<Torneo>();
	}
	@Override
	public String showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TorneoDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(TorneoDTO newData) {
		// TODO Auto-generated method stub
		return false;
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
	


}
