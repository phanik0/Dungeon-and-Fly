package dnf;

public class UnitZeig extends Unit{
	UnitZeig() {
		name = "신관 지그";
		maxhp = 3000;
		curhp = maxhp;
		power = 100;
	}

	public void skill() {
		System.out.println("적 전체에게 공격력의 절반 데미지 ");

	}
}
