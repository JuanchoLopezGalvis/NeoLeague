package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.persistence.AdministradorDAO;

public class AdministradorDAOTest {

    static AdministradorDAO dao;
    private AdministradorDTO dto1, dto2;

    @BeforeClass
    public static void hacerAntesDeLasPruebas() {
        System.out.println("Inicialización pruebas");
        dao = new AdministradorDAO();
    }

    @Before
    public void prepararAntesDeCadaPrueba() {
        System.out.println("Preparando datos para prueba");
        dao.setListaAdministradores(new ArrayList<>());

        dto1 = new AdministradorDTO("Juan", "1234", "juan@email.com", 30, "Colombia", "foto1.jpg", "Gerente");
        dto2 = new AdministradorDTO("Ana", "5678", "ana@email.com", 28, "México", "foto2.jpg", "Subgerente");
    }

    @Test
    public void testAddAdmin() {
        System.out.println("testAddAdmin");
        boolean result = dao.add(dto1);
        assertTrue(result);
        assertEquals(1, dao.getListaAdministradores().size());
        assertEquals("Juan", dao.getListaAdministradores().get(0).getNombre());
    }

    @Test
    public void testDeleteAdmin() {
        System.out.println("testDeleteAdmin");
        dao.add(dto1);

        boolean result = dao.delete(dto1); 
        System.out.println("Resultado delete(): " + result);
        assertFalse("delete() aún no está implementado, debería retornar false", result);
    }

    @Test
    public void testDeleteNoExistentAdmin() {
        System.out.println("testDeleteNoExistentAdmin");
        boolean result = dao.delete(dto2);
        assertFalse(result);
    }

    @Test
    public void testFindAdmin() {
        System.out.println("testFindAdmin");
        dao.getListaAdministradores().add(new Administrador("Ana", "5678", "ana@email.com", 28, "México", "foto2.jpg"));
        Administrador encontrado = dao.find(new Administrador("Ana", "", "", 0, "", ""));
        assertNotNull(encontrado);
        assertEquals("Ana", encontrado.getNombre());
    }

    @Test
    public void testFindAdminNoExists() {
        System.out.println("testFindAdminNoExists");
        Administrador noExiste = new Administrador("Carlos", "", "", 0, "", "");
        Administrador resultado = dao.find(noExiste);
        assertNull(resultado);
    }

    @After
    public void limpiarDespuesDeCadaPrueba() {
        System.out.println("Limpiando después de prueba");
        dao.setListaAdministradores(new ArrayList<>());
    }

    @AfterClass
    public static void cerrarPruebas() {
        System.out.println("Finalizando pruebas");
        dao = null;
    }
}
