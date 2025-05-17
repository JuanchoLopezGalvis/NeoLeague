package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

/**
 * Esta clase representa un panel que permite crear un nuevo administrador.
 * Contiene campos de texto para ingresar información del administrador, como nombre, contraseña, correo, edad, país y cargo específico.
 * También incluye botones para seleccionar una foto y crear el administrador.
 * Además, tiene opciones para mostrar las contraseñas ingresadas.
 */
public class CrearAdmin extends JPanel{
	/**
	 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Este atributo es el encargado de guardar la imagen de fondo.
	 */
	private Image fondo;
	/**
	 * Este atributo es el encargado de guardar el campo de texto para el nombre.
	 */
	private TextFieldRedondeado datoNombre;
	/**
	 * Este atributo es el encargado de guardar el password field para la contraseña.
	 */
	private PassworFieldRedondeado datoContrasena;
	/**
	 * Este atributo es el encargado de guardar el password field para la confirmacion de la contraseña.
	 */
	private PassworFieldRedondeado datoContrasenaConf;
	/**
	 * Este atributo es el encargado de guardar el campo de texto para el correo.
	 */
	private TextFieldRedondeado datoCorreo;
	/**
	 * Este atributo es el encargado de guardar el spinner para la edad.
	 */
	private JSpinner datoEdad;
	/**
	 * Este atributo es el encargado de guardar el combo box para el pais.
	 */
	private JComboBox<String> datoPais;
	/**
	 * Este atributo es el encargado de guardar la contraña de los administradores.
	 */
	private PassworFieldRedondeado passwordAdmins;
	/**
	 * Este atributo es el encargado de guardar el text field para el cargo especifico.
	 */
	private TextFieldRedondeado datoCargoEspecifico;
	/**
	 * Este atributo es el encargado de guardar el boton para seleccionar la foto.
	 */
	private BotonRedondeado seleccionarFoto;
	/**
	 * Este atributo es el encargado de guardar el boton para crear el admin.
	 */
	private BotonRedondeado botonCrearAdmin;
	/**
	 * Este atributo es el encargado de guardar el check box para ver las contraseñas.
	 */
	private JCheckBox verContrasena;
	/**
	 * Este atributo es el encargado de guardar el check box para ver la contraseña de los administradores.
	 */
	private JCheckBox verContrasenaAdmins;
	
