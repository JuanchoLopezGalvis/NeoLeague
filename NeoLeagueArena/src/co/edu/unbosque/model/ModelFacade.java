package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.JugadorDAO;
import co.edu.unbosque.model.persistence.PartidaDAO;
import co.edu.unbosque.model.persistence.TorneoDAO;

/**
 * La clase {@link ModelFacade} es la fachada del modelo, que se encarga de crear cada uno de los DAO del aplicativo.
 */
public class ModelFacade {
	
	/**
	 * {@link JugadorDAO} es el data access object que se encarga de manejar el acceso a los datos de los jugadores.
	 */
	private JugadorDAO jdao;
	/**
	 * {@link EntrenadorDAO} es el data access object que se encarga de manejar el acceso a los datos de los entrenadores.
	 */
	private EntrenadorDAO edao;
	/**
	 * {@link AdministradorDAO} es el data access object que se encarga de manejar el acceso a los datos de los administradores.
	 */
	private AdministradorDAO adao;
	/**
	 * {@link PartidaDAO} es el data access object que se encarga de manejar el acceso a los datos de las partidas.
	 */
	private PartidaDAO pdao;
	/**
	 * {@link TorneoDAO} es el data access object que se encarga de manejar el acceso a los datos de los torneos.
	 */
	private TorneoDAO tdao;
	/**
	 * {@link EquipoDAO} es el data access object que se encarga de manejar el acceso a los datos de los equipos.
	 */
	private EquipoDAO eqdao;
	
	/**
	 * Constructor de la clase {@link ModelFacade} que inicializa los data access object.
	 */
	public ModelFacade() {
		jdao = new JugadorDAO();
		edao = new EntrenadorDAO();
		adao = new AdministradorDAO();
		pdao = new PartidaDAO();
		tdao = new TorneoDAO();
		eqdao = new EquipoDAO();
	}

	/**
	 * Metodo que retorna el data access object de los jugadores.
	 * @return {@link JugadorDAO} el data access object de los jugadores.
	 */
	public JugadorDAO getJdao() {
		return jdao;
	}

	/**
	 * Metodo que setea el data access object de los jugadores.
	 * @param jdao {@link JugadorDAO} el data access object de los jugadores.
	 */
	public void setJdao(JugadorDAO jdao) {
		this.jdao = jdao;
	}

	/**
	 * Metodo que retorna el data access object de los entrenadores.
	 * @return {@link EntrenadorDAO} el data access object de los entrenadores.
	 */
	public EntrenadorDAO getEdao() {
		return edao;
	}

	/**
	 * Metodo que setea el data access object de los entrenadores.
	 * @param edao {@link EntrenadorDAO} el data access object de los entrenadores.
	 */
	public void setEdao(EntrenadorDAO edao) {
		this.edao = edao;
	}

	/**
	 * Metodo que retorna el data access object de los administradores.
	 * @return {@link AdministradorDAO} el data access object de los administradores.
	 */
	public AdministradorDAO getAdao() {
		return adao;
	}

	/**
	 * Metodo que setea el data access object de los administradores.
	 * @param adao {@link AdministradorDAO} el data access object de los administradores.
	 */
	public void setAdao(AdministradorDAO adao) {
		this.adao = adao;
	}

	/**
	 * Metodo que retorna el data access object de las partidas.
	 * @return {@link PartidaDAO} el data access object de las partidas.
	 */
	public PartidaDAO getPdao() {
		return pdao;
	}

	/**
	 * Metodo que setea el data access object de las partidas.
	 * @param pdao {@link PartidaDAO} el data access object de las partidas.
	 */
	public void setPdao(PartidaDAO pdao) {
		this.pdao = pdao;
	}

	/**
	 * Metodo que retorna el data access object de los torneos.
	 * @return {@link TorneoDAO} el data access object de los torneos.
	 */
	public TorneoDAO getTdao() {
		return tdao;
	}

	/**
	 * Metodo que setea el data access object de los torneos.
	 * @param tdao {@link TorneoDAO} el data access object de los torneos.
	 */
	public void setTdao(TorneoDAO tdao) {
		this.tdao = tdao;
	}

	/**
	 * Metodo que retorna el data access object de los equipos.
	 * @return {@link EquipoDAO} el data access object de los equipos.
	 */
	public EquipoDAO getEqdao() {
		return eqdao;
	}

	/**
	 * Metodo que setea el data access object de los equipos.
	 * @param eqdao {@link EquipoDAO} el data access object de los equipos.
	 */
	public void setEqdao(EquipoDAO eqdao) {
		this.eqdao = eqdao;
	}
	
	
	
	

}
