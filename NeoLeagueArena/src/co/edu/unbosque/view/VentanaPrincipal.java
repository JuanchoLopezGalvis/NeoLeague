package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * La clase {@link VentanaPrincipal} es la ventana principal de la aplicacion.
 * Esta ventana contiene el panel principal.
 */
public class VentanaPrincipal extends JFrame{

	/**
	 * Esta instancia es la encargada de guardar el panel principal.
	 */
	private PanelPrincipal panelPrincipal;
	/**
	 * Este es el constructor de la clase {@link VentanaPrincipal} que se encarga de inicializar el panel principal y darle las caracteristicas a la ventana.
	 */
	public VentanaPrincipal() {
		setTitle("Neo League Arena");
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		panelPrincipal = new PanelPrincipal();
		add(panelPrincipal);
	}
	/**
	 * Este metodo se encarga de obtener el panel principal.
	 * @return panelPrincipal
	 */
	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}
	/**
	 * Este metodo se encarga de setear el panel principal.
	 * @param panelPrincipal
	 */
	public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

}




