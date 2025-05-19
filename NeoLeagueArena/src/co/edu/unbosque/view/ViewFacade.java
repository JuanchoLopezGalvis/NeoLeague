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
	 * VentanaGamer es la ventana del gamer del aplicativo.
	 */
	private VentanaGamer vg;
	/**
	 * VentanaEntrenador es la ventana del entrenador del aplicativo.
	 */
	private VentanaEntrenador ve;
	/**
	 * VentanaCouch es la ventana del couch del aplicativo.
	 */
	private VentanaAdmin va;
	/**
	 * VentanaAdmin es la ventana del admin del aplicativo.
	 */
	private InscribirEquipo ie;
	/**
	 * Constructor de la clase ViewFacade, que se encarga de crear cada una de las ventanas del aplicativo.
	 */
	public ViewFacade() {
		vp = new VentanaPrincipal();
		vsu = new VentanaSignUp();
		va = new VentanaAdmin();
		vg = new VentanaGamer();
		ve = new VentanaEntrenador();
		va = new VentanaAdmin();
		ie = new InscribirEquipo();
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
	/**
	 * Metodo que se encarga de devolver la ventana del admin del aplicativo.
	 * @return VentanaAdmin
	 */
	public VentanaAdmin getVa() {
		return va;
	}
	/**
	 * Metodo que se encarga de setear la ventana del admin del aplicativo.
	 * @param va VentanaAdmin
	 */
	public void setVa(VentanaAdmin va) {
		this.va = va;
	}
	/**
	 * Metodo que se encarga de devolver la ventana del gamer del aplicativo.
	 * @return VentanaGamer
	 */
	public VentanaGamer getVg() {
		return vg;
	}
	/**
	 * Metodo que se encarga de setear la ventana del gamer del aplicativo.
	 * @param vg VentanaGamer
	 */
	public void setVg(VentanaGamer vg) {
		this.vg = vg;
	}
	/**
	 * Metodo que se encarga de devolver la ventana del entrenador del aplicativo.
	 * @return VentanaEntrenador
	 */
	public VentanaEntrenador getVe() {
		return ve;
	}
	/**
	 * Metodo que se encarga de setear la ventana del entrenador del aplicativo.
	 * @param ve VentanaEntrenador
	 */
	public void setVe(VentanaEntrenador ve) {
		this.ve = ve;
	}
	/**
	 * Metodo que se encarga de devolver la ventana de inscribir equipo del aplicativo.
	 * @return InscribirEquipo
	 */
	public InscribirEquipo getIe() {
		return ie;
	}
	/**
	 * Metodo que se encarga de setear la ventana de inscribir equipo del aplicativo.
	 * @param ie InscribirEquipo
	 */
	public void setIe(InscribirEquipo ie) {
		this.ie = ie;
	}

}
