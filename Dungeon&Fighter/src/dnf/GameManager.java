package dnf;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	private Random ran = new Random();
	protected static Scanner scan = new Scanner(System.in);
	protected static String nextStage = "";
	private String curStage = "";
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	private StageSetting set;
	public GameManager() {
		
		stageList.put("SETTING", new StageSetting());
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("ºñ±ØÀÇ µµ½Ã ¿¤·¹¸®³í", new StageAstaros());
		stageList.put("ÆÄ¸êÀÇ ±æ¸ñ", new StageCommonMonsterBattle());
		stageList.put("Ä§¹¬ÀÇ ½£", new StageCommonMonsterBattle());
		stageList.put("°øÆ÷ÀÇ ´ëÁö", new StageKhazan());
		stageList.put("È¥µ·ÀÇ ¿ÕÀÚ", new StageBoss());

		nextStage = "TITLE";
		set = new StageSetting();
		set.init();
	}
	
	public boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);

		if (curStage.equals(nextStage))
			return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false)
				break;
		}

		if (nextStage.equals(""))
			return false;
		else
			return true;
	}

}