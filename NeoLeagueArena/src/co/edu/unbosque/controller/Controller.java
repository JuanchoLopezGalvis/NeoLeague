package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PartidaDTO;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.EmptyStringFieldException;
import co.edu.unbosque.util.exception.InvalidEmailException;
import co.edu.unbosque.util.exception.InvalidPasswordException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.view.MensajeEmergente;
import co.edu.unbosque.view.ViewFacade;

/**
 * La clase {@link Controller} es la encargada de controlar el flujo de la
 * aplicacion. Se encarga de recibir los eventos de la vista.
 */
public class Controller implements ActionListener {
	/**
	 * {@link ModelFacade} es la fachada del modelo, que se encarga de crear cada
	 * uno de los DAO del aplicativo.
	 */
	private ModelFacade mf;
	/**
	 * {@link ViewFacade} es la fachada de la vista, que se encarga de crear cada
	 * una de las ventanas del aplicativop.
	 */
	private ViewFacade vf;
	/**
	 * {@link String} panel actual es la variable que se encarga de guardar el panel
	 * actual, su presencia es fundametal para poder reutilizar algunos paneles que
	 * tienen responsabilidades similares pero su comportamiento tiene variaciones y
	 * con ayuda de esta variable y condicionales podemos manejar esto.
	 */
	private String panelActual;
	/**
	 * {@link Properties} prop es la variable que se encarga de guardar las
	 * propiedades del idioma seleccionado por el usuario.
	 */
	private static Properties prop;
	private String nombreUsuario;

