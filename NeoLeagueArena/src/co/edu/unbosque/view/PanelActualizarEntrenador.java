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

public class PanelActualizarEntrenador extends JPanel{
	
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
	 * Este atributo es el encargado de guardar el boton para crear el coach.
	 */
	private BotonRedondeado botonCrearCoach;
	/**
	 * Este atributo es el encargado de guardar el check box para ver las contraseñas.
	 */
	private JCheckBox verContrasena;
	
	/**
	 * Este es el constructor de la clase {@link CrearGamer} que no recibe nada.
	 * Se encarga de inicializar los atributos y de crear los componentes del panel.
	 */
	
	public PanelActualizarEntrenador() {
		setSize(940, 788);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondoActualizarUsuario.png")).getImage();
		setLayout(null);
		datoNombre = new TextFieldRedondeado(Color.white, Color.decode("#7cb58a"), 20, Color.white, 1f);
		datoContrasena = new PassworFieldRedondeado(Color.white, Color.decode("#7cb58a"), 20, Color.white, 1f);
		datoContrasenaConf = new PassworFieldRedondeado(Color.white, Color.decode("#7cb58a"), 20, Color.white, 1f);
		datoCorreo = new TextFieldRedondeado(Color.white, Color.decode("#7cb58a"), 20, Color.white, 1f);
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
		String[] txtTrayectoria = {"How many teams have you managed?", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", " +10"};
		datoTrayectoriaProfesional = new JComboBox<String>(txtTrayectoria);
		String [] txtJuego = {"What is the game in which you specialize?", "FIFA", "Rocket League", "Formula1", "Gran Turismo"};
		datoJuegoEspecialidad = new JComboBox<String>(txtJuego);
		datoAnosDeExperiencia = new JSpinner();
		seleccionarFoto = new BotonRedondeado("Select your photo", 20, Color.decode("#7cb58a"), Color.black, Color.WHITE, Color.white, 1f);
		botonCrearCoach = new BotonRedondeado("SignUp", 20, Color.decode("#7cb58a"), Color.black, Color.WHITE, Color.white, 1f);
		verContrasena = new JCheckBox();
		datoNombre.setBounds(300, 260, 250, 30);
		datoContrasena.setBounds(300, 320, 250, 30);
		datoContrasenaConf.setBounds(300, 380, 250, 30);
		datoCorreo.setBounds(300, 450, 250, 30);
		datoPais.setBounds(300, 510, 250, 30);
		datoEdad.setBounds(300, 570, 250, 30);
		datoAnosDeExperiencia.setBounds(800, 250, 250, 30);
		datoJuegoEspecialidad.setBounds(800, 320, 250, 30);
		datoTrayectoriaProfesional.setBounds(800, 380, 250, 30);
		seleccionarFoto.setBounds(800, 445, 250, 30);
		botonCrearCoach.setBounds(800, 575, 250, 30);
		verContrasena.setBounds(560, 320, 30, 30);
		bloquearSpinner(datoEdad, 0, 1, Color.decode("#7cb58a"), Color.white);
		bloquearSpinner(datoAnosDeExperiencia, 0, 1, Color.decode("#7cb58a"), Color.white);
		datoPais.setBackground(Color.decode("#7cb58a"));
		datoPais.setForeground(Color.white);
		datoTrayectoriaProfesional.setBackground(Color.decode("#7cb58a"));
		datoTrayectoriaProfesional.setForeground(Color.white);
		datoJuegoEspecialidad.setBackground(Color.decode("#7cb58a"));
		datoJuegoEspecialidad.setForeground(Color.white);
		verContrasena.setBackground(Color.decode("#7cb58a"));
		datoNombre.setToolTipText("Enter your name");
		datoContrasena.setToolTipText("Enter your password");
		datoContrasenaConf.setToolTipText("Confirm your password");
		datoContrasena.setEchoChar('●');
		datoContrasenaConf.setEchoChar('●');
		datoCorreo.setToolTipText("Enter your email");
		datoEdad.setToolTipText("Enter your age");
		datoAnosDeExperiencia.setToolTipText("Enter your years of experience");
		verContrasena.setToolTipText("Show password");
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
		add(botonCrearCoach);
		add(verContrasena);
		
	}
	
	/**
	 * Este metodo se encarga de pintar el panel con el fondo.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (fondo != null) {
			g.drawImage(fondo, 0, 0, 1267, 700, this);
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

}
