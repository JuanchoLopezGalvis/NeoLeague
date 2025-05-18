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
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;

public class DataMapper {

	// Administrador
	public static Administrador AdministradorDTOToAdministrador(AdministradorDTO dto) {
		Administrador entity;
		entity = new Administrador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), dto.getPais(),
				dto.getUrlFoto(), dto.getCargoEspecifico());
		return entity;
	}

	public static AdministradorDTO AdministradorToAdministradorDTO(Administrador entity) {
		AdministradorDTO dto;
		dto = new AdministradorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getCargoEspecifico());
		return dto;
	}

	public static ArrayList<AdministradorDTO> listaAdministradorToListaAdministradorDTO(
			ArrayList<Administrador> entityList) {
		ArrayList<AdministradorDTO> dtoList = new ArrayList<>();
		for (Administrador m : entityList) {
			dtoList.add(new AdministradorDTO(m.getNombre(), m.getContrasena(), m.getCorreo(), m.getEdad(), m.getPais(),
					m.getUrlFoto(), m.getCargoEspecifico()));
		}
		return dtoList;
	}

	public static ArrayList<Administrador> listaAdministradorDTOToListaAdministrador(
			ArrayList<AdministradorDTO> dtoList) {
		ArrayList<Administrador> entityList = new ArrayList<>();
		for (AdministradorDTO d : dtoList) {
			entityList.add(new Administrador(d.getNombre(), d.getContrasena(), d.getCorreo(), d.getEdad(), d.getPais(),
					d.getUrlFoto(), d.getCargoEspecifico()));
		}
		return entityList;
	}

	// Entrenador
	public static Entrenador EntrenadorDTOToEntrenador(EntrenadorDTO dto) {
		Entrenador entity;
		entity = new Entrenador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), dto.getPais(),
				dto.getUrlFoto(), dto.getTrayectoriaProfesional(), dto.getEspecialidadDeEntreno(),
				dto.getAnosDeEntrenamiento(), dto.getEquipo());
		return entity;
	}

	public static EntrenadorDTO EntrenadorToEntrenadorDTO(Entrenador entity) {
		EntrenadorDTO dto;
		dto = new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaProfesional(),
				entity.getEspecialidadDeEntreno(), entity.getAnosDeEntrenamiento(), entity.getEquipo());
		return dto;
	}

	public static ArrayList<EntrenadorDTO> listaEntrenadorToListaEntrenadorDTO(ArrayList<Entrenador> entityList) {
		ArrayList<EntrenadorDTO> dtoList = new ArrayList<>();
		for (Entrenador entity : entityList) {
			dtoList.add(new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(),
					entity.getEdad(), entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaProfesional(),
					entity.getEspecialidadDeEntreno(), entity.getAnosDeEntrenamiento(), entity.getEquipo()));
		}
		return dtoList;
	}

	public static ArrayList<Entrenador> listaEntrenadorDTOToListaEntrenador(ArrayList<EntrenadorDTO> dtoList) {
		ArrayList<Entrenador> entityList = new ArrayList<>();
		for (EntrenadorDTO dto : dtoList) {
			entityList.add(new Entrenador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(),
					dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaProfesional(), dto.getEspecialidadDeEntreno(),
					dto.getAnosDeEntrenamiento(), dto.getEquipo()));
		}
		return entityList;
	}

	// Gamer
	public static Jugador JugadorDTOToJugador(JugadorDTO dto) {
		Jugador entity;
		entity = new Jugador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), dto.getPais(),
				dto.getUrlFoto(), dto.getTrayectoriaCompetitiva(), dto.getJuegoEspecialidad(),
				dto.getAnosDeExperiencia());
		return entity;
	}

	public static JugadorDTO JugadorToJugadorDTO(Jugador entity) {
		JugadorDTO dto;
		dto = new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaCompetitiva(),
				entity.getJuegoEspecialidad(), entity.getAnosDeExperiencia());
		return dto;
	}

	public static ArrayList<JugadorDTO> listaJugadorToListaJugadorDTO(ArrayList<Jugador> entityList) {
		ArrayList<JugadorDTO> dtoList = new ArrayList<>();
		for (Jugador entity : entityList) {
			dtoList.add(new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
					entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaCompetitiva(),
					entity.getJuegoEspecialidad(), entity.getAnosDeExperiencia()));
		}
		return dtoList;
	}

	public static ArrayList<Jugador> listaJugadorDTOToListaJugador(ArrayList<JugadorDTO> dtoList) {
		ArrayList<Jugador> entityList = new ArrayList<>();
		for (JugadorDTO dto : dtoList) {
			entityList.add(new Jugador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(),
					dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaCompetitiva(), dto.getJuegoEspecialidad(),
					dto.getAnosDeExperiencia()));
		}
		return entityList;
	}

	// Torneo
	public static Torneo TorneoDTOToTorneo(TorneoDTO dto) {
		Torneo entity;
		entity = new Torneo(dto.getNombre(), dto.getJuego(), dto.getFechaInicio(), dto.getFechaFin(), dto.getFormato(),
				dto.getMaxEquipos(), dto.getPremio(), dto.getListaEquiposInscritos());
		return entity;
	}

	public static TorneoDTO TorneoToTorneoDTO(Torneo entity) {
		TorneoDTO dto;
		dto = new TorneoDTO(entity.getNombre(), entity.getJuego(), entity.getFechaInicio(), entity.getFechaFin(),
				entity.getFormato(), entity.getMaxEquipos(), entity.getPremio(), entity.getListaEquiposInscritos());
		return dto;
	}

	public static ArrayList<TorneoDTO> listaTorneoToListaTorneoDTO(ArrayList<Torneo> entityList) {
		ArrayList<TorneoDTO> dtoList = new ArrayList<>();
		for (Torneo entity : entityList) {
			dtoList.add(new TorneoDTO(entity.getNombre(), entity.getJuego(), entity.getFechaInicio(),
					entity.getFechaFin(), entity.getFormato(), entity.getMaxEquipos(), entity.getPremio(),
					entity.getListaEquiposInscritos()));
		}
		return dtoList;
	}

	public static ArrayList<Torneo> listaTorneoDTOToListaTorneo(ArrayList<TorneoDTO> dtoList) {
		ArrayList<Torneo> entityList = new ArrayList<>();
		for (TorneoDTO dto : dtoList) {
			entityList.add(new Torneo(dto.getNombre(), dto.getJuego(), dto.getFechaInicio(), dto.getFechaFin(),
					dto.getFormato(), dto.getMaxEquipos(), dto.getPremio(), dto.getListaEquiposInscritos()));
		}
		return entityList;
	}

	// Equipo
	public static Equipo EquipoDTOToEquipo(EquipoDTO dto) {
		Equipo entity;
		entity = new Equipo(dto.getNombre(), dto.getIntegrantes(), dto.getJuegoDesempeñado(), dto.getTorneosInscritos(),
				dto.getPartidasJugadas(), dto.getEntrenador(), dto.getPuntos());
		return entity;
	}

	public static EquipoDTO EquipoToEquipoDTO(Equipo entity) {
		EquipoDTO dto;
		dto = new EquipoDTO(entity.getNombre(), entity.getIntegrantes(), entity.getJuegoDesempeñado(),
				entity.getTorneosInscritos(), entity.getPartidasJugadas(), entity.getEntrenador(), entity.getPuntos());
		return dto;
	}

	public static ArrayList<EquipoDTO> listaEquipoToListaEquipoDTO(ArrayList<Equipo> entityList) {
		ArrayList<EquipoDTO> dtoList = new ArrayList<>();
		for (Equipo entity : entityList) {
			dtoList.add(new EquipoDTO(entity.getNombre(), entity.getIntegrantes(), entity.getJuegoDesempeñado(),
					entity.getTorneosInscritos(), entity.getPartidasJugadas(), entity.getEntrenador(), entity.getPuntos()));
		}
		return dtoList;
	}

	public static ArrayList<Equipo> listaEquipoDTOToListaEquipo(ArrayList<EquipoDTO> dtoList) {
		ArrayList<Equipo> entityList = new ArrayList<>();
		for (EquipoDTO dto : dtoList) {
			entityList.add(new Equipo(dto.getNombre(), dto.getIntegrantes(), dto.getJuegoDesempeñado(),
					dto.getTorneosInscritos(), dto.getPartidasJugadas(), dto.getEntrenador(), dto.getPuntos()));
		}
		return entityList;
	}

	// Falta completar el DataMapper para los demas DTOs
}