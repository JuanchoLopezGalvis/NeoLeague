package co.edu.unbosque.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.persistence.AdministradorDAO;
public class AdministradorDAOTest {

	 static AdministradorDAO dao;
	 static AdministradorDTO dto;

	@BeforeClass
    public static void hacerAntesdelaspruevas() {
        System.out.println("Inicialización pruebas");
        dao = new AdministradorDAO();
    }

    @Before
    public void hcerAntesDeCadaPrueba() {
        System.out.println("Preparando datos para prueba");
        dto = new AdministradorDTO( );
        dao.add(dto); 
    }

  

    @Test
    public void testFind() {
        System.out.println("Verificando método find");
        Administrador found = dao.find(new Administrador());
        assertNotNull(found);
        assertEquals("Juan", found.getNombre());
    }

    @Test
    public void testGetAllNoNull() {
        System.out.println("Verificando método getAll no es null");
        ArrayList<AdministradorDTO> all = dao.getAll();
        assertNull("getAll está sin implementar, debería retornar null", all); 
    }


    @AfterClass
    public static void hacerDespuesDeTodo() {
        System.out.println("Finalizando prueba");
        dao = null;
    }
}
