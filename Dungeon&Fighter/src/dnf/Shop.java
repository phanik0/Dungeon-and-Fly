package dnf;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	public ArrayList<Item>weapon= new ArrayList<>();
	public ArrayList<Item>armor= new ArrayList<>();
	public ArrayList<Item>accessory= new ArrayList<>();
	public Shop() {
		 weapon.add(new Item(Item.WEAPON,10,"���� ���ڰ�"));//����
		 weapon.add(new Item(Item.WEAPON,10,"�콼 û����"));//����
		 weapon.add(new Item(Item.WEAPON,10,"�콼 ������"));//����
		 weapon.add(new Item(Item.WEAPON,10,"���� ���ڰ�"));//����
		 armor.add(new Item(Item.WEAPON,"���� ��������",15));//����
		 accessory.add(new Item(Item.ACCESSORY,"���� ���ڰ�",5,8));//����
		  
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
		printShop();
		int sel = inputNumber("�޴��� �������ּ���");
		if(sel == Item.WEAPON) {
			
		}
		else if(sel == Item.ARMOR) {
			
		}
		else if(sel == Item.ACCESSORY) {
			
		}
	}
	private void printShop() {
		System.out.println("[1. ���� ]");
		System.out.println("[2. �� ]");
		System.out.println("[3. �Ǽ����� ]");
	}
	private void printWeaponList() {
		
	}
	private void printWeaponMenu() {
		
	}
}
