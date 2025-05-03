package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.view.ViewFacade;

/**
 * La clase {@link Controller} es la encargada de controlar el flujo de la aplicacion.
 * Se encarga de recibir los eventos de la vista.
 */
public class Controller implements ActionListener {
	/**
	 * {@link ModelFacade} es la fachada del modelo, que se encarga de crear cada uno de los DAO del aplicativo.
	 */
	private ModelFacade mf;
	/**
	 * {@link ViewFacade} es la fachada de la vista, que se encarga de crear cada una de las ventanas del aplicativop.
	 */
	private ViewFacade vf;
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
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
	 * Este metodo se encarga de asignar los oyentes a los botones de la ventana principal.
	 */
	public void asignarLectores() {
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

	}
	/**
	 * Este metodo se encarga de asignar los eventos a cada uno de los objetos que lo requieren.
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Admin":{
			vf.getVp().getPanelPrincipal().getBtnCouch().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnGamer().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnCouch().repaint();
			vf.getVp().getPanelPrincipal().getBtnGamer().repaint();
			break;
		}
		case "Couch":{
			vf.getVp().getPanelPrincipal().getBtnAdmin().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnGamer().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnAdmin().repaint();
			vf.getVp().getPanelPrincipal().getBtnGamer().repaint();
			break;
		}
		case "Gamer":{
			vf.getVp().getPanelPrincipal().getBtnAdmin().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnCouch().setSelected(false);
			vf.getVp().getPanelPrincipal().getBtnAdmin().repaint();
			vf.getVp().getPanelPrincipal().getBtnCouch().repaint();
			break;
		}
		case "btnSignUp":{
			vf.getVsu().setVisible(true);
			break;
		}
		case "comboRoles":{
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
				JOptionPane.showMessageDialog(vf.getVsu(), "Select your rol", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}

			break;
		}
		case "fotoGamer":{
			if (vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText().isEmpty() || vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText() == null) {
				JOptionPane.showMessageDialog(vf.getVsu(), "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}else {
				FileManager.leerImagen(vf.getVsu().getCardSignUp().getCrearGamer(), vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText());
			}
			break;
		}
		case "fotoCoach":{
			if (vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText().isEmpty() || vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText() == null) {
				JOptionPane.showMessageDialog(vf.getVsu(), "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}else {
				FileManager.leerImagen(vf.getVsu().getCardSignUp().getCrearCoach(), vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText());
			}
			break;
		}
		case "fotoAdmin":{
			if (vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText().isEmpty() || vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText() == null) {
				JOptionPane.showMessageDialog(vf.getVsu(), "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}else {
				FileManager.leerImagen(vf.getVsu().getCardSignUp().getCrearAdmin(), vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText());
			}
			break;
		}
		case "verContrasenaGamer":{
			if (vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().setEchoChar((char)0);
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().setEchoChar((char)0);
			}else {
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().setEchoChar('●');
			}
			break;
		}
		case "verContrasenaCouch":{
			if (vf.getVsu().getCardSignUp().getCrearCoach().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().setEchoChar((char)0);
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().setEchoChar((char)0);
			}else {
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().setEchoChar('●');
			}
			break;
		}
		case "verContrasenaAdmin":{
			if (vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().setEchoChar((char)0);
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().setEchoChar((char)0);
			}else {
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().setEchoChar('●');
			}
			break;
		}
		case "verContrasenaAdmins":{
			if (vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setEchoChar((char)0);
			}else {
				vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().setEchoChar('●');
			}
			break;
		}
		case "btnCrearGamer":{
			String nombre = vf.getVsu().getCardSignUp().getCrearGamer().getDatoNombre().getText();
			String contrasena = String.valueOf(vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasena().getPassword());
			String contrasenaConf = String.valueOf(vf.getVsu().getCardSignUp().getCrearGamer().getDatoContrasenaConf().getPassword());
			String correo = vf.getVsu().getCardSignUp().getCrearGamer().getDatoCorreo().getText();
			int edad = (int) vf.getVsu().getCardSignUp().getCrearGamer().getDatoEdad().getValue();
			String pais = vf.getVsu().getCardSignUp().getCrearGamer().getDatoPais().getSelectedItem().toString();
			String [] extensiones = {".jpg", ".png", ".jpeg"};
			String urlFoto = "imageUser/" + nombre;
			File imagen = null;
			for (String extension : extensiones) {
				File f  = new File(urlFoto + extension);
				if (f.exists()) {
					imagen = f;
					urlFoto += extension;
					break;
				}
			}
			String trayectoriaCompetitiva = vf.getVsu().getCardSignUp().getCrearGamer().getDatoTrayectoriaCompetitiva().getSelectedItem().toString();
			String juegoEspecialidad = vf.getVsu().getCardSignUp().getCrearGamer().getDatoJuegoEspecialidad().getSelectedItem().toString();
			int anosDeExperiencia = (int) vf.getVsu().getCardSignUp().getCrearGamer().getDatoAnosDeExperiencia().getValue();
			if(!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && edad != 0 && !pais.isEmpty() && imagen != null && !trayectoriaCompetitiva.isEmpty() && !juegoEspecialidad.isEmpty()) {
				if (contrasena.equals(contrasenaConf)) {
					if (mf.getJdao().find(new Jugador(nombre, null, null, 0, null, null, null, null, 0)) == null) {
						JugadorDTO gamer = new JugadorDTO(nombre, contrasena, correo, edad, pais, urlFoto, trayectoriaCompetitiva, juegoEspecialidad, anosDeExperiencia);
						mf.getJdao().add(gamer);
						JOptionPane.showMessageDialog(vf.getVsu(), "User created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						vf.getVsu().setVisible(false);
					}else {
						JOptionPane.showMessageDialog(vf.getVsu(), "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(vf.getVsu(), "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(vf.getVsu(), "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "btnCrearCoach":{
			String nombre = vf.getVsu().getCardSignUp().getCrearCoach().getDatoNombre().getText();
			String contrasena = String.valueOf(vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasena().getPassword());
			String contrasenaConf = String.valueOf(vf.getVsu().getCardSignUp().getCrearCoach().getDatoContrasenaConf().getPassword());
			String correo = vf.getVsu().getCardSignUp().getCrearCoach().getDatoCorreo().getText();
			int edad = (int) vf.getVsu().getCardSignUp().getCrearCoach().getDatoEdad().getValue();
			String pais = vf.getVsu().getCardSignUp().getCrearCoach().getDatoPais().getSelectedItem().toString();
			String [] extensiones = {".jpg", ".png", ".jpeg"};
			String urlFoto = "imageUser/" + nombre;
			File imagen = null;
			for (String extension : extensiones) {
				File f  = new File(urlFoto + extension);
				if (f.exists()) {
					imagen = f;
					urlFoto += extension;
					break;
				}
			}
			String trayectoriaCompetitiva = vf.getVsu().getCardSignUp().getCrearCoach().getDatoTrayectoriaProfesional().getSelectedItem().toString();
			String juegoEspecialidad = vf.getVsu().getCardSignUp().getCrearCoach().getDatoJuegoEspecialidad().getSelectedItem().toString();
			int anosDeExperiencia = (int) vf.getVsu().getCardSignUp().getCrearCoach().getDatoAnosDeExperiencia().getValue();
			if(!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && edad != 0 && !pais.isEmpty() && imagen != null && !trayectoriaCompetitiva.isEmpty() && !juegoEspecialidad.isEmpty()) {
				if (contrasena.equals(contrasenaConf)) {
					if (mf.getEdao().find(new Entrenador(nombre, null, null, 0, null, null, null, null, 0)) == null) {
						EntrenadorDTO coach = new EntrenadorDTO(nombre, contrasena, correo, edad, pais, urlFoto, trayectoriaCompetitiva, juegoEspecialidad, anosDeExperiencia);
						mf.getEdao().add(coach);
						JOptionPane.showMessageDialog(vf.getVsu(), "User created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						vf.getVsu().setVisible(false);
					}else {
						JOptionPane.showMessageDialog(vf.getVsu(), "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(vf.getVsu(), "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(vf.getVsu(), "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "btnCrearAdmin":{
			String nombre = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoNombre().getText();
			String contrasena = String.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasena().getPassword());
			String contrasenaConf = String.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getDatoContrasenaConf().getPassword());
			String correo = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCorreo().getText();
			int edad = (int) vf.getVsu().getCardSignUp().getCrearAdmin().getDatoEdad().getValue();
			String pais = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoPais().getSelectedItem().toString();
			String [] extensiones = {".jpg", ".png", ".jpeg"};
			String urlFoto = "imageUser/" + nombre;
			String cargoEspecifico = vf.getVsu().getCardSignUp().getCrearAdmin().getDatoCargoEspecifico().getText();
			String contrasenaAdmins = String.valueOf(vf.getVsu().getCardSignUp().getCrearAdmin().getPasswordAdmins().getPassword());
			File imagen = null;
			for (String extension : extensiones) {
				File f  = new File(urlFoto + extension);
				if (f.exists()) {
					imagen = f;
					urlFoto += extension;
					break;
				}
			}
			if(!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && edad != 0 && !pais.isEmpty() && imagen != null && !cargoEspecifico.isEmpty()) {
				if (contrasena.equals(contrasenaConf)) {
					if(contrasenaAdmins.equals("Transparencia290")) {
						if (mf.getAdao().find(new Administrador(nombre, null, null, 0, null, null, null)) == null) {
							AdministradorDTO admin = new AdministradorDTO(nombre, contrasena, correo, edad, pais, urlFoto, cargoEspecifico);
							mf.getAdao().add(admin);
							JOptionPane.showMessageDialog(vf.getVsu(), "User created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
							vf.getVsu().setVisible(false);
						}else {
							JOptionPane.showMessageDialog(vf.getVsu(), "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(vf.getVsu(), "Incorrect password for admins", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(vf.getVsu(), "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(vf.getVsu(), "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "btnEntrar":{
			String nombre = vf.getVp().getPanelPrincipal().getDatoUsuario().getText();
			String contrasena = String.valueOf(vf.getVp().getPanelPrincipal().getDatoContrasena().getPassword());
			if (vf.getVp().getPanelPrincipal().getBtnAdmin().isSelected()) {
				Administrador admin = new Administrador(nombre, contrasena, null, 0, null, null, null);
				if (mf.getAdao().find(admin) != null) {
					//					vf.getVp().setVisible(false);
					//					vf.getVam().setVisible(true);
					//					vf.getVam().setAdmin(mf.getAdao().find(admin));
					JOptionPane.showMessageDialog(vf.getVp(), "Welcome " + nombre, "Success", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(vf.getVp(), "User not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else if (vf.getVp().getPanelPrincipal().getBtnCouch().isSelected()) {
				Entrenador coach = new Entrenador(nombre, contrasena, null, 0, null, null, null, null, 0);
				if (mf.getEdao().find(coach) != null) {
					//					vf.getVp().setVisible(false);
					//					vf.getVco().setVisible(true);
					//					vf.getVco().setEntrenador(mf.getEdao().find(coach));
					JOptionPane.showMessageDialog(vf.getVp(), "Welcome " + nombre, "Success", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(vf.getVp(), "User not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else if (vf.getVp().getPanelPrincipal().getBtnGamer().isSelected()) {
				Jugador gamer = new Jugador(nombre, contrasena, null, 0, null, null, null, null, 0);
				if (mf.getJdao().find(gamer) != null) {
					//					vf.getVp().setVisible(false);
					//					vf.getVga().setVisible(true);
					//					vf.getVga().setJugador(mf.getJdao().find(gamer));
					JOptionPane.showMessageDialog(vf.getVp(), "Welcome " + nombre, "Success", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(vf.getVp(), "User not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(vf.getVp(), "Select your rol", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		}
	}
}
