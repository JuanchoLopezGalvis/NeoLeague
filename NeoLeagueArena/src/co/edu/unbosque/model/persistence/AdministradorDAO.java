package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;

/**
 * Clase AdministradorDAO que implementa la interfaz OperacionDAO.
 * Esta clase se encarga de realizar operaciones CRUD sobre los administradores.
 */
public class AdministradorDAO implements OperacionDAO<AdministradorDTO, Administrador>{
	/**
	 * Este atributo es el nombre del archivo de texto donde se guardan los administradores.
	 */
	private final String TEXT_FILE_NAME = "admin.csv";
	/**
	 * Este atributo es el nombre del archivo serializado donde se guardan los administradores.
	 */
	private final String SERIAL_FILE_NAME = "admin.dat";
	/**
	 * Este atributo es una lista de administradores.
	 */
	private ArrayList<Administrador> listaAdministradores;
	/**
	 * Constructor de la clase {@link AdministradorDAO}.
	 * Inicializa la lista de administradores y carga los datos desde el archivo serializado.
	 */
	public AdministradorDAO() {
		listaAdministradores = new ArrayList<>();
		leerArchivoSerializado();
	}
	/**
	 * Método que muestra todos los administradores en una tabla.
	 * @param tabla JTable donde se mostrarán los administradores.
	 * @return true si se muestran los administradores, false en caso contrario.
	 */
	@Override
	public boolean showAll(JTable tabla) {
		return false;
	}
	/**
	 * Método que obtiene todos los administradores.
	 * @return una lista de administradores.
	 */
	@Override
	public ArrayList<AdministradorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Método que agrega un nuevo administrador a la lista y lo guarda en el archivo.
	 * @param newData el nuevo administrador a agregar.
	 * @return true si se agrega el administrador, false en caso contrario.
	 */
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
		return true;
	}

	@Override
	public Administrador find(Administrador toFind) {
		Administrador found = null;
		if (toFind == null) {
			System.out.println("El objeto a buscar es nulo");
			return null;
		}
		if (!listaAdministradores.isEmpty()) {
			for (Administrador admin : listaAdministradores) {
				if (admin.getNombre().equals(toFind.getNombre())) {
					found = admin;
					break;
				}else {
					continue;
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
