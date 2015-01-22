import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;

public class GraphicsTester{

	public static void main(String[]args){
		JFrame jf = new JFrame();
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Graphics tester");
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		DrawView dv = new DrawView();
		dv.setView(9);
		GraphicsHelper gh = new GraphicsHelper(dv.createGraphics());
		jf.add(gh);
		jf.pack();
		System.out.println(gh.getGraphics().toString());
	}
}