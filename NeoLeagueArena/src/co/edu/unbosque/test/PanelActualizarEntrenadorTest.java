package co.edu.unbosque.test;



import static org.junit.Assert.*;

import javax.swing.*;

import org.junit.*;

import co.edu.unbosque.view.PanelActualizarEntrenador;

public class PanelActualizarEntrenadorTest {

    private static PanelActualizarEntrenador panel;

    @BeforeClass
    public static void hacerAntesdelaspruevas() {
        System.out.println("Inicializando todas las pruebas");
        panel = new PanelActualizarEntrenador();
    }

    @Before
    public void hcerAntesDeCadaPrueba() {
        System.out.println("Preparando prueba");
    }

    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getDatoNombre());
        assertNotNull(panel.getDatoContrasena());
        assertNotNull(panel.getDatoCorreo());
        assertNotNull(panel.getDatoEdad());
        assertNotNull(panel.getDatoPais());
        assertNotNull(panel.getDatoTrayectoriaProfesional());
        assertNotNull(panel.getDatoJuegoEspecialidad());
        assertNotNull(panel.getDatoAnosDeExperiencia());
        assertNotNull(panel.getSeleccionarFoto());
        assertNotNull(panel.getBotonActualizar());
        assertNotNull(panel.getVerContrasena());
    }

    @Test
    public void testSetearYLeerTexto() {
        panel.getDatoNombre().setText("Misty");
        assertEquals("Misty", panel.getDatoNombre().getText());

        panel.getDatoCorreo().setText("misty@cerulean.com");
        assertEquals("misty@cerulean.com", panel.getDatoCorreo().getText());
    }

    @Test
    public void testVerContrasenaSimulada() {
        JPasswordField passField = panel.getDatoContrasena();
        JCheckBox verCheckbox = panel.getVerContrasena();

        passField.setText("poke123");

        // Simulamos selección
        verCheckbox.setSelected(true);
        if (verCheckbox.isSelected()) {
            passField.setEchoChar((char) 0);
        }
        assertEquals((char) 0, passField.getEchoChar());

        // Simulamos deselección
        verCheckbox.setSelected(false);
        if (!verCheckbox.isSelected()) {
            passField.setEchoChar('*');
        }
        assertEquals('*', passField.getEchoChar());
    }

    @After
    public void hacerDespuesDeCadaPrueba() {
        System.out.println("Prueba individual finalizada");
    }

    @AfterClass
    public static void hacerDespuesDeTodo() {
        System.out.println("Pruebas terminadas");
        panel = null;
    }
}

