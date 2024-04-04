package dnf;

import java.util.Random;
import java.util.Scanner;

public class StageKhazan extends Stage{
	public static boolean isKhazanClear;
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private Unit khazan;

	private int monDead;
	private int playerDead;
	@Override
	public void init() {
		playerDead = StageSetting.playerList.size();
		khazan = new UnitKhazan();
		
	}
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
	private void print_character() {
		System.out.println("======[BATTLE]======");
		// System.out.println(playerSize + " " + monSize);
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < StageSetting.playerList.size(); i++) {
			Player player = StageSetting.playerList.get(i);
			System.out.println(player);
		}
		System.out.println("======[MONSTER]======");
		System.out.println(khazan);
	}

}