	/**
	 * Constructor de la clase {@link Controller}, que se encarga de inicializar las
	 * variables de la clase.
	 */
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		prop = new Properties();
		panelActual = "PanelPrincipal";
		nombreUsuario = "";
		asignarLectores();
	}

	/**
	 * Metodo run, que se encarga de ejecutar el aplicativo.
	 */
	public void run() {
		FileManager.crearCarpeta();
		vf.getVp().setVisible(true);
		mf.getEqdao().asignarElmentosCombos(
				vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes());
		mf.getEqdao().asignarElmentosCombos(
				vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1());
		mf.getEqdao().asignarElmentosCombos(
				vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2());
		mf.getEqdao().asignarElmentosCombos(
				vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador());
		mf.getTdao().asignarElementosAComboBox(
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes());
		mf.getTdao().asignarElementosAComboBox(
				vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos());
		mf.getTdao().asignarElementosAComboBox(
				vf.getVe().getCardCoach().getPanelInscribirTorneo().getTorneoInscribir());
		mf.getTdao().asignarElementosAComboBox(
				vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos());
		mf.getTdao().asignarElementosAComboBox(
				vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes());

	}

	/**
	 * Este metodo se encarga de asignar los oyentes a los botones de la ventana
	 * principal.
	 */
	public void asignarLectores() {

		vf.getVp().getPanelPrincipal().getCheckEspañol().addActionListener(this);
		vf.getVp().getPanelPrincipal().getCheckEspañol().setActionCommand("checkEspañol");
		vf.getVp().getPanelPrincipal().getCheckIngles().addActionListener(this);
		vf.getVp().getPanelPrincipal().getCheckIngles().setActionCommand("checkIngles");

		vf.getVp().getPanelPrincipal().getBtnAdmin().addActionListener(this);
		vf.getVp().getPanelPrincipal().getBtnAdmin().setActionCommand("Admin");
		vf.getVp().getPanelPrincipal().getBtnCouch().addActionListener(this);
		vf.getVp().getPanelPrincipal().getBtnCouch().setActionCommand("Couch");
		vf.getVp().getPanelPrincipal().getBtnGamer().addActionListener(this);
		vf.getVp().getPanelPrincipal().getBtnGamer().setActionCommand("Gamer");
		vf.getVp().getPanelPrincipal().getBtnRegistrar().addActionListener(this);
		vf.getVp().getPanelPrincipal().getBtnRegistrar().setActionCommand("btnSignUp");
		vf.getVp().getPanelPrincipal().getBtnEntrar().addActionListener(this);
		vf.getVp().getPanelPrincipal().getBtnEntrar().setActionCommand("btnEntrar");
		vf.getVsu().getRoles().addActionListener(this);
		vf.getVsu().getRoles().setActionCommand("comboRoles");
		vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto().setActionCommand("fotoGamer");
		vf.getVsu().getCardSignUp().getCrearCoach().getSeleccionarFoto().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearCoach().getSeleccionarFoto().setActionCommand("fotoCoach");
		vf.getVsu().getCardSignUp().getCrearAdmin().getSeleccionarFoto().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearAdmin().getSeleccionarFoto().setActionCommand("fotoAdmin");
		vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena().setActionCommand("verContrasenaGamer");
		vf.getVsu().getCardSignUp().getCrearCoach().getVerContrasena().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearCoach().getVerContrasena().setActionCommand("verContrasenaCouch");
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena().setActionCommand("verContrasenaAdmin");
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins().setActionCommand("verContrasenaAdmins");
		vf.getVsu().getCardSignUp().getCrearGamer().getBotonCrearGamer().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearGamer().getBotonCrearGamer().setActionCommand("btnCrearGamer");
		vf.getVsu().getCardSignUp().getCrearCoach().getBotonCrearCoach().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearCoach().getBotonCrearCoach().setActionCommand("btnCrearCoach");
		vf.getVsu().getCardSignUp().getCrearAdmin().getBotonCrearAdmin().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearAdmin().getBotonCrearAdmin().setActionCommand("btnCrearAdmin");
		vf.getVa().getMostrarGamers().addActionListener(this);
		vf.getVa().getMostrarGamers().setActionCommand("btnMostrarGamers");
		vf.getVa().getMostrarCoachs().addActionListener(this);
		vf.getVa().getMostrarCoachs().setActionCommand("btnMostrarCoaches");
		vf.getVa().getCrearTorneo().addActionListener(this);
		vf.getVa().getCrearTorneo().setActionCommand("PanelCrearTorneo");
		vf.getVa().getCardAdmin().getPanelAgregarTorneo().getBtnAgregar().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelAgregarTorneo().getBtnAgregar().setActionCommand("btnAgregarTorneo");
		vf.getVa().getCardAdmin().getPanelMostrar().getBuscar().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelMostrar().getBuscar().setActionCommand("btnBuscar");
		vf.getVa().getCardAdmin().getPanelMostrar().getBtnShowllAll().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelMostrar().getBtnShowllAll().setActionCommand("btnShowllAll");
		vf.getVa().getCardAdmin().getPanelMostrar().getBtnEliminar().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelMostrar().getBtnEliminar().setActionCommand("btnEliminar");
		vf.getVa().getMostrarTorneos().addActionListener(this);
		vf.getVa().getMostrarTorneos().setActionCommand("btnMostrarTorneos");
		vf.getVa().getCrearPartida().addActionListener(this);
		vf.getVa().getCrearPartida().setActionCommand("PanelCrearPartida");
		vf.getVe().getCrearEquipo().addActionListener(this);
		vf.getVe().getCrearEquipo().setActionCommand("PanelCrearEquipo");
		vf.getVa().getMostrarEquipos().addActionListener(this);
		vf.getVa().getMostrarEquipos().setActionCommand("btnMostrarEquipos");

		vf.getVa().getActualizarEquipo().addActionListener(this);
		vf.getVa().getActualizarEquipo().setActionCommand("PanelActualizarEquipo");

		vf.getVa().getActualizarTorneo().addActionListener(this);
		vf.getVa().getActualizarTorneo().setActionCommand("PanelActualizarTorneo");

		vf.getVa().getAnaliytics().addActionListener(this);
		vf.getVa().getAnaliytics().setActionCommand("PanelAnalytics");

		vf.getVe().getCardCoach().getPanelAgregarEquipo().getBtnAgregarEquipo().addActionListener(this);
		vf.getVe().getCardCoach().getPanelAgregarEquipo().getBtnAgregarEquipo().setActionCommand("btnAgregarEquipo");

		vf.getVe().getVerEquipos().addActionListener(this);
		vf.getVe().getVerEquipos().setActionCommand("panelMostrarEquipos");

		vf.getVe().getActualizarEquipo().addActionListener(this);
		vf.getVe().getActualizarEquipo().setActionCommand("panelActualizarEquipo");

		vf.getVe().getActualizarCuenta().addActionListener(this);
		vf.getVe().getActualizarCuenta().setActionCommand("ActualizarCuentaEntrenador");

		vf.getVg().getActualizarCuenta().addActionListener(this);
		vf.getVg().getActualizarCuenta().setActionCommand("ActualizarCuentaGamer");

		vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes().setActionCommand("comboEquipos");
		vf.getVa().getCardAdmin().getPanelActualizar().getBtnActualizarEquipo().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelActualizar().getBtnActualizarEquipo().setActionCommand("btnActualizarEquipo");
		vf.getVa().getActualizarEquipo().addActionListener(this);
		vf.getVa().getActualizarEquipo().setActionCommand("PanelActualizarEquipo");
		vf.getVa().getActualizarTorneo().addActionListener(this);
		vf.getVa().getActualizarTorneo().setActionCommand("PanelActualizarTorneo");
		vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes().setActionCommand("comboTorneos");
		vf.getVa().getCardAdmin().getPanelActualizarTorneo().getBtnActualizar().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelActualizarTorneo().getBtnActualizar().setActionCommand("btnActualizarTorneo");

		vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes()
				.setActionCommand("comboTorneosexistentes");

		vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1().setActionCommand("comboEquipo1");
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2().setActionCommand("comboEquipo2");
		vf.getVe().getInscribirTorneo().addActionListener(this);
		vf.getVe().getInscribirTorneo().setActionCommand("PanelInscribirTorneo");
		vf.getVe().getCardCoach().getPanelMostrar().getBtnEliminar().addActionListener(this);
		vf.getVe().getCardCoach().getPanelMostrar().getBtnEliminar().setActionCommand("btnEliminarPanelCoach");
		vf.getVa().getTorneoAnalitycs().addActionListener(this);
		vf.getVa().getTorneoAnalitycs().setActionCommand("PanelTorneoAnalytics");
		vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos()
				.setActionCommand("comboTorneosAnalytics");
		vf.getVe().getCardCoach().getPanelInscribirTorneo().getBtnInscribir().addActionListener(this);
		vf.getVe().getCardCoach().getPanelInscribirTorneo().getBtnInscribir().setActionCommand("btnInscribirTorneo");
		vf.getVe().getVerTorneos().addActionListener(this);
		vf.getVe().getVerTorneos().setActionCommand("mostrarTorneosEntrenador");
		vf.getVe().getCardCoach().getPanelMostrar().getBtnEliminar().addActionListener(this);
		vf.getVe().getCardCoach().getPanelMostrar().getBtnEliminar().setActionCommand("btnEliminarPanelCoach");
		vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos().addActionListener(this);
		vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos()
				.setActionCommand("comboTorneosAnalyticsEntrenador");
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getBtnAgregarPartida().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getBtnAgregarPartida().addActionListener(this);
		vf.getVa().getCardAdmin().getPanelAgregarPartida().getBtnAgregarPartida()
				.setActionCommand("btnAgregarPartida");
		vf.getVg().getTopGamers().addActionListener(this);
		vf.getVg().getTopGamers().setActionCommand("btnTopGamers");
		vf.getIe().getBtnInscribir().addActionListener(this);
		vf.getIe().getBtnInscribir().setActionCommand("btnInscribirJugador");

	}

	/**
	 * Este metodo se encarga de asignar los eventos a cada uno de los objetos que
	 * lo requieren.
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Admin": {
			vf.getVp().getPanelPrincipal().getBtnCouch().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnGamer().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnCouch().repaint();
			vf.getVp().getPanelPrincipal().getBtnGamer().repaint();
			break;
		}
		case "Couch": {
			vf.getVp().getPanelPrincipal().getBtnAdmin().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnGamer().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnAdmin().repaint();
			vf.getVp().getPanelPrincipal().getBtnGamer().repaint();
			break;
		}
		case "Gamer": {
			vf.getVp().getPanelPrincipal().getBtnAdmin().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnCouch().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnAdmin().repaint();
			vf.getVp().getPanelPrincipal().getBtnCouch().repaint();
			break;
		}
		case "btnSignUp": {
			if (vf.getVp().getPanelPrincipal().getCheckEspañol().isSelected()
					|| vf.getVp().getPanelPrincipal().getCheckIngles().isSelected()) {
				vf.getVsu().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vf.getVp(), "Plis select your language.", "Warning.",
						JOptionPane.WARNING_MESSAGE);
			}
			break;
		}
		case "checkEspañol": {
			if (vf.getVp().getPanelPrincipal().getCheckEspañol().isSelected()) {

				try {
					prop.load(new FileInputStream(new File("src/archivos/textosespaniol.properties")));
					MensajeEmergente.cargarPropiedadesParaMensajesEmergentes("src/archivos/textosespaniol.properties");

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vf.getVp().getPanelPrincipal().getBtnAdmin()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnadmin"));
				vf.getVp().getPanelPrincipal().getBtnCouch()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnentrenador"));
				vf.getVp().getPanelPrincipal().getBtnGamer()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnjugador"));
				vf.getVp().getPanelPrincipal().getBtnEntrar()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btniniciarsesion"));
				vf.getVp().getPanelPrincipal().getBtnRegistrar()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnregistrarse"));
				vf.getVp().getPanelPrincipal().getEtiqueta0()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.usuario"));
				vf.getVp().getPanelPrincipal().getEtiqueta1()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionrol"));
				vf.getVp().getPanelPrincipal().getEtiqueta2()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.contrasenia"));
				vf.getVp().getPanelPrincipal().getEtiqueta3()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionidioma"));
				vf.getVp().getPanelPrincipal().getCheckEspañol()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionidiomaespañol"));
				vf.getVp().getPanelPrincipal().getCheckIngles()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionidiomaingles"));

				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarnombre"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña2"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcorreo"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registraredad"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarrol"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.mostrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setToolTipText(
						prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseñaadmin"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.mostrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getBotonCrearAdmin()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.btnregistrarse"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getSeleccionarFoto()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionafoto"));

				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionarpais"), 0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().repaint();
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().revalidate();

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarnombre"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña2"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcorreo"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registraredad"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.anosexperiencia"));
				vf.getVsu().getCardSignUp().getCrearCoach().getSeleccionarFoto()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionafoto"));
				vf.getVsu().getCardSignUp().getCrearCoach().getBotonCrearCoach()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.btnregistrarse"));
				vf.getVsu().getCardSignUp().getCrearCoach().getVerContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.mostrarcontraseña"));

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionarpais"), 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().repaint();
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().revalidate();

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().insertItemAt(
						prop.getProperty("archivosdepropiedades.panelcrearuser.juegoespecialidadcoach"), 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().repaint();
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().revalidate();

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.equiposcoach"), 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().repaint();
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().revalidate();

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarnombre"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña2"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcorreo"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registraredad"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.anosexperiencia"));
				vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionafoto"));
				vf.getVsu().getCardSignUp().getCrearGamer().getBotonCrearGamer()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.btnregistrarse"));
				vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.mostrarcontraseña"));

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionarpais"), 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().repaint();
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().revalidate();

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().insertItemAt(
						prop.getProperty("archivosdepropiedades.panelcrearuser.juegoespecialidadcoach"), 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().repaint();
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().revalidate();

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.torneosjugados"), 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().repaint();
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().revalidate();

				vf.getVa().getReportes().setText(prop.getProperty("archivosdepropiedades.panelAdmin.informes"));
				vf.getVa().getAdministrarGamer()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarjugadores"));
				vf.getVa().getAdministrarCouch()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarentrenador"));
				vf.getVa().getMostrarGamers()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarjugadores"));
				vf.getVa().getMostrarCoachs()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarentrenadores"));
				vf.getVa().getAdministrarTorneos()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrartorneos"));
				vf.getVa().getAdministrarPartidas()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarpartidos"));
				vf.getVa().getCrearTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.creartorneos"));
				vf.getVa().getCrearPartida()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.crearpartidos"));
				vf.getVa().getMostrarTorneos()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrartorneos"));
				vf.getVa().getActualizarTorneo()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizartorneo"));
				vf.getVa().getAdministrarEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.Administrarequipos"));
				vf.getVa().getActualizarEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizarequipos"));
				vf.getVa().getMostrarEquipos()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarequipos"));
				vf.getVa().getAnaliytics().setText(prop.getProperty("archivosdepropiedades.panelAdmin.analitica"));

				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoJuego()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.nombrejuego"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoNombreTorneo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.nombretorneo"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFormatoTorneo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.formatodeltorneo"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoMaxEquipos()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.maxequipos"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getEtiqueta0()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.fechainicio"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getEtiqueta1()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.fechafin"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getRecompensa()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.reconpensa"));

				vf.getVe().getCardCoach().getPanelAgregarEquipo().getEtiquetaNombreEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelcreaequipo.nombreequipo"));
				vf.getVe().getCardCoach().getPanelAgregarEquipo().getDatoJuego()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreaequipo.nombre"));
				vf.getVe().getCardCoach().getPanelAgregarEquipo().getBtnAgregarEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelcreaequipo.btnagregarequpo"));

				vf.getVp().getPanelPrincipal().getCheckIngles().setSelected(false);

			}

			break;
		}
		case "checkIngles": {
			if (vf.getVp().getPanelPrincipal().getCheckIngles().isSelected()) {
				try {

					prop.load(new FileInputStream(new File("src/archivos/textosingles.properties")));
					MensajeEmergente.cargarPropiedadesParaMensajesEmergentes("src/archivos/textosingles.properties");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				vf.getVp().getPanelPrincipal().getBtnAdmin()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnadmin"));
				vf.getVp().getPanelPrincipal().getBtnCouch()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnentrenador"));
				vf.getVp().getPanelPrincipal().getBtnGamer()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnjugador"));
				vf.getVp().getPanelPrincipal().getBtnEntrar()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btniniciarsesion"));
				vf.getVp().getPanelPrincipal().getBtnRegistrar()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.btnregistrarse"));
				vf.getVp().getPanelPrincipal().getEtiqueta0()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.usuario"));
				vf.getVp().getPanelPrincipal().getEtiqueta1()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionrol"));
				vf.getVp().getPanelPrincipal().getEtiqueta2()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.contrasenia"));
				vf.getVp().getPanelPrincipal().getEtiqueta3()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionidioma"));
				vf.getVp().getPanelPrincipal().getCheckEspañol()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionidiomaespañol"));
				vf.getVp().getPanelPrincipal().getCheckIngles()
						.setText(prop.getProperty("archivosdepropiedades.paneprincipal.seleccionidiomaingles"));

				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarnombre"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña2"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcorreo"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registraredad"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarrol"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.mostrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setToolTipText(
						prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseñaadmin"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.mostrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getBotonCrearAdmin()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.btnregistrarse"));
				vf.getVsu().getCardSignUp().getCrearAdmin().getSeleccionarFoto()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionafoto"));

				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionarpais"), 0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().repaint();
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().revalidate();

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarnombre"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña2"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcorreo"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registraredad"));
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.anosexperiencia"));
				vf.getVsu().getCardSignUp().getCrearCoach().getSeleccionarFoto()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionafoto"));
				vf.getVsu().getCardSignUp().getCrearCoach().getBotonCrearCoach()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.btnregistrarse"));

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionarpais"), 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().repaint();
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().revalidate();

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().insertItemAt(
						prop.getProperty("archivosdepropiedades.panelcrearuser.juegoespecialidadcoach"), 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().repaint();
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().revalidate();

				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.equiposcoach"), 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().repaint();
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().revalidate();

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarnombre"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcontraseña2"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registrarcorreo"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.registraredad"));
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcrearuser.anosexperiencia"));
				vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionafoto"));
				vf.getVsu().getCardSignUp().getCrearGamer().getBotonCrearGamer()
						.setText(prop.getProperty("archivosdepropiedades.panelcrearuser.btnregistrarse"));

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.seleccionarpais"), 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().repaint();
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().revalidate();

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().insertItemAt(
						prop.getProperty("archivosdepropiedades.panelcrearuser.juegoespecialidadcoach"), 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().repaint();
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().revalidate();

				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().removeItemAt(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva()
						.insertItemAt(prop.getProperty("archivosdepropiedades.panelcrearuser.torneosjugados"), 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().repaint();
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().revalidate();

				vf.getVa().getReportes().setText(prop.getProperty("archivosdepropiedades.panelAdmin.informes"));
				vf.getVa().getAdministrarGamer()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarjugadores"));
				vf.getVa().getAdministrarCouch()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarentrenador"));
				vf.getVa().getMostrarGamers()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarjugadores"));
				vf.getVa().getMostrarCoachs()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarentrenadores"));
				vf.getVa().getAdministrarTorneos()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrartorneos"));
				vf.getVa().getAdministrarPartidas()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarpartidos"));
				vf.getVa().getCrearTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.creartorneos"));
				vf.getVa().getCrearPartida()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.crearpartidos"));
				vf.getVa().getMostrarTorneos()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrartorneos"));
				vf.getVa().getActualizarTorneo()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizartorneo"));
				vf.getVa().getAdministrarEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.Administrarequipos"));
				vf.getVa().getActualizarEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizarequipos"));

				vf.getVa().getAnaliytics().setText(prop.getProperty("archivosdepropiedades.panelAdmin.analitica"));

				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoJuego()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.nombrejuego"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoNombreTorneo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.nombretorneo"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFormatoTorneo()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.formatodeltorneo"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoMaxEquipos()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.maxequipos"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getEtiqueta0()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.fechainicio"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getEtiqueta1()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.fechafin"));
				vf.getVa().getCardAdmin().getPanelAgregarTorneo().getRecompensa()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreartorneo.reconpensa"));

				vf.getVe().getCardCoach().getPanelAgregarEquipo().getEtiquetaNombreEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelcreaequipo.nombreequipo"));
				vf.getVe().getCardCoach().getPanelAgregarEquipo().getDatoJuego()
						.setToolTipText(prop.getProperty("archivosdepropiedades.panelcreaequipo.nombre"));
				vf.getVe().getCardCoach().getPanelAgregarEquipo().getBtnAgregarEquipo()
						.setText(prop.getProperty("archivosdepropiedades.panelcreaequipo.btnagregarequpo"));

				vf.getVp().getPanelPrincipal().getCheckEspañol().setSelected(false);

			}
			break;
		}
		case "comboRoles": {
			String rol = vf.getVsu().getRoles().getSelectedItem().toString();
			switch (rol) {
			case "Admin":
				vf.getVsu().getCardSignUp().mostrarPanel("CrearAdmin");
				break;
			case "Coach":
				vf.getVsu().getCardSignUp().mostrarPanel("CrearCoach");
				break;
			case "Gamer":
				vf.getVsu().getCardSignUp().mostrarPanel("CrearGamer");
				break;

			default:
				MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.error",
						"archivosdepropiedades.mensajes.errorrol");
				break;
			}

			break;
		}
		case "fotoGamer": {
			if (vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText().isEmpty()
					|| vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText() == null) {
				MensajeEmergente.mensajeAdvertencia("archivosdepropiedades.mensajes.errorfoto",
						"archivosdepropiedades.mensajes.error");
				break;
			} else {
				FileManager.leerImagen(vf.getVsu().getCardSignUp().getCrearGamer(),
						vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText());
			}
			break;
		}
		case "fotoCoach": {
			if (vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText().isEmpty()
					|| vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText() == null) {
				MensajeEmergente.mensajeAdvertencia("archivosdepropiedades.mensajes.errorfoto",
						"archivosdepropiedades.mensajes.error");
				break;
			} else {
				FileManager.leerImagen(vf.getVsu().getCardSignUp().getCrearCoach(),
						vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText());
			}
			break;
		}
		case "fotoAdmin": {
			if (vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText().isEmpty()
					|| vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText() == null) {
				MensajeEmergente.mensajeAdvertencia("archivosdepropiedades.mensajes.errorfoto",
						"archivosdepropiedades.mensajes.error");
				break;
			} else {
				FileManager.leerImagen(vf.getVsu().getCardSignUp().getCrearAdmin(),
						vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText());
			}
			break;
		}
		case "verContrasenaGamer": {
			if (vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().setEchoChar((char) 0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().setEchoChar((char) 0);
			} else {
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().setEchoChar('●');
			}
			break;
		}
		case "verContrasenaCouch": {
			if (vf.getVsu().getCardSignUp().getCrearCoach().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().setEchoChar((char) 0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().setEchoChar((char) 0);
			} else {
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().setEchoChar('●');
			}
			break;
		}
		case "verContrasenaAdmin": {
			if (vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().setEchoChar((char) 0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().setEchoChar((char) 0);
			} else {
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().setEchoChar('●');
			}
			break;
		}
		case "verContrasenaAdmins": {
			if (vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setEchoChar((char) 0);
			} else {
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setEchoChar('●');
			}
			break;
		}
		case "btnCrearGamer": {
			try {
				// Extracción de datos del formulario
				String nombre = vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText();
				String contrasena = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().getPassword());
				String contrasenaConf = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().getPassword());
				String correo = vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo().getText();
				int edad = (int) vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad().getValue();
				String pais = vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().getSelectedItem().toString();
				int indexPais = vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().getSelectedIndex();
				int indexTrayectoria = vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva()
						.getSelectedIndex();
				int indexJuego = vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad()
						.getSelectedIndex();
				int anosDeExperiencia = (int) vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia()
						.getValue();

				// Validaciones
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
				ExceptionChecker.checkPasswordField(contrasena,
						"archivosdepropiedades.mensajes.error.contrasenainconsistente");
				ExceptionChecker.checkPasswordField(contrasenaConf,
						"archivosdepropiedades.mensajes.error.camposincompletos");
				ExceptionChecker.checkEmailField(correo, "archivosdepropiedades.mensajes.error.correo");
				ExceptionChecker.checkNegativeNumber(edad, "archivosdepropiedades.mensajes.error.camposincompletos");

				if (!contrasena.equals(contrasenaConf)) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenanoigual",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				if (indexPais == 0 || indexTrayectoria == 0 || indexJuego == 0) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Verificación de foto
				String[] extensiones = { ".jpg", ".png", ".jpeg" };
				String urlFoto = "imageUser/" + nombre;
				File imagen = null;
				for (String extension : extensiones) {
					File f = new File(urlFoto + extension);
					if (f.exists()) {
						imagen = f;
						urlFoto += extension;
						break;
					}
				}
				if (imagen == null) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Verificación de existencia de usuario
				boolean nombreOcupado = mf.getEdao()
						.find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0, null)) != null
						|| mf.getJdao().find(new Jugador(nombre, null, null, 0, null, null, null, null, 0)) != null
						|| mf.getAdao().find(new Administrador(nombre, null, null, 0, null, null, null)) != null;

				if (nombreOcupado) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Creación y guardado del nuevo Gamer
				String trayectoriaCompetitiva = vf.getVsu().getCardSignUp().getCrearGamer()
						.getDatoTrayectoriaCompetitiva().getSelectedItem().toString();
				String juegoEspecialidad = vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad()
						.getSelectedItem().toString();

				JugadorDTO gamer = new JugadorDTO(nombre, contrasena, correo, edad, pais, urlFoto,
						trayectoriaCompetitiva, juegoEspecialidad, anosDeExperiencia);
				mf.getJdao().add(gamer);

				String asunto = MensajeEmergente
						.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntogamercreado");
				String cuerpo = MensajeEmergente
						.obtenerMensaje("archivosdepropiedades.mensajescorreo.cuerpogamercreado") + nombre;
				MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

				// Limpieza de campos
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().setText("");
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().setText("");
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().setText("");
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo().setText("");
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad().setValue(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia().setValue(0);
				vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto().setIcon(null);

				// Mensaje de confirmación
				MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
						"archivosdepropiedades.mensajes.confirmacion.exito");

				vf.getVsu().setVisible(false);

			} catch (EmptyStringFieldException | InvalidPasswordException | InvalidEmailException
					| NegativeNumberException ex) {
				MensajeEmergente.mensajeAdvertencia(ex.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}

		case "btnCrearCoach": {
			try {
				String nombre = vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText();
				String contrasena = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().getPassword());
				String contrasenaConf = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().getPassword());
				String correo = vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo().getText();
				int edad = (int) vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad().getValue();
				String pais = vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().getSelectedItem().toString();
				int indexPais = vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().getSelectedIndex();
				int indexTrayectoria = vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional()
						.getSelectedIndex();
				int indexJuego = vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad()
						.getSelectedIndex();
				int anosDeExperiencia = (int) vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia()
						.getValue();

				// Validaciones básicas
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
				ExceptionChecker.checkPasswordField(contrasena,
						"archivosdepropiedades.mensajes.error.contrasenainconsistente");
				ExceptionChecker.checkEmailField(correo, "archivosdepropiedades.mensajes.error.correo");
				ExceptionChecker.checkNegativeNumber(edad, "archivosdepropiedades.mensajes.error.camposincompletos");

				if (!contrasena.equals(contrasenaConf)) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenanoigual",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				if (indexPais == 0 || indexTrayectoria == 0 || indexJuego == 0) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Validación de imagen
				String[] extensiones = { ".jpg", ".png", ".jpeg" };
				String urlFoto = "imageUser/" + nombre;
				File imagen = null;
				for (String extension : extensiones) {
					File f = new File(urlFoto + extension);
					if (f.exists()) {
						imagen = f;
						urlFoto += extension;
						break;
					}
				}
				if (imagen == null) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Validación de nombre existente (coach, gamer, admin)
				boolean nombreOcupado = mf.getEdao()
						.find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0, null)) != null
						|| mf.getJdao().find(new Jugador(nombre, null, null, 0, null, null, null, null, 0)) != null
						|| mf.getAdao().find(new Administrador(nombre, null, null, 0, null, null, null)) != null;

				if (nombreOcupado) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Datos restantes
				String trayectoriaCompetitiva = vf.getVsu().getCardSignUp().getCrearCoach()
						.getDatoTrayectoriaProfesional().getSelectedItem().toString();
				String juegoEspecialidad = vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad()
						.getSelectedItem().toString();

				// Verificación de contraseña
				// Crear objeto DTO y guardar
				EntrenadorDTO coach = new EntrenadorDTO(nombre, contrasena, correo, edad, pais, urlFoto,
						trayectoriaCompetitiva, juegoEspecialidad, anosDeExperiencia, null);
				mf.getEdao().add(coach);

				String asunto = MensajeEmergente
						.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntoentrenadorcreado");
				String cuerpo = MensajeEmergente
						.obtenerMensaje("archivosdepropiedades.mensajescorreo.cuerpoentrenadorcreado") + nombre;
				MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

				// Limpiar campos
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().setText("");
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().setText("");
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().setText("");
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo().setText("");
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad().setValue(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia().setValue(0);
				vf.getVsu().getCardSignUp().getCrearCoach().getSeleccionarFoto().setIcon(null);

				MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
						"archivosdepropiedades.mensajes.confirmacion.exito");
				vf.getVsu().setVisible(false);

			} catch (EmptyStringFieldException | InvalidPasswordException | InvalidEmailException
					| NegativeNumberException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}

		case "btnCrearAdmin": {
			try {
				String nombre = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText();
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");

				String contrasena = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().getPassword());
				ExceptionChecker.checkPasswordField(contrasena,
						"archivosdepropiedades.mensajes.error.contrasenainconsistente");

				String contrasenaConf = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().getPassword());
				ExceptionChecker.checkPasswordField(contrasenaConf,
						"archivosdepropiedades.mensajes.error.camposincompletos");

				if (!contrasena.equals(contrasenaConf)) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenanoigual",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				String correo = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo().getText();
				ExceptionChecker.checkEmailField(correo, "archivosdepropiedades.mensajes.error.correo");

				int edad = (int) vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad().getValue();
				ExceptionChecker.checkNegativeNumber(edad, "archivosdepropiedades.mensajes.error.camposincompletos");

				String pais = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().getSelectedItem().toString();
				if (vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().getSelectedIndex() == 0) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				String cargoEspecifico = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico().getText();
				ExceptionChecker.checkStringField(cargoEspecifico,
						"archivosdepropiedades.mensajes.error.camposincompletos");

				String contrasenaAdmins = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().getPassword());
				if (!contrasenaAdmins.equals("Transparencia290")) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenaincorrectaadmin",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				String[] extensiones = { ".jpg", ".png", ".jpeg" };
				String urlFoto = "imageUser/" + nombre;
				File imagen = null;
				for (String extension : extensiones) {
					File f = new File(urlFoto + extension);
					if (f.exists()) {
						imagen = f;
						urlFoto += extension;
						break;
					}
				}

				if (imagen == null) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				// Validación de nombre existente (coach, gamer, admin)
				boolean nombreOcupado = mf.getEdao()
						.find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0, null)) != null
						|| mf.getJdao().find(new Jugador(nombre, null, null, 0, null, null, null, null, 0)) != null
						|| mf.getAdao().find(new Administrador(nombre, null, null, 0, null, null, null)) != null;

				if (nombreOcupado) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
							"archivosdepropiedades.mensajes.error");
					break;
				}

				AdministradorDTO admin = new AdministradorDTO(nombre, contrasena, correo, edad, pais, urlFoto,
						cargoEspecifico);
				mf.getAdao().add(admin);

				String asunto = MensajeEmergente
						.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntoadmincreado");
				String cuerpo = MensajeEmergente
						.obtenerMensaje("archivosdepropiedades.mensajescorreo.cuerpoadmincreado") + nombre;
				MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().setText("");
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().setText("");
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().setText("");
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo().setText("");
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad().setValue(0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().setSelectedIndex(0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico().setText("");
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setText("");
				vf.getVsu().getCardSignUp().getCrearAdmin().getSeleccionarFoto().setIcon(null);

				MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
						"archivosdepropiedades.mensajes.confirmacion.exito");
				vf.getVsu().setVisible(false);

			} catch (EmptyStringFieldException | InvalidPasswordException | InvalidEmailException
					| NegativeNumberException ex) {
				MensajeEmergente.mensajeAdvertencia(ex.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}
		case "btnEntrar": {
			try {
				if (vf.getVp().getPanelPrincipal().getCheckEspañol().isSelected()
						|| vf.getVp().getPanelPrincipal().getCheckIngles().isSelected()) {

					String nombre = vf.getVp().getPanelPrincipal().getDatoUsuario().getText();
					ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
					String contrasena = String
							.valueOf(vf.getVp().getPanelPrincipal().getDatoContrasena().getPassword());
					ExceptionChecker.checkStringField(contrasena,
							"archivosdepropiedades.mensajes.error.camposincompletos");

					if (vf.getVp().getPanelPrincipal().getBtnAdmin().isSelected()) {
						Administrador adminTemp = mf.getAdao()
								.find(new Administrador(nombre, null, null, 0, null, null, null));
						if (adminTemp != null && adminTemp.getContrasena().equals(contrasena)) {
							nombreUsuario = nombre;
							vf.getVp().getPanelPrincipal().getDatoUsuario().setText("");
							vf.getVp().getPanelPrincipal().getDatoContrasena().setText("");
							MensajeEmergente.mensajeNormalMasAlgo("archivosdepropiedades.mensajes.bienvenida",
									" " + nombre, "archivosdepropiedades.mensajes.confirmacion.exito");

							String asunto = MensajeEmergente
									.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntoiniciosecionadmin");
							String cuerpo = MensajeEmergente.obtenerMensaje(
									"archivosdepropiedades.mensajescorreo.cuerpoiniciosecionadmin") + nombre;
							String correo = mf.getAdao()
									.find(new Administrador(nombre, null, null, 0, null, null, null)).getCorreo();
							MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

							vf.getVa().setVisible(true);
						} else {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.usuarionoencontrado",
									"archivosdepropiedades.mensajes.error");

						}

					} else if (vf.getVp().getPanelPrincipal().getBtnCouch().isSelected()) {
						Entrenador coach = mf.getEdao()
								.find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0, null));
						if (coach != null && coach.getContrasena().equals(contrasena)) {
							nombreUsuario = nombre;
							vf.getVp().getPanelPrincipal().getDatoUsuario().setText("");
							vf.getVp().getPanelPrincipal().getDatoContrasena().setText("");
							Equipo eq = coach.getEquipo();
							vf.getVe().getCardCoach().getPanelInscribirTorneo().getEquipoInscribir().removeAllItems();
							if (eq != null) {
								vf.getVe().getCardCoach().getPanelInscribirTorneo().getEquipoInscribir()
										.addItem(eq.getNombre());
							}
							MensajeEmergente.mensajeNormalMasAlgo("archivosdepropiedades.mensajes.bienvenida",
									" " + nombre, "archivosdepropiedades.mensajes.confirmacion.exito");

							String asunto = MensajeEmergente
									.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntoiniciosecioncoach");
							String cuerpo = MensajeEmergente.obtenerMensaje(
									"archivosdepropiedades.mensajescorreo.cuerpoiniciosecioncoach") + nombre;
							String correo = mf.getEdao()
									.find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0, null))
									.getCorreo();
							MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

							vf.getVe().setVisible(true);
						} else {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.usuarionoencontrado",
									"archivosdepropiedades.mensajes.error");
						}

					} else if (vf.getVp().getPanelPrincipal().getBtnGamer().isSelected()) {
						Jugador gamer = mf.getJdao()
								.find(new Jugador(nombre, null, null, 0, null, null, null, null, 0));
						if (gamer != null && gamer.getContrasena().equals(contrasena)) {
							nombreUsuario = nombre;
							vf.getVp().getPanelPrincipal().getDatoUsuario().setText("");
							vf.getVp().getPanelPrincipal().getDatoContrasena().setText("");
							MensajeEmergente.mensajeNormalMasAlgo("archivosdepropiedades.mensajes.bienvenida",
									" " + nombre, "archivosdepropiedades.mensajes.confirmacion.exito");

							String asunto = MensajeEmergente
									.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntoinicioseciongamer");
							String cuerpo = MensajeEmergente.obtenerMensaje(
									"archivosdepropiedades.mensajescorreo.cuerpoinicioseciongamer") + nombre;
							String correo = mf.getJdao()
									.find(new Jugador(nombre, null, null, 0, null, null, null, null, 0)).getCorreo();
							MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

							vf.getVg().setVisible(true);
						} else {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.usuarionoencontrado",
									"archivosdepropiedades.mensajes.error");
						}

					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.errorrol",
								"archivosdepropiedades.mensajes.error");
					}

				} else {
					JOptionPane.showMessageDialog(vf.getVp(), "Plis select your language.", "Warning.",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}

		case "btnMostrarGamers": {
			panelActual = "mostrarG";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String contrasena = prop.getProperty("archivosdepropiedades.arraymostrar.contrasena");
			String correo = prop.getProperty("archivosdepropiedades.arraymostrar.correo");
			String edad = prop.getProperty("archivosdepropiedades.arraymostrar.edad");
			String pais = prop.getProperty("archivosdepropiedades.arraymostrar.pais");
			String trayectoriaCompetitiva = prop
					.getProperty("archivosdepropiedades.arraymostrar.trayectoriacompetitiva");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegoespecialidad");
			String anosDeExperiencia = prop.getProperty("archivosdepropiedades.arraymostrar.anosexperiencia");
			String foto = prop.getProperty("archivosdepropiedades.arraymostrar.foto");

			String[] titulos = { nombre, contrasena, correo, edad, pais, trayectoriaCompetitiva, juegoEspecialidad,
					anosDeExperiencia, foto };
			vf.getVa().getCardAdmin().getPanelMostrar().setModelo(titulos, 1);
			mf.getJdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			vf.getVa().getCardAdmin().mostrarPanel("PanelMostrar");
			break;
		}
		case "btnMostrarTorneos": {
			panelActual = "mostrarT";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegoespecialidad");
			String fechaInicio = prop.getProperty("archivosdepropiedades.arraymostrar.fechainicio");
			String fechaFin = prop.getProperty("archivosdepropiedades.arraymostrar.fechafin");
			String formato = prop.getProperty("archivosdepropiedades.arraymostrar.tipotorneo");
			String maxEquipos = prop.getProperty("archivosdepropiedades.arraymostrar.maxequipos");
			String recompensa = prop.getProperty("archivosdepropiedades.arraymostrar.recompensa");
			String equi = prop.getProperty("archivosdepropiedades.arraymostrar.equiposinscritos");
			String[] titulos = { nombre, juegoEspecialidad, fechaInicio, fechaFin, formato, maxEquipos, recompensa,
					equi };
			vf.getVa().getCardAdmin().getPanelMostrar().setModelo(titulos, 0);
			mf.getTdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			vf.getVa().getCardAdmin().mostrarPanel("PanelMostrar");
			break;
		}
		case "btnMostrarCoaches": {
			panelActual = "mostrarC";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String contrasena = prop.getProperty("archivosdepropiedades.arraymostrar.contrasena");
			String correo = prop.getProperty("archivosdepropiedades.arraymostrar.correo");
			String edad = prop.getProperty("archivosdepropiedades.arraymostrar.edad");
			String pais = prop.getProperty("archivosdepropiedades.arraymostrar.pais");
			String trayectoriaProfesional = prop
					.getProperty("archivosdepropiedades.arraymostrar.trayectoriaprofesional");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegoespecialidad");
			String anosDeExperiencia = prop.getProperty("archivosdepropiedades.arraymostrar.anosexperiencia");
			String foto = prop.getProperty("archivosdepropiedades.arraymostrar.foto");

			String[] titulos = { nombre, contrasena, correo, edad, pais, trayectoriaProfesional, juegoEspecialidad,
					anosDeExperiencia, foto };
			vf.getVa().getCardAdmin().getPanelMostrar().setModelo(titulos, 1);
			mf.getEdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			vf.getVa().getCardAdmin().mostrarPanel("PanelMostrar");
			break;
		}
		case "PanelCrearTorneo": {
			vf.getVa().getCardAdmin().mostrarPanel("PanelAgregarTorneo");
			break;
		}
		case "btnAgregarTorneo": {
			try {
				String nombreJuego = vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoJuego().getSelectedItem()
						.toString();
				String nombreTorneo = vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoNombreTorneo().getText();
				ExceptionChecker.checkStringField(nombreTorneo,
						"archivosdepropiedades.mensajes.error.camposincompletos");
				String formatoTorneo = vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFormatoTorneo()
						.getSelectedItem().toString();
				int maxEquipos = (int) vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoMaxEquipos().getValue();
				long premio = ((Number) vf.getVa().getCardAdmin().getPanelAgregarTorneo().getRecompensa().getValue())
						.longValue();
				Date fechaInicio = vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFechaInicio().getDate();
				Date fechaFin = vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFechaFin().getDate();
				if (mf.getTdao().find(new Torneo(nombreTorneo, null, null, null, null, 0, 0, null)) == null) {
					TorneoDTO torneo = new TorneoDTO(nombreTorneo, nombreJuego, fechaInicio, fechaFin, formatoTorneo,
							maxEquipos, premio);
					mf.getTdao().add(torneo);
					mf.getTdao().asignarElementosAComboBox(
							vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes());
					mf.getTdao().asignarElementosAComboBox(
							vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos());
					mf.getTdao().asignarElementosAComboBox(
							vf.getVe().getCardCoach().getPanelInscribirTorneo().getTorneoInscribir());
					mf.getTdao().asignarElementosAComboBox(
							vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos());
					mf.getTdao().asignarElementosAComboBox(
							vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes());
					String correo = mf.getAdao().find(new Administrador(nombreUsuario, null, null, 0, null, null, null))
							.getCorreo();
					String asunto = MensajeEmergente
							.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntocreaciontorneo");
					String cuerpo = MensajeEmergente
							.obtenerMensaje("archivosdepropiedades.mensajescorreo.cuerpocreasiontorneo") + nombreTorneo;
					MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

					vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoNombreTorneo().setText("");
					vf.getVa().getCardAdmin().getPanelAgregarTorneo().getRecompensa().setValue(0);
					vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoMaxEquipos().setValue(0);
					vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFechaInicio().setDate(null);
					vf.getVa().getCardAdmin().getPanelAgregarTorneo().getDatoFechaFin().setDate(null);
					MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
							"archivosdepropiedades.mensajes.confirmacion.exito");

					mf.getTdao().asignarElementosAComboBox(
							vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes());
					mf.getTdao().asignarElementosAComboBox(
							vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes());
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.torneoesistente",
							"archivosdepropiedades.mensajes.error");

				}
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}
		case "btnBuscar": {
			if (panelActual == "mostrarC") {
				String nombre = vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().getText();
				Entrenador coach = new Entrenador(nombre, null, null, 0, null, null, null, null, 0, null);
				vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().setText("");
				mf.getEdao().showOne(vf.getVa().getCardAdmin().getPanelMostrar().getTabla(), coach,
						MensajeEmergente.obtenerMensaje("archivosdepropiedades.panelmostrar.noencontrado"));
			} else if (panelActual == "mostrarG") {
				String nombre = vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().getText();
				Jugador gamer = new Jugador(nombre, null, null, 0, null, null, null, null, 0);
				vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().setText("");
				mf.getJdao().showOne(vf.getVa().getCardAdmin().getPanelMostrar().getTabla(), gamer,
						MensajeEmergente.obtenerMensaje("archivosdepropiedades.panelmostrar.noencontrado"));
			} else if (panelActual == "mostrarT") {
				String nombre = vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().getText();
				Torneo torneo = new Torneo(nombre, null, null, null, null, 0, 0);
				vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().setText("");
				mf.getTdao().showOne(vf.getVa().getCardAdmin().getPanelMostrar().getTabla(), torneo,
						MensajeEmergente.obtenerMensaje("archivosdepropiedades.panelmostrar.noencontrado"));
			} else if (panelActual == "mostrarE") {
				String nombre = vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().getText();
				Equipo equipo = new Equipo(nombre, null, null, null, null, null, 0);
				vf.getVa().getCardAdmin().getPanelMostrar().getaBuscar().setText("");
				mf.getEqdao().showOne(vf.getVa().getCardAdmin().getPanelMostrar().getTabla(), equipo,
						MensajeEmergente.obtenerMensaje("archivosdepropiedades.panelmostrar.noencontrado"));
			} else {
				MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
						"archivosdepropiedades.mensajes.error");
			}
			break;
		}
		case "btnShowllAll": {
			if (panelActual == "mostrarC") {
				mf.getEdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			} else if (panelActual == "mostrarG") {
				mf.getJdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			} else if (panelActual == "mostrarT") {
				mf.getTdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			} else if (panelActual == "mostrarE") {
				mf.getEqdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
				vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			} else {
				MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
						"archivosdepropiedades.mensajes.error");
			}
			break;
		}
		case "btnEliminar": {
			int fila = vf.getVa().getCardAdmin().getPanelMostrar().getTabla().getSelectedRow();
			if (fila == -1) {
				MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
						"archivosdepropiedades.mensajes.error");
				break;
			} else if (fila != -1) {
				String nombre = vf.getVa().getCardAdmin().getPanelMostrar().getTabla().getValueAt(fila, 0).toString();

				if (panelActual.equals("mostrarC")) {
					int opcion = JOptionPane.showConfirmDialog(null,
							MensajeEmergente.obtenerMensaje("archivosdepropiedades.mensajes.preguntas.eliminar"),
							MensajeEmergente
									.obtenerMensaje("archivosdepropiedades.mensajes.preguntas.confirmacioneliminar"),
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (opcion == JOptionPane.YES_OPTION) {
						EntrenadorDTO en = new EntrenadorDTO(nombre, null, null, 0, null, null, null, null, 0, null);
						Equipo eq = mf.getEdao().find(DataMapper.EntrenadorDTOToEntrenador(en)).getEquipo();
						EquipoDTO eqdto = DataMapper.EquipoToEquipoDTO(eq);
						if (eq != null) {
							eq.setEntrenador(null);
							mf.getEqdao().delete(eqdto);

						}
						boolean exito = mf.getEdao().delete(en);
						if (!exito) {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.eliminar",
									"archivosdepropiedades.mensajes.error");
						} else {
							MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exitoeliminar",
									"archivosdepropiedades.mensajes.confirmacion.exito");
							mf.getEqdao().asignarElmentosCombos(
									vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes());
							mf.getEqdao().asignarElmentosCombos(
									vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1());
							mf.getEqdao().asignarElmentosCombos(
									vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2());
							mf.getEqdao().asignarElmentosCombos(
									vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador());
							mf.getEdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
						}
					}
				} else if (panelActual == "mostrarG") {
					JugadorDTO en = new JugadorDTO(nombre, null, null, 0, null, null, null, null, 0);
					boolean exito = mf.getJdao().delete(en);
					if (!exito) {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.eliminar",
								"archivosdepropiedades.mensajes.error");
						break;
					} else {
						MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exitoeliminar",
								"archivosdepropiedades.mensajes.confirmacion.exito");
						mf.getJdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
					}
				} else if (panelActual == "mostrarT") {
					TorneoDTO en = new TorneoDTO(nombre, null, null, null, null, 0, 0);
					boolean exito = mf.getTdao().delete(en);
					if (!exito) {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.eliminar",
								"archivosdepropiedades.mensajes.error");
						break;
					} else {
						MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exitoeliminar",
								"archivosdepropiedades.mensajes.confirmacion.exito");
						mf.getTdao().asignarElementosAComboBox(
								vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes());
						mf.getTdao().asignarElementosAComboBox(
								vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos());
						mf.getTdao().asignarElementosAComboBox(
								vf.getVe().getCardCoach().getPanelInscribirTorneo().getTorneoInscribir());
						mf.getTdao().asignarElementosAComboBox(
								vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos());
						mf.getTdao().asignarElementosAComboBox(
								vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes());
						mf.getTdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
					}
				} else if (panelActual == "mostrarE") {
					String nombreEnt = vf.getVa().getCardAdmin().getPanelMostrar().getTabla().getValueAt(fila, 4)
							.toString();
					Entrenador creador = mf.getEdao().find(DataMapper.EntrenadorDTOToEntrenador(
							new EntrenadorDTO(nombreEnt, null, null, 0, null, null, null, null, 0, null)));
					if (creador != null) {
						creador.setEquipo(null);
						mf.getEdao().escribirArchivoSerializado();
					}
					EquipoDTO en = new EquipoDTO(nombre, null, null, null, null, null, 0);
					boolean exito = mf.getEqdao().delete(en);
					if (!exito) {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.eliminar",
								"archivosdepropiedades.mensajes.error");
						break;
					} else {
						MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exitoeliminar",
								"archivosdepropiedades.mensajes.confirmacion.exito");
						mf.getEqdao().asignarElmentosCombos(
								vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes());
						mf.getEqdao()
								.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1());
						mf.getEqdao()
								.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2());
						mf.getEqdao()
								.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador());
					}
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
				}
				break;
			}
		}
		case "PanelCrearEquipo": {
			vf.getVe().getCardCoach().mostrarPanel("PanelAgregarEquipo");
			break;
		}
		case "PanelCrearPartida": {
			vf.getVa().getCardAdmin().mostrarPanel("PanelAgregarPartida");
			break;
		}
		case "btnMostrarEquipos": {
			panelActual = "mostrarE";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String cantidadJugadores = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadintegrantes");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegodesempeñado");
			String torneosInscritos = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadtorneosincritos");
			String partidasJugadas = prop.getProperty("archivosdepropiedades.arraymostrar.partidasjugadas");
			String entrenador = prop.getProperty("archivosdepropiedades.arraymostrar.entrenador");
			String[] titulos = { nombre, cantidadJugadores, juegoEspecialidad, torneosInscritos, entrenador,
					partidasJugadas };
			vf.getVa().getCardAdmin().getPanelMostrar().setModelo(titulos, 0);
			mf.getEqdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();

			vf.getVa().getCardAdmin().mostrarPanel("PanelMostrar");
			break;
		}
		case "PanelActualizarPartida": {
			vf.getVa().getCardAdmin().mostrarPanel("PanelActualizarPartida");
			break;
		}
		case "PanelAnalytics": {
			vf.getVa().getCardAdmin().mostrarPanel("PanelInforme");
			break;
		}
		case "btnAgregarEquipo": {
			try {
				Entrenador creador = mf.getEdao()
						.find(new Entrenador(nombreUsuario, null, null, 0, null, null, null, null, 0, null));
				if (creador.getEquipo() != null) {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.equipoyjugador",
							"archivosdepropiedades.mensajes.error");
					break;
				} else {
					String nombreEquipo = vf.getVe().getCardCoach().getPanelAgregarEquipo().getDatoNombreEquipo()
							.getText();
					ExceptionChecker.checkStringField(nombreEquipo,
							"archivosdepropiedades.mensajes.error.camposincompletos");
					String juegoEspecialidad = vf.getVe().getCardCoach().getPanelAgregarEquipo().getDatoJuego()
							.getSelectedItem().toString();
					if (mf.getEqdao().find(new Equipo(nombreEquipo, null, null, null, null, null, 0)) == null) {
						EquipoDTO equipo = new EquipoDTO(nombreEquipo, juegoEspecialidad, creador, 0);
						mf.getEqdao().add(equipo);
						creador.setEquipo(DataMapper.EquipoDTOToEquipo(equipo));
						mf.getEdao().escribirArchivoSerializado();
						mf.getEqdao().escribirArchivoTxt();

						String correo = mf.getEdao()
								.find(new Entrenador(nombreUsuario, null, null, 0, null, null, null, null, 0, null))
								.getCorreo();
						String asunto = MensajeEmergente
								.obtenerMensaje("archivosdepropiedades.mensajescorreo.asuntocreacionequipo");
						String cuerpo = MensajeEmergente.obtenerMensaje(
								"archivosdepropiedades.mensajescorreo.cuerpocreasionequipo") + nombreEquipo;
						MensajeEmergente.enviarCorreo(correo, asunto, cuerpo);

						vf.getVe().getCardCoach().getPanelAgregarEquipo().getDatoNombreEquipo().setText("");
						vf.getVe().getCardCoach().getPanelAgregarEquipo().getDatoJuego().setSelectedIndex(0);

						mf.getEqdao().asignarElmentosCombos(
								vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes());
						mf.getEqdao()
								.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1());
						mf.getEqdao()
								.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2());
						mf.getEqdao()
								.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador());

						MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
								"archivosdepropiedades.mensajes.confirmacion.exito");
					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
								"archivosdepropiedades.mensajes.error");

					}
				}
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;

		}

		case "panelMostrarEquipos": {
			panelActual = "mostrarEEntrenador";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String cantidadJugadores = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadintegrantes");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegodesempeñado");
			String torneosInscritos = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadtorneosincritos");
			String partidasJugadas = prop.getProperty("archivosdepropiedades.arraymostrar.partidasjugadas");
			String entrenador = prop.getProperty("archivosdepropiedades.arraymostrar.entrenador");
			String[] titulos = { nombre, cantidadJugadores, juegoEspecialidad, torneosInscritos, entrenador,
					partidasJugadas };
			vf.getVe().getCardCoach().getPanelMostrar().setModelo(titulos, 0);
			mf.getEqdao().showAll(vf.getVe().getCardCoach().getPanelMostrar().getTabla());
			vf.getVe().getCardCoach().getPanelMostrar().getTabla().revalidate();
			vf.getVe().getCardCoach().getPanelMostrar().getTabla().repaint();

			vf.getVe().getCardCoach().mostrarPanel("PanelMostrar");
			break;
		}
		case "panelActualizarEquipo": {
			panelActual = "actualizarE";

			vf.getVe().getCardCoach().mostrarPanel("PanelActualizarEquipo");
			break;
		}
		case "ActualizarCuentaEntrenador": {
			panelActual = "actualizarcuentaE";

			vf.getVe().getCardCoach().mostrarPanel("PanelActualizarEntrenador");
			break;
		}
		case "ActualizarCuentaGamer": {
			panelActual = "actualizarcuentaG";

			vf.getVg().getCardGamer().mostrarPanel("PanelActualizarJugador");
			break;
		}
		case "comboEquipos": {
			if(mf.getEqdao().getListaEquipos().isEmpty()) {
				break;
			}
			if (vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes().getSelectedIndex() == -1) {
				break;
			} else {
				String nombre = vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes().getSelectedItem()
						.toString();
				Equipo equipo = mf.getEqdao().find(new Equipo(nombre, null, null, null, null, null, 0));
				if (equipo != null) {
					vf.getVa().getCardAdmin().getPanelActualizar().getDatoNombreEquipo().setText(equipo.getNombre());
					vf.getVa().getCardAdmin().getPanelActualizar().getDatoNombreEquipo().setText(nombre);
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
							"archivosdepropiedades.mensajes.error");
				}
			}
			break;
		}
		case "comboTorneos": {
			if(mf.getTdao().getListaTorneos().isEmpty()) {
				break;
			}
			if (vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes().getSelectedIndex() == -1) {
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoNombreTorneo().setText("");
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoFechaInicio().setDate(null);
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoFechaFin().setDate(null);
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoMaxEquipos().setValue(0);
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getRecompensa().setValue(0);
				break;
			} else {
				String nombre = vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes()
						.getSelectedItem().toString();
				Torneo torneo = mf.getTdao().find(new Torneo(nombre, null, null, null, null, 0, 0));
				if (torneo != null) {
					vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoNombreTorneo()
							.setText(torneo.getNombre());
					vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoFechaInicio()
							.setDate(torneo.getFechaInicio());
					vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoFechaFin()
							.setDate(torneo.getFechaFin());
					vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoMaxEquipos()
							.setValue(torneo.getMaxEquipos());
					vf.getVa().getCardAdmin().getPanelActualizarTorneo().getRecompensa().setValue(torneo.getPremio());
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
							"archivosdepropiedades.mensajes.error");
				}
				vf.getVa().getCardAdmin().getPanelActualizar().getDatoNombreEquipo().setText(nombre);
			}
			break;
		}
		case "btnActualizarTorneo": {
			try {
				if (mf.getTdao().getListaTorneos().isEmpty()) {
					break;
				}
				String nombreTorneo = vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes()
						.getSelectedItem().toString();
				String nombreNuevo = vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoNombreTorneo()
						.getText();
				ExceptionChecker.checkStringField(nombreNuevo,
						"archivosdepropiedades.mensajes.error.camposincompletos");
				Date fechaInicio = vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoFechaInicio().getDate();
				Date fechaFin = vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoFechaFin().getDate();
				int maxEquipos = (int) vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoMaxEquipos()
						.getValue();
				long premio = ((Number) vf.getVa().getCardAdmin().getPanelActualizarTorneo().getRecompensa().getValue())
						.longValue();
				mf.getTdao().update(new TorneoDTO(nombreTorneo, null, null, null, null, 0, 0),
						new TorneoDTO(nombreNuevo, null, fechaInicio, fechaFin, null, maxEquipos, premio));
				MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
						"archivosdepropiedades.mensajes.confirmacion.exito");
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoNombreTorneo().setText("");
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getRecompensa().setValue(0);
				vf.getVa().getCardAdmin().getPanelActualizarTorneo().getDatoMaxEquipos().setValue(0);
				mf.getTdao().asignarElementosAComboBox(
						vf.getVa().getCardAdmin().getPanelActualizarTorneo().getTorneosExistentes());
				mf.getTdao().asignarElementosAComboBox(
						vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos());
				mf.getTdao().asignarElementosAComboBox(
						vf.getVe().getCardCoach().getPanelInscribirTorneo().getTorneoInscribir());
				mf.getTdao().asignarElementosAComboBox(
						vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos());
				mf.getTdao().asignarElementosAComboBox(
						vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes());
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}
		case "btnActualizarEquipo": {
			try {
				String nombreAnterior = vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes()
						.getSelectedItem().toString();
				String nombreNuevo = vf.getVa().getCardAdmin().getPanelActualizar().getDatoNombreEquipo().getText();
				ExceptionChecker.checkStringField(nombreNuevo,
						"archivosdepropiedades.mensajes.error.camposincompletos");
				mf.getEqdao().update(new EquipoDTO(nombreAnterior, null, null, null, null, null, 0),
						new EquipoDTO(nombreNuevo, null, null, null, null, null, 0));
				MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
						"archivosdepropiedades.mensajes.confirmacion.exito");
				vf.getVa().getCardAdmin().getPanelActualizar().getDatoNombreEquipo().setText("");
				mf.getEqdao()
						.asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelActualizar().getEquiposExistentes());
				mf.getEqdao().asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1());
				mf.getEqdao().asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2());
				mf.getEqdao().asignarElmentosCombos(vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador());

			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
			break;
		}
		case "PanelActualizarEquipo": {
			vf.getVa().getCardAdmin().mostrarPanel("PanelActualizarEquipo");
			break;
		}
		case "PanelActualizarTorneo": {
			vf.getVa().getCardAdmin().mostrarPanel("PanelActualizarTorneo");
			break;
		}
		case "comboTorneosexistentes": {

			if (mf.getTdao().getListaTorneos().isEmpty()) {
				break;
			}
			int index = vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes()
					.getSelectedIndex();
			if (index == -1) {
				break;
			}
			String nombre = vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes().getSelectedItem()
					.toString();
			mf.getTdao().mostrarEquiposEnComboBox(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1(),
					new TorneoDTO(nombre, null, null, null, null, 0, 0),2);

			mf.getTdao().mostrarEquiposEnComboBox(vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2(),
					new TorneoDTO(nombre, null, null, null, null, 0, 0),2);

			mf.getTdao().mostrarEquiposEnComboBox(vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador(),
					new TorneoDTO(nombre, null, null, null, null, 0, 0),1);

			break;
		}
		case "PanelInscribirTorneo": {
			vf.getVe().getCardCoach().mostrarPanel("PanelInscribirTorneo");
			break;
		}
		case "PanelTorneoAnalytics": {
			panelActual = "mostrarEEntrenador";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String cantidadJugadores = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadintegrantes");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegodesempeñado");
			String torneosInscritos = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadtorneosincritos");
			String partidasJugadas = prop.getProperty("archivosdepropiedades.arraymostrar.partidasjugadas");
			String entrenador = prop.getProperty("archivosdepropiedades.arraymostrar.entrenador");
			String puntos = prop.getProperty("archivosdepropiedades.arraymostrar.puntos");
			String[] titulos = { nombre, cantidadJugadores, juegoEspecialidad, torneosInscritos, entrenador,
					partidasJugadas, puntos };
			vf.getVa().getCardAdmin().getPanelMostrarTorneo().setModelo(titulos, 0);
			vf.getVa().getCardAdmin().mostrarPanel("PanelMostrarTorneo");
			break;
		}
		case "comboTorneosAnalytics": {

			if(mf.getTdao().getListaTorneos().isEmpty()) {
				break;
			}
			if (vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos().getSelectedIndex() == -1) {
				break;
			} else {
				String nombreT = vf.getVa().getCardAdmin().getPanelMostrarTorneo().getComboBoxTorneos()
						.getSelectedItem().toString();
				Torneo torneo = mf.getTdao().find(new Torneo(nombreT, null, null, null, null, 0, 0));
				if (torneo != null) {
					mf.getTdao().showEquipos(vf.getVa().getCardAdmin().getPanelMostrarTorneo().getTabla(), torneo);
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
							"archivosdepropiedades.mensajes.error");
				}
			}
			break;
		}
		case "comboTorneosAnalyticsEntrenador":{
			if(mf.getTdao().getListaTorneos().isEmpty()) {
				break;
			}
			if (vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos().getSelectedIndex() == -1) {
				break;
			} else {
				String nombreT = vf.getVe().getCardCoach().getPanelMostrarTorneo().getComboBoxTorneos()
						.getSelectedItem().toString();
				Torneo torneo = mf.getTdao().find(new Torneo(nombreT, null, null, null, null, 0, 0));
				if (torneo != null) {
					mf.getTdao().showEquipos(vf.getVe().getCardCoach().getPanelMostrarTorneo().getTabla(), torneo);
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
							"archivosdepropiedades.mensajes.error");
				}
			}
			break;
		}
		case "btnInscribirTorneo": {
			String nombreTorneo = vf.getVe().getCardCoach().getPanelInscribirTorneo().getTorneoInscribir()
					.getSelectedItem().toString();
			String nombreEquipo = vf.getVe().getCardCoach().getPanelInscribirTorneo().getEquipoInscribir()
					.getSelectedItem().toString();

			Torneo t = mf.getTdao()
					.find(DataMapper.TorneoDTOToTorneo(new TorneoDTO(nombreTorneo, null, null, null, null, 0, 0)));

			if (t != null) {
				Equipo team = mf.getEqdao().find(
						DataMapper.EquipoDTOToEquipo(new EquipoDTO(nombreEquipo, null, null, null, null, null, 0)));

				if (team != null) {
					boolean yaInscrito = false;

					for (Equipo equipo : t.getListaEquiposInscritos()) {
						if (equipo.getNombre().equals(team.getNombre())) {
							yaInscrito = true;
							break;
						}
					}

					if (yaInscrito) {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.equipoinscrito",
								"archivosdepropiedades.mensajes.error");
					} else {
						t.getListaEquiposInscritos().add(team);
						team.getTorneosInscritos().add(t);
						mf.getTdao().escribirArchivoSerializado();
						mf.getEqdao().escribirArchivoTxt();
						MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
								"archivosdepropiedades.mensajes.confirmacion.exito");
					}
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
							"archivosdepropiedades.mensajes.error");
				}
			} else {
				MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
						"archivosdepropiedades.mensajes.error");
			}
			break;
		}
		case "mostrarTorneosEntrenador": {
			panelActual = "mostrarEEntrenador";
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String cantidadJugadores = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadintegrantes");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegodesempeñado");
			String torneosInscritos = prop.getProperty("archivosdepropiedades.arraymostrar.cantidadtorneosincritos");
			String partidasJugadas = prop.getProperty("archivosdepropiedades.arraymostrar.partidasjugadas");
			String entrenador = prop.getProperty("archivosdepropiedades.arraymostrar.entrenador");
			String puntos = prop.getProperty("archivosdepropiedades.arraymostrar.puntos");
			String[] titulos = { nombre, cantidadJugadores, juegoEspecialidad, torneosInscritos, entrenador,
					partidasJugadas, puntos };
			vf.getVe().getCardCoach().getPanelMostrarTorneo().setModelo(titulos, 0);
			vf.getVe().getCardCoach().mostrarPanel("PanelMostrarTorneo");
			vf.getVe().getCardCoach().mostrarPanel("PanelMostrarTorneo");
			break;
		}
		case "btnEliminarPanelCoach":{
			MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.notdelete",
					"archivosdepropiedades.mensajes.error");
			break;
		}
		case "btnAgregarPartida": {
		    Object torneoItem = vf.getVa().getCardAdmin().getPanelAgregarPartida().getTorneosExistentes().getSelectedItem();
		    Object equipo1Item = vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo1().getSelectedItem();
		    Object equipo2Item = vf.getVa().getCardAdmin().getPanelAgregarPartida().getEquipo2().getSelectedItem();
		    Object ganadorItem = vf.getVa().getCardAdmin().getPanelAgregarPartida().getGanador().getSelectedItem();
		    Date fecha = vf.getVa().getCardAdmin().getPanelAgregarPartida().getFechaPartida().getDate();

		    // Verificar que ninguno de los elementos es nulo
		    if (torneoItem == null || equipo1Item == null || equipo2Item == null || ganadorItem == null || fecha == null) {
		        MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
		                "archivosdepropiedades.mensajes.error");
		        break;
		    }

		    // Convertir a String
		    String nombreTorneo = torneoItem.toString();
		    String nombreEquipo1 = equipo1Item.toString();
		    String nombreEquipo2 = equipo2Item.toString();
		    String nombreGanador = ganadorItem.toString();

		    // Valor por defecto para el juego (puedes personalizarlo si tienes ese campo en GUI)
		    String juego = "Desconocido";

		    // Buscar objetos reales
		    Torneo torneo = mf.getTdao().find(
		            DataMapper.TorneoDTOToTorneo(new TorneoDTO(nombreTorneo, null, null, null, null, 0, 0)));
		    Equipo eq1 = mf.getEqdao().find(
		            DataMapper.EquipoDTOToEquipo(new EquipoDTO(nombreEquipo1, null, null, null, null, null, 0)));
		    Equipo eq2 = mf.getEqdao().find(
		            DataMapper.EquipoDTOToEquipo(new EquipoDTO(nombreEquipo2, null, null, null, null, null, 0)));
		    Equipo ganadorEq = mf.getEqdao().find(
		            DataMapper.EquipoDTOToEquipo(new EquipoDTO(nombreGanador, null, null, null, null, null, 0)));

		    if (torneo == null || eq1 == null || eq2 == null || ganadorEq == null) {
		        MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
		                "archivosdepropiedades.mensajes.error");
		        break;
		    }

		    // Generar un ID aleatorio único
		    Random rand = new Random();
		    int numeroAleatorio = rand.nextInt(100000000);
		    PartidaDTO partida = new PartidaDTO(numeroAleatorio, eq1, eq2, ganadorEq, juego, fecha, torneo);

		    while (mf.getPdao().find(DataMapper.PartidaDTOToPartida(partida)) != null) {
		        numeroAleatorio = rand.nextInt(100000000);
		        partida.setId(numeroAleatorio);
		    }

		    // Agregar la partida
		    mf.getPdao().add(partida);

		    // Verificar el formato del torneo y actuar en consecuencia
		    String formato = torneo.getFormato();

		    if (formato.equalsIgnoreCase("Liga")) {
		        // Sumar puntos al equipo ganador
		        if (ganadorEq.getNombre().equals(eq1.getNombre())) {
		            eq1.setPuntos(eq1.getPuntos() + 3);
		        } else if (ganadorEq.getNombre().equals(eq2.getNombre())) {
		            eq2.setPuntos(eq2.getPuntos() + 3);
		        }
		    } else if (formato.equalsIgnoreCase("Groups")) {
		        // Eliminar al equipo perdedor
		        Equipo perdedor = ganadorEq.getNombre().equals(eq1.getNombre()) ? eq2 : eq1;
		        torneo.getListaEquiposInscritos().remove(perdedor);
		    }

		    MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
		            "archivosdepropiedades.mensajes.confirmacion.exito");
		    break;
		}
		case "btnTopGamers":{
			mf.getEqdao().asignarElmentosCombos(vf.getIe().getEquipos());
			vf.getIe().setVisible(true);
			break;
		}
		case "btnInscribirJugador":{
			String nombreEquipo = vf.getIe().getEquipos().getSelectedItem().toString();

			Equipo t = mf.getEqdao()
					.find(DataMapper.EquipoDTOToEquipo(new EquipoDTO(nombreEquipo, null, null, null, null, null, 0)));

			if (t != null) {
				Jugador team = mf.getJdao().find(
						DataMapper.JugadorDTOToJugador(new JugadorDTO(nombreUsuario,null, null, 0, null, null, null, null, 0)));

				if (team != null) {
					boolean yaInscrito = false;

					for (Jugador equipo : t.getIntegrantes()) {
						if (equipo.getNombre().equals(team.getNombre())) {
							yaInscrito = true;
							break;
						}
					}

					if (yaInscrito) {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error",
								"archivosdepropiedades.mensajes.error");
					} else {
						t.getIntegrantes().add(team);
						mf.getEqdao().escribirArchivoSerializado();
						mf.getEqdao().escribirArchivoTxt();
						MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exito",
								"archivosdepropiedades.mensajes.confirmacion.exito");
					}
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
							"archivosdepropiedades.mensajes.error");
				}
			} else {
				MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.noencontrado",
						"archivosdepropiedades.mensajes.error");
			}
			break;
		}
		}

	}

}