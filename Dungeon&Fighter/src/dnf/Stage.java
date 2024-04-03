package dnf;
public abstract class Stage {
	private boolean isClear;
	
	public Stage() {
		isClear = false;
	}
	public boolean getIsClear() {
		return isClear;
	}
	public void setIsClear(boolean isClear) {
		this.isClear = isClear;
	}
	public abstract boolean update();

	public abstract void init();
}