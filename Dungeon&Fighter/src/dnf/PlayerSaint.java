package dnf;

public class PlayerSaint extends Player{

	PlayerSaint(String name) {
		super(name, 1500, 120,100,"세인트");
		// TODO Auto-generated constructor stub
		this.setJobWeapon(Item.CROSS);
	}
	PlayerSaint(String name,boolean isParty) {
		super(name, 1500, 120,100,"세인트",true,"RISING");
		// TODO Auto-generated constructor stub
		this.setJobWeapon(Item.CROSS);
	}

	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
