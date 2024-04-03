package dnf;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	public Vector<Player> player_list = new Vector<>();
	public Vector<Unit> monster_list = new Vector<>();
	private String path = "dnf."; // 패키지명 + .
	private String commonMonster[] = { "UnitHollowZombie", "UnitImposter", "UnitPioneers" };
	private Random ran = new Random();

	UnitManager() {
		player_list.add(new PlayerStriker());
		player_list.add(new PlayerNenMaster());
		player_list.add(new PlayerSaint());
		player_list.add(new PlayerWeaponMaster());
	}

	public void setCommonMonster(int size) {
		for (int i = 0; i < size; i++) {
			int num = ran.nextInt(commonMonster.length);
			try {
				Class<?> clazz = Class.forName(path + commonMonster[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int pow = ran.nextInt(10) + 10;
				temp.init(hp, pow);
				monster_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println(mon_list.get(i).name);
		}
	}



}