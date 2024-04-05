package dnf;

public abstract class Unit {
	private int hp;
	private int maxHp;
	private int damage;
	private int level;
	private int exp;
	private int def;
	private String name;
	private String state = "노말";

	public Unit() {
	}
	public Unit(String name) {
		this.name = name;
	}
	
	public Unit(String name, int max, int damage,int def) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
		this.def = def;
		this.level = 0;
		this.exp = 0;
	}
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getDamage() {
		return this.damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public void init(int max, int damage) {
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
	}

	public void init(String na, int max, int pw) {
		this.name = na;
		this.maxHp = max;
		this.hp = max;
		this.damage = pw;
	}

	public void attack(Monster enemy) {
		int hp = enemy.getHp();
		hp -= damage;
		System.out.println("[" + name + "] 이 " + "[" + enemy.getName() + "] 에게 " + damage + "의 데미지를 입힙니다. ");
//		String attack = String.format(name, null);
		if (hp <= 0) {
			System.out.println("[" + name + "] 을 쳐치했습니다.");
			hp = 0;
		}
		enemy.setHp(hp);
	}
	@Override
	public String toString() {
		return String.format("[%s][%s/%s][%d]", name,hp,maxHp,damage);
	}
	
}
