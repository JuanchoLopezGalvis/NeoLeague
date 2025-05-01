package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;


public class DataMapper {

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

}