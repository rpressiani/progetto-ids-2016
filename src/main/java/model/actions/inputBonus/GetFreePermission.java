package model.actions.inputBonus;

import model.GameState;
import model.bonusItem.BonusFreePermission;
import model.bonusable.PermissionCard;
import model.changes.ChangeGetFreePermission;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.map.Region;
import model.player.Player;

public class GetFreePermission implements InputBonusAction {

	private Region region;
	private int index;
	
	public GetFreePermission(Region region, int index) {
		this.region=region;
		this.index=index;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		PermissionCard drawedCard;
		
		drawedCard=region.getPermissionDeck().drawCard(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards(), index);
		drawedCard.assignBonuses(player, gameState);
		player.getPermissionHand().add(drawedCard);
		
		player.getBonusInputs().remove(0);
		
		gameState.notifyObserver(player, new ChangeGetFreePermission(region, drawedCard));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(!(player.getBonusInputs().get(0) instanceof BonusFreePermission)){
			gameState.notifyObserver(player, new ChangeMsg("You can't choose now a free permission card to get"));
			return false;
		}
		
		if(index>1){
			gameState.notifyObserver(player, new ChangeMsg("You have to choose 0 or 1 as the index of permission card to get"));
			return false;
		}
		
		return true;
	}

}
