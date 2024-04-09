package dnf;
public class Player extends Unit {
	private int attackGauge;
	public static int gold;
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	public Player() {
		
	}
	public Player(String name, int maxHp, int damage,int def,String job) {
		super(name, maxHp, damage,def,job);
		attackGauge = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName) {
		super(name, maxHp, damage,def,job,isParty,guildName);
		attackGauge = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName,int level, int exp) {
		super(name, maxHp, damage,def,job,isParty,guildName,level,exp);
		attackGauge = 0;
	}
	public void getGuildMember() {
		
	}
//	@Override
//	public String toString() {
//		return String.format("[닉네임: %s][HP : %d/%d][공격력 : %d][방어력 : %d][직업 : %s][lv : %d]",
//				this.getName(),this.getHp(),this.getMaxHp(),this.getDamage(),this.getDef(),job,this.getLevel());
//	}
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