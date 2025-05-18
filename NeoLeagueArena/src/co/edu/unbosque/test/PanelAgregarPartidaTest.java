package co.edu.unbosque.test;


import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.JComboBox;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.view.BotonRedondeado;
import co.edu.unbosque.view.PanelAgregarPartida;
import de.wannawork.jcalendar.JCalendarComboBox;

public class PanelAgregarPartidaTest {

    private static PanelAgregarPartida panel;

    @BeforeClass
    public static void hacerAntesdelaspruevas() {
        System.out.println("Iniciando pruebas para PanelAgregarPartida.");
        panel = new PanelAgregarPartida();
    }

   

    @Before
    public void hcerAntesDeCadaPrueba()  {
        
        System.out.println("Iniciando prueba individual");
    }

 

    @Test
    public void testComponentInitialization() {
        assertNotNull("El combo equipo1 debe estar inicializado.", panel.getEquipo1());
        assertNotNull("El combo equipo2 debe estar inicializado.", panel.getEquipo2());
        assertNotNull("El combo datoJuego debe estar inicializado.", panel.getDatoJuego());
        assertNotNull("El calendario debe estar inicializado.", panel.getFechaPartida());
        assertNotNull("El combo ganador debe estar inicializado.", panel.getGanador());
        assertNotNull("El combo torneosExistentes debe estar inicializado.", panel.getTorneosExistentes());
        assertNotNull("El botón debe estar inicializado.", panel.getBtnAgregarPartida());
        assertNotNull("La imagen de fondo debe estar inicializada.", panel.getFondo());
    }

    @Test
    public void testGettersAndSetters() {
        JComboBox<String> nuevoCombo = new JComboBox<>();
        panel.setEquipo1(nuevoCombo);
        assertEquals(nuevoCombo, panel.getEquipo1());

        panel.setEquipo2(nuevoCombo);
        assertEquals(nuevoCombo, panel.getEquipo2());

        panel.setDatoJuego(nuevoCombo);
        assertEquals(nuevoCombo, panel.getDatoJuego());

        panel.setGanador(nuevoCombo);
        assertEquals(nuevoCombo, panel.getGanador());

        panel.setTorneosExistentes(nuevoCombo);
        assertEquals(nuevoCombo, panel.getTorneosExistentes());

        JCalendarComboBox nuevaFecha = new JCalendarComboBox();
        panel.setFechaPartida(nuevaFecha);
        assertEquals(nuevaFecha, panel.getFechaPartida());

        BotonRedondeado boton = new BotonRedondeado("Test", 20, java.awt.Color.BLACK, java.awt.Color.BLACK, java.awt.Color.WHITE, java.awt.Color.WHITE, 1f);
        panel.setBtnAgregarPartida(boton);
        assertEquals(boton, panel.getBtnAgregarPartida());

        Image imagen = panel.getFondo();
        panel.setFondo(imagen);
        assertEquals(imagen, panel.getFondo());
    }

    @Test
    public void testSerialVersionUID() {
        assertEquals(1L, PanelAgregarPartida.getSerialversionuid());
    }
    
    @After
    public void hacerDespuesDeCadaPrueba() {
        
        System.out.println("Finalizando prueba individual");
    }
    
    @AfterClass
    public static void hacerDespuesDeTodo(){
        System.out.println("Finalizando pruebas para PanelAgregarPartida");
        panel = null;
    }
}

