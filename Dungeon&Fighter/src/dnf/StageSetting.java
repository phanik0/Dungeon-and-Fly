package dnf;

import java.util.Vector;

public class StageSetting extends Stage {
	private UnitManager unitManager = new UnitManager();
	public static Vector<Player> playerList;
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		playerList = null;
		playerList = unitManager.player_list;
	}

}