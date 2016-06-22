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
		PermissionCard drawedCard=region.getPermissionDeck().drawCard(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards(), index);
		
		player.getBonusInputs().remove(0);
		player.setBonusChosed(true);

		player.getPermissionHand().add(drawedCard);
		
		gameState.notifyObserver(player, new ChangeGetFreePermission(region, drawedCard));
		drawedCard.assignBonuses(player, gameState);
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
		gameState.getNobility().checkNobility(player, gameState);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(!(player.getBonusInputs().get(0) instanceof BonusFreePermission)){
			gameState.notifyObserver(player, new ChangeMsg("It's not time to choose a free permission card to get"));
			return false;
		}
		
		if(region==null){
			gameState.notifyObserver(player, new ChangeMsg("The region you selected doesn't exist"));
			return false;
		}
		
		if(index>1){
			gameState.notifyObserver(player, new ChangeMsg("You have to choose 0 or 1 as the index of permission card to get"));
			return false;
		}
		
		return true;
	}

}
