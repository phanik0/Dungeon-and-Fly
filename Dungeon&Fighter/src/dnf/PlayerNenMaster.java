package dnf;

public class PlayerNenMaster extends Player{

	PlayerNenMaster(String name) {
		super(name,1000, 120,20,"����");
		this.setJobWeapon(Item.KNUCKLE);

		// TODO Auto-generated constructor stub
	}
	
	PlayerNenMaster(String name,boolean isParty) {
		super(name, 1000, 120,20,"����",isParty,"RISING");
		this.setJobWeapon(Item.KNUCKLE);

		// TODO Auto-generated constructor stub
	}
	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
