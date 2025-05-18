package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;

public class EntrenadorDAOTest {

    private static EntrenadorDAO dao;
    private EntrenadorDTO dto1,dto2;

    @BeforeClass
    public static void hacerAntesdelaspruevas() {
        System.out.println("Iniciando todas las pruebas");
        dao = new EntrenadorDAO();
    }

  

    @Before
    public void hcerAntesDeCadaPrueba() {
        System.out.println("Iniciando prueba individual");

        dao.setListaEntrenadores(new ArrayList<>());

        dto1 = new EntrenadorDTO("Juan", "1234", "juan@example.com", 30, "Colombia",
                "foto1.jpg", "corta", "fifa", 10);

        dto2 = new EntrenadorDTO("Ana", "abcd", "ana@example.com", 28, "Chile",
                "foto2.jpg", "amplia", "formula 1", 6);
    }

  

    @Test
    public void testAddCoach() {
        System.out.println("testAddCoach");
        boolean result = dao.add(dto1);
        assertTrue(result);
        assertEquals(1, dao.getListaEntrenadores().size());
        assertEquals("Juan", dao.getListaEntrenadores().get(0).getNombre());
    }

    @Test
    public void testDeleteCoach() {
        System.out.println("testDeleteCoach");
        dao.add(dto1);
        boolean result = dao.delete(dto1);
        assertTrue(result);
        assertTrue(dao.getListaEntrenadores().isEmpty());
    }

    @Test
    public void testDeleteNoExistentCoach() {
        System.out.println("testDeleteNonExistentCoach");
        boolean result = dao.delete(dto2);
        assertFalse(result);
    }

    @Test
    public void testFindCoach() {
        System.out.println("testFindCoach");
        dao.add(dto2);
        Entrenador toFind = new Entrenador();
        toFind.setNombre("Ana");
        Entrenador found = dao.find(toFind);
        assertNotNull(found);
        assertEquals("Ana", found.getNombre());
    }

    @Test
    public void testFindCoachNoExists() {
        System.out.println("testFindCoachNotExists");
        Entrenador toFind = new Entrenador();
        toFind.setNombre("Carlos");
        Entrenador found = dao.find(toFind);
        assertNull(found);
    }
    @After
    public void hacerDespuesDeCadaPrueba() {
        System.out.println("terminada la prueba");
        dao.setListaEntrenadores(new ArrayList<>());
    }
    
    @AfterClass
    public static void hacerDespuesDeTodo() {
        System.out.println("Finaliza las pruebas");
        dao.setListaEntrenadores(new ArrayList<>());
    }
}