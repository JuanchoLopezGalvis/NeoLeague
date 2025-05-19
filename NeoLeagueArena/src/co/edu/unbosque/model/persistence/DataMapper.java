package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PartidaDTO;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;
/**
 * Clase DataMapper que se encarga de mapear los objetos DTO a entidades y viceversa.
 * Esta clase contiene métodos estáticos para convertir entre diferentes tipos de objetos.
 */
public class DataMapper {

	/**
	 * Convierte un objeto AdministradorDTO a un objeto Administrador.
	 * @param dto el objeto AdministradorDTO a convertir.
	 * @return el objeto Administrador convertido.
	 */
	public static Administrador AdministradorDTOToAdministrador(AdministradorDTO dto) {
		Administrador entity;
		entity = new Administrador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), dto.getPais(),
				dto.getUrlFoto(), dto.getCargoEspecifico());
		return entity;
	}
/**
	 * Convierte un objeto Administrador a un objeto AdministradorDTO.
	 * @param entity el objeto Administrador a convertir.
	 * @return el objeto AdministradorDTO convertido.
	 */
	public static AdministradorDTO AdministradorToAdministradorDTO(Administrador entity) {
		AdministradorDTO dto;
		dto = new AdministradorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getCargoEspecifico());
		return dto;
	}
/**
	 * Convierte una lista de objetos Administrador a una lista de objetos AdministradorDTO.
	 * @param entityList la lista de objetos Administrador a convertir.
	 * @return la lista de objetos AdministradorDTO convertida.
	 */
	public static ArrayList<AdministradorDTO> listaAdministradorToListaAdministradorDTO(
			ArrayList<Administrador> entityList) {
		ArrayList<AdministradorDTO> dtoList = new ArrayList<>();
		for (Administrador m : entityList) {
			dtoList.add(new AdministradorDTO(m.getNombre(), m.getContrasena(), m.getCorreo(), m.getEdad(), m.getPais(),
					m.getUrlFoto(), m.getCargoEspecifico()));
		}
		return dtoList;
	}

	/**
	 * Convierte una lista de objetos AdministradorDTO a una lista de objetos Administrador.
	 * @param dtoList la lista de objetos AdministradorDTO a convertir.
	 * @return la lista de objetos Administrador convertida.
	 */
	public static ArrayList<Administrador> listaAdministradorDTOToListaAdministrador(
			ArrayList<AdministradorDTO> dtoList) {
		ArrayList<Administrador> entityList = new ArrayList<>();
		for (AdministradorDTO d : dtoList) {
			entityList.add(new Administrador(d.getNombre(), d.getContrasena(), d.getCorreo(), d.getEdad(), d.getPais(),
					d.getUrlFoto(), d.getCargoEspecifico()));
		}
		return entityList;
	}

	/**
	 * Convierte un objeto EntrenadorDTO a un objeto Entrenador.
	 * @param dto el objeto EntrenadorDTO a convertir.
	 * @return el objeto Entrenador convertido.
	 */
	public static Entrenador EntrenadorDTOToEntrenador(EntrenadorDTO dto) {
		Entrenador entity;
		entity = new Entrenador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), dto.getPais(),
				dto.getUrlFoto(), dto.getTrayectoriaProfesional(), dto.getEspecialidadDeEntreno(),
				dto.getAnosDeEntrenamiento(), dto.getEquipo());
		return entity;
	}
/**
	 * Convierte un objeto Entrenador a un objeto EntrenadorDTO.
	 * @param entity el objeto Entrenador a convertir.
	 * @return el objeto EntrenadorDTO convertido.
	 */
	public static EntrenadorDTO EntrenadorToEntrenadorDTO(Entrenador entity) {
		EntrenadorDTO dto;
		dto = new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaProfesional(),
				entity.getEspecialidadDeEntreno(), entity.getAnosDeEntrenamiento(), entity.getEquipo());
		return dto;
	}
/**
	 * Convierte una lista de objetos Entrenador a una lista de objetos EntrenadorDTO.
	 * @param entityList la lista de objetos Entrenador a convertir.
	 * @return la lista de objetos EntrenadorDTO convertida.
	 */
	public static ArrayList<EntrenadorDTO> listaEntrenadorToListaEntrenadorDTO(ArrayList<Entrenador> entityList) {
		ArrayList<EntrenadorDTO> dtoList = new ArrayList<>();
		for (Entrenador entity : entityList) {
			dtoList.add(new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(),
					entity.getEdad(), entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaProfesional(),
					entity.getEspecialidadDeEntreno(), entity.getAnosDeEntrenamiento(), entity.getEquipo()));
		}
		return dtoList;
	}
