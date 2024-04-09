package dnf;

public abstract class Unit {
	private int hp;
	private int maxHp;
	private int damage;
	private int level;
	private int exp;
	private int def;
	private boolean isParty;
	private Item weapon;
	private Item armor;
	private Item accessory;
	private String name;
	private String job;
	private String guildName;
	private String state = "노말";
	
	public Unit() {
	}
	public Unit(String name) {
		this.name = name;
	}
	
	public Unit(String name, int max, int damage,int def,String job) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
		this.def = def;
		this.job = job;
		this.level = 1;
		this.exp = 0;
		isParty = false;
		weapon = null;
		armor = null;
		accessory = null;
	}
	public Unit(String name, int max, int damage,int def,String job,boolean isParty,String guildName) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
		this.def = def;
		this.job = job;
		this.level = 1;
		this.exp = 0;
		this.isParty = isParty;
		this.guildName = guildName;
		weapon = null;
		armor = null;
		accessory = null;
	}
	public Unit(String name, int max, int damage,int def,String job,boolean isParty,String guildName,int level,int exp) {
		this.name = name;
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
		this.def = def;
		this.job = job;
		this.level = level;
		this.exp = exp;
		this.isParty = isParty;
		this.guildName = guildName;
		weapon = null;
		armor = null;
		accessory = null;
	}
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getDamage() {
		return this.damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public boolean getIsParty() {
		return isParty;
	}
	public void setIsParty(boolean isParty) {
		this.isParty = isParty;
	}
	public Item getWeapon() {
		return weapon;
	}
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	public Item getArmor() {
		return armor;
	}
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	public Item getAccessory() {
		return accessory;
	}
	public void setAccessory(Item accessory) {
		this.accessory = accessory;
	}
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGuildName() {
		return guildName;
	}
	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}
	
	public void init(int max, int damage) {
		this.maxHp = max;
		this.hp = max;
		this.damage = damage;
	}

	public void init(String na, int max, int pw) {
		this.name = na;
		this.maxHp = max;
		this.hp = max;
		this.damage = pw;
	}

	public void attack(Monster enemy) {
		int hp = enemy.getHp();
		hp -= damage;
		System.out.println("[" + name + "] 이 " + "[" + enemy.getName() + "] 에게 " + damage + "의 데미지를 입힙니다. ");
//		String attack = String.format(name, null);
		if (hp <= 0) {
			System.out.println("[" + name + "] 을 쳐치했습니다.");
			hp = 0;
		}
		enemy.setHp(hp);
	}
	public abstract void skill(Unit unit);
	
	@Override
	public String toString() {
		if(weapon!= null || armor!= null || accessory != null)
			return String.format("[닉네임: %s][HP : %d/%d][공격력 : %d][방어력 : %d][직업 : %s][lv : %d]",
					name,hp,maxHp,damage,def,job,level);
		return String.format("[닉네임: %s][HP : %d/%d][공격력 : %d][방어력 : %d][직업 : %s][lv : %d]",
				name,hp,maxHp,damage,def,job,level);
	}
	
}
