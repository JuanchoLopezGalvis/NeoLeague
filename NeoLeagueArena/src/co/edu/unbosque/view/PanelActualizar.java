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

/**
 * Esta clase representa un panel que permite actualizar la información de los objetos en la aplicación.
 * Contiene una tabla para mostrar los datos, un campo de texto para buscar y botones para realizar acciones.
 */
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
	
	/**
	 * Este método se encarga de pintar el panel y su fondo.
	 * @param g El objeto Graphics utilizado para dibujar en el panel.
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
	/**
	 * Este método se encarga de establecer el modelo de la tabla.
	 * @param nombresColumnas Un arreglo de cadenas que contiene los nombres de las columnas.
	 * @param f Un entero que indica el tipo de modelo a utilizar (0 o 1).
	 */
	public void setModelo(String[] nombresColumnas, int f) {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, nombresColumnas) {
			/**
			 * La serialVersionUID es un identificador único que se utiliza en la serialización y deserialización de objetos en Java.
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
			/**
			 * Este método se encarga de determinar si una celda es editable o no.
			 * @param row La fila de la celda.
			 * @param column La columna de la celda.
			 * @return false, indicando que la celda no es editable.
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla.setModel(modelo);
	}
	/**
	 * Este metodo se encarga de obtener la tabla.
	 * @return la tabla.
	 */
	public JTable getTabla() {
		return tabla;
	}
	/**
	 * Este metodo se encarga de setear la tabla.
	 * @param tabla la tabla a setear.
	 */
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	/**
	 * Este metodo se encarga de obtener el deslizador.
	 * @return el deslizador.
	 */
	public JScrollPane getDeslizador() {
		return deslizador;
	}
	/**
	 * Este metodo se encarga de setear el deslizador.
	 * @param deslizador el deslizador a setear.
	 */
	public void setDeslizador(JScrollPane deslizador) {
		this.deslizador = deslizador;
	}
	/**
	 * Este metodo se encarga de obtener el campo de texto para buscar.
	 * @return el campo de texto para buscar.
	 */
	public TextFieldRedondeado getaBuscar() {
		return aBuscar;
	}
	/**
	 * Este metodo se encarga de setear el campo de texto para buscar.
	 * @param aBuscar el campo de texto para buscar a setear.
	 */
	public void setaBuscar(TextFieldRedondeado aBuscar) {
		this.aBuscar = aBuscar;
	}
	/**
	 * Este metodo se encarga de obtener el boton de buscar.
	 * @return el boton de buscar.
	 */
	public BotonRedondeado getBuscar() {
		return buscar;
	}
	/**
	 * Este metodo se encarga de setear el boton de buscar.
	 * @param buscar el boton de buscar a setear.
	 */
	public void setBuscar(BotonRedondeado buscar) {
		this.buscar = buscar;
	}
	/**
	 * Este metodo se encarga de obtener el boton de mostrar todos.
	 * @return el boton de mostrar todos.
	 */
	public BotonRedondeado getBtnShowllAll() {
		return btnShowllAll;
	}
	/**
	 * Este metodo se encarga de setear el boton de mostrar todos.
	 * @param btnShowllAll el boton de mostrar todos a setear.
	 */
	public void setBtnShowllAll(BotonRedondeado btnShowllAll) {
		this.btnShowllAll = btnShowllAll;
	}
	/**
	 * Este metodo se encarga de obtener el boton de actualizar.
	 * @return el boton de actualizar.
	 */
	public BotonRedondeado getBtnActualizar() {
		return btnActualizar;
	}
	/**
	 * Este metodo se encarga de setear el boton de actualizar.
	 * @param btnActualizar el boton de actualizar a setear.
	 */
	public void setBtnActualizar(BotonRedondeado btnActualizar) {
		this.btnActualizar = btnActualizar;
	}
	/**
	 * Este metodo se encarga de obtener el boton de editar.
	 * @return el boton de editar.
	 */
	public BotonRedondeado getBtnEditar() {
		return btnEditar;
	}
	/**
	 * Este metodo se encarga de setear el boton de editar.
	 * @param btnEditar el boton de editar a setear.
	 */
	public void setBtnEditar(BotonRedondeado btnEditar) {
		this.btnEditar = btnEditar;
	}
}