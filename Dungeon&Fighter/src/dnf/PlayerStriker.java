package dnf;

public class PlayerStriker extends Player{

	public PlayerStriker() {
		super("패황", 1200, 120);
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public void skill(Unit unit) {
		System.out.println("[1] 화염의 각(attack gauge:20) [2] 헥토파스칼 킥(attack gauge:10)");
		unit.curhp -= power;
		System.out.println("[" + name + "] 이 " + "[" + target.name + "] 에게 " + power + "의 데미지를 입힙니다. ");
		if (unit.curhp <= 0) {
			System.out.println("[" + unit.name + "] 을 쳐치했습니다.");
			unit.curhp = 0;
		}
	}
	
}