/**
	 * Convierte una lista de objetos EntrenadorDTO a una lista de objetos Entrenador.
	 * @param dtoList la lista de objetos EntrenadorDTO a convertir.
	 * @return la lista de objetos Entrenador convertida.
	 */
	public static ArrayList<Entrenador> listaEntrenadorDTOToListaEntrenador(ArrayList<EntrenadorDTO> dtoList) {
		ArrayList<Entrenador> entityList = new ArrayList<>();
		for (EntrenadorDTO dto : dtoList) {
			entityList.add(new Entrenador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(),
					dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaProfesional(), dto.getEspecialidadDeEntreno(),
					dto.getAnosDeEntrenamiento(), dto.getEquipo()));
		}
		return entityList;
	}

	/**
	 * Convierte un objeto JugadorDTO a un objeto Jugador.
	 * @param dto el objeto JugadorDTO a convertir.
	 * @return el objeto Jugador convertido.
	 */
	public static Jugador JugadorDTOToJugador(JugadorDTO dto) {
		Jugador entity;
		entity = new Jugador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), dto.getPais(),
				dto.getUrlFoto(), dto.getTrayectoriaCompetitiva(), dto.getJuegoEspecialidad(),
				dto.getAnosDeExperiencia());
		return entity;
	}
/**
	 * Convierte un objeto Jugador a un objeto JugadorDTO.
	 * @param entity el objeto Jugador a convertir.
	 * @return el objeto JugadorDTO convertido.
	 */
	public static JugadorDTO JugadorToJugadorDTO(Jugador entity) {
		JugadorDTO dto;
		dto = new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaCompetitiva(),
				entity.getJuegoEspecialidad(), entity.getAnosDeExperiencia());
		return dto;
	}
/**
	 * Convierte una lista de objetos Jugador a una lista de objetos JugadorDTO.
	 * @param entityList la lista de objetos Jugador a convertir.
	 * @return la lista de objetos JugadorDTO convertida.
	 */
	public static ArrayList<JugadorDTO> listaJugadorToListaJugadorDTO(ArrayList<Jugador> entityList) {
		ArrayList<JugadorDTO> dtoList = new ArrayList<>();
		for (Jugador entity : entityList) {
			dtoList.add(new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
					entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaCompetitiva(),
					entity.getJuegoEspecialidad(), entity.getAnosDeExperiencia()));
		}
		return dtoList;
	}
/**
	 * Convierte una lista de objetos JugadorDTO a una lista de objetos Jugador.
	 * @param dtoList la lista de objetos JugadorDTO a convertir.
	 * @return la lista de objetos Jugador convertida.
	 */
	public static ArrayList<Jugador> listaJugadorDTOToListaJugador(ArrayList<JugadorDTO> dtoList) {
		ArrayList<Jugador> entityList = new ArrayList<>();
		for (JugadorDTO dto : dtoList) {
			entityList.add(new Jugador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(),
					dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaCompetitiva(), dto.getJuegoEspecialidad(),
					dto.getAnosDeExperiencia()));
		}
		return entityList;
	}
/**
	 * Convierte un objeto TorneoDTO a un objeto Torneo.
	 * @param dto el objeto TorneoDTO a convertir.
	 * @return el objeto Torneo convertido.
	 */

	public static Torneo TorneoDTOToTorneo(TorneoDTO dto) {
		Torneo entity;
		entity = new Torneo(dto.getNombre(), dto.getJuego(), dto.getFechaInicio(), dto.getFechaFin(), dto.getFormato(),
				dto.getMaxEquipos(), dto.getPremio(), dto.getListaEquiposInscritos());
		return entity;
	}
/**
	 * Convierte un objeto Torneo a un objeto TorneoDTO.
	 * @param entity el objeto Torneo a convertir.
	 * @return el objeto TorneoDTO convertido.
	 */
	public static TorneoDTO TorneoToTorneoDTO(Torneo entity) {
		TorneoDTO dto;
		dto = new TorneoDTO(entity.getNombre(), entity.getJuego(), entity.getFechaInicio(), entity.getFechaFin(),
				entity.getFormato(), entity.getMaxEquipos(), entity.getPremio(), entity.getListaEquiposInscritos());
		return dto;
	}
/**
	 * Convierte una lista de objetos Torneo a una lista de objetos TorneoDTO.
	 * @param entityList la lista de objetos Torneo a convertir.
	 * @return la lista de objetos TorneoDTO convertida.
	 */
	public static ArrayList<TorneoDTO> listaTorneoToListaTorneoDTO(ArrayList<Torneo> entityList) {
		ArrayList<TorneoDTO> dtoList = new ArrayList<>();
		for (Torneo entity : entityList) {
			dtoList.add(new TorneoDTO(entity.getNombre(), entity.getJuego(), entity.getFechaInicio(),
					entity.getFechaFin(), entity.getFormato(), entity.getMaxEquipos(), entity.getPremio(),
					entity.getListaEquiposInscritos()));
		}
		return dtoList;
	}
