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
		System.out.println("[" + name + "] �� " + "[" + enemy.getName() + "] ���� " + damage + "�� �������� �����ϴ�. ");
		String attack = String.format(name, null);
		if (hp <= 0) {
			System.out.println("[" + enemy.getName() + "] �� ��ġ�߽��ϴ�.");
			hp = 0;
		}
	}
}
