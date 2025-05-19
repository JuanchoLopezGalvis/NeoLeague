package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa el panel de mostrar torneos.
 * 
 * @version 1.0
 */
public class PanelMostrarTorneo extends JPanel{
	private static final long serialVersionUID = 1L;
	/**
	 * atributo de la clase encargado de almacenar la imagen de fondo del panel.
	 */
	private Image imagenFondo;
	private JComboBox<String> comboBoxTorneos;
	/**
	 * atributo de la clase encargado de almacenar la tabla de usuarios.
	 */
	private JTable tabla;
	/**
	 * atributo de la clase encargado de almacenar el deslizador de la tabla.
	 */
	private JScrollPane deslizador;
	
	public PanelMostrarTorneo() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		imagenFondo = new ImageIcon(getClass().getResource("/recursos/fondoMostrarTorneo.png")).getImage();
		comboBoxTorneos = new JComboBox<>();
		comboBoxTorneos.setBounds(280, 80, 200, 30);
		comboBoxTorneos.setBackground(Color.decode("#8da1ab"));
		comboBoxTorneos.setForeground(Color.white);
		tabla = new JTable();
		tabla.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tabla.setFillsViewportHeight(true);
		tabla.setRowHeight(80);
		tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getWidth(), 40));
		tabla.setBackground(Color.decode("#8da1ab"));
		tabla.setForeground(Color.white);
		tabla.setGridColor(Color.white);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		deslizador = new JScrollPane(tabla);
		deslizador.setBounds(257, 114, 755, 465);
		deslizador.setBackground(Color.decode("#8da1ab"));
		deslizador.setForeground(Color.white);
		add(deslizador);
		add(comboBoxTorneos);
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

	public JComboBox<String> getComboBoxTorneos() {
		return comboBoxTorneos;
	}

	public void setComboBoxTorneos(JComboBox<String> comboBoxTorneos) {
		this.comboBoxTorneos = comboBoxTorneos;
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

}
