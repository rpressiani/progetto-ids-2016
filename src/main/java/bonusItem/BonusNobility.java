package bonusItem;
import player.Player;

public class BonusNobility implements BonusItem {
	
	private final int items;
	
	public BonusNobility(int items){
		this.items=items;
	}
	
	public void giveBonus(Player player){
		player.getNobilityLevel().add(items);
	}
}
