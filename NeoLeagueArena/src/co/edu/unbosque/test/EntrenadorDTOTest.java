package co.edu.unbosque.test;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.EntrenadorDTO;

public class EntrenadorDTOTest {

    private static EntrenadorDTO entrenador;

   
    

    
    @Before
    public void setUp() throws Exception {
        System.out.println("Creando entrenador de prueba");
        entrenador = new EntrenadorDTO("Juan", "1234", "juan@mail.com", 30, "Colombia", "foto.jpg",
                                        "Ex jugador profesional", "FPS", 10);
    }

    @Test
    public void testConstructorConParametros() {
        System.out.println("Constructor Con Parametros");
        assertEquals("Ex jugador profesional", entrenador.getTrayectoriaProfesional());
        assertEquals("FPS", entrenador.getEspecialidadDeEntreno());
        assertEquals(10, entrenador.getAnosDeEntrenamiento());
        System.out.println("OK");
    }

    @Test
    public void testObtenerInfo() {
        System.out.println("Basicos");
        entrenador.setTrayectoriaProfesional("Nueva trayectoria");
        entrenador.setEspecialidadDeEntreno("MOBA");
        entrenador.setAnosDeEntrenamiento(5);

        assertEquals("Nueva trayectoria", entrenador.getTrayectoriaProfesional());
        assertEquals("MOBA", entrenador.getEspecialidadDeEntreno());
        assertEquals(5, entrenador.getAnosDeEntrenamiento());
        System.out.println("OK");
    }

    @Test
    public void testToStringIncluyeCampos() {
        System.out.println(" testToStringIncluyeCampos");
        String s = entrenador.toString();
        assertTrue(s.contains("Ex jugador profesional") || s.contains("Nueva trayectoria"));
        assertTrue(s.contains("FPS") || s.contains("MOBA"));
        assertTrue(s.contains("10") || s.contains("5"));
        System.out.println(" incluye datos");
    }

   

    @AfterClass
    public static void finComprobacion() {
        System.out.println("Fin de Test");
    }
}
