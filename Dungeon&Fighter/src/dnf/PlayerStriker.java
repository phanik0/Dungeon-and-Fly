package dnf;

public class PlayerStriker extends Player{

	public PlayerStriker() {
		super("��Ȳ", 1200, 120);
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public void skill(Unit unit) {
		System.out.println("[1] ȭ���� ��(attack gauge:20) [2] �����Ľ�Į ű(attack gauge:10)");
		unit.curhp -= power;
		System.out.println("[" + name + "] �� " + "[" + target.name + "] ���� " + power + "�� �������� �����ϴ�. ");
		if (unit.curhp <= 0) {
			System.out.println("[" + unit.name + "] �� ��ġ�߽��ϴ�.");
			unit.curhp = 0;
		}
	}
	
}