/**
	 * Convierte una lista de objetos TorneoDTO a una lista de objetos Torneo.
	 * @param dtoList la lista de objetos TorneoDTO a convertir.
	 * @return la lista de objetos Torneo convertida.
	 */
	public static ArrayList<Torneo> listaTorneoDTOToListaTorneo(ArrayList<TorneoDTO> dtoList) {
		ArrayList<Torneo> entityList = new ArrayList<>();
		for (TorneoDTO dto : dtoList) {
			entityList.add(new Torneo(dto.getNombre(), dto.getJuego(), dto.getFechaInicio(), dto.getFechaFin(),
					dto.getFormato(), dto.getMaxEquipos(), dto.getPremio(), dto.getListaEquiposInscritos()));
		}
		return entityList;
	}

	/**
	 * Convierte un objeto EquipoDTO a un objeto Equipo.
	 * @param dto el objeto EquipoDTO a convertir.
	 * @return el objeto Equipo convertido.
	 */
	public static Equipo EquipoDTOToEquipo(EquipoDTO dto) {
		Equipo entity;
		entity = new Equipo(dto.getNombre(), dto.getIntegrantes(), dto.getJuegoDesempeñado(), dto.getTorneosInscritos(),
				dto.getPartidasJugadas(), dto.getEntrenador(), dto.getPuntos());
		return entity;
	}
/**
	 * Convierte un objeto Equipo a un objeto EquipoDTO.
	 * @param entity el objeto Equipo a convertir.
	 * @return el objeto EquipoDTO convertido.
	 */
	public static EquipoDTO EquipoToEquipoDTO(Equipo entity) {
		EquipoDTO dto;
		dto = new EquipoDTO(entity.getNombre(), entity.getIntegrantes(), entity.getJuegoDesempeñado(),
				entity.getTorneosInscritos(), entity.getPartidasJugadas(), entity.getEntrenador(), entity.getPuntos());
		return dto;
	}
/**
	 * Convierte una lista de objetos Equipo a una lista de objetos EquipoDTO.
	 * @param entityList la lista de objetos Equipo a convertir.
	 * @return la lista de objetos EquipoDTO convertida.
	 */
	public static ArrayList<EquipoDTO> listaEquipoToListaEquipoDTO(ArrayList<Equipo> entityList) {
		ArrayList<EquipoDTO> dtoList = new ArrayList<>();
		for (Equipo entity : entityList) {
			dtoList.add(new EquipoDTO(entity.getNombre(), entity.getIntegrantes(), entity.getJuegoDesempeñado(),
					entity.getTorneosInscritos(), entity.getPartidasJugadas(), entity.getEntrenador(), entity.getPuntos()));
		}
		return dtoList;
	}
/**
	 * Convierte una lista de objetos EquipoDTO a una lista de objetos Equipo.
	 * @param dtoList la lista de objetos EquipoDTO a convertir.
	 * @return la lista de objetos Equipo convertida.
	 */
	public static ArrayList<Equipo> listaEquipoDTOToListaEquipo(ArrayList<EquipoDTO> dtoList) {
		ArrayList<Equipo> entityList = new ArrayList<>();
		for (EquipoDTO dto : dtoList) {
			entityList.add(new Equipo(dto.getNombre(), dto.getIntegrantes(), dto.getJuegoDesempeñado(),
					dto.getTorneosInscritos(), dto.getPartidasJugadas(), dto.getEntrenador(), dto.getPuntos()));
		}
		return entityList;
	}
/**
	 * Convierte un objeto PartidaDTO a un objeto Partida.
	 * @param dto el objeto PartidaDTO a convertir.
	 * @return el objeto Partida convertido.
	 */
	public static Partida PartidaDTOToPartida(PartidaDTO dto) {
		Partida entity;
		entity = new Partida(dto.getId(), dto.getEquipo1(), dto.getEquipo2(), dto.getGanador(), dto.getJuego(), dto.getFecha(),
				dto.getTorneoAlQuePertenece());
		return entity;
	}
	/**
	 * Convierte un objeto Partida a un objeto PartidaDTO.
	 * @param entity el objeto Partida a convertir.
	 * @return el objeto PartidaDTO convertido.
	 */
	public static PartidaDTO PartidaToPartidaDTO(Partida entity) {
		PartidaDTO dto;
		dto = new PartidaDTO(entity.getId(), entity.getEquipo1(), entity.getEquipo2(), entity.getGanador(), entity.getJuego(), entity.getFecha(),
				entity.getTorneoAlQuePertenece());
		return dto;
	}
	// Falta completar el DataMapper para los demas DTOs
}