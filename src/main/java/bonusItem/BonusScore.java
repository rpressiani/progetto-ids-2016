package bonusItem;
import player.Player;

public class BonusScore implements BonusItem {
	private final int items;
	
	public BonusScore(int items) {
		this.items = items;
	}

	public void giveBonus(Player player){
		player.getScore().add(items);
	}
}
