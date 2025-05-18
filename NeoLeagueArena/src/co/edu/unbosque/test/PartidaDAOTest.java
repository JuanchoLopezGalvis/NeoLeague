package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.PartidaDAO;

public class PartidaDAOTest {

    private static PartidaDAO dao;
    static PartidaDTO dto;
    static Partida entidad;
//restore
    @BeforeClass
    public static void hacerAntesdelaspruevas()  {
        System.out.println("Inicialización todas las pruebas");
        dao = new PartidaDAO();
    }

    @Before
    public void hcerAntesDeCadaPrueba() {
        System.out.println("empezando prueba individual");

       
        Equipo eq1 = new Equipo("Equipo A", null);
        Equipo eq2 = new Equipo("Equipo B", null);
        Torneo torneo = new Torneo("Torneo X", null, null, null, null,0,0);

        Partida partida = new Partida(1, eq1, eq2, eq1, "League of Legends", new Date(), torneo);
        entidad = partida;

        dto = new PartidaDTO(1, "Equipo A", "Equipo B", "Equipo A", "League of Legends", new Date(), "Torneo X");

        dao.add(dto);  
    }

    @Test
    public void testAdd() {
        System.out.println(" Verificando método add()");
        boolean result = dao.add(dto);
        assertFalse("no implementado, debería retornar false", result);
    }

    @Test
    public void testFind() {
        System.out.println(" Verificando método");
        Partida found = dao.find(entidad);
        assertNull(" no implementado, debería retornar null", found);
    }

    @Test
    public void testGetAll() {
        System.out.println("Verificando método getAll()");
        ArrayList<PartidaDTO> all = dao.getAll();
        assertNull("no implementado, debería retornar null", all);
    }

    @Test
    public void testDelete() {
        System.out.println(" Verificando método delete()");
        boolean deleted = dao.delete(dto);
        assertFalse("delete() no implementado, debería retornar false", deleted);
    }

    @Test
    public void testUpdate() {
        System.out.println(" Verificando método update()");
        PartidaDTO updatedDTO = new PartidaDTO( 1, "Equipo A", "Equipo B", "Equipo A", "League of Legends", new Date(), "Torneo X");
        boolean result = dao.update(dto, updatedDTO);
        assertFalse(" no implementado, debería retornar false", result);
    }

    @After
    public void hacerDespuesDeCadaPrueba(){
        System.out.println("Finalizando prueba");
    }

    @AfterClass
    public static void hacerDespuesDeTodo(){
        System.out.println("Finalización todas las pruebas");
        dao = null;
    }
}
