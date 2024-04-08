package dnf;

import java.util.ArrayList;

public class Inventory {
public static int gold;
public static ArrayList<Item>myWeapon;
public static ArrayList<Item>myArmor;
public static ArrayList<Item>myAccessory;
public Inventory() {
	gold = 10000;
	myWeapon = new ArrayList<>();
	myArmor= new ArrayList<>();
	myAccessory = new ArrayList<>();
}
public  void inventoryMenu() {
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
}
