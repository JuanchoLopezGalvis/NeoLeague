package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.view.BotonRedondeado;
import co.edu.unbosque.view.PanelActualizarEquipo;
import co.edu.unbosque.view.TextFieldRedondeado;

public class PanelActualizarEquipoTest {

    private static PanelActualizarEquipo panel;

    @BeforeClass
    public static void hacerAntesdelaspruevas() {
        System.out.println("Iniciando pruebas de PanelActualizarEquipo");
        panel = new PanelActualizarEquipo();
    }

   

    @Before
    public void hcerAntesDeCadaPrueba()  {
        System.out.println("Iniciando prueba individual");
    }

   

    @Test
    public void testComponentInitialization() {
        assertNotNull("El campo de texto del nombre del equipo debe estar inicializado.", panel.getDatoNombreEquipo());
        assertNotNull("La etiqueta del nombre del equipo debe estar inicializada.", panel.getEtiquetaNombreEquipo());
        assertNotNull("El botón de actualizar debe estar inicializado.", panel.getBtnActualizarEquipo());
        assertNotNull("El combo de equipos existentes debe estar inicializado.", panel.getEquiposExistentes());
        assertNotNull("La imagen de fondo debe estar inicializada.", panel.getFondo());
    }

    @Test
    public void testGettersAndSetters() {
        TextFieldRedondeado nuevoCampo = new TextFieldRedondeado(java.awt.Color.WHITE, java.awt.Color.BLUE, 10, java.awt.Color.BLACK, 1f);
        panel.setDatoNombreEquipo(nuevoCampo);
        assertEquals(nuevoCampo, panel.getDatoNombreEquipo());

        JLabel nuevaEtiqueta = new JLabel("Nuevo");
        panel.setEtiquetaNombreEquipo(nuevaEtiqueta);
        assertEquals(nuevaEtiqueta, panel.getEtiquetaNombreEquipo());

        BotonRedondeado nuevoBoton = new BotonRedondeado("Test", 20, java.awt.Color.BLACK, java.awt.Color.BLACK, java.awt.Color.WHITE, java.awt.Color.WHITE, 1f);
        panel.setBtnActualizarEquipo(nuevoBoton);
        assertEquals(nuevoBoton, panel.getBtnActualizarEquipo());

        JComboBox<String> nuevoCombo = new JComboBox<>();
        panel.setEquiposExistentes(nuevoCombo);
        assertEquals(nuevoCombo, panel.getEquiposExistentes());

        Image nuevaImagen = panel.getFondo();
        panel.setFondo(nuevaImagen);
        assertEquals(nuevaImagen, panel.getFondo());
    }
    
    @After
    public void hacerDespuesDeCadaPrueba() throws Exception {
        System.out.println("Terminando prueba individual");
    }
    
    @AfterClass
    public static void hacerDespuesDeTodo() throws Exception {
        System.out.println("Finalizando pruebas de PanelActualizarEquipo");
        panel = null;
    }
}
