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
    public void hcerAntesDeCadaPrueba() throws Exception {
        System.out.println("Preparando datos para prueba");
        dto = new AdministradorDTO( );
        dao.add(dto); 
    }

    @Test
    public void testAdd() {
        System.out.println("Verificando método add");
        ArrayList<Administrador> lista = dao.getListaAdministradores();
        boolean exists = lista.stream().anyMatch(a -> a.getNombre().equals("Juan"));
        assertTrue(exists);
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

    @After
    public void hacerDespuesDeCadaPrueba() throws Exception {
        System.out.println("Terminando prueba");
        
    }

    @AfterClass
    public static void hacerDespuesDeTodo() throws Exception {
        System.out.println("Finalizando prueba");
        dao = null;
    }
}
