package controller;

import model.GameState;

public class StateChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5371049159602584022L;
	private final GameState newState; 
	
	public StateChange(GameState newState) {
		this.newState = newState; 
	}

	@Override
	public String toString() {
		return "StateChange [newState=" + newState + "]";
	}
	

	
}
