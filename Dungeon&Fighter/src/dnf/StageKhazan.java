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
		playerDead = Stage.playerList.size();
		khazan = new UnitKhazan();
		monDead = 1;
		
	}
	
	private void print_character() {
		System.out.println("======[BATTLE]======");
		// System.out.println(playerSize + " " + monSize);
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < Stage.playerList.size(); i++) {
			Player player = Stage.playerList.get(i);
			System.out.println(player);
		}
		System.out.println("======[MONSTER]======");
		System.out.println(khazan);
	}
	private void attackPlayer(int index) {
		Player player = Stage.playerList.get(index);
		if (player.getHp() <= 0)
			return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + player.getName() + "] [1.일반공격] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {

				if (khazan.getHp() > 0) {
					player.attack(khazan);// 캐릭별로 대사랑 데미지 만들어보기
					break;
				}
			}
		} else if (sel == 2) {
		}
	}
	private void attackMonster(int index) {
		if (khazan.getHp() <= 0)
			return;
		while (true) {
			int idx = ran.nextInt(Stage.playerList.size());
			if (Stage.playerList.get(idx).getHp() > 0) {
				khazan.attack(Stage.playerList.get(idx));// 몬스터도 게이지 차면 스킬쓰기
				break;
			}
		}
	}
	private void check_live() {
		int num = 0;
		for (int i = 0; i < Stage.playerList.size(); i++) {
			if (Stage.playerList.get(i).getHp() <= 0) {
				num += 1;
			}
		}
		playerDead = Stage.playerList.size() - num;
		num = 0;

		if (khazan.getHp() <= 0) {
			monDead = 0;
		}

	}
	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		while (run) {
			// print_character();
			if (turn) {
				print_character();
				if (p_index < Stage.playerList.size()) {
					attackPlayer(p_index);

					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}

			} else if (!turn) {
				attackMonster(m_index);
				turn = !turn;
			}
			check_live();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		isKhazanClear = true;
		System.out.println("[검은 대지를 클리어 하였습니다 마을로 돌아갑니다]");
		GameManager.nextStage = "LOBBY";

		return false;
	}

}
