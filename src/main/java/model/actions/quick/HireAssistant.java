package model.actions.quick;

import model.GameState;
import model.changes.ChangeHireAssistants;
import model.changes.ChangePlayerStatus;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;

public class HireAssistant implements QuickAction {
	
	public HireAssistant(){
		
	}
	
	@Override
	public void doAction(Player player, GameState gameState){
		player.getAssistants().add(1);
		player.getCoins().sub(3);
			
		gameState.notifyObserver(new ChangeHireAssistants(new Assistants(1), new Coins(3)));
		gameState.notifyObserver(new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player.getCoins().getItems()<3) return false;
		
		else return true;
	}
}
