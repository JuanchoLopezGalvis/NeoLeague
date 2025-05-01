package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		vf.getVsu().getRoles().addActionListener(this);
		vf.getVsu().getRoles().setActionCommand("comboRoles");
		vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearGamer().getSeleccionarFoto().setActionCommand("fotoGamer");
		vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearGamer().getVerContrasena().setActionCommand("verContrasenaGamer");
		vf.getVsu().getCardSignUp().getCrearCouch().getVerContrasena().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearCouch().getVerContrasena().setActionCommand("verContrasenaCouch");
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasena().setActionCommand("verContrasenaAdmin");
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins().addActionListener(this);
		vf.getVsu().getCardSignUp().getCrearAdmin().getVerContrasenaAdmins().setActionCommand("verContrasenaAdmins");
		
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
			case "Couch":
				vf.getVsu().getCardSignUp().mostrarPanel("CrearCouch");
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
			if (vf.getVsu().getCardSignUp().getCrearCouch().getVerContrasena().isSelected()) {
				vf.getVsu().getCardSignUp().getCrearCouch().getDatoContrasena().setEchoChar((char)0);
				vf.getVsu().getCardSignUp().getCrearCouch().getDatoContrasenaConf().setEchoChar((char)0);
			}else {
				vf.getVsu().getCardSignUp().getCrearCouch().getDatoContrasena().setEchoChar('●');
				vf.getVsu().getCardSignUp().getCrearCouch().getDatoContrasenaConf().setEchoChar('●');
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

	}
	}
}
