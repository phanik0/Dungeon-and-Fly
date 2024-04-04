package dnf;
abstract public class Player extends Unit {
	private int atttackGauge;
	public static int gold;
	public Player(String name, int maxHp, int damage) {
		super(name, maxHp, damage);
	}
	
	public abstract void skill(Unit unit); 

	

}