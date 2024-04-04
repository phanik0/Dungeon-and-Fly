package dnf;

public class PlayerStriker extends Player{

	public PlayerStriker(String name) {
		super(name, 1200, 120,60,"패황");
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public void skill(Unit unit) {
		System.out.println("[1] 화염의 각(attack gauge:20) [2] 헥토파스칼 킥(attack gauge:10)");
		int hp = unit.getHp();
		hp -= unit.getHp();
		unit.setHp(hp);
		System.out.println("[" + this.getName() + "] 이 " + "[" + unit.getName() + "] 에게 " + unit.getDamage() + "의 데미지를 입힙니다. ");
		if (unit.getHp()<= 0) {
			System.out.println("[" + unit.getName() + "] 을 쳐치했습니다.");
			unit.setHp(0);
		}
	}
	
}
