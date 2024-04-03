package dnf;

public class UnitKhazan extends Unit{
	public UnitKhazan() {
		name = "카잔";
		maxhp = 3000;
		curhp = maxhp;
		power = 100;
	}

	void skill() {
		System.out.println("적 전체에게 공격력의 절반 데미지 ");

	}
}
