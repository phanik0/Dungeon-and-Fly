package dnf;

public class PlayerStriker extends Player{

	public PlayerStriker(String name) {
		super(name, 1200, 120,60,"��Ȳ");
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public void skill(Unit unit) {
		System.out.println("[1] ȭ���� ��(attack gauge:20) [2] �����Ľ�Į ű(attack gauge:10)");
		int hp = unit.getHp();
		hp -= unit.getHp();
		unit.setHp(hp);
		System.out.println("[" + this.getName() + "] �� " + "[" + unit.getName() + "] ���� " + unit.getDamage() + "�� �������� �����ϴ�. ");
		if (unit.getHp()<= 0) {
			System.out.println("[" + unit.getName() + "] �� ��ġ�߽��ϴ�.");
			unit.setHp(0);
		}
	}
	
}
