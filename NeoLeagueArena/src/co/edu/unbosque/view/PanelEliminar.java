package co.edu.unbosque.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEliminar extends JPanel{
	
	private JLabel etiqueta;
	
	public PanelEliminar() {
		setSize(1280, 720);
		setLayout(null);
		JLabel etiqueta = new JLabel();
		etiqueta.setBounds(0, 0, 1280, 720);
		add(etiqueta);
	}
	
	public void txtEtiqueta(String txtContenido) {
		etiqueta.setText(txtContenido);
	}
	
	
	

}
