package model.actions.inputBonus;

import model.GameState;
import model.bonusable.PermissionCard;
import model.changes.ChangeMsg;
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
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(index>1){
			gameState.notifyObserver(player, new ChangeMsg("You have to choose 0 or 1 as the index of permission card to buy"));
			return false;
		}
		
		return true;
	}

}
