package model.actions;

import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class ChatAction implements GeneralAction {

	private String msg;
	
	public ChatAction(String msg){
		this.msg=msg;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		gameState.notifyObserver(new ChangeMsg(player.getNickname()+": "+msg));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null");
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
		return true;
	}

}
