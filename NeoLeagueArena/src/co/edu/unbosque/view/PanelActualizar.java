package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelActualizar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/**
	 * atributo de la clase encargado de almacenar la tabla de usuarios.
	 */
	private JTable tabla;
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
	private BotonRedondeado btnShowllAll;
	private BotonRedondeado btnActualizar;
	private BotonRedondeado btnEditar;
	
	public PanelActualizar() {
		setBackground(Color.BLACK);
		setSize(1280, 720);
		setLayout(null);
		imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondoActualizar.png")).getImage();
		tabla = new JTable();
		tabla.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tabla.setFillsViewportHeight(true);
		tabla.setRowHeight(80);
		tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getWidth(), 40));
		tabla.setBackground(Color.decode("#9e9e9e"));
		tabla.setForeground(Color.white);
		tabla.setGridColor(Color.white);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		deslizador = new JScrollPane(tabla);
		deslizador.setBounds(257, 114, 755, 420);
		deslizador.setBackground(Color.decode("#9e9e9e"));
		deslizador.setForeground(Color.black);
		btnEditar = new BotonRedondeado("Edit", 20, Color.decode("#9e9e9e"), Color.black, Color.white, Color.white, 1f);
		btnActualizar = new BotonRedondeado("Update", 20, Color.decode("#9e9e9e"), Color.black, Color.white, Color.WHITE, 1f);
		buscar = new BotonRedondeado("Search", 20, Color.decode("#9e9e9e"), Color.black, Color.white, Color.white, 1f);
		btnShowllAll = new BotonRedondeado("Show All", 20, Color.decode("#9e9e9e"), Color.black, Color.white, Color.white, 1f);
		aBuscar = new TextFieldRedondeado(Color.white, Color.decode("#9e9e9e"), 20, Color.white, 1f);
		aBuscar.setToolTipText("Enter the name of the object to search");
		btnShowllAll.setToolTipText("Show all objects");
		btnActualizar.setToolTipText("Select the row to delete");
		aBuscar.setBounds(330, 75, 380, 30);
		buscar.setBounds(650, 75, 150, 30);
		btnShowllAll.setBounds(820, 75, 150, 30);
		btnActualizar.setBounds(655, 550, 150, 30);
		btnEditar.setBounds(455, 550, 150, 30);
		add(btnShowllAll);
		add(deslizador);
		add(buscar);
		add(btnActualizar);
		add(aBuscar);
		add(btnEditar);
		
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
		tabla.setModel(modelo);
	}

	

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
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

	public TextFieldRedondeado getaBuscar() {
		return aBuscar;
	}

	public void setaBuscar(TextFieldRedondeado aBuscar) {
		this.aBuscar = aBuscar;
	}

	public BotonRedondeado getBuscar() {
		return buscar;
	}

	public void setBuscar(BotonRedondeado buscar) {
		this.buscar = buscar;
	}

	public BotonRedondeado getBtnShowllAll() {
		return btnShowllAll;
	}

	public void setBtnShowllAll(BotonRedondeado btnShowllAll) {
		this.btnShowllAll = btnShowllAll;
	}

	public BotonRedondeado getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(BotonRedondeado btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public BotonRedondeado getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(BotonRedondeado btnEditar) {
		this.btnEditar = btnEditar;
	}
	
	

	

	

}
