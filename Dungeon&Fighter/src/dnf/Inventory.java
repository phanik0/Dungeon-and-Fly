package dnf;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	private Scanner scan = new Scanner(System.in);
	public static int gold;
	public static ArrayList<Item> myWeapon;
	public static ArrayList<Item> myArmor;
	public static ArrayList<Item> myAccessory;

	public Inventory() {
		gold = 10000;
		myWeapon = new ArrayList<>();
		myArmor = new ArrayList<>();
		myAccessory = new ArrayList<>();
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

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [�κ��丮 �޴�] =============");
			System.out.println("[1.����] [2.�Ǹ�] [0.�ڷΰ���]");
			int sel = GameManager.scan.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}

	private void equipMenu() {
		while (true) {
			UnitManager.printAllPlayer();
			int sel = inputNumber("�÷��̾ �������ּ���[0. �ڷΰ���]") - 1;
			if (sel == -1)
				break;
			if (sel < 0 || sel >= GameManager.playerList.size()) {
				System.err.println("�ùٸ� �÷��̾ �������ּ���");
				continue;
			}
			Player player = GameManager.playerList.get(sel);
			while (true) {
				printItemMenu();
				int menu = inputNumber("������ ������ ������ �������ּ���");
				if (menu == 0)
					break;

				ArrayList<Item> temp = selectItemSort(menu);

				for (int i = 0; i < temp.size(); i++) {
					System.out.printf("%d\n" + temp.get(i), i + 1);
				}
				int index = inputNumber("������ �������� �������ּ���") - 1;

				if (index < 0 || index >= temp.size()) {
					System.err.println("�κ��丮�� �����ϴ� �������� �������ּ���");
					continue;
				}
				Item item = temp.get(index);
				if (player.getPlayerWeapon() != item.getKind()) {
					System.err.println("�������� ������ �� �����ϴ�");
					continue;
				}
				addItem(player, item, menu);
				break;
			}
			return;
		}

	}

	private void printItemMenu() {
		System.out.println("[1. ����]");
		System.out.println("[2. ��]");
		System.out.println("[3. �Ǽ�����]");
		System.out.println("[0. �ڷΰ���]");
	}

	private ArrayList<Item> selectItemSort(int menu) {
		ArrayList<Item> temp = null;
		if (menu == Item.WEAPON) {
			temp = myWeapon;
		} else if (menu == Item.ARMOR) {
			temp = myArmor;
		} else if (menu == Item.ACCESSORY) {
			temp = myAccessory;
		}
		for (int i = 0; i < temp.size(); i++) {
			System.out.printf("%d\n" + temp.get(i), i + 1);
		}
		return temp;
	}

	private void addItem(Player player, Item item, int menu) {
		if (menu == Item.WEAPON) {
			player.setWeapon(item);
		} else if (menu == Item.ARMOR) {
			player.setArmor(item);
		} else if (menu == Item.ACCESSORY) {
			player.setAccessory(item);
		}
	}

	private void sellMenu() {
		while (true) {
			printItemMenu();
			int menu = inputNumber("�Ǹ��� ������ ������ �������ּ���");
			if (menu == 0)
				break;

			ArrayList<Item> temp = selectItemSort(menu);

			for (int i = 0; i < temp.size(); i++) {
				System.out.printf("%d\n" + temp.get(i), i + 1);
			}
			int index = inputNumber("�Ǹ��� �������� �������ּ���") - 1;

			if (index < 0 || index >= temp.size()) {
				System.err.println("�κ��丮�� �����ϴ� �������� �������ּ���");
				continue;
			}
			Item item = temp.get(index);

			System.out.println("�������� �Ǹ��Ͻðڽ��ϱ�?[Y/N]");
			String ans = scan.next();
			if (ans.equals("N|n"))
				continue;
			else if (ans.equals("Y|y")) {
				int price = (int) (item.getPrice() * 0.7);
				gold += price;
				temp.remove(index);
			}
			break;
		}
	}
}
