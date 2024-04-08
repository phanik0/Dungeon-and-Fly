package dnf;

import java.io.IOException;
import java.util.Vector;

public class StageSetting extends Stage {
	FileData fileData;
	@Override
	public boolean update() {
		int sel = GameManager.scan.nextInt();
		if(sel == 1) {
	        try {
	          fileData.saveData();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	      else if(sel == 2) {
	        try {
				fileData.loadData();
			} catch (Exception e) {
				// TODO: handle exception
			}
	      }
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 fileData = new FileData();
	}

}