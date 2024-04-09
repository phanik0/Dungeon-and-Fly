package dnf;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class StageAstaros extends Stage{
	public static boolean isAstarosClear;
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private Monster astaros;

	private int monDead;
	private int playerDead;

	public void init() {
		playerDead = GameManager.playerList.size();
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
			System.err.println("���ڸ� �Է����ּ���");
		}
		return number;
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
		System.out.println(astaros);
	}

	private void attackPlayer(int index) {
		Player player = GameManager.playerList.get(index);
		if (player.getHp() <= 0)
			return;
		System.out.println("======[�޴� ����]=====");
		System.out.println("[" + player.getName() + "] [1.�Ϲݰ���] [2.��ų]");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {

				if (astaros.getHp() > 0) {
					player.attack(astaros);// ĳ������ ���� ������ ������
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
			int idx = ran.nextInt(GameManager.playerList.size());
			if (GameManager.playerList.get(idx).getHp() > 0) {
				astaros.attack(GameManager.playerList.get(idx));// ���͵� ������ ���� ��ų����
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
		isAstarosClear = true;
		System.out.println("[����� ���� ���������� Ŭ���� �Ͽ����ϴ� ������ ���ư��ϴ�]");

		GameManager.nextStage = "LOBBY";

		return false;
	}

}
