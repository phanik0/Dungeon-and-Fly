package dnf;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int ACCESSORY = 3;
	private String name;
	private int kind;
	private int damage;
	private int def;
	private int price;

	public Item(int kind, String name, int def, int price) {// 방어구
		this.kind = kind;
		this.name = name;
		this.def = def;
		this.price = price;
	}

	public Item(int kind, int damage, String name, int price) {// 무기
		this.kind = kind;
		this.name = name;
		this.damage = damage;
		this.price = price;

	}

	public Item(int kind, String name, int damage, int def, int price) {// 장신구
		this.kind = kind;
		this.name = name;
		this.def = def;
		this.damage = damage;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		if (this.kind == WEAPON) {
			return String.format("[아이템 :%s][공격력 :%s][가격 : %s  gold]", name, damage, price);
		} else if (this.kind == ARMOR)
			return String.format("[아이템 :%s][방어력: %s][가격: %s  gold]", name, def, price);
		else
			return String.format("[아이템 :%s][공격력: %s ][방어력: %s][가격 :%s  gold]", name, damage, def, price);

	}
}
