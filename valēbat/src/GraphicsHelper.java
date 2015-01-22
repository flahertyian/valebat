import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;


public class GraphicsHelper extends JPanel{
	private Graphics2D g2d;
	public GraphicsHelper(Graphics2D g2d){
		this.g2d = g2d;
		setFocusable(true);
		setPreferredSize(new Dimension(500,500));
		g2d.setColor(Color.RED);
		g2d.fillRect(0,0,500,500);
		paintComponent(g2d);
		Rectangle r = new Rectangle(0,0,500,500);
		repaint(r);
		//System.out.println(g2d.toString());
		//paint((Graphics)g2d);
	}



}