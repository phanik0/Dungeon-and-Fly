package dnf;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int ACCESSORY = 3;
	private String name;
	private int kind;
	private int damage;
	private int def;
	public Item(int kind, String name,  int def) {//방어구
		this.kind = kind;
		this.name = name;
		this.def = def;
	}
	public Item(int kind, int damage, String name) {//무기
		this.kind= kind;
		this.name = name;
		this.damage = damage;
	}
	public Item(int kind, String name, int damage, int def) {//장신구
		this.kind = kind;
		this.name = name;
		this.def = def;
		this.damage = damage;
	}
}
