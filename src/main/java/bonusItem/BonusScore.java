package bonusItem;
import player.Player;

public class BonusScore extends BonusItem {
	private Integer items;
	
	public void giveBonus(Player player){
		player.getScore().add(items);
	}
}
