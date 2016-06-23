package model.bonusItem;

import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class BonusAgainPermission implements BonusInputItem {

	@Override
	public void giveBonus(Player player, GameState gameState) {
		
		if(player.getPermissionHand().isEmpty()){
			gameState.notifyObserver(player, new ChangeMsg("You got a bonus permission gift, but you haven't any permission cards in your hand, sorry"));
		}
		
		else{
			player.getBonusInputs().add(this);
			gameState.notifyObserver(player, new ChangeMsg("Congratulations, you can get bonuses of a permission card you already have"));
		}
	}
}
