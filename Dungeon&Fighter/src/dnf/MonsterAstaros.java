package dnf;

public class MonsterAstaros extends Monster{
	MonsterAstaros() {
		super("아스타로스",3000,100,20);
		
	}

	public void skill() {
		System.out.println("적 전체에게 공격력의 절반 데미지 ");

	}
}
