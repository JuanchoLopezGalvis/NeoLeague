package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.EmptyStringFieldException;
import co.edu.unbosque.util.exception.InvalidEmailException;
import co.edu.unbosque.util.exception.InvalidPasswordException;
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

	private static Properties prop;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		prop = new Properties();
		asignarLectores();
	}

	/**
	 * Metodo run, que se encarga de ejecutar el aplicativo.
	 */
	public void run() {
		FileManager.crearCarpeta();
		vf.getVp().setVisible(true);
		vf.getVsu().getRoles().setSelectedIndex(0);

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
				vf.getVa().getAdministrarGamer().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarjugadores"));
				vf.getVa().getAdministrarCouch().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarentrenador"));
				vf.getVa().getMostrarGamers().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarjugadores"));
				vf.getVa().getMostrarCoachs().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarentrenadores"));
				vf.getVa().getEliminarGamer().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarjugadores"));
				vf.getVa().getEliminarCouch().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarentrenadores"));
				vf.getVa().getAdministrarTorneos().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrartorneos"));
				vf.getVa().getAdministrarPartidas().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrartorneos"));
				vf.getVa().getCrearTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.creartorneos"));
				vf.getVa().getCrearPartida().setText(prop.getProperty("archivosdepropiedades.panelAdmin.crearpartidos"));
				vf.getVa().getMostrarTorneos().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrartorneos"));
				vf.getVa().getMostrarPartidas().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarpartidos"));
				vf.getVa().getActualizarTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizartorneo"));
				vf.getVa().getActualizarPartida().setText(prop.getProperty("archivosdepropiedades.panelAdmin.actializarpartidos"));
				vf.getVa().getEliminarTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminartorneos"));
				vf.getVa().getEliminarPartida().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarpartidos"));
				vf.getVa().getAdministrarEquipo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.Administrarequipos"));
				vf.getVa().getActualizarEquipo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizarequipos"));
				vf.getVa().getEliminarEquipo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarequipos"));
				vf.getVa().getMostrarEquipos().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarequipos"));
				vf.getVa().getConfigurarNotificaciones().setText(prop.getProperty("archivosdepropiedades.panelAdmin.configurarnotificaciones"));
				vf.getVa().getAnaliytics().setText(prop.getProperty("archivosdepropiedades.panelAdmin.analitica"));

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
				vf.getVa().getAdministrarGamer().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarjugadores"));
				vf.getVa().getAdministrarCouch().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrarentrenador"));
				vf.getVa().getMostrarGamers().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarjugadores"));
				vf.getVa().getMostrarCoachs().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarentrenadores"));
				vf.getVa().getEliminarGamer().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarjugadores"));
				vf.getVa().getEliminarCouch().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarentrenadores"));
				vf.getVa().getAdministrarTorneos().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrartorneos"));
				vf.getVa().getAdministrarPartidas().setText(prop.getProperty("archivosdepropiedades.panelAdmin.administrartorneos"));
				vf.getVa().getCrearTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.creartorneos"));
				vf.getVa().getCrearPartida().setText(prop.getProperty("archivosdepropiedades.panelAdmin.crearpartidos"));
				vf.getVa().getMostrarTorneos().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrartorneos"));
				vf.getVa().getMostrarPartidas().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarpartidos"));
				vf.getVa().getActualizarTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizartorneo"));
				vf.getVa().getActualizarPartida().setText(prop.getProperty("archivosdepropiedades.panelAdmin.actializarpartidos"));
				vf.getVa().getEliminarTorneo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminartorneos"));
				vf.getVa().getEliminarPartida().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarpartidos"));
				vf.getVa().getAdministrarEquipo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.Administrarequipos"));
				vf.getVa().getActualizarEquipo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.actualizarequipos"));
				vf.getVa().getEliminarEquipo().setText(prop.getProperty("archivosdepropiedades.panelAdmin.eliminarequipos"));
				vf.getVa().getMostrarEquipos().setText(prop.getProperty("archivosdepropiedades.panelAdmin.mostrarequipos"));
				vf.getVa().getConfigurarNotificaciones().setText(prop.getProperty("archivosdepropiedades.panelAdmin.configurarnotificaciones"));
				vf.getVa().getAnaliytics().setText(prop.getProperty("archivosdepropiedades.panelAdmin.analitica"));

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

				String nombre = vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText();
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
				String contrasena = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().getPassword());
				ExceptionChecker.checkPasswordField(contrasena,
						"archivosdepropiedades.mensajes.error.contrasenainconsistente");
				String contrasenaConf = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().getPassword());
				ExceptionChecker.checkPasswordField(contrasenaConf,
						"archivosdepropiedades.mensajes.error.camposincompletos");
				String correo = vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo().getText();
				ExceptionChecker.checkEmailField(correo, "archivosdepropiedades.mensajes.error.correo");
				int edad = (int) vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad().getValue();
				String pais = vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().getSelectedItem().toString();
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
				String trayectoriaCompetitiva = vf.getVsu().getCardSignUp().getCrearGamer()
						.getDatoTrayectoriaCompetitiva().getSelectedItem().toString();
				String juegoEspecialidad = vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad()
						.getSelectedItem().toString();
				int anosDeExperiencia = (int) vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia()
						.getValue();
				if (!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && edad != 0 && !pais.isEmpty()
						&& imagen != null && !trayectoriaCompetitiva.isEmpty() && !juegoEspecialidad.isEmpty()
						&& vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva()
								.getSelectedIndex() != 0
						&& vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad()
								.getSelectedIndex() != 0
						&& vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().getSelectedIndex() != 0) {
					if (contrasena.equals(contrasenaConf)) {
						if (mf.getJdao().find(new Jugador(nombre, null, null, 0, null, null, null, null, 0)) == null) {
							JugadorDTO gamer = new JugadorDTO(nombre, contrasena, correo, edad, pais, urlFoto,
									trayectoriaCompetitiva, juegoEspecialidad, anosDeExperiencia);
							mf.getJdao().add(gamer);
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().setText("");
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().setText("");
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().setText("");
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo().setText("");
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad().setValue(0);
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().setSelectedIndex(0);
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva()
									.setSelectedIndex(0);
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().setSelectedIndex(0);
							vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia().setValue(0);
							vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto().setIcon(null);
							MensajeEmergente.mensajeNormal("archivosdepropiedades.mensajes.confirmacion.exitousuario",
									"archivosdepropiedades.mensajes.confirmacion.exito");
							vf.getVsu().setVisible(false);
						} else {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
									"archivosdepropiedades.mensajes.error");
						}
					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenanoigual",
								"archivosdepropiedades.mensajes.error");
					}
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
				}
				break;
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			} catch (InvalidPasswordException e2) {
				MensajeEmergente.mensajeAdvertencia(e2.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			} catch (InvalidEmailException e3) {
				MensajeEmergente.mensajeAdvertencia(e3.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
		}
		case "btnCrearCoach": {
			try {
				String nombre = vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText();
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
				String contrasena = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().getPassword());
				ExceptionChecker.checkPasswordField(contrasena,
						"archivosdepropiedades.mensajes.error.contrasenainconsistente");
				String contrasenaConf = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().getPassword());
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
				String correo = vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo().getText();
				ExceptionChecker.checkEmailField(correo, "archivosdepropiedades.mensajes.error.correo");
				int edad = (int) vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad().getValue();
				String pais = vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().getSelectedItem().toString();
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
				String trayectoriaCompetitiva = vf.getVsu().getCardSignUp().getCrearCoach()
						.getDatoTrayectoriaProfesional().getSelectedItem().toString();
				String juegoEspecialidad = vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad()
						.getSelectedItem().toString();
				int anosDeExperiencia = (int) vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia()
						.getValue();
				if (!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && edad != 0 && !pais.isEmpty()
						&& imagen != null && !trayectoriaCompetitiva.isEmpty() && !juegoEspecialidad.isEmpty()
						&& vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional()
								.getSelectedIndex() != 0
						&& vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad()
								.getSelectedIndex() != 0
						&& vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().getSelectedIndex() != 0) {
					if (contrasena.equals(contrasenaConf)) {
						if (mf.getEdao()
								.find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0)) == null) {
							EntrenadorDTO coach = new EntrenadorDTO(nombre, contrasena, correo, edad, pais, urlFoto,
									trayectoriaCompetitiva, juegoEspecialidad, anosDeExperiencia);
							mf.getEdao().add(coach);
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().setText("");
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().setText("");
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().setText("");
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo().setText("");
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad().setValue(0);
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().setSelectedIndex(0);
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional()
									.setSelectedIndex(0);
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().setSelectedIndex(0);
							vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia().setValue(0);
							vf.getVsu().getCardSignUp().getCrearCoach().getSeleccionarFoto().setIcon(null);
							MensajeEmergente.mensajeNormal(
									"trayectoriarchivosdepropiedades.mensajes.confirmacion.exitousuario",
									"archivosdepropiedades.mensajes.confirmacion.exito");
							vf.getVsu().setVisible(false);
						} else {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
									"archivosdepropiedades.mensajes.error");
						}
					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenanoigual",
								"archivosdepropiedades.mensajes.error");
					}
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
				}
				break;
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			} catch (InvalidPasswordException e2) {
				MensajeEmergente.mensajeAdvertencia(e2.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			} catch (InvalidEmailException e3) {
				MensajeEmergente.mensajeAdvertencia(e3.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
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
				ExceptionChecker.checkStringField(nombre, "archivosdepropiedades.mensajes.error.camposincompletos");
				String correo = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo().getText();
				ExceptionChecker.checkEmailField(correo, "archivosdepropiedades.mensajes.error.correo");
				int edad = (int) vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad().getValue();
				String pais = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().getSelectedItem().toString();
				String[] extensiones = { ".jpg", ".png", ".jpeg" };
				String urlFoto = "imageUser/" + nombre;
				String cargoEspecifico = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico().getText();
				ExceptionChecker.checkStringField(cargoEspecifico,
						"archivosdepropiedades.mensajes.error.camposincompletos");
				String contrasenaAdmins = String
						.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().getPassword());
				File imagen = null;
				for (String extension : extensiones) {
					File f = new File(urlFoto + extension);
					if (f.exists()) {
						imagen = f;
						urlFoto += extension;
						break;
					}
				}
				if (!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && edad != 0 && !pais.isEmpty()
						&& imagen != null && !cargoEspecifico.isEmpty()
						&& vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().getSelectedIndex() != 0) {
					if (contrasena.equals(contrasenaConf)) {
						if (contrasenaAdmins.equals("Transparencia290")) {
							if (mf.getAdao().find(new Administrador(nombre, null, null, 0, null, null, null)) == null) {
								AdministradorDTO admin = new AdministradorDTO(nombre, contrasena, correo, edad, pais,
										urlFoto, cargoEspecifico);
								mf.getAdao().add(admin);
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().setText("");
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().setText("");
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().setText("");
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo().setText("");
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad().setValue(0);
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().setSelectedIndex(0);
								vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico().setText("");
								vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setText("");
								vf.getVsu().getCardSignUp().getCrearAdmin().getSeleccionarFoto().setIcon(null);
								MensajeEmergente.mensajeNormal(
										"trayectoriarchivosdepropiedades.mensajes.confirmacion.exitousuario",
										"archivosdepropiedades.mensajes.confirmacion.exito");
								vf.getVsu().setVisible(false);
							} else {
								MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.usuarioexistente",
										"archivosdepropiedades.mensajes.error");
							}
						} else {
							MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenaincorrectaadmin",
									"archivosdepropiedades.mensajes.error");
						}
					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.contrasenanoigual",
								"archivosdepropiedades.mensajes.error");
					}
				} else {
					MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.camposincompletos",
							"archivosdepropiedades.mensajes.error");
				}
				break;
			} catch (EmptyStringFieldException e1) {
				MensajeEmergente.mensajeAdvertencia(e1.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			} catch (InvalidPasswordException e2) {
				MensajeEmergente.mensajeAdvertencia(e2.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			} catch (InvalidEmailException e3) {
				MensajeEmergente.mensajeAdvertencia(e3.getMessage(), "archivosdepropiedades.mensajes.advertencia");
			}
		}
		case "btnEntrar": {
			if (vf.getVp().getPanelPrincipal().getCheckEspañol().isSelected()
					|| vf.getVp().getPanelPrincipal().getCheckIngles().isSelected()) {
				String nombre = vf.getVp().getPanelPrincipal().getDatoUsuario().getText();
				String contrasena = String.valueOf(vf.getVp().getPanelPrincipal().getDatoContrasena().getPassword());
				if (vf.getVp().getPanelPrincipal().getBtnAdmin().isSelected()) {
					Administrador admin = new Administrador(nombre, contrasena, null, 0, null, null, null);
					if (mf.getAdao().find(admin) != null) {
						MensajeEmergente.mensajeNormalMasAlgo("archivosdepropiedades.mensajes.bienvenida", " " + nombre,
								"archivosdepropiedades.mensajes.confirmacion.exito");
						vf.getVa().setVisible(true);
					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.usuarionoencontrado",
								"archivosdepropiedades.mensajes.error");
					}
				} else if (vf.getVp().getPanelPrincipal().getBtnCouch().isSelected()) {
					Entrenador coach = new Entrenador(nombre, contrasena, null, 0, null, null, null, null, 0);
					if (mf.getEdao().find(coach) != null) {
						MensajeEmergente.mensajeNormalMasAlgo("archivosdepropiedades.mensajes.bienvenida", " " + nombre,
								"archivosdepropiedades.mensajes.confirmacion.exito");
						vf.getVe().setVisible(true);
					} else {
						MensajeEmergente.mensajeError("archivosdepropiedades.mensajes.error.usuarionoencontrado",
								"archivosdepropiedades.mensajes.error");
					}
				} else if (vf.getVp().getPanelPrincipal().getBtnGamer().isSelected()) {
					Jugador gamer = new Jugador(nombre, contrasena, null, 0, null, null, null, null, 0);
					if (mf.getJdao().find(gamer) != null) {
						MensajeEmergente.mensajeNormalMasAlgo("archivosdepropiedades.mensajes.bienvenida", " " + nombre,
								"archivosdepropiedades.mensajes.confirmacion.exito");
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
			break;
		}
		case "btnMostrarGamers": {
			
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String contrasena = prop.getProperty("archivosdepropiedades.arraymostrar.contrasena");
			String correo = prop.getProperty("archivosdepropiedades.arraymostrar.correo");
			String edad = prop.getProperty("archivosdepropiedades.arraymostrar.edad");
			String pais = prop.getProperty("archivosdepropiedades.arraymostrar.pais");
			String trayectoriaCompetitiva = prop.getProperty("archivosdepropiedades.arraymostrar.trayectoriacompetitiva");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegoespecialidad");
			String anosDeExperiencia = prop.getProperty("archivosdepropiedades.arraymostrar.anosexperiencia");
			String foto = prop.getProperty("archivosdepropiedades.arraymostrar.foto");
			
			
			String[] titulos = { nombre, contrasena, correo, edad, pais, trayectoriaCompetitiva,
					juegoEspecialidad, anosDeExperiencia, foto };
			vf.getVa().getCardAdmin().getPanelMostrar().setModelo(titulos);
			mf.getJdao().showAll(vf.getVa().getCardAdmin().getPanelMostrar().getTabla());
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().revalidate();
			vf.getVa().getCardAdmin().getPanelMostrar().getTabla().repaint();
			vf.getVa().getCardAdmin().mostrarPanel("PanelMostrar");
			break;
		}
		case "btnMostrarCoaches": {
			
			String nombre = prop.getProperty("archivosdepropiedades.arraymostrar.nombre");
			String contrasena = prop.getProperty("archivosdepropiedades.arraymostrar.contrasena");
			String correo = prop.getProperty("archivosdepropiedades.arraymostrar.correo");
			String edad = prop.getProperty("archivosdepropiedades.arraymostrar.edad");
			String pais = prop.getProperty("archivosdepropiedades.arraymostrar.pais");
			String trayectoriaProfesional = prop.getProperty("archivosdepropiedades.arraymostrar.trayectoriaprofesional");
			String juegoEspecialidad = prop.getProperty("archivosdepropiedades.arraymostrar.juegoespecialidad");
			String anosDeExperiencia = prop.getProperty("archivosdepropiedades.arraymostrar.anosexperiencia");
			String foto = prop.getProperty("archivosdepropiedades.arraymostrar.foto");
			
			
			
			String[] titulos = { nombre, contrasena, correo, edad, pais, trayectoriaProfesional,
					juegoEspecialidad, anosDeExperiencia, foto };
			vf.getVa().getCardAdmin().getPanelMostrar().setModelo(titulos);
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
		}
	}

}