package dnf;

public class MonsterKhazan extends Monster{
	public MonsterKhazan() {
		super("소멸의신 카잔",5000,100,40);

	}

	void skill() {
		System.out.println("적 전체에게 공격력의 절반 데미지 ");

	}
}
