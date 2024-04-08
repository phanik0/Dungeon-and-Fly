package dnf;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class StageCommonMonsterBattle extends Stage {
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private UnitManager unitManager = new UnitManager();
	private Vector<Player> playerList;
	private Vector<Monster> monList;
	public static int name;
	public static boolean dooms;
	public static boolean silence;
	
	private int monDead;
	private int playerDead;

	public void init() {
		unitManager.monsterList.clear();
		unitManager.setCommonMonster(4);
		playerList = null;
		playerList = GameManager.playerList;
		monList = null;
		monList = unitManager.monsterList;
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
			Player player = playerList.get(i);
			System.out.println(player);
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			Monster monster = monList.get(i);
			System.out.println(monster);
		}
	}

	private void attackPlayer(int index) {
		Player player = playerList.get(index);
		if (player.getHp() <= 0)
			return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + player.getName() + "] [1.일반공격] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {
				int idx = inputNumber("공격할 대상을 선택해주세요")-1;
				if (idx < 0 || idx >= monList.size()) {
					System.err.println("올바른 대상을 선택해주세요");
					continue;
				}
				if (monList.get(idx).getHp() > 0) {
					player.attack(monList.get(idx));// 캐릭별로 대사랑 데미지 만들어보기
					break;
				}
			}
		} else if (sel == 2) {
		}
	}

	private void attackMonster(int index) {
		Monster monster = monList.get(index);
		if (monster.getHp() <= 0)
			return;
		while (true) {
			int idx = ran.nextInt(playerList.size());
			if (playerList.get(idx).getHp() > 0) {
				monster.attack(playerList.get(idx));// 몬스터도 게이지 차면 스킬쓰기
				break;
			}
		}
	}

	private void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getHp() <= 0) {
				num += 1;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).getHp() <= 0) {
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
					attackPlayer(p_index);

					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}

			} else if (!turn) {
				if (m_index < monList.size()) {
					attackMonster(m_index);
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
			if(name == 1) {
				dooms = true;
			}else if(name == 2) {
				silence = true;
			}
			Stage.stageClearCount++;
			GameManager.nextStage = "LOBBY";
		
		return false;
	}
}
