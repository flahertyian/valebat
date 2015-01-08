import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.awt.Toolkit;
import java.net.MalformedURLException;


public class DrawView {
	Graphics2D g2d;
	int boardSizeY;
	int boardSizeX;
	int pos;
	URL url;
	BufferedImage currentView;
	public DrawView(Graphics2D g2d,int pos){
		this.g2d = g2d;
		pos = pos;
		url = null;
		currentView = null;
		makeView();
	}

	public void makeView(){
		switch(pos){
			case 0:
				try{
					url = new URL("../resource/deadEnd.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 1:
				try{
					url = new URL("../resource/Hall.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 2:
				try{
					url = new URL("../resource/RightOpen.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 3:
				try{
					url = new URL("../resource/LeftOpen.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 4:
				try{
					url = new URL("../resource/farLeftTurn.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 5:
				try{
					url = new URL("../resource/farRightTurn.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 6:
				try{
					url = new URL("../resource/rightCloseFarLeft.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 7:
				try{
					url = new URL("../resource/leftCloseFarRight.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 8:
				try{
					url = new URL("../resource/fork.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 9:
				try{
					url = new URL("../resource/farT.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 10:
				try{
					url = new URL("../resource/T.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 11:
				try{
					url = new URL("../resource/closerLeftTurn.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 12:
				try{
					url = new URL("../resource/CloseRightTurn.png");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
		}
		g2d = currentView.createGraphics();
	}
	
	public Graphics2D getGraphics(){
		return g2d;
	}
}
