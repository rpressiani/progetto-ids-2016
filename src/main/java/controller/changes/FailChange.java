package controller.changes;

import model.actions.NullAction;

public class FailChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7310486880687184380L;
	private NullAction failedAction; 
	
	public FailChange(NullAction failedAction) {
		this.failedAction = failedAction; 
	}
	public NullAction getFailedAction() {
		return failedAction; 
	}
	@Override
	public String toString() {
		return "FailChange [failedAction=" + failedAction + "]";
	}
	

}
