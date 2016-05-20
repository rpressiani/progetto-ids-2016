package controller;

import model.GameState;
import model.actions.GeneralAction;
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
		action.doAction(game.getCurrentPlayer(), game);
	}
	

}
