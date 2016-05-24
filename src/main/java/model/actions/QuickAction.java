package model.actions;

import model.GameState;
import model.player.Player;

public abstract class QuickAction implements GeneralAction {

	/**
	 * create the normal quick action
	 */
	public QuickAction(){
		
	}
	
	/**
	 * create the addictional action
	 * @param action can't be null
	 */
	public QuickAction(MainAction action) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		
	}

}
