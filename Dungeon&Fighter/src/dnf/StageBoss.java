package dnf;

import java.util.Random;
import java.util.Scanner;

public class StageBoss extends Stage {
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private Monster ozma;

	private int monDead;
	private int playerDead;

	@Override
	public void init() {
		playerDead = GameManager.playerList.size();
		ozma = new MonsterOzma();

	}

	private void print_character() {
		System.out.println("======[BATTLE]======");
		// System.out.println(playerSize + " " + monSize);
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < GameManager.playerList.size(); i++) {
			Player player = GameManager.playerList.get(i);
			System.out.println(player);
		}
		System.out.println("======[MONSTER]======");
		System.out.println(ozma);
	}

	private void attackPlayer(int index) {
		Player player = GameManager.playerList.get(index);
		if (player.getHp() <= 0)
			return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + player.getName() + "] [1.일반공격] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {

				if (ozma.getHp() > 0) {
					player.attack(ozma);// 캐릭별로 대사랑 데미지 만들어보기
					break;
				}
			}
		} else if (sel == 2) {
		}
	}

	private void attackMonster(int index) {
		if (ozma.getHp() <= 0)
			return;
		while (true) {
			int idx = ran.nextInt(GameManager.playerList.size());
			if (GameManager.playerList.get(idx).getHp() > 0) {
				ozma.attack(GameManager.playerList.get(idx));// 몬스터도 게이지 차면 스킬쓰기
				break;
			}
		}
	}

	private void check_live() {
		int num = 0;
		for (int i = 0; i < GameManager.playerList.size(); i++) {
			if (GameManager.playerList.get(i).getHp() <= 0) {
				num += 1;
			}
		}
		playerDead = GameManager.playerList.size() - num;
		num = 0;

		if (ozma.getHp() <= 0) {
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
				if (p_index < GameManager.playerList.size()) {
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
		StageCommonMonsterBattle.silence = false;
		StageCommonMonsterBattle.dooms = false;
		StageKhazan.isKhazanClear = false;
		StageAstaros.isAstarosClear = false;
		return false;
	}

}
