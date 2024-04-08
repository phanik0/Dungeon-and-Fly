package dnf;

import java.util.Vector;

public abstract class Stage {
	
	public static int stageClearCount =2;
	public Stage() {
	
	
		
	}
	
	public abstract boolean update();

	public abstract void init();
}