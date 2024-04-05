package dnf;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class StageAstaros extends Stage {
	public static boolean isAstarosClear;
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private Monster astaros;

	private int monDead;
	private int playerDead;

	public void init() {
		playerDead = Stage.playerList.size();
		astaros = new MonsterAstaros();
		monDead = 1;
	}

	private int inputNumber(String message) {
		System.out.println(message);
		int number = 0;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력해주세요");
		}
		return number;
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
		System.out.println(astaros);
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

				if (astaros.getHp() > 0) {
					player.attack(astaros);// 캐릭별로 대사랑 데미지 만들어보기
					break;
				}
			}
		} else if (sel == 2) {
		}
	}

	private void attackMonster(int index) {
		if (astaros.getHp() <= 0)
			return;
		while (true) {
			int idx = ran.nextInt(Stage.playerList.size());
			if (Stage.playerList.get(idx).getHp() > 0) {
				astaros.attack(Stage.playerList.get(idx));// 몬스터도 게이지 차면 스킬쓰기
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

		if (astaros.getHp() <= 0) {
			monDead = 0;
		}

	}

	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		while (run) {
			// print_character();
			if (turn) {
				print_character();
				if (p_index < StageSetting.playerList.size()) {
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
		isAstarosClear = true;
		System.out.println("[비극의 도시 엘레리논을 클리어 하였습니다 마을로 돌아갑니다]");

		GameManager.nextStage = "LOBBY";

		return false;
	}

}
