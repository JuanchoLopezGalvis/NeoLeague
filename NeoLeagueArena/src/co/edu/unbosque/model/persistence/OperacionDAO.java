package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;
/**
 * Interfaz OperacionDAO que define las operaciones CRUD para cualquier entidad.
 * @param <D> Tipo de dato de transferencia (DTO).
 * @param <E> Tipo de entidad.
 */
public interface OperacionDAO <D, E>{//D -> DTO || E -> Entidad
	/**
	 * Método para mostrar todos los registros en una tabla.
	 * @param tabla JTable donde se mostrarán los registros.
	 * @return true si se muestran los registros, false en caso contrario.
	 */
	public boolean showAll(JTable tabla); //mostrar todo
	/**
	 * Método para obtener todos los registros.
	 * @return una lista de registros.
	 */
	public ArrayList<D> getAll(); //mostrar todo Todito como DTO
	/**
	 * Método para agregar un nuevo registro.
	 * @param newData el nuevo registro a agregar.
	 * @return true si se agrega el registro, false en caso contrario.
	 */
	public boolean add(D newData); //ahora verifico que no haya duplicados c:
	/**
	 * Método para eliminar un registro.
	 * @param toDelete el registro a eliminar.
	 * @return true si se elimina el registro, false en caso contrario.
	 */
	public boolean delete(D toDelete); //eliminar
	/**
	 * Método para buscar un registro.
	 * @param toFind el registro a buscar.
	 * @return el registro encontrado o null si no se encuentra.
	 */
	public E find(E toFind); //to buscar; verificar si existe o no; null -> no existe
	/**
	 * Método para actualizar un registro.
	 * @param previous el registro anterior.
	 * @param newData el nuevo registro a actualizar.
	 * @return true si se actualiza el registro, false en caso contrario.
	 */
	public boolean update(D previous, D newData); //actualizarr
}
