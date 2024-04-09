package dnf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class GameManager {
	private Random ran = new Random();
	protected static Scanner scan = new Scanner(System.in);
	public static ArrayList<Player> playerList;
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	private UnitManager manager;
	private Inventory inven;
	protected static String nextStage = "";
	private String curStage = "";
	public GameManager() {
		
		stageList.put("SETTING", new StageSetting());
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("����� ���� ��������", new StageAstaros());
		stageList.put("�ĸ��� ���", new StageCommonMonsterBattle());
		stageList.put("ħ���� ��", new StageCommonMonsterBattle());
		stageList.put("������ ����", new StageKhazan());
		stageList.put("ȥ���� ����", new StageBoss());

		nextStage = "TITLE";
		inven = new Inventory();
		manager = new UnitManager();
		playerList = UnitManager.playerList;

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