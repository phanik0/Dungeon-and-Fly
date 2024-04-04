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
	public Monster(String name, int max, int damage,int def) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
		this.def = def;
	}
	public void attack(Unit enemy) {
		int hp = enemy.getHp();
		hp -= damage;
		enemy.setHp(hp);
		System.out.println("[" + name + "] 이 " + "[" + enemy.getName() + "] 에게 " + damage + "의 데미지를 입힙니다. ");
		String attack = String.format(name, null);
		if (hp <= 0) {
			System.out.println("[" + enemy.getName() + "] 을 쳐치했습니다.");
			hp = 0;
		}
	}
}