	/**
	 * Este es el constructor de la clase {@link CrearGamer} que no recibe nada.
	 * Se encarga de inicializar los atributos y de crear los componentes del panel.
	 */
	public CrearAdmin() {
		setSize(940, 788);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondo3.png")).getImage();
		setLayout(null);
		datoNombre = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		datoContrasena = new PassworFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		datoContrasenaConf = new PassworFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		datoCorreo = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		datoEdad = new JSpinner();
		String[] countryCodes = Locale.getISOCountries();
		Locale englishLocale = Locale.ENGLISH;
		datoPais = new JComboBox<String>();
		datoPais.addItem("Select your country");
		for (String countryCode : countryCodes) {
		    @SuppressWarnings("deprecation")
			Locale countryLocale = new Locale("", countryCode); 
		    String countryName = countryLocale.getDisplayCountry(englishLocale); 
		    datoPais.addItem(countryName);
		}
		passwordAdmins = new PassworFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		datoCargoEspecifico = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		seleccionarFoto = new BotonRedondeado("Select your photo", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		botonCrearAdmin = new BotonRedondeado("SignUp", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		verContrasena = new JCheckBox();
		verContrasenaAdmins = new JCheckBox();
		datoNombre.setBounds(170, 280, 250, 30);
		datoContrasena.setBounds(170, 350, 250, 30);
		datoContrasenaConf.setBounds(170, 420, 250, 30);
		datoCorreo.setBounds(170, 490, 250, 30);
		datoPais.setBounds(170, 560, 250, 30);
		datoEdad.setBounds(170, 630, 250, 30);
		datoCargoEspecifico.setBounds(580, 280, 250, 30);
		passwordAdmins.setBounds(580, 350, 250, 30);
		seleccionarFoto.setBounds(580, 490, 250, 30);
		botonCrearAdmin.setBounds(580, 630, 250, 30);
		verContrasena.setBounds(430, 350, 30, 30);
		verContrasenaAdmins.setBounds(840, 350, 30, 30);
		bloquearSpinner(datoEdad, 0, 1, Color.decode("#002d69"), Color.white);
		verContrasena.setBackground(Color.decode("#002d69"));
		datoPais.setBackground(Color.decode("#002d69"));
		datoPais.setForeground(Color.white);
		verContrasenaAdmins.setBackground(Color.decode("#002d69"));
		datoNombre.setToolTipText("Enter your name");
		datoContrasena.setToolTipText("Enter your password");
		datoContrasenaConf.setToolTipText("Confirm your password");
		datoContrasena.setEchoChar('●');
		datoContrasenaConf.setEchoChar('●');
		datoCorreo.setToolTipText("Enter your email");
		datoEdad.setToolTipText("Enter your age");
		datoCargoEspecifico.setToolTipText("Enter your your specific role");
		verContrasena.setToolTipText("Show password");
		passwordAdmins.setToolTipText("Enter the password of the admins");
		passwordAdmins.setEchoChar('●');
		verContrasenaAdmins.setToolTipText("Show password");
		add(datoNombre);
		add(datoContrasena);
		add(datoContrasenaConf);
		add(datoCorreo);
		add(datoEdad);
		add(datoPais);
		add(passwordAdmins);
		add(datoCargoEspecifico);
		add(seleccionarFoto);
		add(botonCrearAdmin);
		add(verContrasena);
		add(verContrasenaAdmins);
		
	}
	/**
	 * Este metodo se encarga de pintar el panel con el fondo.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (fondo != null) {
			g.drawImage(fondo, 0, 0, 940, 788, this);
		} else {

		}
	}
	/**
	 * Este metodo se encarga de bloquear el spinner y de establecer el color del fondo y del texto.
	 * @param spinner el spinner que se va a bloquear.
	 * @param minimo el valor minimo que puede tener el spinner.
	 * @param stepSize el tamaño del paso del spinner.
	 * @param color1 el color del fondo del spinner.
	 * @param color2 el color del texto del spinner.
	 */
	public void bloquearSpinner(JSpinner spinner, int minimo, int stepSize, Color color1, Color color2) {
		spinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setBackground(color1);
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setForeground(color2);
		JFormattedTextField txt = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		NumberFormatter formatter = (NumberFormatter) txt.getFormatter();
		formatter.setAllowsInvalid(false); 
		formatter.setMinimum(0); 
	}
	/**
	 * Es el metodo que se encarga de obtener el campo de texto para el nombre.
	 * @return el campo de texto para el nombre.
	 */
	public TextFieldRedondeado getDatoNombre() {
		return datoNombre;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para el nombre.
	 * @param datoNombre el campo de texto para el nombre.
	 */
	public void setDatoNombre(TextFieldRedondeado datoNombre) {
		this.datoNombre = datoNombre;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para la contraseña.
	 * @return el campo de texto para la contraseña.
	 */
	public PassworFieldRedondeado getDatoContrasena() {
		return datoContrasena;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para la contraseña.
	 * @param datoContrasena el campo de texto para la contraseña.
	 */
	public void setDatoContrasena(PassworFieldRedondeado datoContrasena) {
		this.datoContrasena = datoContrasena;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para la confirmacion de la contraseña.
	 * @return el campo de texto para la confirmacion de la contraseña.
	 */
	public PassworFieldRedondeado getDatoContrasenaConf() {
		return datoContrasenaConf;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para la confirmacion de la contraseña.
	 * @param datoContrasenaConf el campo de texto para la confirmacion de la contraseña.
	 */
	public void setDatoContrasenaConf(PassworFieldRedondeado datoContrasenaConf) {
		this.datoContrasenaConf = datoContrasenaConf;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para el correo.
	 * @return el campo de texto para el correo.
	 */
	public TextFieldRedondeado getDatoCorreo() {
		return datoCorreo;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para el correo.
	 * @param datoCorreo el campo de texto para el correo.
	 */
	public void setDatoCorreo(TextFieldRedondeado datoCorreo) {
		this.datoCorreo = datoCorreo;
	}
	/**
	 * Este metodo se encarga de obtener el spinner para la edad.
	 * @return el spinner para la edad.
	 */
	public JSpinner getDatoEdad() {
		return datoEdad;
	}
	/**
	 * Este metodo se encarga de establecer el spinner para la edad.
	 * @param datoEdad el spinner para la edad.
	 */
	public void setDatoEdad(JSpinner datoEdad) {
		this.datoEdad = datoEdad;
	}
	/**
	 * Este metodo se encarga de obtener el combo box para el pais.
	 * @return el combo box para el pais.
	 */
	public JComboBox<String> getDatoPais() {
		return datoPais;
	}
	/**
	 * Este metodo se encarga de establecer el combo box para el pais.
	 * @param datoPais el combo box para el pais.
	 */
	public void setDatoPais(JComboBox<String> datoPais) {
		this.datoPais = datoPais;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para la contraseña de los administradores.
	 * @return el campo de texto para la contraseña de los administradores.
	 */
	public PassworFieldRedondeado getPasswordAdmins() {
		return passwordAdmins;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para la contraseña de los administradores.
	 * @param passwordAdmins el campo de texto para la contraseña de los administradores.
	 */
	public void setPasswordAdmins(PassworFieldRedondeado passwordAdmins) {
		this.passwordAdmins = passwordAdmins;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para el cargo especifico.
	 * @return el campo de texto para el cargo especifico.
	 */
	public TextFieldRedondeado getDatoCargoEspecifico() {
		return datoCargoEspecifico;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para el cargo especifico.
	 * @param datoCargoEspecifico el campo de texto para el cargo especifico.
	 */
	public void setDatoCargoEspecifico(TextFieldRedondeado datoCargoEspecifico) {
		this.datoCargoEspecifico = datoCargoEspecifico;
	}
	/**
	 * Este metodo se encarga de obtener el boton para seleccionar la foto.
	 * @return el boton para seleccionar la foto.
	 */
	public BotonRedondeado getSeleccionarFoto() {
		return seleccionarFoto;
	}
	/**
	 * Este metodo se encarga de establecer el boton para seleccionar la foto.
	 * @param seleccionarFoto el boton para seleccionar la foto.
	 */
	public void setSeleccionarFoto(BotonRedondeado seleccionarFoto) {
		this.seleccionarFoto = seleccionarFoto;
	}
	/**
	 * Este metodo se encarga de obtener el boton para crear el admin.
	 * @return el boton para crear el admin.
	 */
	public BotonRedondeado getBotonCrearAdmin() {
		return botonCrearAdmin;
	}
	/**
	 * Este metodo se encarga de establecer el boton para crear el admin.
	 * @param botonCrearAdmin el boton para crear el admin.
	 */
	public void setBotonCrearAdmin(BotonRedondeado botonCrearAdmin) {
		this.botonCrearAdmin = botonCrearAdmin;
	}
	/**
	 * Este metodo se encarga de obtener el check box para ver las contraseñas.
	 * @return el check box para ver las contraseñas.
	 */
	public JCheckBox getVerContrasena() {
		return verContrasena;
	}
	/**
	 * Este metodo se encarga de establecer el check box para ver las contraseñas.
	 * @param verContrasena el check box para ver las contraseñas.
	 */
	public void setVerContrasena(JCheckBox verContrasena) {
		this.verContrasena = verContrasena;
	}
	/**
	 * Este metodo se encarga de obtener el check box para ver la contraseña de los administradores.
	 * @return el check box para ver la contraseña de los administradores.
	 */
	public JCheckBox getVerContrasenaAdmins() {
		return verContrasenaAdmins;
	}
	/**
	 * Este metodo se encarga de establecer el check box para ver la contraseña de los administradores.
	 * @param verContrasenaAdmins el check box para ver la contraseña de los administradores.
	 */
	public void setVerContrasenaAdmins(JCheckBox verContrasenaAdmins) {
		this.verContrasenaAdmins = verContrasenaAdmins;
	}
	
	
}
