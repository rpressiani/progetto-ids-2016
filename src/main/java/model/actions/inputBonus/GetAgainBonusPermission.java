package model.actions.inputBonus;

import model.GameState;
import model.bonusItem.BonusAgainPermission;
import model.bonusable.PermissionCard;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.player.Player;

public class GetAgainBonusPermission implements InputBonusAction {

	private PermissionCard cardChosed;
	
	public GetAgainBonusPermission(PermissionCard cardChosed) {
		if(cardChosed==null) {
			throw new NullPointerException("cardChosed cannot be null"); 
		}
		this.cardChosed=cardChosed;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		player.getBonusInputs().remove(0);
		player.setBonusChosed(true);
		cardChosed.assignBonuses(player, gameState);
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
		gameState.getNobility().checkNobility(player, gameState);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(!(player.getBonusInputs().get(0) instanceof BonusAgainPermission)){
			gameState.notifyObserver(player, new ChangeMsg("It's no time to get again bonuses from one of your permission cards"));
			return false;
		}
		
		if(cardChosed==null){
			gameState.notifyObserver(player, new ChangeMsg("You don't have the permission card you chosed or it doesn't exist"));
			return false;
		}
		
		return true;
	}

}
