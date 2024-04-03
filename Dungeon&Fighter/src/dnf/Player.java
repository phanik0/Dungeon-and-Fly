package dnf;
abstract public class Player extends Unit {

	Player(String na, int max, int pow) {
		super(na, max, pow);
	}

	abstract void skill(Unit unit); 

	

}