package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelInforme extends JPanel{
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
	
	/**
	 * atributo de la clase encargado de almacenar el boton de buscar.
	 */
	
	
	private BotonRedondeado btnGenerarInformePDF;
	
	private JCheckBox equipos;
	private JCheckBox jugadores;

	/**
	 * Constructor de la clase {@link PanelMostrar} donde se inicializan los
	 * atributos de la clase.
	 */
	
	public PanelInforme() {
		setBackground(Color.BLACK);
		setSize(1280, 720);
		setLayout(null);
		imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondoInforme.png")).getImage();
		equipos = new JCheckBox("Equipos");
		jugadores = new JCheckBox("Jugadores");
		equipos.setBounds(10, 10, 100, 30);
		jugadores.setBounds(10, 30, 100, 30);
		equipos.setBackground(Color.decode("#8da1ab"));
		jugadores.setBackground(Color.decode("#8da1ab"));
		tablaDeUsuarios = new JTable();
		tablaDeUsuarios.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tablaDeUsuarios.setFillsViewportHeight(true);
		tablaDeUsuarios.setRowHeight(80);
		tablaDeUsuarios.getTableHeader().setPreferredSize(new Dimension(tablaDeUsuarios.getWidth(), 40));
		tablaDeUsuarios.setBackground(Color.decode("#8da1ab"));
		tablaDeUsuarios.setForeground(Color.black);
		tablaDeUsuarios.setGridColor(Color.black);
		tablaDeUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		deslizador = new JScrollPane(tablaDeUsuarios);
		deslizador.setBounds(257, 160, 755, 360);
		deslizador.setBackground(Color.decode("#8da1ab"));
		deslizador.setForeground(Color.black);
		btnGenerarInformePDF = new BotonRedondeado("Generate PDF report", 20, Color.decode("#8da1ab"), Color.white, Color.BLACK, Color.BLACK, 1f);
		btnGenerarInformePDF.setToolTipText("Select the row to delete");
		btnGenerarInformePDF.setBounds(540, 550, 180, 30);
		
		add(deslizador);
		
		add(btnGenerarInformePDF);
	
		add(equipos);
		add(jugadores);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 0, 0, 1269, 660, this);
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}

	public void setModelo(String[] nombresColumnas, int f) {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, nombresColumnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			   @Override
			   public Class<?> getColumnClass(int column) {
			       if (f == 1) {
			           return column == nombresColumnas.length - 1 ? ImageIcon.class : String.class;
			       } else if (f == 0) {
			           return column == nombresColumnas.length - 1 ? Integer.class : String.class;
			       }
			       return Object.class; 
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

	public JTable getTablaDeUsuarios() {
		return tablaDeUsuarios;
	}

	public void setTablaDeUsuarios(JTable tablaDeUsuarios) {
		this.tablaDeUsuarios = tablaDeUsuarios;
	}

	public JScrollPane getDeslizador() {
		return deslizador;
	}

	public void setDeslizador(JScrollPane deslizador) {
		this.deslizador = deslizador;
	}

	public Image getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
	}



	public BotonRedondeado getBtnEliminar() {
		return btnGenerarInformePDF;
	}

	public void setBtoonEliminar(BotonRedondeado btnEliminar) {
		this.btnGenerarInformePDF = btnEliminar;
	}

}
