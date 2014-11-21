
public class Creature {
	int health;
	int attack;
	public  Creature (int health, int attack) {
		this.health = health;
		this.attack = attack;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void isHit(int dmg) {
		health -= dmg;
	}
	
	public void fight(Creature target) {
		target.isHit(attack);
	}
}
