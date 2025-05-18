package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.JugadorDAO;

public class JugadorDAOTest {

    static JugadorDAO jugadorDAO;
    static Jugador jugadorEntidad;
    static JugadorDTO jugadorDTO;
    static int contador = 0;

    @BeforeClass
    public static void hacerAntesDeLasPruebas() {
        jugadorDAO = new JugadorDAO();
        jugadorEntidad = new Jugador("mario", "Mario123", "mario@mail.com", 25, "Colombia", "5 años", "LOL", "mario.png", 3);
        jugadorDTO = new JugadorDTO("luis", "Luis321", "luis@mail.com", 30, "Peru", "10 años", "Valorant", "luis.png", 7);
        System.out.println("Iniciando las pruebas unitarias de JugadorDAO");
        System.out.println("Entidad Jugador inicial: " + jugadorEntidad.toString());
        System.out.println("DTO Jugador inicial: " + jugadorDTO.toString());
    }

    @Before
    public void hacerAntesDeCadaPrueba() {
        System.out.println("Iniciando la siguiente prueba...");
        jugadorDAO = new JugadorDAO();
        jugadorEntidad = new Jugador("mario", "Mario123", "mario@mail.com", 25, "Colombia", "5 años", "LOL", "mario.png", 3);
        jugadorDTO = new JugadorDTO("mario", "Mario123", "mario@mail.com", 25, "Colombia", "5 años", "LOL", "mario.png", 3);
    }

    @Test
    public void verificarAgregarJugador() {
        boolean exito = jugadorDAO.add(jugadorDTO);
        if (exito) {
            System.out.println("Jugador agregado exitosamente");
        } else {
            System.err.println("Error al agregar el jugador");
        }
        assertTrue(exito);
    }

    @Test
    public void verificarBuscarJugador() {
        jugadorDAO.add(jugadorDTO);
        Jugador encontrado = jugadorDAO.find(jugadorEntidad);
        boolean exito = encontrado != null && encontrado.getNombre().equals(jugadorEntidad.getNombre());
        if (exito) {
            System.out.println("Jugador encontrado exitosamente");
        } else {
            System.err.println("Jugador no encontrado");
        }
        assertTrue(exito);
    }

    @Test
    public void verificarEliminarJugador() {
        jugadorDAO.add(jugadorDTO);
        boolean eliminado = jugadorDAO.delete(jugadorDTO);
        if (eliminado) {
            System.out.println("Jugador eliminado exitosamente");
        } else {
            System.err.println("Error al eliminar jugador");
        }
        assertTrue(eliminado);
    }

    @Test
    public void verificarMostrarTodos() {
        jugadorDAO.add(jugadorDTO);
        JTable tabla = new JTable(new DefaultTableModel(new Object[] {"Nombre", "Contrasena", "Correo", "Edad", "Pais", "Trayectoria", "Juego", "Experiencia", "Foto"}, 0));
        boolean exito = jugadorDAO.showAll(tabla);
        if (exito) {
            System.out.println("Se mostraron todos los jugadores correctamente");
        } else {
            System.err.println("No hay jugadores para mostrar");
        }
        assertTrue(exito);
    }

    @After
    public void hacerDespuesDeCadaPrueba() {
        contador++;
        System.out.println("Finalizada la prueba número " + contador);
    }

    @AfterClass
    public static void hacerDespuesDeTodo() {
        System.out.println("Finalizadas todas las pruebas unitarias de JugadorDAO.");
        System.out.println("Se ejecutaron un total de " + contador + " pruebas.");
    }
}
