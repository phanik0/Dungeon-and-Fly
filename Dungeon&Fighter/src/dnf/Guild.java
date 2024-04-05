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

//길드목록 출력
//길드원 추가
// 길드원 삭제
// 파티원 교체
//정렬
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
			System.err.println("숫자만 입력해주세요");
		}
		return number;
	}

	public void guildMenu() {
		printSelectMenu();
		int sel = inputNumber("메뉴를 선택해주세요");
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
		System.out.println("[1. 길드원 목록]");
		System.out.println("[2. 길드원 추가]");
		System.out.println("[3. 길드원 삭제]");
		System.out.println("[4. 파티원 교체]");
		System.out.println("[5. 정렬]");
		System.out.println("[0. 뒤로가기]");
		System.out.println("=========================================");
	}

	private void printAllGuildMember() {
		for (int i = 0; i < guildMember.size(); i++) {
			Player player = guildMember.get(i);
			if (player.getIsParty())
				System.out.println(player + "[파티중]");
			else
				System.out.println(player);
		}
	}

	private void addGuildMember() {
		Player player = generateRandomPlayer();
		System.out.println(player + "가 길드가입을 신청했습니다");
		System.out.println("수락하시겠습니까? [Y/N]");
		String ans = scan.next();
		if (ans.equals("Y"))
			guildMember.add(player);
		else if (ans.equals("N"))
			System.out.println("가입을 거절했습니다");
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
		String[] name1 = { "홍", "미", "지", "구", "김", "응", "후" };
		String[] name2 = { "비", "넨", "스", "제", "포", "잉", "전" };
		String[] name3 = { "키", "스", "제", "주", "공", "귀", "옹" };
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
		int index = inputNumber("삭제할 길드원을 선택해주세요");
		if (index < 0 || index > guildMember.size()) {
			System.err.println("올바른 길드원을 선택해주세요");
			return;
		}
		guildMember.remove(index);
	}

	private void changePartyMember() {
		System.out.println("==========[현재 파티]============");
		printPartyMember();
		int nowMember = inputNumber("변경하실 파티원을 선택해주세요") - 1;
		if (nowMember < 0 || nowMember >= partyList.length) {
			System.err.println("올바른 파티원을 선택해주세요");
			return;
		}
		printAllGuildMember();
		int changeMember = inputNumber("새로파티에 들어갈 멤버를 선택해주세요") - 1;
		if (changeMember < 0 || changeMember >= guildMember.size()) {
			System.err.println("올바른 파티원을 선택해주세요");
			return;
		}
		Player player = guildMember.get(changeMember);
		if (player.getIsParty()) {
			System.err.println("이미 파티중인 길드원입니다");
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
