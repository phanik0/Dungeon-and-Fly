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
		System.out.println("[1.�ĸ��� ���]");
		else	
		System.out.println("[1.�ĸ��� ���](clear)");
		if(!StageCommonMonsterBattle.silence)
			System.out.println("[2.ħ���� ��]");
		else
			System.out.println("[2.ħ���� ��](clear)");
		if(!StageKhazan.isKhazanClear) 
		System.out.println("[3.������ ����]");
		else 
			System.out.println("[3.������ ����](clear)");
		if(!StageAstaros.isAstarosClear) 
		System.out.println("[4.����� ���� ��������]");
		else
			System.out.println("[4.����� ���� ��������](clear)");
		System.out.println("[5.ȥ���� ����]");
	}
	private void selectDungeon() {
		while(true) {
			int sel = GameManager.scan.nextInt();
			if (sel == 1 ) {
				if(!StageCommonMonsterBattle.dooms) {
				GameManager.nextStage = "�ĸ��� ���";
				StageCommonMonsterBattle.name =1;
				break;
				}
				else {
					System.err.println("�̹� Ŭ������ ������ �����Ͻ� �� �����ϴ�");
				}
			} else if (sel == 2) {
				if(!StageCommonMonsterBattle.silence) {
				GameManager.nextStage = "ħ���� ��";
				StageCommonMonsterBattle.name =2;
				break;
				}else {
					System.err.println("�̹� Ŭ������ ������ �����Ͻ� �� �����ϴ�");
				}
			} else if(sel == 3 ){
				if(StageSetting.stageClearCount>=2) {
				GameManager.nextStage = "������ ����";
				break;
				}
				else if(StageKhazan.isKhazanClear) {
					System.out.println("�̹� Ŭ������ ������ �����Ͻ� �� �����ϴ�");
				}
				else
					System.err.println("�ĸ��� ���� ħ���� ���� ��� Ŭ�����ؾ� �����Ҽ� �ֽ��ϴ�");
			} else if(sel == 4 ){
				if(StageKhazan.isKhazanClear) {
				GameManager.nextStage = "����� ���� ��������";
				break;
				}
				else if(StageAstaros.isAstarosClear) {
					System.out.println("�̹� Ŭ������ ������ �����Ͻ� �� �����ϴ�");
				}
				else
					System.err.println("������ ������ Ŭ�����ؾ� �����Ͻ� �� �ֽ��ϴ�");
			} else if(sel == 5 ){
				if(StageAstaros.isAstarosClear) {
				GameManager.nextStage = "ȥ���� ����";
				break;
				}
				else 
					System.err.println("����� ���� ���������� Ŭ�����ؾ� �����Ͻ� �� �ֽ��ϴ�");
			}
			}
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}