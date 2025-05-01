package co.edu.unbosque.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JToggleButton;

/**
 * {@link ToggleBtnRedondeado} es una clase que extiende de {@link JToggleButton} y
 * permite crear botones con bordes redondeados.
 */
public class ToggleBtnRedondeado extends JToggleButton{
	
	/**
	 * Este atributo es el encargado de guardar el radio de los bordes del boton.
	 */
	private int cornerRadius;
	/**
	 * Este atributo es el encargado de guardar el color del boton.
	 */
	private Color colorPorDefecto;
	/**
	 * Este atributo es el encargado de guardar el color del boton.
	 */
	private Color colorInteraccion;
	/**
	 * Este atributo es el encargado de guardar el color del borde del boton.
	 */
	private Color borderColor;
	/**
	 * Este atributo es el encargado de guardar el grosor del borde del boton.
	 */
	private float borderWidth;

	/**
	 * Este es el constructor de la clase {@link ToggleBtnRedondeado} que recibe
	 * @param text
	 * @param cornerRadius
	 * @param colorPorDefecto
	 * @param colorInteraccion
	 * @param colorForegraund
	 * @param borderColor
	 * @param borderWidth
	 */
    public ToggleBtnRedondeado(String text, int cornerRadius, Color colorPorDefecto, Color colorInteraccion, Color colorForegraund, Color borderColor, float borderWidth) {
        super(text);
        this.cornerRadius = cornerRadius;
        this.colorPorDefecto = colorPorDefecto;
        this.colorInteraccion = colorInteraccion;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        setContentAreaFilled(false);
        setForeground(colorForegraund);
    }

    /**
     * Este metodo se encarga de pintar el boton con los bordes redondeados.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isSelected()) {
            g2.setColor(colorInteraccion);
        } else if (!getModel().isSelected()) {
            g2.setColor(colorPorDefecto);
        }
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        super.paintComponent(g2);
        g2.dispose();
    }

    /**
     * Este metodo se encarga de pintar el borde del boton con los bordes redondeados.
     */
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.draw(new RoundRectangle2D.Float(borderWidth / 2, borderWidth / 2, 
        	    getWidth() - borderWidth, getHeight() - borderWidth, cornerRadius, cornerRadius));
        g2.dispose();
    }
}
