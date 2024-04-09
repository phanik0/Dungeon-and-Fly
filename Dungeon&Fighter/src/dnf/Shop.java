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
		cross.add(new Item(Item.CROSS, 10, "나무 십자가", 1000));// 무기
		cross.add(new Item(Item.CROSS, 10, "청동십자가", 1200));// 무기
			
		sword.add(new Item(Item.SWORD, 10, "녹슨 청동검", 800));// 무기
		sword.add(new Item(Item.SWORD, 10, "빛이 바랜 광검", 800));// 무기

		knuckle.add(new Item(Item.KNUCKLE, 10, "낡은 가죽 너클", 700));// 무기
		knuckle.add(new Item(Item.KNUCKLE, 10, "녹슨 너클", 700));// 무기
		
		boxingGlove.add(new Item(Item.BOXING_GLOVE, 10, "견습 글러브", 700));// 무기
		boxingGlove.add(new Item(Item.BOXING_GLOVE, 10, "헤진 글러브", 700));// 무기
		
		gun.add(new Item(Item.GUN, 10, "낡은 리볼버", 800));// 무기
		gun.add(new Item(Item.GUN, 10, "낡은 자동권총", 800));// 무기
		gun.add(new Item(Item.GUN, 10, "낡은 머스켓", 800));// 무기

		armor.add(new Item(Item.ARMOR, "낡은 가죽자켓", 15, 500));// 무기
	
		accessory.add(new Item(Item.ACCESSORY, "풀꽃반지", 5, 8, 600));// 무기
	
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
			System.err.println("숫자만 입력해주세요");
		}
		return number;
	}

	public void shopManager() {
		while (true) {
			printShop();
			int sel = inputNumber("메뉴를 선택해주세요");
			if (sel == 0) {
				return;
			}

			int index = -1;
			if (sel != Item.WEAPON) {
				printItemList(sel);
				index = inputNumber("구매할 아이템을 선택해주세요") - 1;
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
		System.out.println("[1. 무기 ]");
		System.out.println("[2. 방어구 ]");
		System.out.println("[3. 악세서리 ]");
		System.out.println("[0. 뒤로가기]");
	}

	private void printWeaponMenu() {
		System.out.println("[1. 리볼버 ]");
		System.out.println("[2. 십자가 ]");
		System.out.println("[3. 검 ]");
		System.out.println("[4. 너클 ]");
		System.out.println("[5. 권투글러브 ]");
		System.out.println("[0. 뒤로가기]");

	}

	private void runWeaponMenu() {
		while (true) {
			printWeaponMenu();
			int sel = inputNumber("무기 종류를 골라주세요");
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
			int index = inputNumber("구매할 아이템을 선택해주세요 [0. 뒤로가기]") - 1;
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
		System.out.println("[0. 뒤로가기");
	}

	private void addItem(int sel, Item item) {
		if (item.getPrice() > Inventory.gold) {
			System.err.println("골드가 부족합니다");
			return;
		}
		if(sel == 2)
			Inventory.myArmor.add(item);
		else if(sel == 3)
			Inventory.myAccessory.add(item);
		Inventory.gold -= item.getPrice();
        System.out.println("[" + item.getName()+ "] 을 구입했습니다.");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
	}

}
