package model.actions.inputBonus;

import model.GameState;
import model.bonusable.PermissionCard;
import model.player.Player;

public class GetAgainBonusPermission implements InputBonusAction {

	private PermissionCard cardChosed;
	
	public GetAgainBonusPermission(PermissionCard cardChosed) {
		this.cardChosed=cardChosed;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
		cardChosed.assignBonuses(player, gameState);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		return false;
	}

}
