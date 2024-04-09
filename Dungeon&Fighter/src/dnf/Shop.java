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
	public ArrayList<Item> boxingGlove = new ArrayList<>();

	public ArrayList<Item> armor = new ArrayList<>();
	public ArrayList<Item> accessory = new ArrayList<>();

	public Shop() {
		cross.add(new Item(Item.CROSS, 10, "���� ���ڰ�", 1000));// ����
		cross.add(new Item(Item.CROSS, 10, "û�����ڰ�", 1200));// ����
			
		sword.add(new Item(Item.SWORD, 10, "�콼 û����", 800));// ����
		sword.add(new Item(Item.SWORD, 10, "���� �ٷ� ����", 800));// ����

		knuckle.add(new Item(Item.KNUCKLE, 10, "���� ���� ��Ŭ", 700));// ����
		knuckle.add(new Item(Item.KNUCKLE, 10, "�콼 ��Ŭ", 700));// ����
		
		boxingGlove.add(new Item(Item.BOXING_GLOVE, 10, "�߽� �۷���", 700));// ����
		boxingGlove.add(new Item(Item.BOXING_GLOVE, 10, "���� �۷���", 700));// ����
		
		gun.add(new Item(Item.GUN, 10, "���� ������", 800));// ����
		gun.add(new Item(Item.GUN, 10, "���� �ڵ�����", 800));// ����
		gun.add(new Item(Item.GUN, 10, "���� �ӽ���", 800));// ����

		armor.add(new Item(Item.ARMOR, "���� ��������", 15, 500));// ����
	
		accessory.add(new Item(Item.ACCESSORY, "Ǯ�ɹ���", 5, 8, 600));// ����
	
		weapon.add(gun);
		weapon.add(cross);
		weapon.add(knuckle);
		weapon.add(sword);
		weapon.add(boxingGlove);

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
			if (sel == 0) {
				return;
			}

			int index = -1;
			if (sel != Item.WEAPON) {
				printItemList(sel);
				index = inputNumber("������ �������� �������ּ���") - 1;
				if (index == -1)
					continue;
			}
			Item item = null;
			if (sel == 1) {
				runWeaponMenu();
			} else if (sel == 2) {
				item = armor.get(index);

			} else if (sel == 3) {
				item = accessory.get(index);
			} else if (sel == 0)
				break;
			if (item != null)
				addItem(sel, item);
			sel = 0;

		}
	}

	private void printShop() {
		System.out.println("[1. ���� ]");
		System.out.println("[2. �� ]");
		System.out.println("[3. �Ǽ����� ]");
		System.out.println("[0. �ڷΰ���]");
	}

	private void printWeaponMenu() {
		System.out.println("[1. ������ ]");
		System.out.println("[2. ���ڰ� ]");
		System.out.println("[3. �� ]");
		System.out.println("[4. ��Ŭ ]");
		System.out.println("[5. �����۷��� ]");
		System.out.println("[0. �ڷΰ���]");

	}

	private void runWeaponMenu() {
		while (true) {
			printWeaponMenu();
			int sel = inputNumber("���� ������ ����ּ���");
			ArrayList<Item> temp = null;
			if (sel == 1)
				temp = gun;
			else if (sel == 2)
				temp = cross;
			else if (sel == 3)
				temp = sword;
			else if (sel == 4)
				temp = knuckle;
			else if (sel == 5)
				temp = boxingGlove;
			else if (sel == 0)
				break;
			else
				continue;

			printWeaponList(temp);
			int index = inputNumber("������ �������� �������ּ��� [0. �ڷΰ���]") - 1;
			if (index == -1)
				continue;
			Item item = temp.get(index);
			if (item != null)
				Inventory.myWeapon.add(item);
		}
		return;

	}

	private void printWeaponList(ArrayList<Item> kind) {

		for (int i = 0; i < kind.size(); i++) {
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
		System.out.println("[0. �ڷΰ���");
	}

	private void addItem(int sel, Item item) {
		if (item.getPrice() > Inventory.gold) {
			System.err.println("��尡 �����մϴ�");
			return;
		}
		if(sel == 2)
			Inventory.myArmor.add(item);
		else if(sel == 3)
			Inventory.myAccessory.add(item);
		Inventory.gold -= item.getPrice();
        System.out.println("[" + item.getName()+ "] �� �����߽��ϴ�.");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
	}

}
