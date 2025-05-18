package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.view.VentanaAdmin;

public class VentanaAdminTest {
	
	static VentanaAdmin ventana;

    @BeforeClass
    public static void hacerAntesDeLasPruebas() throws Exception {
        System.out.println("Inicializando tests de VentanaAdmin");
        ventana = new VentanaAdmin();
    }

    @Before
    public void hcerAntesDeCadaPrueba() throws Exception {
        System.out.println("inicializando prueba");
    }

    @Test
    public void MenusNoNull() {
        System.out.println("Verificando que los menús no son null");

        assertNotNull(ventana.getAdministrarGamer());
        assertNotNull(ventana.getAdministrarCouch());
        assertNotNull(ventana.getAdministrarEquipo());
        assertNotNull(ventana.getAdministrarTorneos());
        assertNotNull(ventana.getAdministrarPartidas());
        assertNotNull(ventana.getReportes());
    }

    @Test
    public void MenuItemstNull() {
        System.out.println("Verificando que los JMenuItem no son null");

        assertNotNull(ventana.getMostrarGamers());
        assertNotNull(ventana.getMostrarCoachs());
        assertNotNull(ventana.getCrearTorneo());
        assertNotNull(ventana.getCrearPartida());
        assertNotNull(ventana.getMostrarTorneos());
        assertNotNull(ventana.getMostrarPartidas());
        assertNotNull(ventana.getActualizarTorneo());
        assertNotNull(ventana.getActualizarPartida());
        assertNotNull(ventana.getActualizarEquipo());
        assertNotNull(ventana.getMostrarEquipos());
        assertNotNull(ventana.getAnaliytics());
    }

    @Test
    public void CardAdminNotNull() {
        System.out.println("Test - Verificando que CardAdmin no es null");
        assertNotNull(ventana.getCardAdmin());
    }

    @After
    public void hacerDespuesDeCadaPrueba() throws Exception {
        System.out.println("After - Limpieza después de prueba individual");
    }

    @AfterClass
    public static void hacerDespuesDeTodo() throws Exception {
        System.out.println("AfterClass - Cerrando VentanaAdmin");
        ventana.dispose(); 
    }

}
