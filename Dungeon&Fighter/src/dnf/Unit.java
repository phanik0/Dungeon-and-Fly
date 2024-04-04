package dnf;

public abstract class Unit {
	private int hp;
	private int maxHp;
	private int damage;
	private String name;
	private String state = "�븻";

	public Unit() {
	}
	public Unit(String name) {
		this.name = name;
	}
	public Unit(String name, int max, int damage) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
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
	public void init(int max, int damage) {
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
	}

	public void init(String na, int max, int pw) {
		name = na;
		maxHp = max;
		hp = max;
		damage = pw;
	}

	public void attack(Unit target) {
		target.hp -= damage;
		System.out.println("[" + name + "] �� " + "[" + target.name + "] ���� " + damage + "�� �������� �����ϴ�. ");
		String attack = String.format(name, null);
		if (target.hp <= 0) {
			System.out.println("[" + target.name + "] �� ��ġ�߽��ϴ�.");
			target.hp = 0;
		}
	}
	@Override
	public String toString() {
		return String.format("[%s][%s/%s][%d]", name,hp,maxHp,damage);
	}
	
}
