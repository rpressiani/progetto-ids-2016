package bonusItem;
import player.Player;

public class BonusCoins implements BonusItem {
	private final int items;
		
	public BonusCoins(int items) {
		this.items = items;
	}
	public void giveBonus(Player player){
		player.getCoins().add(items);
	}
	

}
