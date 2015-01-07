import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable,KeyListener{
	private boolean running;
	//private boolean gameOverTest;
	public static final int boardSizeX = 1200;
	public static final int boardSizeY = 800;
	private Thread game; //butt
	private int direction; //the previus direction of the player
	private Player player;

	public Game(){
		direction = null;
		int startX=1;
		int startY=1;
		setFocusable(true);
		setPreferredSize(new Dimension(boardSizeX,boardSizeY));//1200,800
		addKeyListener(this);
		MazeGenerator abyss = new MazeGenerator(50,50,startX,startY,30,30);
		int height = abyss.height;
		int width =	abyss.width;
		MazeTile[][] b = abyss.getBoard();
		player = new Player(10, 5, firstDirection(b,startX,startY),b,startX,startY);
		b[startX][startY].addPlayer();

		printBoard(b,height,width);
	}

	public void printBoard(MazeTile[][] b,int height,int width){
	int space = 0;

		for (int c = 0; c < width; c++) {
			for (int u = 0; u < height; u++) {
				if (b[c][u].getThere()) {
					if (b[c][u].getIsPlayer()) {
						System.out.print("p ");
					} else if (b[c][u].getExit()) {
							System.out.print("E ");
					} else {
						System.out.print("  ");
					}
					space++;
				} else {
					System.out.print("# ");
				} 
			}
			System.out.println();
		}

	System.out.println();
	System.out.println(space);
//------------------------------------------------------------------------
	}
	
	public int getPosition(MazeTile[][] b, int x, int y) {
		int position = 0;
		int forward = 0;
		boolean dirLeft = false;
		boolean forLeft = false;
		boolean dirFor = false;
		boolean forRight = false;
		boolean dirRight = false;
		if (/*east*/) {
			forward = 1;
		} else if (/*south*/) {
			forward = 2;
		} else if (/*west*/) {
			forward = 3;
		}
		if (forward == 0) {
			dirLeft = !b[x - 1][y].getWall();
			forLeft = !b[x - 1][y - 1].getWall();
			dirFor = !b[x][y - 1].getWall();
			forRight = !b[x + 1][y - 1].getWall();
			dirRight = !b[x + 1][y].getWall();
		} else if (forward == 1) {
			dirLeft = !b[x][y - 1].getWall();
			forLeft = !b[x + 1][y - 1].getWall();
			dirFor = !b[x + 1][y].getWall();
			forRight = !b[x + 1][y + 1].getWall();
			dirRight = !b[x][y + 1].getWall();
		} else if (forward == 2) {
			dirLeft = !b[x - 1][y].getWall();
			forLeft = !b[x - 1][y + 1].getWall();
			dirFor = !b[x][y + 1].getWall();
			forRight = !b[x + 1][y + 1].getWall();
			dirRight = !b[x + 1][y].getWall();
		} else {
			dirLeft = !b[x][y + 1].getWall();
			forLeft = !b[x - 1][y + 1].getWall();
			dirFor = !b[x - 1][y].getWall();
			forRight = !b[x - 1][y - 1].getWall();
			dirRight = !b[x][y - 1].getWall();
		}
		if (dirLeft) {
			if (dirFor) {
				if (dirRight) {
					position = 8;
				} else if (forRight) {
					position = 7;
				} else {
					position = 11;
				}
			} else {
				if (dirRight) {
					position = 10;
				} else {
					position = 3;
				}
			}
		} else if (dirFor) {
			if (forLeft) {
				if (forRight) {
					position = 9;
				} else if (dirRight) {
					position = 6;
				} else {
					position = 4;
				}
			} else if (forRight) {
				position = 5;
			} else {
				position = 1;
			}
		} else if (dirRight) {
			if (dirFor) {
				position = 12;
			} else {
				position = 2;
			}
		}
		return position;
	}

	private String firstDirection(MazeTile[][] b,int x,int y){
		if(!b[x-1][y].getWall()){
			direction = 0;
			return "north";
		}else if(!b[x][y-1].getWall()){
			direction = 3;
			return "west";
		}else if(!b[x][y+1].getWall()){
			direction = 1;
			return "east";
		}else if(!b[x+1][y].getWall()){
			direction = 2;
			return "south";
		}else{
			return "i fucked up somehow";
		}
	}

	private void playerTurn(boolean rightOrLeft){
		if(rightOrLeft){//right turn
			if(direction != 3){
				player.changeDirection(direction + 1);
			}else{
				direction = 0;
				player.changeDirection(direction);
			}
		}else{//left turn
			if(direction != 0){
				player.changeDirection(direction - 1);
			}else{
				direction = 3;
				player.changeDirection(direction);
			}
		}
	}

	private void playerMove(){
		//old player location befor move
		int pX = player.LOC_X
		int pY = player.LOC_Y
		//player moves
		player.move(direction);
		//new player location after move
		pXnew = player.LOC_X;
		pYnew = player.LOC_Y;
		//updates board with player location
		updateBoard(pX,pY,pXnew,pYnew);
	}

	private void updateBoard(int pX, int pY, int pXnew, int pYnew){
		//adds the player to the board
		b[pXnew][pYnew].addPlayer();
		//removes the players old location from the board
		b[pX][pY].removePlayer();
	}

	private void update(){
		// where the key code is input
		if(Key.typed(KeyEvent.VK_UP)){
			playerMove();
			System.out.println("Up");
		}if(Key.typed(KeyEvent.VK_DOWN)){
			playerMove();
			System.out.println("Down");
		}if(Key.typed(KeyEvent.VK_LEFT)){
			playerTurn(false);
			System.out.println("Left");
		}if(Key.typed(KeyEvent.VK_RIGHT)){
			playerTurn(true);
			System.out.println("Right");
		}if(Key.typed(KeyEvent.VK_SPACE)){
			System.out.println("Space");
		}
		Key.update();
	}

	private void render(){ //used to render the graphics
		Graphics2D g2d = (Graphics2D) getGraphics();
		DrawView View = new DrawView(g2d,boardSizeX,boardSizeY);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(50, 50, 100, 100);
		DrawView = new DrawView(g2d,);
	}

	//game loop
	public void run() {
		long fpsTimer = System.currentTimeMillis();
		double nsPerUpdate = 1000000000.0 / 60;

		double then = System.nanoTime();
		double notprocessed = 0;

		while(running){
			boolean shouldRender = false;
			double now = System.nanoTime();
			notprocessed += (now - then) / nsPerUpdate;
			then = now;


			while(notprocessed >=1 ){
				update();
				notprocessed--;
				shouldRender = true;
			}
			if(shouldRender){
				render();
				shouldRender = false;
			}else{
				try{
					Thread.sleep(1);
				}catch(Exception e){
					e.printStackTrace();
				}

			}
		}
		if(System.currentTimeMillis() - fpsTimer > 1000){
			fpsTimer += 1000;
			System.out.println();
			System.out.println("Game Over");
			System.out.println();
			System.out.println("thanks for playing");
		}
	}
	public synchronized void start(){
		if(running) return;
		running = true;
		game = new Thread(this, "game");
		game.start();
	}
	public synchronized void end(){
		if(!running) return;
		running = false;
		System.exit(0);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Key.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
		Key.keyReleased(e);
	}
	public void keyTyped(KeyEvent e) {}
	// not used
}
