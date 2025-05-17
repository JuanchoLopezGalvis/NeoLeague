package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.view.CrearAdmin;

public class CrearAdminTest {

    private static CrearAdmin panel;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Iniciando las pruebas unitarias de CrearAdmin");
        panel = new CrearAdmin();
    }

    @Before
    public void setUp() {
        System.out.println("Ejecutando prueba");
        // Aquí puedes reiniciar valores si fuera necesario.
    }

    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getDatoNombre());
        assertNotNull(panel.getDatoContrasena());
        assertNotNull(panel.getDatoContrasenaConf());
        assertNotNull(panel.getDatoCorreo());
        assertNotNull(panel.getDatoEdad());
        assertNotNull(panel.getDatoPais());
        assertNotNull(panel.getPasswordAdmins());
        assertNotNull(panel.getDatoCargoEspecifico());
        assertNotNull(panel.getSeleccionarFoto());
        assertNotNull(panel.getBotonCrearAdmin());
        assertNotNull(panel.getVerContrasena());
        assertNotNull(panel.getVerContrasenaAdmins());
    }

    @Test
    public void testSpinnerEdadConfigurado() {
        JSpinner spinner = panel.getDatoEdad();
        SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
        assertEquals(0, model.getMinimum());
        assertTrue((Integer) model.getStepSize() > 0);
    }

    @Test
    public void testComboBoxPaisTieneElementos() {
        JComboBox<String> comboBox = panel.getDatoPais();
        assertTrue(comboBox.getItemCount() > 1);
    }

    @Test
    public void testContrasenasOcultasPorDefecto() {
        assertEquals('●', panel.getDatoContrasena().getEchoChar());
        assertEquals('●', panel.getDatoContrasenaConf().getEchoChar());
        assertEquals('●', panel.getPasswordAdmins().getEchoChar());
    }

    @After
    public void tearDown() {
        System.out.println("Prueba finalizada");
        // Puedes limpiar estados si es necesario.
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Todas las pruebas de CrearAdmin han finalizado");
        panel = null;
    }

}
