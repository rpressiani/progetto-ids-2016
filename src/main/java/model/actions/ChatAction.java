package model.actions;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		gameState.notifyObserver(new ChangeMsg("[CHAT] "+hour+":"+minute+":"+second+" "+player.getNickname()+": "+msg));
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
