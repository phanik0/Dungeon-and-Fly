package dnf;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	protected static Vector<Player> playerList = new Vector<>();
	public Vector<Monster> monsterList = new Vector<>();
	private String path = "dnf."; // 패키지명 + .
	private String commonMonster[] = { "MonsterHollowZombie", "MonsterImposter", "MonsterPioneers" };
	private Random ran = new Random();
	public Player player = new Player();
	
	public void init() {
		playerList.add(new PlayerStriker("GunB",true));
		playerList.add(new PlayerNenMaster("Earth",true));
		playerList.add(new PlayerSaint("Planet",true));
		playerList.add(new PlayerWeaponMaster("레녹몬차",true));
		
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
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println(mon_list.get(i).name);
		}
	}



}