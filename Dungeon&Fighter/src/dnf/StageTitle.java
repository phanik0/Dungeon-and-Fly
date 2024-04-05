package dnf;

public class StageTitle extends Stage {
	private UnitManager manager = new UnitManager();

	@Override
	public boolean update() {
		System.out.println("==== Dungeon&Fighter ====");
		System.out.println("Press Any Button");
		String start = GameManager.scan.next();
		
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		manager.init();

	}

}