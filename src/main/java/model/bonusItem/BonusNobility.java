package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusNobility implements BonusItem {
	
	private final int items;
	
	/**
	 * set the bonus of nobility
	 * @param items can't be <=0
	 */
	public BonusNobility(int items){
		this.items=items;
	}
	
	@Override
	public void giveBonus(Player player, GameState gameState){
		player.getNobilityLevel().add(items);
	}
}
