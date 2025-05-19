package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;

import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PartidaDTO;

/**
 * PartidaDAO is a class that implements the OperacionDAO interface for the
 * Partida entity.
 * 
 * @author Juan Pablo Garcia
 * @version 1.0
 */
public class PartidaDAO implements OperacionDAO<PartidaDTO, Partida> {
	private ArrayList<Partida> listaPartidas;
	public PartidaDAO() {
		listaPartidas = new ArrayList<>();
	}/**
 * This method is used to show all the data in the JTable.
 * 
 * @param tabla the JTable to show the data in
 * @return true if the data is shown successfully, false otherwise
 * 
 */	@Override
	public boolean showAll(JTable tabla) {
		// TODO Auto-generated method stub
		return false;
	}/**
 * This method is used to get all the data from the database.
 * 
 * @return an ArrayList of PartidaDTO objects
 * 
 */	@Override
	public ArrayList<PartidaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}/**
 * This method is used to add a new PartidaDTO object to the database.
 * 
 * @param newData the PartidaDTO object to add
 */	@Override
	public boolean add(PartidaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * This method is used to delete a PartidaDTO object from the database.
	 * 
	 * @param toDelete the PartidaDTO object to delete
	 * @return true if the object is deleted successfully, false otherwise
	 */	@Override
	public boolean delete(PartidaDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * This method is used to find a PartidaDTO object in the database.
	 * 
	 * @param toFind the PartidaDTO object to find
	 * @return the PartidaDTO object if found, null otherwise
	 */	@Override
	public Partida find(Partida toFind) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * This method is used to update a PartidaDTO object in the database.
	 * 
	 * @param previous the previous PartidaDTO object
	 * @param newData  the new PartidaDTO object
	 * @return true if the object is updated successfully, false otherwise
	 */	@Override
	public boolean update(PartidaDTO previous, PartidaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}
/**
	 * This method is used to get the list of Partida objects.
	 * 
	 * @return an ArrayList of Partida objects
	 */
	public ArrayList<Partida> getListaPartidas() {
		return listaPartidas;
	}
/**
 * este metodo es usado para setear la lista de partidas
 * 
 * @param listaPartidas
 */
	public void setListaPartidas(ArrayList<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

}
