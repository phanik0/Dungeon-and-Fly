package dnf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class FileData {
	private File file;
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private String fileName;
	private Vector<Player> playerList;
	// 저장해야할거
	// 플레이어 이름 직업 레벨 방어력 공격력 경험치 hp 파티 길드여부 인벤토리
	// 길드 파티멤버
	// 길드 초대 신청 추가하기

	public void setFile() {
		fileName = "DnF.txt";
	}

	public void saveData() throws IOException {
		setFile();
		playerList = Stage.playerList;
		String gameData = setData();
		file = new File(fileName);
		fw= new FileWriter(file);
		fw.write(gameData);
		fw.close();

	}

	private String setData() {
		String gameData = "";
		// 플레이어 인포
		gameData += playerData();
		gameData += inventoryData();
		return gameData;
	}

	private String playerData() {
		String playerData = "";
		playerData += "PlayerInfo";
		playerData += "\n";
		playerData += Inventory.gold;
		playerData += "\n";
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			Item weapon = player.getWeapon();
			Item armor = player.getArmor();
			Item accessroy = player.getAccessory();
			// 이름,맥피,데미지,방어력,직업,파티,길드,레벨, 경험치
			playerData += player.getName();
			playerData += ",";
			playerData += player.getMaxHp();
			playerData += ",";
			playerData += player.getDamage();
			playerData += ",";
			playerData += player.getDef();
			playerData += ",";
			playerData += player.getJob();
			playerData += ",";
			playerData += player.getIsParty();
			playerData += ",";
			playerData += player.getGuildName();
			playerData += "\n";
		}
		return playerData;
	}

	private String inventoryData() {
		String inven = "";
		// 무기
		inven += "Weapon";
		inven += "\n";
		for (int i = 0; i < Inventory.myWeapon.size(); i++) {
			// 이름 종류 데미지 가격
			Item item = Inventory.myWeapon.get(i);
			inven += item.getName();
			inven += ",";
			inven += item.getKind();
			inven += ",";
			inven += item.getDamage();
			inven += ",";
			inven += item.getPrice();
			inven += "\n";
		}
		// 방어구
		inven += "Armor";
		inven += "\n";
		for (int i = 0; i < Inventory.myWeapon.size(); i++) {
			// 이름 종류 방어력 가격
			Item item = Inventory.myWeapon.get(i);
			inven += item.getName();
			inven += ",";
			inven += item.getKind();
			inven += ",";
			inven += item.getDef();
			inven += ",";
			inven += item.getPrice();
			inven += "\n";
		}
		// 장신구
		inven += "Accessroy";
		inven += "\n";
		for (int i = 0; i < Inventory.myWeapon.size(); i++) {
			// 이름 종류 데미지 방어력 가격
			Item item = Inventory.myWeapon.get(i);
			inven += item.getName();
			inven += ",";
			inven += item.getKind();
			inven += ",";
			inven += item.getDamage();
			inven += ",";
			inven += item.getDef();
			inven += ",";
			inven += item.getPrice();
			inven += "\n";
		}
		return inven;
	}
	public void loadData() {
		
	}

}
