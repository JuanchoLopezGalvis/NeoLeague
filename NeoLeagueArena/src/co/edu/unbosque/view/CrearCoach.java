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

public class CrearCoach extends JPanel{
	/**
	 * 
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
	 * Este atributo es el encargado de guardar el combo box para la trayectoria competitiva.
	 */
	private JComboBox<String> datoTrayectoriaProfesional;
	/**
	 * Este atributo es el encargado de guardar el combo box para la especialidad.
	 */
	private JComboBox<String> datoJuegoEspecialidad;
	/**
	 * Este atributo es el encargado de guardar el spinner para los años de experiencia.
	 */
	private JSpinner datoAnosDeExperiencia;
	/**
	 * Este atributo es el encargado de guardar el boton para seleccionar la foto.
	 */
	private BotonRedondeado seleccionarFoto;
	/**
	 * Este atributo es el encargado de guardar el boton para crear el couch.
	 */
	private BotonRedondeado botonCrearCouch;
	/**
	 * Este atributo es el encargado de guardar el check box para ver las contraseñas.
	 */
	private JCheckBox verContrasena;
	
	/**
	 * Este es el constructor de la clase {@link CrearGamer} que no recibe nada.
	 * Se encarga de inicializar los atributos y de crear los componentes del panel.
	 */
	public CrearCoach() {
		setSize(940, 788);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondo2.png")).getImage();
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
		String[] txtTrayectoria = {"How many teams have you managed?", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten or more"};
		datoTrayectoriaProfesional = new JComboBox<String>(txtTrayectoria);
		String [] txtJuego = {"What is the game in which you specialize?", "FIFA", "Rocket League", "Formula1", "Gran Turismo"};
		datoJuegoEspecialidad = new JComboBox<String>(txtJuego);
		datoAnosDeExperiencia = new JSpinner();
		seleccionarFoto = new BotonRedondeado("Select your photo", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		botonCrearCouch = new BotonRedondeado("SignUp", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		verContrasena = new JCheckBox();
		datoNombre.setBounds(170, 280, 250, 30);
		datoContrasena.setBounds(170, 350, 250, 30);
		datoContrasenaConf.setBounds(170, 420, 250, 30);
		datoCorreo.setBounds(170, 490, 250, 30);
		datoPais.setBounds(170, 560, 250, 30);
		datoEdad.setBounds(170, 630, 250, 30);
		datoAnosDeExperiencia.setBounds(580, 280, 250, 30);
		datoJuegoEspecialidad.setBounds(580, 350, 250, 30);
		datoTrayectoriaProfesional.setBounds(580, 420, 250, 30);
		seleccionarFoto.setBounds(580, 490, 250, 30);
		botonCrearCouch.setBounds(580, 630, 250, 30);
		verContrasena.setBounds(430, 350, 30, 30);
		bloquearSpinner(datoEdad, 0, 1, Color.decode("#002d69"), Color.white);
		bloquearSpinner(datoAnosDeExperiencia, 0, 1, Color.decode("#002d69"), Color.white);
		datoPais.setBackground(Color.decode("#002d69"));
		datoPais.setForeground(Color.white);
		datoTrayectoriaProfesional.setBackground(Color.decode("#002d69"));
		datoTrayectoriaProfesional.setForeground(Color.white);
		datoJuegoEspecialidad.setBackground(Color.decode("#002d69"));
		datoJuegoEspecialidad.setForeground(Color.white);
		verContrasena.setBackground(Color.decode("#002d69"));
		datoNombre.setToolTipText("Enter your name");
		datoContrasena.setToolTipText("Enter your password");
		datoContrasenaConf.setToolTipText("Confirm your password");
		datoContrasena.setEchoChar('●');
		datoContrasenaConf.setEchoChar('●');
		datoCorreo.setToolTipText("Enter your email");
		datoEdad.setToolTipText("Enter your age");
		datoAnosDeExperiencia.setToolTipText("Enter your years of experience");
		add(datoNombre);
		add(datoContrasena);
		add(datoContrasenaConf);
		add(datoCorreo);
		add(datoEdad);
		add(datoPais);
		add(datoTrayectoriaProfesional);
		add(datoJuegoEspecialidad);
		add(datoAnosDeExperiencia);
		add(seleccionarFoto);
		add(botonCrearCouch);
		add(verContrasena);
		
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
	 * Este metodo se encarga de obtener el campo de texto para el nombre.
	 * @return datoNombre
	 */
	public TextFieldRedondeado getDatoNombre() {
		return datoNombre;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para el nombre.
	 * @param datoNombre
	 */
	public void setDatoNombre(TextFieldRedondeado datoNombre) {
		this.datoNombre = datoNombre;
	}
	/**
	 * Este metodo se encarga de obtener el password field para la contraseña.
	 * @return datoContrasena
	 */
	public PassworFieldRedondeado getDatoContrasena() {
		return datoContrasena;
	}
	/**
	 * Este metodo se encarga de establecer el password field para la contraseña.
	 * @param datoContrasena
	 */
	public void setDatoContrasena(PassworFieldRedondeado datoContrasena) {
		this.datoContrasena = datoContrasena;
	}
	/**
	 * Este metodo se encarga de obtener el password field para la confirmacion de la contraseña.
	 * @return datoContrasenaConf
	 */
	public PassworFieldRedondeado getDatoContrasenaConf() {
		return datoContrasenaConf;
	}
	/**
	 * Este metodo se encarga de establecer el password field para la confirmacion de la contraseña.
	 * @param datoContrasenaConf
	 */
	public void setDatoContrasenaConf(PassworFieldRedondeado datoContrasenaConf) {
		this.datoContrasenaConf = datoContrasenaConf;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para el correo.
	 * @return datoCorreo
	 */
	public TextFieldRedondeado getDatoCorreo() {
		return datoCorreo;
	}
	/**
	 * Este metodo se encarga de establecer el campo de texto para el correo.
	 * @param datoCorreo
	 */
	public void setDatoCorreo(TextFieldRedondeado datoCorreo) {
		this.datoCorreo = datoCorreo;
	}
	/**
	 * Este metodo se encarga de obtener el spinner para la edad.
	 * @return datoEdad
	 */
	public JSpinner getDatoEdad() {
		return datoEdad;
	}
	/**
	 * Este metodo se encarga de establecer el spinner para la edad.
	 * @param datoEdad
	 */
	public void setDatoEdad(JSpinner datoEdad) {
		this.datoEdad = datoEdad;
	}
	/**
	 * Este metodo se encarga de obtener el combo box para el pais.
	 * @return datoPais
	 */
	public JComboBox<String> getDatoPais() {
		return datoPais;
	}
	/**
	 * Este metodo se encarga de establecer el combo box para el pais.
	 * @param datoPais
	 */
	public void setDatoPais(JComboBox<String> datoPais) {
		this.datoPais = datoPais;
	}
	/**
	 * Este metodo se encarga de obtener el combo box para la trayectoria profesional.
	 * @return datoTrayectoriaProfesional
	 */
	public JComboBox<String> getDatoTrayectoriaProfesional() {
		return datoTrayectoriaProfesional;
	}
	/**
	 * Este metodo se encarga de establecer el combo box para la trayectoria profesional.
	 * @param datoTrayectoriaProfesional
	 */
	public void setDatoTrayectoriaProfesional(JComboBox<String> datoTrayectoriaProfesional) {
		this.datoTrayectoriaProfesional = datoTrayectoriaProfesional;
	}
	/**
	 * Este metodo se encarga de obtener el combo box para la especialidad.
	 * @return datoJuegoEspecialidad
	 */
	public JComboBox<String> getDatoJuegoEspecialidad() {
		return datoJuegoEspecialidad;
	}
	/**
	 * Este metodo se encarga de establecer el combo box para la especialidad.
	 * @param datoJuegoEspecialidad
	 */
	public void setDatoJuegoEspecialidad(JComboBox<String> datoJuegoEspecialidad) {
		this.datoJuegoEspecialidad = datoJuegoEspecialidad;
	}
	/**
	 * Este metodo se encarga de obtener el spinner para los años de experiencia.
	 * @return datoAnosDeExperiencia
	 */
	public JSpinner getDatoAnosDeExperiencia() {
		return datoAnosDeExperiencia;
	}
	/**
	 * Este metodo se encarga de establecer el spinner para los años de experiencia.
	 * @param datoAnosDeExperiencia
	 */
	public void setDatoAnosDeExperiencia(JSpinner datoAnosDeExperiencia) {
		this.datoAnosDeExperiencia = datoAnosDeExperiencia;
	}
	/**
	 * Este metodo se encarga de obtener el boton para seleccionar la foto.
	 * @return seleccionarFoto
	 */
	public BotonRedondeado getSeleccionarFoto() {
		return seleccionarFoto;
	}
	/**
	 * Este metodo se encarga de establecer el boton para seleccionar la foto.
	 * @param seleccionarFoto
	 */
	public void setSeleccionarFoto(BotonRedondeado seleccionarFoto) {
		this.seleccionarFoto = seleccionarFoto;
	}
	/**
	 * Este metodo se encarga de obtener el boton para crear el couch.
	 * @return botonCrearCouch
	 */
	public BotonRedondeado getBotonCrearCouch() {
		return botonCrearCouch;
	}
	/**
	 * Este metodo se encarga de establecer el boton para crear el couch.
	 * @param botonCrearCouch
	 */
	public void setBotonCrearCouch(BotonRedondeado botonCrearCouch) {
		this.botonCrearCouch = botonCrearCouch;
	}
	/**
	 * Este metodo se encarga de obtener el check box para ver la contraseña.
	 * @return verContrasena
	 */
	public JCheckBox getVerContrasena() {
		return verContrasena;
	}
	/**
	 * Este metodo se encarga de establecer el check box para ver la contraseña.
	 * @param verContrasena
	 */
	public void setVerContrasena(JCheckBox verContrasena) {
		this.verContrasena = verContrasena;
	}
}
