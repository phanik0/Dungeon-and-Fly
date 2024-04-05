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
		cross.add(new Item(Item.CROSS, 10, "나무 십자가", 1000));// 무기
		sword.add(new Item(Item.SWORD, 10, "녹슨 청동검", 800));// 무기
		knuckle.add(new Item(Item.GUN, 10, "녹슨 리볼버", 700));// 무기
		gun.add(new Item(Item.CROSS, 10, "나무 십자가", 2500));// 무기
		armor.add(new Item(Item.ARMOR, "낡은 가죽자켓", 15, 500));// 무기
		accessory.add(new Item(Item.ACCESSORY, "나무 십자가", 5, 8, 600));// 무기
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
			System.err.println("숫자만 입력해주세요");
		}
		return number;
	}

	public void shopManager() {
		while (true) {
			printShop();
			int sel = inputNumber("메뉴를 선택해주세요");
			while (true) {
				int index = 0;
				if (sel != Item.WEAPON) {
					printItemList(sel);
					index = inputNumber("구매할 아이템을 선택해주세요") - 1;
				
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
		System.out.println("[1. 무기 ]");
		System.out.println("[2. 방어구 ]");
		System.out.println("[3. 악세서리 ]");
	}

	private void printWeaponMenu() {
		System.out.println("[1. 리볼버 ]");
		System.out.println("[2. 십자가 ]");
		System.out.println("[3. 광검 ]");
		System.out.println("[4. 너클 ]");

	}
	private void runWeaponMenu() {
		
		printWeaponMenu();
		int sel = inputNumber("무기 종류를 골라주세요");
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
		int index = inputNumber("구매할 아이템을 선택해주세요") - 1;
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
			System.err.println("골드가 부족합니다");
			return;
		}
		ArrayList<Item> temp = null;
		temp = sel == Item.ARMOR ? armor : accessory;
		temp.add(item);
	}

}
