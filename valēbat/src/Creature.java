public class Creature {
	int health;
	int attack;
	public Creature(int health, int attack){
		this.health = health;
		this.attack = attack; 
	}
	
	
	public void attack(Player p){
		p.damage(attack);
	}
	public int getAttack(){
		return this.attack;
	}
	public void damage(int damage){
		this.health -= damage;
	}
	public int getHealth(){
		return this.health;
	}
	
}

	