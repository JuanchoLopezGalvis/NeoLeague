package co.edu.unbosque.view;

/**
 * ViewFacade esta clase es la fachada de la vista, que se encarga de crear cada una de las ventanas del aplicativo.
 */
public class ViewFacade {

	/**
	 * VentanaSignUp es la ventana de registro del aplicativo.
	 */
	private VentanaSignUp vsu;
	/**
	 * VentanaPrincipal es la ventana principal del aplicativo.
	 */
	private VentanaPrincipal vp;
	/**
	 * Constructor de la clase ViewFacade, que se encarga de crear la ventana principal del aplicativo.
	 */
	private VentanaAdmin va;
	public ViewFacade() {
		vp = new VentanaPrincipal();
		vsu = new VentanaSignUp();
		va = new VentanaAdmin();
	}
	/**
	 * Metodo que se encarga de devolver la ventana principal del aplicativo.
	 * @return VentanaPrincipal
	 */
	public VentanaPrincipal getVp() {
		return vp;
	}
	/**
	 * Metodo que se encarga de setear la ventana principal del aplicativo.
	 * @param vp VentanaPrincipal
	 */
	public void setVp(VentanaPrincipal vp) {
		this.vp = vp;
	}
	/**
	 * Metodo que se encarga de devolver la ventana de registro del aplicativo.
	 * @return VentanaSignUp
	 */
	public VentanaSignUp getVsu() {
		return vsu;
	}
	/**
	 * Metodo que se encarga de setear la ventana de registro del aplicativo.
	 * @param vsu VentanaSignUp
	 */
	public void setVsu(VentanaSignUp vsu) {
		this.vsu = vsu;
	}
	public VentanaAdmin getVa() {
		return va;
	}
	public void setVa(VentanaAdmin va) {
		this.va = va;
	}
	
}
