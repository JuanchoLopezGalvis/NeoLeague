package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JFrame;
/**
 * La clase {@link VentanaSignUp} es la ventana de registro de la aplicacion.
 * Esta ventana contiene el panel de registro.
 */
public class VentanaSignUp extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CardSignUp cardSignUp;
	private JComboBox<String>  roles;
	public VentanaSignUp() {
		setTitle("Sign Up");
		setSize(940, 788);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		cardSignUp = new CardSignUp();
		String [] rolesTxt = { "Gamer", "Coach", "Admin" };
		roles = new JComboBox<>(rolesTxt);
		roles.setBounds(20, 20, 100, 30);
		cardSignUp.setBounds(0, 0, 940, 788);
		add(roles);
		add(cardSignUp);
	}
	/**
	 * Este metodo se encarga de obtener el panel de registro.
	 * @return cardSignUp
	 */
	public CardSignUp getCardSignUp() {
		return cardSignUp;
	}
	/**
	 * Este metodo se encarga de setear el panel de registro.
	 * @param cardSignUp
	 */
	public void setCardSignUp(CardSignUp cardSignUp) {
		this.cardSignUp = cardSignUp;
	}
	/**
	 * Este metodo se encarga de obtener el comboBox de roles.
	 * @return roles
	 */
	public JComboBox<String> getRoles() {
		return roles;
	}
	/**
	 * Este metodo se encarga de setear el comboBox de roles.
	 * @param roles
	 */
	public void setRoles(JComboBox<String> roles) {
		this.roles = roles;
	}





}
