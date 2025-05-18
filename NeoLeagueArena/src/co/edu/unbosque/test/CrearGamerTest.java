package co.edu.unbosque.test;

import static org.junit.Assert.*;
import org.junit.*;

import javax.swing.*;

import co.edu.unbosque.view.CrearGamer;

public class CrearGamerTest {

    private static CrearGamer crearGamer;

    @BeforeClass
    public static void hacerAntesdelaspruevas() {
        System.out.println("Iniciando todas las pruebas de CrearGamer");
        crearGamer = new CrearGamer();
    }

    @Before
    public void hcerAntesDeCadaPrueba() {
        crearGamer.getDatoNombre().setText("");
        crearGamer.getDatoCorreo().setText("");
        crearGamer.getDatoContrasena().setText("");
        crearGamer.getDatoContrasenaConf().setText("");
        crearGamer.getDatoEdad().setValue(0);
    }

    @Test
    public void testComponentesNoNulos() {
        assertNotNull("Campo nombre es nulo", crearGamer.getDatoNombre());
        assertNotNull("Campo correo es nulo", crearGamer.getDatoCorreo());
        assertNotNull("Campo contraseña es nulo", crearGamer.getDatoContrasena());
        assertNotNull("Campo confirmar contraseña es nulo", crearGamer.getDatoContrasenaConf());
        assertNotNull("Campo edad es nulo", crearGamer.getDatoEdad());
        assertNotNull("Campo país es nulo", crearGamer.getDatoPais());
        assertNotNull("Campo trayectoria es nulo", crearGamer.getDatoTrayectoriaCompetitiva());
        assertNotNull("Campo especialidad es nulo", crearGamer.getDatoJuegoEspecialidad());
        assertNotNull("Campo años de experiencia es nulo", crearGamer.getDatoAnosDeExperiencia());
        assertNotNull("Botón seleccionar foto es nulo", crearGamer.getSeleccionarFoto());
        assertNotNull("Botón crear gamer es nulo", crearGamer.getBotonCrearGamer());
        assertNotNull("Checkbox ver contraseña es nulo", crearGamer.getVerContrasena());
    }

    @Test
    public void testAsignarNombre() {
        crearGamer.getDatoNombre().setText("Andrea");
        assertEquals("Andrea", crearGamer.getDatoNombre().getText());
    }

    @Test
    public void testEdadCero() {
        crearGamer.getDatoEdad().setValue(0);
        assertEquals(0, crearGamer.getDatoEdad().getValue());
    }

    @After
    public void hacerDespuesDeCadaPrueba() {
        System.out.println("Prueba individual finalizada");
    }

    @AfterClass
    public static void hacerDespuesDeTodo() {
        crearGamer = null;
        System.out.println("Todas las pruebas de CrearGamer finalizadas.");
    }
}

