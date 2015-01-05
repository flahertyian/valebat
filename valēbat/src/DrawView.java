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
	URL url;
	BufferedImage currentView;
	public DrawView(Graphics2D g2d,int boardSizeX, int boardSizeY){
		this.g2d = g2d;
		this.boardSizeY = boardSizeY;
		this.boardSizeX = boardSizeX;
		url = null;
		currentView = null;
	}
	public void makeView(int pos){
		switch(pos){
			//add try{ catch(MalformedURLException ex){ }}
			case 0:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 1:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 2:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 3:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 4:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 5:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 6:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 7:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 8:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 9:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 10:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 11:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
			case 12:
				try{
					url = new URL("../resource/");			
				}catch(MalformedURLException ex){
					System.err.println("MalformedURLException");
				}
				currentView = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
				break;
		}
		g2d = currentView.createGraphics();
	}
	
	public Graphics2D getView(){
		return g2d;
	}
}
