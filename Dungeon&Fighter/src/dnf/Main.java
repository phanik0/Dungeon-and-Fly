package dnf;

public class Main {
	public static void main(String[] args) {
		 GameManager gameManager = new GameManager();
		    boolean run = true;
		    while (true) {
		      run = gameManager.changeStage();
		      if (run == false) {
		        break;
		      }
		    }
		    System.out.println("게임오버");
		    //길드원 추가할때 능력치 랜덤으로주기
		    // 스킬추가
		    // 어택게이지 차면 스킬 쓸수있음
	}
}
