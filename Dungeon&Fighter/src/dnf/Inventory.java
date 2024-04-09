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
			System.err.println("숫자만 입력해주세요");
		}
		return number;
	}

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
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
			int sel = inputNumber("플레이어를 선택해주세요[0. 뒤로가기]") - 1;
			if (sel == -1)
				break;
			if (sel < 0 || sel >= GameManager.playerList.size()) {
				System.err.println("올바른 플레이어를 선택해주세요");
				continue;
			}
			Player player = GameManager.playerList.get(sel);
			while (true) {
				printItemMenu();
				int menu = inputNumber("착용할 아이템 종류를 선택해주세요");
				if (menu == 0)
					break;

				ArrayList<Item> temp = selectItemSort(menu);

				for (int i = 0; i < temp.size(); i++) {
					System.out.printf("%d\n" + temp.get(i), i + 1);
				}
				int index = inputNumber("착용할 아이템을 선택해주세요") - 1;

				if (index < 0 || index >= temp.size()) {
					System.err.println("인벤토리에 존재하는 아이템을 선택해주세요");
					continue;
				}
				Item item = temp.get(index);
				if (player.getPlayerWeapon() != item.getKind()) {
					System.err.println("이직업은 착용할 수 없습니다");
					continue;
				}
				addItem(player, item, menu);
				break;
			}
			return;
		}

	}

	private void printItemMenu() {
		System.out.println("[1. 무기]");
		System.out.println("[2. 방어구]");
		System.out.println("[3. 악세서리]");
		System.out.println("[0. 뒤로가기]");
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
			int menu = inputNumber("판매할 아이템 종류를 선택해주세요");
			if (menu == 0)
				break;

			ArrayList<Item> temp = selectItemSort(menu);

			for (int i = 0; i < temp.size(); i++) {
				System.out.printf("%d\n" + temp.get(i), i + 1);
			}
			int index = inputNumber("판매할 아이템을 선택해주세요") - 1;

			if (index < 0 || index >= temp.size()) {
				System.err.println("인벤토리에 존재하는 아이템을 선택해주세요");
				continue;
			}
			Item item = temp.get(index);

			System.out.println("아이템을 판매하시겠습니까?[Y/N]");
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
