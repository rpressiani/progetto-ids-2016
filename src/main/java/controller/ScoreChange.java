package controller;

import model.player.Score;

public class ScoreChange extends ItemChange {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5653830861486951144L;
	private Score newScore; 
	
	public ScoreChange(Score newScore) {
		super(newScore); 
	}
}
