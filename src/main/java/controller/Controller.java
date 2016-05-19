package controller;

import actions.GeneralAction;
import gameState.GameState;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<GeneralAction> {
	
	private final GameState game; 
	
	public Controller(GameState game) {
		this.game = game; 
	}

	@Override
	public void update(GeneralAction action) {
		Observer.super.update(action);
		//should I do a check with acceptMove? 
		action.doAction(game.getCurrentPlayer(), game);
	}
	

}
