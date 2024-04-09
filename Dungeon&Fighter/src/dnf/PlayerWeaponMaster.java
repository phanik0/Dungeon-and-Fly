package dnf;

public class PlayerWeaponMaster extends Player {

	PlayerWeaponMaster(String name) {
		super(name, 1200, 120,60,"검신");
		this.setPlayerWeapon(Item.SWORD);

		// TODO Auto-generated constructor stub
	}
	PlayerWeaponMaster(String name,boolean isParty) {
		super(name, 1200, 120,60,"검신",isParty,"RISING");
		this.setPlayerWeapon(Item.SWORD);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
