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
		return String.format("[닉네임: %s][HP : %d/%d][공격력 : %d][방어력 : %d][직업 : %s]",
				this.getName(),this.getHp(),this.getDamage(),this.getDef(),job);
	}
	

}