package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class PanelMostrar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributo de la clase encargado de almacenar la tabla de usuarios.
	 */
	private JTable tablaDeUsuarios;
	/**
	 * atributo de la clase encargado de almacenar el deslizador de la tabla.
	 */
	private JScrollPane deslizador;
	/**
	 * atributo de la clase encargado de almacenar la imagen de fondo del panel.
	 */
	private Image imagenFondo;
	/**
	 * atributo de la clase encargado de almacenar el campo de texto para buscar.
	 */
	private TextFieldRedondeado aBuscar;
	/**
	 * atributo de la clase encargado de almacenar el boton de buscar.
	 */
	private BotonRedondeado buscar;

	/**
	 * Constructor de la clase {@link PanelMostrar} donde se inicializan los
	 * atributos de la clase.
	 */
	public PanelMostrar() {
		setBackground(Color.BLACK);
		setSize(1280, 720);
		setLayout(null);
		imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondoMostrar.png")).getImage();
		tablaDeUsuarios = new JTable();
		tablaDeUsuarios.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tablaDeUsuarios.setFillsViewportHeight(true);
		tablaDeUsuarios.setRowHeight(80);
		tablaDeUsuarios.getTableHeader().setPreferredSize(new Dimension(tablaDeUsuarios.getWidth(), 40));
		tablaDeUsuarios.setBackground(Color.decode("#6981c9"));
		tablaDeUsuarios.setForeground(Color.black);
		tablaDeUsuarios.setGridColor(Color.black);
		tablaDeUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		deslizador = new JScrollPane(tablaDeUsuarios);
		deslizador.setBounds(258, 114, 755, 478);
		deslizador.setBackground(Color.WHITE);
		deslizador.setForeground(Color.black);
		buscar = new BotonRedondeado("Search", 20, Color.decode("#6981c9"), Color.white, Color.BLACK, Color.white, 1f);
		aBuscar = new TextFieldRedondeado(Color.BLACK, Color.decode("#6981c9"), 20, Color.white, 1f);
		aBuscar.setToolTipText("Enter the name of the object to search");
		aBuscar.setBounds(330, 75, 550, 30);
		buscar.setBounds(845, 75, 150, 30);
		add(deslizador);
		add(buscar);
		add(aBuscar);
	}

	private void setDefaultExitOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo que se encarga de pintar la imagen de fondo del panel.
	 * 
	 * @param g es el objeto de la clase Graphics.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 0, 0, 1269, 660, this);
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}

	public void setModelo(String[] nombresColumnas) {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, nombresColumnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				return column == nombresColumnas.length - 1 ? ImageIcon.class : String.class;
			}
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		tablaDeUsuarios.setModel(modelo);
	}

	/**
	 * Metodo que retorna la tabla de productos.
	 * 
	 * @return tablaDeProductos es la tabla de productos.
	 */
	public JTable getTabla() {
		return tablaDeUsuarios;
	}

}
