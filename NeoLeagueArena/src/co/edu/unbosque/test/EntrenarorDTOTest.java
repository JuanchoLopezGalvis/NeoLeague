package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.persistence.DataMapper;

public class EntrenarorDTOTest {

	static Entrenador entidad;
	static EntrenadorDTO dto;
	static int contador = 0;

	@BeforeClass
	public static void hacerAntesdelaspruevas() {
		entidad = new Entrenador("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png", "amplia", "fifa",
				3);
		dto = new EntrenadorDTO("jose", "Jose2006", "josesito@gmail.com", 28, "Peru", "jose.png", "amplia", "Formula 1",
				5);
		System.out.println("test entrenadorDTO");
		System.out.println("los datos del la lista de el perro es " + entidad.toString());
		System.out.println("los datos del la lista de dto's es " + dto.toString());
	}

	@Before
	public void hcerAntesDeCadaPrueba() {
		System.out.println("siguiente prueba");
		entidad = new Entrenador("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png", "amplia", "fifa",
				3);
		dto = new EntrenadorDTO("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png", "amplia", "fifa",
				3);

	}

	@Test
	public void verificarConvercionEntidadDTO() {
		boolean exito = false;
		EntrenadorDTO dto = DataMapper.EntrenadorToEntrenadorDTO(entidad);
		if (dto.getNombre().equals(entidad.getNombre()) && dto.getContrasena().equals(entidad.getContrasena())
				&& dto.getCorreo().equals(entidad.getCorreo()) && dto.getEdad() == entidad.getEdad()
				&& dto.getPais().equals(entidad.getPais()) && dto.getUrlFoto().equals(entidad.getUrlFoto())
				&& dto.getTrayectoriaProfesional().equals(entidad.getTrayectoriaProfesional())
				&& dto.getEspecialidadDeEntreno().equals(entidad.getEspecialidadDeEntreno())
				&& dto.getAnosDeEntrenamiento() == entidad.getAnosDeEntrenamiento()) {
			exito = true;
		}
		if (exito) {
			System.out.println("Se efectuo la conversión de manera satisfactoria");
		} else {
			System.out.println("Se efectuo la conversión de manera insatisfactoria");
		}
		assertTrue(exito);
	}

	@Test
	public void verificarConversionDTOEntidad() {
		Entrenador entrenador = DataMapper.EntrenadorDTOToEntrenador(dto);
		boolean exito = false;
		if (dto.getNombre().equals(entrenador.getNombre()) && dto.getContrasena().equals(entrenador.getContrasena())
				&& dto.getCorreo().equals(entrenador.getCorreo()) && dto.getEdad() == entrenador.getEdad()
				&& dto.getPais().equals(entrenador.getPais()) && dto.getUrlFoto().equals(entidad.getUrlFoto())
				&& dto.getTrayectoriaProfesional().equals(entrenador.getTrayectoriaProfesional())
				&& dto.getEspecialidadDeEntreno().equals(entrenador.getEspecialidadDeEntreno())
				&& dto.getAnosDeEntrenamiento() == entrenador.getAnosDeEntrenamiento()) {
			exito = true;
		}
		if (exito) {
			System.out.println("Se efectuo la conversión de manera satisfactoria");
		} else {
			System.out.println("Se efectuo la conversión de manera insatisfactoria");
		}
		assertTrue(exito);
	}

	@Test
	public void verificarConstructor() {
		Entrenador entrenador1 = new Entrenador("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png",
				"amplia", "fifa", 3);

		if (entrenador1.getNombre() != null && entrenador1.getNombre().equals("juan")) {
			System.out.println("El dato nombre se guarda de manera adecuada");
		} else {
			System.err.println("El dato nombre se guarda de manera inadecuada");
		}
		if (entrenador1.getContrasena() != null && entrenador1.getContrasena().equals("Juan2006")) {
			System.out.println("El dato contrasena se guarda de manera adecuada");
		} else {
			System.out.println("El dato contrasena se guarda de manera inadecuada");
		}
		if (entrenador1.getCorreo() != null && entrenador1.getCorreo().equals("juanito@gmail.com")) {
			System.out.println("El dato correo se guarda de manera adecuada");
		} else {
			System.out.println("El dato correo se guarda de manera inadecuada");
		}
		if (entrenador1.getEdad() != 0 && entrenador1.getEdad() == 18) {
			System.out.println("El dato edad se guarda de manera adecuada");
		} else {
			System.out.println("El dato edad se guarda de manera inadecuada");
		}
		if (entrenador1.getPais() != null && entrenador1.getPais().equals("Colombia")) {
			System.out.println("El dato pais se guarda de manera adecuada");
		} else {
			System.out.println("El dato pais se guarda de manera inadecuada");
		}
		if (entrenador1.getUrlFoto() != null && entrenador1.getUrlFoto().equals("juan.png")) {
			System.out.println("El dato urlFoto se guarda de manera adecuada");
		} else {
			System.out.println("El dato urlFoto se guarda de manera inadecuada");
		}
		if (entrenador1.getTrayectoriaProfesional() != null
				&& entrenador1.getTrayectoriaProfesional().equals("amplia")) {
			System.out.println("El dato trayectoria profesional se guarda de manera adecuada");
		} else {
			System.out.println("El dato trayectoria profesional se guarda de manera inadecuada");
		}
		if (entrenador1.getEspecialidadDeEntreno() != null && entrenador1.getEspecialidadDeEntreno().equals("fifa")) {
			System.out.println("El dato especialidad de entreno se guarda de manera adecuada");
		} else {
			System.out.println("El dato especialidad de entreno se guarda de manera inadecuada");
		}
		if (entrenador1.getAnosDeEntrenamiento() != 0 && entrenador1.getAnosDeEntrenamiento() == 3) {
			System.out.println("El dato anos de entrenamiento se guarda de manera adecuada");
		} else {
			System.out.println("El dato anos de entrenamiento se guarda de manera inadecuada");
		}

	}

	@After
	public void hacerDespuesDeCadaPrueba() {
		contador++;
		System.out.println("Finalizada la prueba numero " + contador);
	}

	@AfterClass
	public static void hacerDespuesDeTodo() {
		System.out.println("Finalizadas todas las pruebas unitarias de PerroDTO.");
		System.out.println("Se ejecutaron un total de " + contador + " pruebas.");
	}

}
