package model.bonusItem;
import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class BonusNobility implements BonusItem {
	
	private final int items;
	
	/**
	 * set the bonus of nobility
	 * @param items can't be <=0
	 * @throws IllegalArgumentException if items <=0
	 */
	public BonusNobility(int items){
		if(items<=0) {
			throw new IllegalArgumentException("items must be greater than zero"); 
		}
		this.items=items;
	}
	
	@Override
	public void giveBonus(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		player.getNobilityLevel().add(items);
		gameState.notifyObserver(player, new ChangeMsg("You did "+items+" steps in the nobility route"));
	}
}
