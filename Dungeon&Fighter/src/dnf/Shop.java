package dnf;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	public ArrayList<Item> weapon = new ArrayList<>();
	public ArrayList<Item> armor = new ArrayList<>();
	public ArrayList<Item> accessory = new ArrayList<>();

	public Shop() {
		weapon.add(new Item(Item.WEAPON, 10, "나무 십자가", 1000));// 무기
		weapon.add(new Item(Item.WEAPON, 10, "녹슨 청동검", 800));// 무기
		weapon.add(new Item(Item.WEAPON, 10, "녹슨 리볼버", 700));// 무기
		weapon.add(new Item(Item.WEAPON, 10, "나무 십자가", 2500));// 무기
		armor.add(new Item(Item.ARMOR, "낡은 가죽자켓", 15, 500));// 무기
		accessory.add(new Item(Item.ACCESSORY, "나무 십자가", 5, 8, 600));// 무기

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

	public void shopManager() {
		while (true) {
			printShop();
			int sel = inputNumber("메뉴를 선택해주세요");
			while (true) {
				printItemList(sel);
				Item item = null;
				int index = inputNumber("구매할 아이템을 선택해주세요") - 1;
				if (sel == Item.WEAPON) {
					item = weapon.get(index);
				} else if (sel == Item.ARMOR) {
					item = armor.get(index);

				} else if (sel == Item.ACCESSORY) {
					item = accessory.get(index);
				}
				if (item.getPrice() > Inventory.gold) {
					System.err.println("골드가 부족합니다");
					return;
				}
				Inventory.myWeapon.add(item);
			}
		}
	}

	private void printShop() {
		System.out.println("[1. 무기 ]");
		System.out.println("[2. 방어구 ]");
		System.out.println("[3. 악세서리 ]");
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
