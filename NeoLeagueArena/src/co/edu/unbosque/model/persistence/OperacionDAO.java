package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;

public interface OperacionDAO <D, E>{//D -> DTO || E -> Entidad
	
	public boolean showAll(JTable tabla); //mostrar todo
	
	public ArrayList<D> getAll(); //mostrar todo Todito como DTO
	
	public boolean add(D newData); //ahora verifico que no haya duplicados c:
	
	public boolean delete(D toDelete); //eliminar
	
	public E find(E toFind); //to buscar; verificar si existe o no; null -> no existe
	
	public boolean update(D previous, D newData); //actualizarr


}
