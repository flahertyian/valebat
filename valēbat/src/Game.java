import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable,KeyListener{
	//is the base of the game loop
	private boolean running;
	//size in px of the JPanel
	private static final int boardSizeX = 1200;
	private static final int boardSizeY = 800;
	//self explanitary
	private Thread game;
	//the previus direction of the player
	private int direction; 
	//the player object (not held in the board)
	private Player player;
	//position of the player
	private int curPos;
	//builds the current view of the player and holds a Graphics2D
	private DrawView view;
	//the graphics object of the JPanel
	private Graphics2D g2d;
	//the current board of the maze
	private MazeTile[][] b;

	//the constructor for the game object
	public Game(){
		g2d = (Graphics2D)this.getGraphics();
		//the head graphics object of the JPanel		//the view of the player
		view = new DrawView();
		//the direction of the player
		direction = 0;
		//start point of the player
		int startX=1;
		int startY=1;
		//jFrame and listener stuff
		setFocusable(true);
		setPreferredSize(new Dimension(boardSizeX,boardSizeY));//1200,800
		addKeyListener(this);
		//makes board
		MazeGenerator abyss = new MazeGenerator(50,50,startX,startY,30,30);
		//size of the board
		int height = abyss.height;
		int width =	abyss.width;
		//makes board
		b = abyss.getBoard();
		//makes the first position
		curPos = firstDirection(startX,startY);
		//makes new player
		player = new Player(10, 5, curPos,b,startX,startY);
		//adds player to start point
		b[startX][startY].addPlayer();
		//prints board
		printBoard(height,width);
	}

	//prints the current contense of current MazeTile[][] bs
	public void printBoard(int height,int width){
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
	}
	
	//returns and int that represents the current view of the player 
	//This int is betwean 0 - 12 There are 13 difrent possable views
	//This int is used to decide which png to print to the Jpanel
	public int getPosition() {
		int x = player.LOC_X;
		int y = player.LOC_Y;
		int position = 0;
		boolean dirLeft = false;
		boolean forLeft = false;
		boolean dirFor = false;
		boolean forRight = false;
		boolean dirRight = false;
		if (direction == 0) {
			dirLeft = !b[x - 1][y].getWall();
			forLeft = !b[x - 1][y - 1].getWall();
			dirFor = !b[x][y - 1].getWall();
			forRight = !b[x + 1][y - 1].getWall();
			dirRight = !b[x + 1][y].getWall();
		} else if (direction == 1) {
			dirLeft = !b[x][y - 1].getWall();
			forLeft = !b[x + 1][y - 1].getWall();
			dirFor = !b[x + 1][y].getWall();
			forRight = !b[x + 1][y + 1].getWall();
			dirRight = !b[x][y + 1].getWall();
		} else if (direction == 2) {
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

	//returns the direction of the first player when the object is spawned into the game
	private int firstDirection(int x,int y){
		if(!b[x-1][y].getWall()){
			//notrh
			direction = 0;
		}else if(!b[x][y-1].getWall()){
			//west
			direction = 3;
		}else if(!b[x][y+1].getWall()){
			//east
			direction = 1;
		}else if(!b[x+1][y].getWall()){
			//south
			direction = 2;
		}
		return direction;
	}

	//when the player turns it changes the int representitive of the comepus in the object player called direction
	//			 0
	//			 N
	//       3 W + E 1
	//			 S
	//			 2
	private void playerTurn(boolean rightOrLeft){
		//right turn
		if(rightOrLeft){
			if(direction != 3){
				player.changeDirection(direction + 1);
			}else{
				direction = 0;
				player.changeDirection(direction);
			}
		//left turn	
		}else{
			if(direction != 0){
				player.changeDirection(direction - 1);
			}else{
				direction = 3;
				player.changeDirection(direction);
			}
		}
	}

	//
	private void playerMove(){
		//old player location befor move
		int pX = player.LOC_X;
		int pY = player.LOC_Y;
		//player moves
		player.move(direction);
		//new player location after move
		int pXnew = player.LOC_X;
		int pYnew = player.LOC_Y;
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
	
	//used to render the graphics
	private void render(){
		view.setView(curPos);
		g2d = view.getGraphics();
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

