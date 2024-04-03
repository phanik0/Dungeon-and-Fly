package dnf;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class StageCommonMonsterBattle extends Stage {
	private Scanner scan = new Scanner(System.in);
	private UnitManager unitManager = new UnitManager();
	private Vector<Player> playerList;;
	private Vector<Unit> monList;
	private Random ran = new Random();
	private int monDead;
	private int playerDead;

	public void init() {
		unitManager.monster_list.clear();
		unitManager.setCommonMonster(4);
		playerList = null;
		playerList = unitManager.player_list;
		monList = null;
		monList = unitManager.monster_list;
		monDead = monList.size();
		playerDead = playerList.size();
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
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	void player_attack(int index) {
		Player p = playerList.get(index);
		if (p.curhp <= 0)
			return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {
				int idx = inputNumber("공격할 대상을 선택해주세요");
				if(idx <1 || idx > monList.size()) {
					System.err.println("올바른 대상을 선택해주세요");
					continue;
				}
				if (monList.get(idx).curhp > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		} else if (sel == 2) {
		}
	}

	void monster_attack(int index) {
		Unit m = monList.get(index);
		if (m.curhp <= 0)
			return;
		while (true) {
			int idx = ran.nextInt(playerList.size());
			if (playerList.get(idx).curhp > 0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
	}

	void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).curhp <= 0) {
				num += 1;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).curhp <= 0) {
				num += 1;
			}
		}
		monDead = monList.size() - num;

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
				if (p_index < playerList.size()) {
					player_attack(p_index);

					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}

			} else if (!turn) {
				if (m_index < monList.size()) {
					monster_attack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}
			check_live();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
}
