import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;

public class DrawView {
	Graphics2D g2d;
	public DrawView(Graphics2D g2d){
		this.g2d = g2d;
		
	}
	/*public void makeView(){
		BufferedImage curView = null;
		try{
			curView = ImageIO.read("../resource/CloseRightTurn.png");
		}catch(FileNotFoundException e){
			System.err.println("Image file x wan't found");
		}
		g2d.draw(curView);
	}
	*/
	public Graphics2D getView(){
		return g2d;
	}
}
