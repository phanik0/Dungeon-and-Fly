package dnf;

public class Monster {
	private int hp;
	private int maxHp;
	private int damage;
	private String name;
	private int def;
	public Monster(String name) {
		this.name = name;
	}
	
	
	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getMaxHp() {
		return maxHp;
	}


	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDef() {
		return def;
	}


	public void setDef(int def) {
		this.def = def;
	}


	public Monster(String name, int max, int damage,int def) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
		this.def = def;
	}
	public void init(int maxHp, int damage) {
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.damage = damage;
	}
	public void init(String name, int maxHp, int damage) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.damage = damage;
	}

	public void attack(Unit enemy) {
		int hp = enemy.getHp();
		hp -= damage;
		System.out.println("[" + name + "] 이 " + "[" + enemy.getName() + "] 에게 " + damage + "의 데미지를 입힙니다. ");
		String attack = String.format(name, null);
		if (hp <= 0) {
			System.out.println("[" + enemy.getName() + "] 을 쳐치했습니다.");
			hp = 0;
		}
		enemy.setHp(hp);
	}
	@Override
	public String toString() {
		return String.format("[%s][%s/%s][%d]", name,hp,maxHp,damage);
	}
}
