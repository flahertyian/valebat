//the player who navigates the maze
public class Player {
	private int health;
	private int attack;
	private int direction; 
	public int LOC_X;
	public int LOC_Y;
	private MazeTile[][] b;
	//constructer for the player class: attack, direction and the board;
	public Player(int health,int attack,int direction,MazeTile[][] b,int locX,int locY){
		this.b = b;
		this.attack = attack;
		this.health = health;
		this.direction = direction;
		this.LOC_Y=locY;
		this.LOC_X=locX;
		System.out.println(direction);
	}

	//called to test if the next move is occupied with a tile
	public boolean move(int direction){
		int c = 1;
		if(direction == 0){
			if(!b[LOC_X][LOC_Y-c].getWall()){
				LOC_Y -= c;
			}
		}else if(direction == 1){
			if(!b[LOC_X+c][LOC_Y].getWall()){
				LOC_X += c;
			}
		}else if(direction == 2){
			if(!b[LOC_X][LOC_Y+c].getWall()){
				LOC_Y += c;
			}
		}else if(direction == 3){
			if(!b[LOC_X-c][LOC_Y].getWall()){
				LOC_X-=c;
			}
		}

		}
		return true;
	}

	public void changeDirection(int d){
		direction = d;
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
