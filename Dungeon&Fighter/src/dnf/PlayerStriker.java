package dnf;

public class PlayerStriker extends Player{

	public PlayerStriker() {
		super("��Ȳ", 1200, 120);
		// TODO Auto-generated constructor stub
	}

	@Override
	void skill(Unit unit) {
		unit.curhp -= power;
		System.out.println("[" + name + "] �� " + "[" + target.name + "] ���� " + power + "�� �������� �����ϴ�. ");
		if (unit.curhp <= 0) {
			System.out.println("[" + unit.name + "] �� ��ġ�߽��ϴ�.");
			unit.curhp = 0;
		}
	}
	
}
