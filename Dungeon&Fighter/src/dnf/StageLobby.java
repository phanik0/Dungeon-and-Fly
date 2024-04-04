package dnf;

public class StageLobby extends Stage {
	@Override
	public boolean update() {
		printDungeon();
		selectDungeon();
		return false;
	}
	private void printDungeon() {
		System.out.println("=====[Dungeon]=====");
		if(!StageCommonMonsterBattle.dooms)
		System.out.println("[1.파멸의 길목]");
		else	
		System.out.println("[1.파멸의 길목](clear)");
		if(!StageCommonMonsterBattle.silence)
			System.out.println("[2.침묵의 숲]");
		else
			System.out.println("[2.침묵의 숲](clear)");
		if(!StageKhazan.isKhazanClear) 
		System.out.println("[3.공포의 대지]");
		else 
			System.out.println("[3.공포의 대지](clear)");
		if(!StageAstaros.isAstarosClear) 
		System.out.println("[4.비극의 도시 엘레리논]");
		else
			System.out.println("[4.비극의 도시 엘레리논](clear)");
		System.out.println("[5.혼돈의 왕좌]");
	}
	private void selectDungeon() {
		while(true) {
			int sel = GameManager.scan.nextInt();
			if (sel == 1 ) {
				if(!StageCommonMonsterBattle.dooms) {
				GameManager.nextStage = "파멸의 길목";
				StageCommonMonsterBattle.name =1;
				break;
				}
				else {
					System.err.println("이미 클리어한 던전은 입장하실 수 없습니다");
				}
			} else if (sel == 2) {
				if(!StageCommonMonsterBattle.silence) {
				GameManager.nextStage = "침묵의 숲";
				StageCommonMonsterBattle.name =2;
				break;
				}else {
					System.err.println("이미 클리어한 던전은 입장하실 수 없습니다");
				}
			} else if(sel == 3 ){
				if(StageSetting.stageClearCount>=2) {
				GameManager.nextStage = "공포의 대지";
				break;
				}
				else if(StageKhazan.isKhazanClear) {
					System.out.println("이미 클리어한 던전은 입장하실 수 없습니다");
				}
				else
					System.err.println("파멸의 길목과 침묵의 숲을 모두 클리어해야 입장할수 있습니다");
			} else if(sel == 4 ){
				if(StageKhazan.isKhazanClear) {
				GameManager.nextStage = "비극의 도시 엘레리논";
				break;
				}
				else if(StageAstaros.isAstarosClear) {
					System.out.println("이미 클리어한 던전은 입장하실 수 없습니다");
				}
				else
					System.err.println("공포의 대지를 클리어해야 입장하실 수 있습니다");
			} else if(sel == 5 ){
				if(StageAstaros.isAstarosClear) {
				GameManager.nextStage = "혼돈의 왕자";
				break;
				}
				else 
					System.err.println("비극의 도시 엘레리논을 클리어해야 입장하실 수 있습니다");
			}
			}
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}