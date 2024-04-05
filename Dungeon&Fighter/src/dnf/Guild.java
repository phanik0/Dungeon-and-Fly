package dnf;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Guild {
private Scanner scan = new Scanner(System.in);
private Random ran = new Random();
private final int PARTY_SIZE = 4;
public ArrayList<Player> guildMember = new ArrayList<>();
public Unit[] partyList;
//����� ���
//���� �߰�
// ���� ����
// ��Ƽ�� ��ü
//����
private void setGuild() {
	for(int i = 0 ; i<UnitManager.player_list.size();i++) {
		Player player = UnitManager.player_list.get(i);
		guildMember.add(player);
	}
	partyList = new Unit[PARTY_SIZE];
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
	if(sel ==1) {
		printAllGuildMember();
	}else if(sel == 2) {
		addGuildMember();
	}
	else if(sel == 3) {
		deleteGuildMember();
	}
	else if(sel == 4) {
		changeParty();
	}
	else if(sel == 5) {
		sortGuildMember();
	}
	else if(sel == 0) {
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
	for(int i = 0 ; i<guildMember.size();i++) {
		Player player = guildMember.get(i);
		System.out.println(player);
	}
}
private void addGuildMember() {
	Player player =  generateRandomPlayer();
	System.out.println(player+"�� ��尡���� ��û�߽��ϴ�");
	System.out.println("�����Ͻðڽ��ϱ�? [Y/N]");
	String ans = scan.next();
	if(ans.equals("Y"))
		guildMember.add(player);
	else if(ans.equals("N"))
		System.out.println("������ �����߽��ϴ�");
}
private Player generateRandomPlayer() {
	String name = generateRandomName();
	
	Player player = null;
	int ranPlayer = ran.nextInt(4)+1;
	if(ranPlayer == 1) {
		player = new PlayerStriker(name);
	}else if(ranPlayer == 2)
		player = new PlayerWeaponMaster(name);
	else if(ranPlayer == 3)
		player = new PlayerSaint(name);
	else if(ranPlayer == 4)
		player = new PlayerNenMaster(name);
	int ranLevel = ran.nextInt(15)+1;
	player.setLevel(ranLevel);
	return player;
}
private String generateRandomName() {
	int rNameSize = ran.nextInt(3)+1;
	String name = "";
	String[] name1 = {"ȫ","��","��","��","��","��","��"};
	String[] name2 = {"��","��","��","��","��","��","��"};
	String[] name3 = {"Ű","��","��","��","��","��","��"};
	for(int i = 0 ; i<rNameSize;i++) {
		String temp[] = null;
		if(i == 0) 
			temp = name1;
		else if(i ==1)
			temp = name2;
		else 
			temp = name3;
		for(int j = 0 ; j<temp.length;j++) {
			int r = ran.nextInt(temp.length);
			name += temp[r];
		}
	}
	return name;
}

private void deleteGuildMember() {
	printAllGuildMember();
	int index = inputNumber("������ ������ �������ּ���");
	if(index <0 || index > guildMember.size()) {
		System.err.println("�ùٸ� ������ �������ּ���");
		return;
	}
	guildMember.remove(index);
}



}
