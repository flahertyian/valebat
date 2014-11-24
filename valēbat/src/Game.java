package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable,KeyListener{
	private boolean running;
	private boolean gameOverTest;
	public static final int boardSizeX = 1200;
	public static final int boardSizeY = 800;
	private Thread game;

	public Game(boolean gameOverTest, Board b){
		Player player = new Player(10, 5, "north",b );
		this.gameOverTest = gameOverTest;
		setFocusable(true);
		setPreferredSize(new Dimension(boardSizeX,boardSizeY));//1200,800
		addKeyListener(this);
	}

	private void update(){
		// where the key code is input
		if(Key.typed(KeyEvent.VK_UP)){
			System.out.println("up");
		}if(Key.typed(KeyEvent.VK_DOWN)){
			System.out.println("down");
		}if(Key.typed(KeyEvent.VK_LEFT)){
			System.out.println("left");
		}if(Key.typed(KeyEvent.VK_RIGHT)){
			System.out.println("right");
		}
		Key.update();
	}
	private void render(){ //used to render the graphics
		Graphics2D g2d = (Graphics2D) getGraphics();
		DrawTile tile = new DrawTile(g2d);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(50, 50, 100, 100);
		g2d.dispose();
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
			if(gameOverTest){
				running = false;
			}


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
