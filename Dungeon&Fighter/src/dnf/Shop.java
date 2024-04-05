package dnf;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	public ArrayList<ArrayList<Item>> weapon = new ArrayList<>();
	public ArrayList<Item> gun = new ArrayList<>();
	public ArrayList<Item> cross = new ArrayList<>();
	public ArrayList<Item> knuckle = new ArrayList<>();
	public ArrayList<Item> sword = new ArrayList<>();

	public ArrayList<Item> armor = new ArrayList<>();
	public ArrayList<Item> accessory = new ArrayList<>();

	public Shop() {
		cross.add(new Item(Item.CROSS, 10, "���� ���ڰ�", 1000));// ����
		sword.add(new Item(Item.SWORD, 10, "�콼 û����", 800));// ����
		knuckle.add(new Item(Item.GUN, 10, "�콼 ������", 700));// ����
		gun.add(new Item(Item.CROSS, 10, "���� ���ڰ�", 2500));// ����
		armor.add(new Item(Item.ARMOR, "���� ��������", 15, 500));// ����
		accessory.add(new Item(Item.ACCESSORY, "���� ���ڰ�", 5, 8, 600));// ����
		weapon.add(gun);
		weapon.add(cross);
		weapon.add(knuckle);
		weapon.add(sword);

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
				int index = 0;
				if (sel != Item.WEAPON) {
					printItemList(sel);
					index = inputNumber("������ �������� �������ּ���") - 1;
				
				}
				Item item = null;
				if (sel == Item.WEAPON) {
					runWeaponMenu();
				} else if (sel == Item.ARMOR) {
					item = armor.get(index);

				} else if (sel == Item.ACCESSORY) {
					item = accessory.get(index);
				}
				addItem(sel,item);
				
			}
		}
	}

	private void printShop() {
		System.out.println("[1. ���� ]");
		System.out.println("[2. �� ]");
		System.out.println("[3. �Ǽ����� ]");
	}

	private void printWeaponMenu() {
		System.out.println("[1. ������ ]");
		System.out.println("[2. ���ڰ� ]");
		System.out.println("[3. ���� ]");
		System.out.println("[4. ��Ŭ ]");

	}
	private void runWeaponMenu() {
		
		printWeaponMenu();
		int sel = inputNumber("���� ������ ����ּ���");
		ArrayList<Item> temp = null;
		if (sel == Item.GUN) {
			temp = gun;
			}
		else if (sel == Item.CROSS) {
			temp = cross;
		}
		else if (sel == Item.KNUCKLE) {
			temp = knuckle;
		}
		else if (sel == Item.SWORD) {
			temp = sword;
		}
		printWeaponList(temp);
		int index = inputNumber("������ �������� �������ּ���") - 1;
		Item item = temp.get(index);
		Inventory.myWeapon.add(item);
		
	}
	private void printWeaponList(ArrayList<Item> kind) {
		
	for (int i = 0; i < weapon.size(); i++) {
		Item item = kind.get(i);
		System.out.printf("%d. " + item + "\n", i + 1);
	}
	}
	private void printItemList(int sel) {
		ArrayList<Item> temp = null;
		
			temp = sel == Item.ARMOR ? armor : accessory;
			for (int i = 0; i < temp.size(); i++) {
				Item item = temp.get(i);
				System.out.printf("%d. " + item + "\n", i + 1);
			
		}
	}
	private void addItem(int sel, Item item) {
		if (item.getPrice() > Inventory.gold) {
			System.err.println("��尡 �����մϴ�");
			return;
		}
		ArrayList<Item> temp = null;
		temp = sel == Item.ARMOR ? armor : accessory;
		temp.add(item);
	}

}
