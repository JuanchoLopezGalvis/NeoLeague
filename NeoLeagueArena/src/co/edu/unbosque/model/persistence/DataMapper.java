package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;


public class DataMapper {

	//Administrador
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

	public static ArrayList<Administrador> listaAdministradorDTOToListaAdministrador
	(ArrayList<AdministradorDTO> dtoList){
		ArrayList<Administrador> entityList = new ArrayList<>();
		for (AdministradorDTO d : dtoList) {
			entityList.add(new Administrador(d.getNombre(), d.getContrasena(), d.getCorreo(), d.getEdad(), d.getPais(),
					d.getUrlFoto(), d.getCargoEspecifico()));
		}
		return entityList;
	}

	//Entrenador
	public static Entrenador EntrenadorDTOToEntrenador(EntrenadorDTO dto) {
		Entrenador entity;
		entity = new Entrenador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(),
				dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaProfesional(), dto.getEspecialidadDeEntreno(),
				dto.getAnosDeEntrenamiento());
		return entity;
	}

	public static EntrenadorDTO EntrenadorToEntrenadorDTO(Entrenador entity) {
		EntrenadorDTO dto;
		dto = new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaProfesional(), entity.getEspecialidadDeEntreno(),
				entity.getAnosDeEntrenamiento());
		return dto;
	}

	public static ArrayList<EntrenadorDTO> listaEntrenadorToListaEntrenadorDTO(
			ArrayList<Entrenador> entityList) {
		ArrayList<EntrenadorDTO> dtoList = new ArrayList<>();
		for (Entrenador entity : entityList) {
			dtoList.add(new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
					entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaProfesional(), entity.getEspecialidadDeEntreno(),
					entity.getAnosDeEntrenamiento()));
		}
		return dtoList;
	}

	public static ArrayList<Entrenador> listaEntrenadorDTOToListaEntrenador
	(ArrayList<EntrenadorDTO> dtoList){
		ArrayList<Entrenador> entityList = new ArrayList<>();
		for (EntrenadorDTO dto : dtoList) {
			entityList.add(new Entrenador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), 
					dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaProfesional(), dto.getEspecialidadDeEntreno(),
					dto.getAnosDeEntrenamiento()));
		}
		return entityList;
	}
	
	//Gamer
	public static Jugador JugadorDTOToJugador(JugadorDTO dto) {
		Jugador entity;
		entity = new Jugador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(),
				dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaCompetitiva(), dto.getJuegoEspecialidad(),
				dto.getAnosDeExperiencia());
		return entity;
	}
	public static JugadorDTO JugadorToJugadorDTO(Jugador entity) {
		JugadorDTO dto;
		dto = new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
				entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaCompetitiva(), entity.getJuegoEspecialidad(),
				entity.getAnosDeExperiencia());
		return dto;
	}
	public static ArrayList<JugadorDTO> listaJugadorToListaJugadorDTO(
			ArrayList<Jugador> entityList) {
		ArrayList<JugadorDTO> dtoList = new ArrayList<>();
		for (Jugador entity : entityList) {
			dtoList.add(new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEdad(),
					entity.getPais(), entity.getUrlFoto(), entity.getTrayectoriaCompetitiva(), entity.getJuegoEspecialidad(),
					entity.getAnosDeExperiencia()));
		}
		return dtoList;
	}	
	public static ArrayList<Jugador> listaJugadorDTOToListaJugador
	(ArrayList<JugadorDTO> dtoList){
		ArrayList<Jugador> entityList = new ArrayList<>();
		for (JugadorDTO dto : dtoList) {
			entityList.add(new Jugador(dto.getNombre(), dto.getContrasena(), dto.getCorreo(), dto.getEdad(), 
					dto.getPais(), dto.getUrlFoto(), dto.getTrayectoriaCompetitiva(), dto.getJuegoEspecialidad(),
					dto.getAnosDeExperiencia()));
		}
		return entityList;
	}
	
	
	
	
	

	//Falta completar el DataMapper para los demas DTOs
}