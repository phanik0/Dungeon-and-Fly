package dnf;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Guild {
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private final int PARTY_SIZE = 4;
	public ArrayList<Player> guildMember = new ArrayList<>();
	public Player[] partyList;

//����� ���
//���� �߰�
// ���� ����
// ��Ƽ�� ��ü
//����
	private void setGuild() {
		for (int i = 0; i < UnitManager.player_list.size(); i++) {
			Player player = UnitManager.player_list.get(i);
			guildMember.add(player);
		}
		partyList = new Player[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildMember.size(); i++) {
			if (guildMember.get(i).getIsParty() == true) {
				partyList[n] = guildMember.get(i);
				n += 1;
			}

		}
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

	public void guildMenu() {
		printSelectMenu();
		int sel = inputNumber("�޴��� �������ּ���");
		if (sel == 1) {
			printAllGuildMember();
		} else if (sel == 2) {
			addGuildMember();
		} else if (sel == 3) {
			deleteGuildMember();
		} else if (sel == 4) {
			changePartyMember();
		} else if (sel == 5) {
			sortGuildMember();
		} else if (sel == 0) {
			GameManager.nextStage = "LOBBY";
		}
	}

	private void printSelectMenu() {
		System.out.println("=============== [RISING] ================");
		System.out.println("[1. ���� ���]");
		System.out.println("[2. ���� �߰�]");
		System.out.println("[3. ���� ����]");
		System.out.println("[4. ��Ƽ�� ��ü]");
		System.out.println("[5. ����]");
		System.out.println("[0. �ڷΰ���]");
		System.out.println("=========================================");
	}

	private void printAllGuildMember() {
		for (int i = 0; i < guildMember.size(); i++) {
			Player player = guildMember.get(i);
			if (player.getIsParty())
				System.out.println(player + "[��Ƽ��]");
			else
				System.out.println(player);
		}
	}

	private void addGuildMember() {
		Player player = generateRandomPlayer();
		System.out.println(player + "�� ��尡���� ��û�߽��ϴ�");
		System.out.println("�����Ͻðڽ��ϱ�? [Y/N]");
		String ans = scan.next();
		if (ans.equals("Y"))
			guildMember.add(player);
		else if (ans.equals("N"))
			System.out.println("������ �����߽��ϴ�");
	}

	private Player generateRandomPlayer() {
		String name = generateRandomName();

		Player player = null;
		int ranPlayer = ran.nextInt(4) + 1;
		if (ranPlayer == 1) {
			player = new PlayerStriker(name);
		} else if (ranPlayer == 2)
			player = new PlayerWeaponMaster(name);
		else if (ranPlayer == 3)
			player = new PlayerSaint(name);
		else if (ranPlayer == 4)
			player = new PlayerNenMaster(name);
		int ranLevel = ran.nextInt(15) + 1;
		player.setLevel(ranLevel);
		return player;
	}

	private String generateRandomName() {
		int rNameSize = ran.nextInt(3) + 1;
		String name = "";
		String[] name1 = { "ȫ", "��", "��", "��", "��", "��", "��" };
		String[] name2 = { "��", "��", "��", "��", "��", "��", "��" };
		String[] name3 = { "Ű", "��", "��", "��", "��", "��", "��" };
		for (int i = 0; i < rNameSize; i++) {
			String temp[] = null;
			if (i == 0)
				temp = name1;
			else if (i == 1)
				temp = name2;
			else
				temp = name3;
			for (int j = 0; j < temp.length; j++) {
				int r = ran.nextInt(temp.length);
				name += temp[r];
			}
		}
		return name;
	}

	private void deleteGuildMember() {
		printAllGuildMember();
		int index = inputNumber("������ ������ �������ּ���");
		if (index < 0 || index > guildMember.size()) {
			System.err.println("�ùٸ� ������ �������ּ���");
			return;
		}
		guildMember.remove(index);
	}

	private void changePartyMember() {
		System.out.println("==========[���� ��Ƽ]============");
		printPartyMember();
		int nowMember = inputNumber("�����Ͻ� ��Ƽ���� �������ּ���") - 1;
		if (nowMember < 0 || nowMember >= partyList.length) {
			System.err.println("�ùٸ� ��Ƽ���� �������ּ���");
			return;
		}
		printAllGuildMember();
		int changeMember = inputNumber("������Ƽ�� �� ����� �������ּ���") - 1;
		if (changeMember < 0 || changeMember >= guildMember.size()) {
			System.err.println("�ùٸ� ��Ƽ���� �������ּ���");
			return;
		}
		Player player = guildMember.get(changeMember);
		if (player.getIsParty()) {
			System.err.println("�̹� ��Ƽ���� �����Դϴ�");
			return;
		}
		partyList[nowMember] = null;
		partyList[nowMember] = player;

	}

	private void printPartyMember() {
		for (int i = 0; i < partyList.length; i++) {
			Player player = partyList[i];
			System.out.printf("%d. " + player, i);
		}
	}

	private void sortGuildMember() {
		for (int i = 0; i < guildMember.size() - 1; i++) {
			Player firstPlayer = guildMember.get(i);
			int maxLv = firstPlayer.getLevel();
			int index = 0;
			for (int j = i; j < guildMember.size() - 1; j++) {
				Player target = guildMember.get(j + 1);
				int lv = target.getLevel();
				if (maxLv < lv) {
					firstPlayer = target;
					maxLv = lv;
					index = j;
				}
			}
			Player temp = guildMember.get(i);
			guildMember.set(i, firstPlayer);
			guildMember.set(index, temp);
			printAllGuildMember();

		}

	}

}
