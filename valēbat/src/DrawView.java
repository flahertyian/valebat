import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.File;


public class DrawView {
	Graphics2D g2d;
	int boardSizeY;
	int boardSizeX;
	int pos;
	File url;
	BufferedImage currentView;
	public DrawView(){

	}

	public void setView(int pos){
		this.pos = pos;
		makeView();
	}

	private void makeView(){
		String urlName;
		switch(pos){
			case 0:
				urlName = "..//resource//deadEnd.png";
				makeFile(urlName);
				break;
			case 1:
				urlName = "..//resource//Hall.png";			
				makeFile(urlName);
				break;
			case 2:
				urlName = "..//resource//rightOpen.png";			
				makeFile(urlName);
				break;
			case 3:
				urlName = "..//resource//LeftOpen.png";	
				makeFile(urlName);	
				break;
			case 4:
				urlName ="..//resource//farLeftTurn.png";			
				makeFile(urlName);
				break;
			case 5:
				urlName = "..//resource//farRightTurn.png";			
				makeFile(urlName);
				break;
			case 6:
				urlName = "..//resource//rightCloseFarLeft.png";			
				makeFile(urlName);
				break;
			case 7:
				urlName = "..//resource//leftCloseFarRight.png";			
				makeFile(urlName);
				break;
			case 8:
				urlName = "..//resource//fork.png";			
				makeFile(urlName);
				break;
			case 9:
				urlName = "..//resource//farT.png";			
				makeFile(urlName);
				break;
			case 10:
				urlName ="..//resource//T.png";			
				makeFile(urlName);
				break;
			case 11:
				urlName = "..//resource//closerLeftTurn.png";			
				makeFile(urlName);
				break;
			case 12:
				urlName = "..//resource//CloseRightTurn.png";			
				makeFile(urlName);
				break;
		}
		try{
			currentView = (BufferedImage) ImageIO.read(url);
			g2d = currentView.createGraphics();
		}catch(IOException ex){
			System.err.println("immageIO couldent read url");
		}
	}
	
	private void makeFile(String urlName){
		// try{
			url = new File(urlName);			
		// }catch(MalformedURLException ex){
		// 	System.err.println("FileNotFoundException");
		// }
	}

	public Graphics2D getGraphics(){
		return g2d;
	}
}
