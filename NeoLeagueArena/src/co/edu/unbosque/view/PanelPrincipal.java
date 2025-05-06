package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * La clase {@link PanelPrincipal} es un panel.
 * Este panel contiene los botones de admin, gamer y couch, ademas de los campos de texto para el usuario y la contraseña.
 */
public class PanelPrincipal extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JCheckBox checkEspañol;
	private JCheckBox checkIngles;
	/**
	 * Esta intancia esta encargada de guardar el boton de admin, boton de gamer y boton de couch.
	 */
	private ToggleBtnRedondeado btnAdmin, btnGamer, btnCouch;
	/**
	 * Esta instancia es la encargada de guardar las etiquetas.
	 */
	private JLabel  etiqueta0, etiqueta1, etiqueta2, etiqueta3;
	/**
	 * Esta instancia esta encargada de guardar el campo de texto de usuario.
	 */
	private TextFieldRedondeado datoUsuario;
	/**
	 * Esta instancia esta encargada de guardar el password field de contraseña.
	 */
	private PassworFieldRedondeado datoContrasena;
	/**
	 * Esta instancia esta encargada de guardar el boton de entrar y el boton de registrar.
	 */
	private BotonRedondeado btnEntrar, btnRegistrar ;
	/**
	 * Esta instancia es la encargada de guardar el fondo del panel.
	 */
	private Image fondo;
	
	/**
	 * Este es el constructor de la clase {@link PanelPrincipal} que se encarga de inicializar todos los componentes del panel.
	 */
	public PanelPrincipal() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1280,720);
		setLayout(null); 
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		checkEspañol = new JCheckBox("Spanish");
		checkIngles = new JCheckBox("English");

		datoUsuario = new TextFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		datoContrasena = new PassworFieldRedondeado(Color.white, Color.decode("#002d69"), 20, Color.white, 1f);
		btnAdmin = new ToggleBtnRedondeado("Admin", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		btnGamer = new ToggleBtnRedondeado("Gamer", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		btnCouch = new ToggleBtnRedondeado("Couch", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		btnEntrar = new BotonRedondeado("Login", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		btnRegistrar = new BotonRedondeado("Sign Up", 20, Color.decode("#002d69"), Color.black, Color.WHITE, Color.white, 1f);
		fondo = new ImageIcon(getClass().getResource("/recursos/fondo1.png")).getImage();
		etiqueta0 = new JLabel("Username:");
		etiqueta1 = new JLabel("Select your role", SwingConstants.CENTER);
		etiqueta2 = new JLabel("Password:");
		etiqueta3 = new JLabel("Select your language:");
		etiqueta0.setForeground(Color.WHITE);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta2.setForeground(Color.WHITE);
		etiqueta3.setForeground(Color.WHITE);
		etiqueta0.setFont(new Font("Arial", 1, 15));
		etiqueta1.setFont(new Font("Arial", 1, 15));
		etiqueta2.setFont(new Font("Arial", 1, 15)); 
		etiqueta3.setFont(new Font("Arial", 1, 15)); 
		btnAdmin.setFont(new Font("Arial", 1, 15));
		btnGamer.setFont(new Font("Arial", 1, 15));
		btnCouch.setFont(new Font("Arial", 1, 15));
		btnEntrar.setFont(new Font("Arial", 1, 15));
		btnRegistrar.setFont(new Font("Arial", 1, 15));
		checkEspañol.setFont(new Font("Arial", 1, 13));
		checkIngles.setFont(new Font("Arial", 1, 13));
		
		checkEspañol.setForeground(Color.white);
		checkIngles.setForeground(Color.white);
		checkEspañol.setBackground(Color.DARK_GRAY);
		checkIngles.setBackground(Color.DARK_GRAY);
		
		etiqueta3.setBounds(700, 600, 200, 30);
		checkEspañol.setBounds(900, 600, 80, 30);
		checkIngles.setBounds(990,600, 80,30);
		datoUsuario.setBounds(890, 250, 200, 30);
		datoContrasena.setBounds(890, 300, 200, 30);
		btnAdmin.setBounds(750, 420, 100, 30);
		btnCouch.setBounds(870, 420, 100, 30);
		btnGamer.setBounds(990, 420, 100, 30);
		etiqueta0.setBounds(770, 250, 200, 30);
		etiqueta1.setBounds(820, 365, 200, 30);
		etiqueta2.setBounds(770, 300, 200, 30);
		btnEntrar.setBounds(750, 520, 160, 30);
		btnRegistrar.setBounds(930, 520, 160, 30);

		add(etiqueta3);
		add(checkEspañol);
		add(checkIngles);
		add(etiqueta0);
		add(etiqueta2);
		add(datoContrasena);
		add(etiqueta1);
		add(btnAdmin);
		add(btnCouch);
		add(btnGamer);
		add(datoUsuario);
		add(btnEntrar);
		add(btnRegistrar);
		
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
	 * Este metodo se encarga de obtener el boton de admin.
	 * @return el boton de admin.
	 */
	public ToggleBtnRedondeado getBtnAdmin() {
		return btnAdmin;
	}
	/**
	 * Este metodo se encarga de setear el boton de admin.
	 * @param btnAdmin
	 */
	public void setBtnAdmin(ToggleBtnRedondeado btnAdmin) {
		this.btnAdmin = btnAdmin;
	}
	/**
	 * Este metodo se encarga de obtener el boton de gamer.
	 * @return el boton de gamer.
	 */
	public ToggleBtnRedondeado getBtnGamer() {
		return btnGamer;
	}
	/**
	 * Este metodo se encarga de setear el boton de gamer.
	 * @param btnGamer.
	 */
	public void setBtnGamer(ToggleBtnRedondeado btnGamer) {
		this.btnGamer = btnGamer;
	}
	/**
	 * Este metodo se encarga de obtener el boton de couch.
	 * @return el boton de couch.
	 */
	public ToggleBtnRedondeado getBtnCouch() {
		return btnCouch;
	}
	/**
	 * Este metodo se encarga de setear el boton de couch.
	 * @param btnCouch.
	 */
	public void setBtnCouch(ToggleBtnRedondeado btnCouch) {
		this.btnCouch = btnCouch;
	}
	/**
	 * Este metodo es el encargado de obtener el usuario.
	 * @return datoUsuario.
	 */
	public TextFieldRedondeado getDatoUsuario() {
		return datoUsuario;
	}
	/**
	 * Este metodo es el encargado de setear el usuario.
	 * @param datoUsuario.
	 */
	public void setDatoUsuario(TextFieldRedondeado datoUsuario) {
		this.datoUsuario = datoUsuario;
	}
	/**
	 * Este metodo es el encargado de obtener la contraseña.
	 * @return datoContrasena.
	 */
	public PassworFieldRedondeado getDatoContrasena() {
		return datoContrasena;
	}
	/**
	 * Este metodo es el encargado de setear la contraseña.
	 * @param datoContrasena.
	 */
	public void setDatoContrasena(PassworFieldRedondeado datoContrasena) {
		this.datoContrasena = datoContrasena;
	}
	/**
	 * Este metodo es el encargado de obtener el boton de entrar.
	 * @return el boton de entrar.
	 */
	public BotonRedondeado getBtnEntrar() {
		return btnEntrar;
	}
	/**
	 * Este metodo es el encargado de setear el boton de entrar.
	 * @param btnEntrar.
	 */
	public void setBtnEntrar(BotonRedondeado btnEntrar) {
		this.btnEntrar = btnEntrar;
	}
	/**
	 * Este metodo es el encargado de obtener el boton de registrar.
	 * @return el boton de registrar.
	 */
	public BotonRedondeado getBtnRegistrar() {
		return btnRegistrar;
	}
	/**
	 * Este metodo es el encargado de setear el boton de registrar.
	 * @param btnRegistrar.
	 */
	public void setBtnRegistrar(BotonRedondeado btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
	public JCheckBox getCheckEspañol() {
		return checkEspañol;
	}
	public void setCheckEspañol(JCheckBox checkEspañol) {
		this.checkEspañol = checkEspañol;
	}
	public JCheckBox getCheckIngles() {
		return checkIngles;
	}
	public void setCheckIngles(JCheckBox checkIngles) {
		this.checkIngles = checkIngles;
	}
	
	


}
