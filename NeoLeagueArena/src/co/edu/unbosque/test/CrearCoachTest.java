package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.view.CrearCoach;

public class CrearCoachTest {

    private static CrearCoach panel;

    @BeforeAll
    public static void hacerAntesdelaspruevas() {
        System.out.println("Ejecutando pruebas unitarias crearCoach");
        panel = new CrearCoach();
    }

    @BeforeEach
    public void hcerAntesDeCadaPrueba() {
        System.out.println("Ejecutando prueba");
       
    }

    @Test
    public void testContenido() {
        System.out.println("Ejecutando testComponentInitialization");

        assertNotNull(panel.getDatoNombre(), "Campo de nombre no debe ser null");
        assertNotNull(panel.getDatoContrasena(), "Campo de contraseña no debe ser null");
        assertNotNull(panel.getDatoContrasenaConf(), "Campo de confirmación de contraseña no debe ser null");
        assertNotNull(panel.getDatoCorreo(), "Campo de correo no debe ser null");
        assertNotNull(panel.getDatoEdad(), "Spinner de edad no debe ser null");
        assertNotNull(panel.getDatoPais(), "Combo de país no debe ser null");
        assertNotNull(panel.getDatoTrayectoriaProfesional(), "Combo de trayectoria no debe ser null");
        assertNotNull(panel.getDatoJuegoEspecialidad(), "Combo de juego especializado no debe ser null");
        assertNotNull(panel.getDatoAnosDeExperiencia(), "Spinner de experiencia no debe ser null");
        assertNotNull(panel.getSeleccionarFoto(), "Botón seleccionar foto no debe ser null");
        assertNotNull(panel.getBotonCrearCoach(), "Botón crear coach no debe ser null");
        assertNotNull(panel.getVerContrasena(), "Checkbox ver contraseña no debe ser null");
    }

    @Test
    public void testSpinnerDefaults() {
        System.out.println("Ejecutando testSpinnerDefaults");

        JSpinner edad = panel.getDatoEdad();
        JSpinner experiencia = panel.getDatoAnosDeExperiencia();

        assertEquals(0, edad.getValue(), "Edad inicial debe ser 0");
        assertEquals(0, experiencia.getValue(), "Experiencia inicial debe ser 0");
    }

    @Test
    public void testComboBoxesHaveItems() {
        System.out.println("Ejecutando testComboBoxesHaveItems");

        JComboBox<String> pais = panel.getDatoPais();
        JComboBox<String> trayectoria = panel.getDatoTrayectoriaProfesional();
        JComboBox<String> especialidad = panel.getDatoJuegoEspecialidad();

        assertTrue(pais.getItemCount() > 1, "Combo de país debe tener más de un elemento");
        assertTrue(trayectoria.getItemCount() > 0, "Combo de trayectoria debe tener opciones");
        assertTrue(especialidad.getItemCount() > 0, "Combo de especialidad debe tener opciones");
    }

    @AfterEach
    public void hacerDespuesDeCadaPrueba() {
        System.out.println("Finalizando prueba");
    }

    @AfterAll
    public static void hacerDespuesDeTodo() {
        System.out.println("Finalizando todas las pruebas unitarias de CrearCoach");
        panel = null;
    }
}
