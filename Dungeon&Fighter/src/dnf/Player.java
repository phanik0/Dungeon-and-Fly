package dnf;
abstract public class Player extends Unit {
	private int attackGauge;
	public static int gold;
	private String job;
	public Player(String name, int maxHp, int damage,int def,String job) {
		super(name, maxHp, damage,def,job);
		attackGauge = 0;
	}
	public Player(String name, int maxHp, int damage,int def,String job,boolean isParty) {
		super(name, maxHp, damage,def,isParty);
		this.job = job;
		attackGauge = 0;
	}
	
	public abstract void skill(Unit unit); 
//	@Override
//	public String toString() {
//		return String.format("[�г���: %s][HP : %d/%d][���ݷ� : %d][���� : %d][���� : %s][lv : %d]",
//				this.getName(),this.getHp(),this.getMaxHp(),this.getDamage(),this.getDef(),job,this.getLevel());
//	}
	

}