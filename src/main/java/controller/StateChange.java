package controller;

import gameState.GameState;

public class StateChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5371049159602584022L;
	private final GameState newState; 
	
	public StateChange(GameState newState) {
		this.newState = newState; 
	}
	public GameState getNewState() {
		return newState; 
	}
	@Override
	public String toString() {
		return "StateChange [newState=" + newState + "]";
	}
	

	
}
