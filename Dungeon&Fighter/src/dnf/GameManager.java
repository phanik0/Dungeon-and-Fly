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

	public GameManager() {

		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("COMMON STAGE", new StageCommonMonsterBattle());
		stageList.put("ELITE STAGE", new StageZiege());
		stageList.put("COMMON STAGE", new StageCommonMonsterBattle());
		stageList.put("ELITE STAGE", new StageKhazan());
		stageList.put("COMMON STAGE", new StageCommonMonsterBattle());
		stageList.put("BOSS STAGE", new StageBoss());

		nextStage = "TITLE";
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