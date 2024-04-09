package dnf;
public class Player extends Unit {
	private int attackGauge;
	private int jobWeapon;
	public static int gold;
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	public Player() {
		
	}
	public Player(String name, int maxHp, int damage,int def,String job) {
		super(name, maxHp, damage,def,job);
		attackGauge = 0;
		jobWeapon = 0;
	}
	
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName) {
		super(name, maxHp, damage,def,job,isParty,guildName);
		attackGauge = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName,int level, int exp , int jobWeapon) {
		super(name, maxHp, damage,def,job,isParty,guildName,level,exp);
		attackGauge = 0;
		this.jobWeapon = jobWeapon;
	}
	
	public int getAttackGauge() {
		return attackGauge;
	}
	public void setAttackGauge(int attackGauge) {
		this.attackGauge = attackGauge;
	}
	public int getJobWeapon() {
		return jobWeapon;
	}
	public void setJobWeapon(int jobWeapon) {
		this.jobWeapon = jobWeapon;
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