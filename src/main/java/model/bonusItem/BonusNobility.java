package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusNobility implements BonusItem {
	
	private final int items;
	
	public BonusNobility(int items){
		this.items=items;
	}
	
	public void giveBonus(Player player, GameState gameState){
		player.getNobilityLevel().add(items);
	}
}
