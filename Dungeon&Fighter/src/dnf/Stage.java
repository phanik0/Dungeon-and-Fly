package dnf;

import java.util.Vector;

public abstract class Stage {
	private UnitManager unitManager = new UnitManager();
	public static Vector<Player> playerList;
	private boolean isClear;
	public static int stageClearCount =2;
	public Stage() {
		isClear = false;
		playerList = null;
		playerList = unitManager.player_list;
	}
	public boolean getIsClear() {
		return isClear;
	}
	public void setIsClear(boolean isClear) {
		this.isClear = isClear;
	}
	public abstract boolean update();

	public abstract void init();
}