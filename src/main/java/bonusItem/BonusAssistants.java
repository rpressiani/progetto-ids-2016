package bonusItem;
import player.Player;

public class BonusAssistants extends BonusItem {
	private Integer items;
	
	public void giveBonus(Player player){
		player.getAssistants().add(items);
	}
}
