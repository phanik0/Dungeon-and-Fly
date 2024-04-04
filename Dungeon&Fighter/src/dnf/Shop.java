package dnf;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	public ArrayList<Item> weapon = new ArrayList<>();
	public ArrayList<Item> armor = new ArrayList<>();
	public ArrayList<Item> accessory = new ArrayList<>();

	public Shop() {
		weapon.add(new Item(Item.WEAPON, 10, "���� ���ڰ�", 1000));// ����
		weapon.add(new Item(Item.WEAPON, 10, "�콼 û����", 800));// ����
		weapon.add(new Item(Item.WEAPON, 10, "�콼 ������", 700));// ����
		weapon.add(new Item(Item.WEAPON, 10, "���� ���ڰ�", 2500));// ����
		armor.add(new Item(Item.ARMOR, "���� ��������", 15, 500));// ����
		accessory.add(new Item(Item.ACCESSORY, "���� ���ڰ�", 5, 8, 600));// ����

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

	public void shopManager() {
		while (true) {
			printShop();
			int sel = inputNumber("�޴��� �������ּ���");
			while (true) {
				printItemList(sel);
				Item item = null;
				int index = inputNumber("������ �������� �������ּ���") - 1;
				if (sel == Item.WEAPON) {
					item = weapon.get(index);
				} else if (sel == Item.ARMOR) {
					item = armor.get(index);

				} else if (sel == Item.ACCESSORY) {
					item = accessory.get(index);
				}
				if (item.getPrice() > Inventory.gold) {
					System.err.println("��尡 �����մϴ�");
					return;
				}
				Inventory.myWeapon.add(item);
			}
		}
	}

	private void printShop() {
		System.out.println("[1. ���� ]");
		System.out.println("[2. �� ]");
		System.out.println("[3. �Ǽ����� ]");
	}

	private void printItemList(int sel) {
		ArrayList<Item> temp = null;
		if (sel == Item.ACCESSORY)
			temp = accessory;
		else
			temp = sel == Item.WEAPON ? weapon : armor;
		for (int i = 0; i < temp.size(); i++) {
			Item item = temp.get(i);
			System.out.printf("%d. " + item + "\n", i + 1);
		}
	}

}
