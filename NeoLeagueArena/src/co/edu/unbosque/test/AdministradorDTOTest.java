	package co.edu.unbosque.test;
	
	import static org.junit.Assert.assertTrue;
	
	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	
	import co.edu.unbosque.model.Administrador;
	import co.edu.unbosque.model.AdministradorDTO;
	import co.edu.unbosque.model.persistence.DataMapper;
	
	public class AdministradorDTOTest {
	
		static Administrador entidad;
		static AdministradorDTO dto;
		static int contador = 0;
	
		@BeforeClass
		public static void hacerAntesdelaspruevas() {
			entidad = new Administrador("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png", "Admin torneos");
			dto = new AdministradorDTO("jose", "Jose2006", "josesito@gmail.com", 28, "Peru", "jose.png", "Admin torneos");
			System.out.println("Iniciando las pruebas unitarias de PerroDTO");
			System.out.println("los datos del la lista de el perro es " + entidad.toString());
			System.out.println("los datos del la lista de dto's es " + dto.toString());
		}
	
		@Before
		public void hcerAntesDeCadaPrueba() {
			System.out.println("Iniciando la siguiente prueba");
			entidad = new Administrador("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png", "admin torneos");
			dto = new AdministradorDTO("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png", "admin torneos");
	
		}
	
		@Test
		public void verificarConvercionEntidadDTO() {
			boolean exito = false;
			AdministradorDTO dto = DataMapper.AdministradorToAdministradorDTO(entidad);
			if (dto.getNombre().equals(entidad.getNombre()) && dto.getContrasena().equals(entidad.getContrasena())
					&& dto.getCorreo().equals(entidad.getCorreo()) && dto.getEdad() == entidad.getEdad()
					&& dto.getPais().equals(entidad.getPais()) && dto.getUrlFoto().equals(entidad.getUrlFoto())
					&& dto.getCargoEspecifico().equals(entidad.getCargoEspecifico())
					) {
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
			Administrador entrenador = DataMapper.AdministradorDTOToAdministrador(dto);
			boolean exito = false;
			if (dto.getNombre().equals(entrenador.getNombre()) && dto.getContrasena().equals(entrenador.getContrasena())
					&& dto.getCorreo().equals(entrenador.getCorreo()) && dto.getEdad() == entrenador.getEdad()
					&& dto.getPais().equals(entrenador.getPais()) && dto.getUrlFoto().equals(entidad.getUrlFoto())
					&& dto.getCargoEspecifico().equals(entrenador.getCargoEspecifico())) {
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
			Administrador entrenador1 = new Administrador("juan", "Juan2006", "juanito@gmail.com", 18, "Colombia", "juan.png",
					"admin torneos");
	
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
			if (entrenador1.getCargoEspecifico() != null
					&& entrenador1.getCargoEspecifico().equals("admin torneos")) {
				System.out.println("El dato trayectoria profesional se guarda de manera adecuada");
			} else {
				System.out.println("El dato trayectoria profesional se guarda de manera inadecuada");
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
