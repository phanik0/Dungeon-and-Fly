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
	private ArrayList<Player> playerList;
	boolean changeData;
	boolean isPlayer;
	boolean isWeapon;
	boolean isArmor;
	boolean isAccessory;
	// �����ؾ��Ұ�
	// �÷��̾� �̸� ���� ���� ���� ���ݷ� ����ġ hp ��Ƽ ��忩�� �κ��丮
	// ��� ��Ƽ���
	// ��� �ʴ� ��û �߰��ϱ�

	public void setFile() {
		fileName = "DnF.txt";
		file = new File(fileName);
		playerList = GameManager.playerList;
	}

	public void saveData() throws IOException {
		setFile();
		String gameData = setData();
		fw = new FileWriter(file);
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
		String weaponData = "";
		String armorData = "";
		String accessoryData = "";
		playerData += Inventory.gold;
		playerData += "\n";
		playerData += "PlayerInfo";
		playerData += "\n";
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			Item weapon = player.getWeapon();
			Item armor = player.getArmor();
			Item accessory = player.getAccessory();
			// �̸�,����,������,����,����,��Ƽ,���,����, ����ġ
			playerData += player.getName();

			playerData += "/";
			playerData += player.getMaxHp();
			playerData += "/";
			playerData += player.getDamage();
			playerData += "/";
			playerData += player.getDef();
			playerData += "/";
			playerData += player.getJob();
			playerData += "/";
			playerData += player.getIsParty();
			playerData += "/";
			playerData += player.getGuildName();
			playerData += "/";
			playerData += player.getLevel();
			playerData += "/";
			playerData += player.getExp();
			playerData += "/";
			if (weapon != null) {
				weaponData += weapon.getName();
				weaponData += ",";
				weaponData += weapon.getKind();
				weaponData += ",";
				weaponData += weapon.getDamage();
				weaponData += ",";
				weaponData += weapon.getPrice();
				playerData += weaponData;
			} else
				playerData += weapon;
			playerData += "/";
			if (armor != null) {
				armorData += armor.getName();
				armorData += ",";
				armorData += armor.getKind();
				armorData += ",";
				armorData += armor.getDef();
				armorData += ",";
				armorData += armor.getPrice();
				playerData += armorData;
			} else
				playerData += armor;
			playerData += "/";
			if (armor != null) {
				accessoryData += accessory.getName();
				accessoryData += ",";
				accessoryData += accessory.getKind();
				accessoryData += ",";
				accessoryData += accessory.getDamage();
				accessoryData += ",";
				accessoryData += accessory.getDef();
				accessoryData += ",";
				accessoryData += accessory.getPrice();
				playerData += accessoryData;
			} else
				playerData += accessory;
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
			inven += "/";
			inven += item.getKind();
			inven += "/";
			inven += item.getDamage();
			inven += "/";
			inven += item.getPrice();
			inven += "\n";
		}
		// ��
		inven += "Armor";
		inven += "\n";
		for (int i = 0; i < Inventory.myArmor.size(); i++) {
			// �̸� ���� ���� ����
			Item item = Inventory.myArmor.get(i);
			inven += item.getName();
			inven += "/";
			inven += item.getKind();
			inven += "/";
			inven += item.getDef();
			inven += "/";
			inven += item.getPrice();
			inven += "\n";
		}
		// ��ű�
		inven += "Accessory";
		inven += "\n";
		for (int i = 0; i < Inventory.myAccessory.size(); i++) {
			// �̸� ���� ������ ���� ����
			Item item = Inventory.myAccessory.get(i);
			inven += item.getName();
			inven += "/";
			inven += item.getKind();
			inven += "/";
			inven += item.getDamage();
			inven += "/";
			inven += item.getDef();
			inven += "/";
			inven += item.getPrice();
			inven += "\n";
		}
		return inven;
	}

	public void loadData()  {
		setFile();
		String playerInfo = "";
		String itemInfo = "";
		try {
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				resetData();
				Inventory.gold = Integer.parseInt(br.readLine());
				
				while (br.ready()) {
					String line = br.readLine();
					System.out.println(line);
					if (checkData(line))
						continue;
					setLoadData(line);
//				if (changeData) {
//					ArrayList temp =changeArrayList(line);
//				}
					
				}
				fr.close();
				br.close();
				System.out.println("�ε强��");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("�ε����");
		}

	}

	private void resetData() {
		GameManager.playerList.clear();
		
		Inventory.myWeapon.clear();
		Inventory.myArmor.clear();
		Inventory.myAccessory.clear();
	}

	private boolean checkData(String line) {
		if (line.equals("PlayerInfo")) {
			this.isPlayer = true;
			return true;
		} else if (line.equals("Weapon")) {
			this.isPlayer = false;
			this.isWeapon = true;
			return true;

		} else if (line.equals("Armor")) {
			this.isWeapon = false;
			this.isArmor = true;
			return true;
		} else if (line.equals("Accessory")) {
			this.isArmor = false;
			this.isAccessory = true;
			return true;
		}
		return false;
	}

