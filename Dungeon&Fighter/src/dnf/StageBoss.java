package dnf;

import java.util.Random;
import java.util.Scanner;

public class StageBoss extends Stage{
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private Unit astaros;

	private int monDead;
	private int playerDead;
	@Override
	public boolean update() {
		playerDead = StageSetting.playerList.size();
		astaros = new UnitAstaros();
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
