package dnf;
public class Player extends Unit {
	private int attackGauge;
	private int playerWeapon;
	public static int gold;
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	public Player() {
		
	}
	public Player(String name, int maxHp, int damage,int def,String job) {
		super(name, maxHp, damage,def,job);
		attackGauge = 0;
		playerWeapon = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName) {
		super(name, maxHp, damage,def,job,isParty,guildName);
		attackGauge = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName,int level, int exp) {
		super(name, maxHp, damage,def,job,isParty,guildName,level,exp);
		attackGauge = 0;
	}
	
	public int getAttackGauge() {
		return attackGauge;
	}
	public void setAttackGauge(int attackGauge) {
		this.attackGauge = attackGauge;
	}
	public int getPlayerWeapon() {
		return playerWeapon;
	}
	public void setPlayerWeapon(int playerWeapon) {
		this.playerWeapon = playerWeapon;
	}
	public void getGuildMember() {
		
	}

	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}
	public void inventoryMenu() {
		inven.inventoryMenu();
		
	}
	public void guildMenu() {
		guild.guildMenu();
	}
	

}