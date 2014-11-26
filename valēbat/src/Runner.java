import javax.swing.JFrame;

public class Runner extends JFrame {

	public static void main(String[]args){
		Board b = new Board();
		Game game = new Game(gameOverTest(),b);
		JFrame jf = new JFrame();
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("valebat");
		jf.add(game);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

		game.start();
	}
	
	public static boolean gameOverTest(){
		return false;
	}
}
