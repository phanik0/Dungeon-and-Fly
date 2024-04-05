package dnf;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	protected static Vector<Player> player_list = new Vector<>();
	public Vector<Monster> monster_list = new Vector<>();
	private String path = "dnf."; // 패키지명 + .
	private String commonMonster[] = { "MonsterHollowZombie", "MonsterImposter", "MonsterPioneers" };
	private Random ran = new Random();
	
	
	public void init() {
		player_list.add(new PlayerStriker("GunB",true));
		player_list.add(new PlayerNenMaster("Earth",true));
		player_list.add(new PlayerSaint("Planet",true));
		player_list.add(new PlayerWeaponMaster("레녹몬차",true));
		
	}
	public void setCommonMonster(int size) {
		for (int i = 0; i < size; i++) {
			int num = ran.nextInt(commonMonster.length);
			try {
				Class<?> clazz = Class.forName(path + commonMonster[num]);
				Object obj = clazz.newInstance(); // clazz.newInstance();
				Monster temp = (Monster) obj;
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