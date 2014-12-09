public class Creature {
	private int HEALTH;
	private int ATTACK;
	public Creature(int health, int attack){
	this.HEALTH = health;
	this.ATTACK = attack; 
	}
	
	
	public void attack(Player p){
		p.damage(ATTACK);
	}
	public int getAttack(){
		return this.ATTACK;
	}
	public void damage(int damage){
		this.HEALTH -= damage;
	}
	public int getHealth(){
		return this.HEALTH;
	}
	
}

	