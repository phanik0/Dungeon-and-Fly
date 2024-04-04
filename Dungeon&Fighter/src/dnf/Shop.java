package dnf;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	public ArrayList<Item>weapon= new ArrayList<>();
	public ArrayList<Item>armor= new ArrayList<>();
	public ArrayList<Item>accessory= new ArrayList<>();
	public Shop() {
		 weapon.add(new Item(Item.WEAPON,10,"나무 십자가"));//무기
		 weapon.add(new Item(Item.WEAPON,10,"녹슨 청동검"));//무기
		 weapon.add(new Item(Item.WEAPON,10,"녹슨 리볼버"));//무기
		 weapon.add(new Item(Item.WEAPON,10,"나무 십자가"));//무기
		 armor.add(new Item(Item.WEAPON,"낡은 가죽자켓",15));//무기
		 accessory.add(new Item(Item.ACCESSORY,"나무 십자가",5,8));//무기
		  
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
		printShop();
		int sel = inputNumber("메뉴를 선택해주세요");
		if(sel == Item.WEAPON) {
			
		}
		else if(sel == Item.ARMOR) {
			
		}
		else if(sel == Item.ACCESSORY) {
			
		}
	}
	private void printShop() {
		System.out.println("[1. 무기 ]");
		System.out.println("[2. 방어구 ]");
		System.out.println("[3. 악세서리 ]");
	}
	private void printWeaponList() {
		
	}
	private void printWeaponMenu() {
		
	}
}