//	private ArrayList changeArrayList(String line) {
//		ArrayList temp = null;
//		if (isPlayer) {
//			temp = GameManager.playerList;
//			setPlayerData(line);
//		} else if (isWeapon)
//			temp = Inventory.myWeapon;
//		else if (isArmor)
//			temp = Inventory.myArmor;
//		else if (isAccessory)
//			temp = Inventory.myAccessory;
//		changeData = false;
//		return temp;
//	}

	private void setLoadData(String line) {
		if (isPlayer) {
			setPlayerData(line);
		} else if (isWeapon)
			setWeaponData(line);
		else if (isArmor)
			setArmorData(line);
		else if (isAccessory)
			setAccessoryData(line);
	}

	private void setPlayerData(String line) {
		// �̸�,����,������,����,����,��Ƽ,���,����, ����ġ
		String[] temp = line.split("/");
		String name = temp[0];
		int maxHp = Integer.parseInt(temp[1]);
		int damage = Integer.parseInt(temp[2]);
		int def = Integer.parseInt(temp[3]);
		String job = temp[4];
		boolean party = Boolean.parseBoolean(temp[5]);
		String guildName = temp[6];
		int level = Integer.parseInt(temp[7]);
		int exp = Integer.parseInt(temp[8]);
		Player player = new Player(name, maxHp, damage, def, job, party, guildName, level, exp);
		GameManager.playerList.add(player);
		
		if (!(temp[9]).equals("null")) {
			// �̸� ���� ������ ����
			String[] weaponData = temp[9].split(",");
			String weaponName = weaponData[0];
			int kind = Integer.parseInt(weaponData[1]);
			int weaponDamage = Integer.parseInt(weaponData[2]);
			int price = Integer.parseInt(weaponData[3]);
			Item weapon = new Item(kind,weaponDamage,weaponName,price);
			player.setWeapon(weapon);
		}
		if (!(temp[10]).equals("null")) {
			// �̸� ���� ������ ����
			String[] armorData = temp[9].split(",");
			String armorName = armorData[0];
			int kind = Integer.parseInt(armorData[1]);
			int armorDef= Integer.parseInt(armorData[2]);
			int price = Integer.parseInt(armorData[3]);
			Item armor = new Item(kind,armorName,armorDef,price);
			player.setArmor(armor);
		}
		if (!(temp[11]).equals("null")) {
			// �̸� ���� ������ ����
			String[] accessoryData = temp[9].split(",");
			String accessoryName = accessoryData[0];
			int kind = Integer.parseInt(accessoryData[1]);
			int accessoryDamage = Integer.parseInt(accessoryData[2]);
			int accessoryDef = Integer.parseInt(accessoryData[3]);
			int price = Integer.parseInt(accessoryData[4]);
			Item accessory = new Item(kind,accessoryName,accessoryDamage,accessoryDef,price);
			player.setAccessory(accessory);
		}
		
	}

	private void setWeaponData(String line) {
		// �̸� ���� ���ݷ� ����
		String[] temp = line.split("/");
		String name = temp[0];
		int kind = Integer.parseInt(temp[1]);
		int damage = Integer.parseInt(temp[2]);
		int price = Integer.parseInt(temp[3]);
		Item weapon = new Item(kind, name, damage, price);
		Inventory.myWeapon.add(weapon);
	}

	private void setArmorData(String line) {
		// �̸� ���� ���� ����
		String[] temp = line.split("/");
		String name = temp[0];
		int kind = Integer.parseInt(temp[1]);
		int def = Integer.parseInt(temp[2]);
		int price = Integer.parseInt(temp[3]);
		Item armor = new Item(kind, name, def, price);
		Inventory.myArmor.add(armor);

	}

	private void setAccessoryData(String line) {
		// �̸� ���� ���ݷ� ���� ����
		String[] temp = line.split("/");
		String name = temp[0];
		int kind = Integer.parseInt(temp[1]);
		int damage = Integer.parseInt(temp[2]);
		int def = Integer.parseInt(temp[3]);
		int price = Integer.parseInt(temp[4]);
		Item accessory = new Item(kind, name, damage, def, price);
		Inventory.myAccessory.add(accessory);

	}

}
