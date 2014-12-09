//the player who navigates the maze
public class Player {
	private int HEALTH;
	private int ATTACK;
	private String DIRECTION; 
	private int LOC_X;
	private int LOC_Y;
	private MazeTile[][] b;
	//constructer for the player class: attack, direction and the board;
	public Player(int health,int attack,String direction,MazeTile[][] b,int locX,int locY){
		this.b = b;
		this.ATTACK = attack;
		this.HEALTH = health;
		this.DIRECTION = direction;
		this.LOC_Y=locY;
		this.LOC_X=locX;
	}
	//tests forward for a wall then preformes action
	public void action(){
		testOption("forward");
	}
	//tests and executes a move right
	public void moveRight(){
		testOption("right");
	}
	//tests and executes a move left
	public void moveLeft(){
		testOption("left");
	}
	//tests and executes a move forward
	public void moveForward(){
		testOption("forward");
	}
	//tests and executes a move backward
	public void moveBack(){
		testOption("back");
	}
	
	
	//called to test if the next move is occupied with a tile
	private boolean testOption(String choice){
		int c = 1;
		if(DIRECTION == "north"){
			if(choice == "right"){
				if(b[LOC_X+c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "left"){
				if(b[LOC_X-c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "forward"){
				if(b[LOC_X][LOC_Y-c].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "back"){
				if(b[LOC_X][LOC_Y+c].getWall()){
					return false;
				}else{
					return true;
				}
			}
		}else if(DIRECTION == "south"){
			if(choice == "right"){
				if(b[LOC_X-c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "left"){
				if(b[LOC_X+c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "forward"){
				if(b[LOC_X][LOC_Y+c].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "back"){
				if(b[LOC_X][LOC_Y-c].getWall()){
					return false;
				}else{
					return true;
				}
			}
		}else if(DIRECTION == "west"){
			if(choice == "right"){
				if(b[LOC_X][LOC_Y-c].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "left"){
				if(b[LOC_X][LOC_Y+c].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "forward"){
				if(b[LOC_X-c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "back"){
				if(b[LOC_X+c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}
		}else if(DIRECTION == "east"){
			if(choice == "right"){
				if(b[LOC_X][LOC_Y+c].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "left"){
				if(b[LOC_X][LOC_Y-c].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "forward"){
				if(b[LOC_X+c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}else if(choice == "back"){
				if(b[LOC_X-c][LOC_Y].getWall()){
					return false;
				}else{
					return true;
				}
			}
		}
		return true;
	}

	//gives the attacked unit damage
	public void attack(Creature c){
		c.damage(ATTACK);
	}
	//returns the value of attack
	public int getAttack(){
		return this.ATTACK;
	}
	//called with the player takes damage 
	public void damage(int damage){
		this.HEALTH -= damage;
	}
	//returns the health of the player
	public int getHealth(){
		return this.HEALTH;
	}
	//returns the direction the player is facing
	public String getDirection(){
		return DIRECTION;
	}
	public boolean gameOverTest(){
		if(this.HEALTH <= 0){
			return true;
		}else {
			return false;
		}

	}
}
