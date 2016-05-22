package controller;

import model.GameState;
import model.actions.GeneralAction;
import model.actions.MainAction;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.player.Player;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<GeneralAction> {
	
	private final GameState game; 
	
	public Controller(GameState game) {
		this.game = game; 
	}

//	@Override
//	public void update(GeneralAction action) {
//		Observer.super.update(action);
//		//should I do a check with acceptMove? 
//		action.doAction(game.getCurrentPlayer(), game);
////		System.out.println(action);
//	}
	
	public void update(Player player, GeneralAction action){
		Observer.super.update(action);
		
		if (action instanceof MainAction) {
			MainAction mainAction = (MainAction) action;
			player.move(mainAction, game);
		}
		
		if (action instanceof QuickAction) {
			QuickAction quickAction = (QuickAction) action;
			player.move(quickAction, game);
		}
		
		if (action instanceof NullAction) {
			NullAction nullAction = (NullAction) action;
			player.move(nullAction, game);
		}
	}
	

}
