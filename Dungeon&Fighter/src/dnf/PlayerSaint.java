package dnf;

public class PlayerSaint extends Player{

	PlayerSaint(String name) {
		super(name, 1500, 120,100,"����Ʈ");
		// TODO Auto-generated constructor stub
	}
	PlayerSaint(String name,boolean isParty) {
		super(name, 1500, 120,100,"����Ʈ",true,"RISING");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
