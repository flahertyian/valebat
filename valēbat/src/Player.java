//the player who navigates the maze
public class Player {
	int health;
	int attack;
	String direction; 
	int locX;
	static int locY;
	Board b;
	
	//constructer for the player class: attack, direction and the board;
	public Player(int health,int attack,String direction,Board b){
		this.attack = attack;
		this.health = health;
		this.direction = direction;
		this.Board b;
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
		int x;
		int y;
		int c = 1;
		if(direction == "north"){
			if(choice == "right"){
				if(b[x+c][y].getIsWall()){
					return false;
				}
			}else if(choice == "left"){
				if(b[x-c][y].getIsWall()){
					return false;
				}
			}else if(choice == "forward"){
				if(b[x][y-c].getIsWall()){
					return false;
				}
			}else if(choice == "back"){
				if(b[x][y+c].getIsWall()){
					return false;
				}
			}
		}else if(direction == "south"){
			if(choice == "right"){
				if(b[x-c][y].getIsWall()){
					return false;
				}
			}else if(choice == "left"){
				if(b[x+c][y].getIsWall()){
					return false;
				}
			}else if(choice == "forward"){
				if(b[x][y+c].getIsWall()){
					return false;
				}
			}else if(choice == "back"){
				if(b[x][y-c].getIsWall()){
					return false;
				}
			}
		}else if(direction == "west"){
			if(choice == "right"){
				if(b[x][y-c].getIsWall()){
					return false;
				}
			}else if(choice == "left"){
				if(b[x][y+c].getIsWall()){
					return false;
				}
			}else if(choice == "forward"){
				if(b[x-c][y].getIsWall()){
					return false;
				}
			}else if(choice == "back"){
				if(b[x+c][y].getIsWall()){
					return false;
				}
			}
		}else if(direction == "east"){
			if(choice == "right"){
				if(b[x][y+c].getIsWall()){
					return false;
				}
			}else if(choice == "left"){
				if(b[x][y-c].getIsWall()){
					return false;
				}
			}else if(choice == "forward"){
				if(b[x+c][y].getIsWall()){
					return false;
				}
			}else if(choice == "back"){
				if(b[x-c][y].getIsWall()){
					return false;
				}
			}
		}

	}

	//gives the attacked unit damage
	public void attack(Creature c){
		c.damage(attack);
	}
	//returns the value of attack
	public int getAttack(){
		return this.attack;
	}
	//called with the player takes damage 
	public void damage(int damage){
		this.health -= damage;
	}
	//returns the health of the player
	public int getHealth(){
		return this.health;
	}
	//returns the direction the player is facing
	public String getDirection(){
		return direction;
	}
	public boolean gameOverTest(){
		if(this.health <= 0){
			return true;
		}else {
			return false;
		}
	}
}
