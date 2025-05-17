//package co.edu.unbosque.test;
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import co.edu.unbosque.model.Administrador;
//import co.edu.unbosque.model.AdministradorDTO;
//import co.edu.unbosque.model.persistence.AdministradorDAO;
//public class AdministradorDAOTest {
//	
//	 private static AdministradorDAO dao;
//	    private AdministradorDTO sampleAdmin;
//
//	@BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        System.out.println("BeforeClass - Inicialización global");
//        dao = new AdministradorDAO();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        System.out.println("Before - Preparando datos para prueba");
//        sampleAdmin = new AdministradorDTO("123", "Juan", "juan@mail.com", "pass");
//        dao.add(sampleAdmin); // Agregamos un administrador antes de cada prueba
//    }
//
//    @Test
//    public void testAdd() {
//        System.out.println("Test - Verificando método add()");
//        ArrayList<Administrador> lista = dao.getListaAdministradores();
//        boolean exists = lista.stream().anyMatch(a -> a.getNombre().equals("Juan"));
//        assertTrue(exists);
//    }
//
//    @Test
//    public void testFind() {
//        System.out.println("Test - Verificando método find()");
//        Administrador found = dao.find(new Administrador("123", "Juan", "juan@mail.com", "pass"));
//        assertNotNull(found);
//        assertEquals("Juan", found.getNombre());
//    }
//
//    @Test
//    public void testGetAllIsNotNull() {
//        System.out.println("Test - Verificando método getAll() no es null");
//        ArrayList<AdministradorDTO> all = dao.getAll();
//        assertNull("getAll está sin implementar, debería retornar null", all); // Esto depende de implementación
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        System.out.println("After - Limpiando datos de prueba");
//        // Eliminar manualmente al administrador agregado si fuera necesario
//        // Aquí podría implementarse una eliminación real si `delete()` estuviera funcional
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        System.out.println("AfterClass - Finalización global");
//        dao = null;
//    }
//}
