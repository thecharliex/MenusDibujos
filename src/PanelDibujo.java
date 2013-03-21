import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
	// paint 566, 848

public class PanelDibujo extends JPanel {
	private static final long serialVersionUID = 1L;
	private int diametro = 50;
	private Color color;
	private Shape shape;
	
	public PanelDibujo() {
		color = Color.BLACK;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		if(shape != null) {
			g2D.setPaint(color);
			g2D.draw(shape );
			g2D.fill(shape);
		}
		
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = (diametro >= 0 ? diametro : 10);
		repaint();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
	
	public Dimension getMinimunSize() {
		return getPreferredSize();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(String str) {
		
		Dimension d = this.getSize();
		
		int x = (d.width-diametro) / 2;
		int y = (d.height-diametro) / 2;
		
		if(str == "Rectangulo") {
			shape = new Rectangle2D.Double(x, y, diametro, diametro);
		} else if(str == "Circulo") {
			shape = new Ellipse2D.Double(x, y, diametro, diametro);
		} else if(str == "Ovalo") {
			shape = new RoundRectangle2D.Double(x, y, diametro, diametro, 10, 5);
		} else if(str == "Linea") {
			shape = new Line2D.Double(x, y, x+x, y+y);
		}
		
		repaint();
	}
	
	
	
}
