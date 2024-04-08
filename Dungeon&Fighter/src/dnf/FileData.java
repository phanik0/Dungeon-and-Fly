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
	// �����ؾ��Ұ�
	// �÷��̾� �̸� ���� ���� ���� ���ݷ� ����ġ hp ��Ƽ ��忩�� �κ��丮
	// ��� ��Ƽ���
	// ��� �ʴ� ��û �߰��ϱ�

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
		// �÷��̾� ����
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
			// �̸�,����,������,����,����,��Ƽ,���,����, ����ġ
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
		// ����
		inven += "Weapon";
		inven += "\n";
		for (int i = 0; i < Inventory.myWeapon.size(); i++) {
			// �̸� ���� ������ ����
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
		// ��
		inven += "Armor";
		inven += "\n";
		for (int i = 0; i < Inventory.myWeapon.size(); i++) {
			// �̸� ���� ���� ����
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
		// ��ű�
		inven += "Accessroy";
		inven += "\n";
		for (int i = 0; i < Inventory.myWeapon.size(); i++) {
			// �̸� ���� ������ ���� ����
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
