package dnf;
abstract public class Player extends Unit {
	private int atttackGauge;
	
	public Player(String na, int max, int pow) {
		super(na, max, pow);
	}
	
	public abstract void skill(Unit unit); 

	

}