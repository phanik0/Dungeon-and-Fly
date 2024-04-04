package dnf;
abstract public class Player extends Unit {
	private int attackGauge;
	public static int gold;
	private String job;
	public Player(String name, int maxHp, int damage,int def,String job) {
		super(name, maxHp, damage,def);
		this.job = job;
		attackGauge = 0;
	}
	
	public abstract void skill(Unit unit); 
	@Override
	public String toString() {
		return String.format("[�г���: %s][HP : %d/%d][���ݷ� : %d][���� : %d][���� : %s]",
				this.getName(),this.getHp(),this.getDamage(),this.getDef(),job);
	}
	

}