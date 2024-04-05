package dnf;
abstract public class Player extends Unit {
	private int attackGauge;
	public static int gold;
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	public Player(String name, int maxHp, int damage,int def,String job) {
		super(name, maxHp, damage,def,job);
		attackGauge = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty,String guildName) {
		super(name, maxHp, damage,def,job,isParty,guildName);
		attackGauge = 0;
	}
	public void getGuildMember() {
		
	}
	public abstract void skill(Unit unit); 
//	@Override
//	public String toString() {
//		return String.format("[닉네임: %s][HP : %d/%d][공격력 : %d][방어력 : %d][직업 : %s][lv : %d]",
//				this.getName(),this.getHp(),this.getMaxHp(),this.getDamage(),this.getDef(),job,this.getLevel());
//	}
	

}