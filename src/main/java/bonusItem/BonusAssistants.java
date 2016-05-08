package bonusItem;
import player.Player;

public class BonusAssistants implements BonusItem {
	private final int items;
	
	public BonusAssistants(int items) {
		this.items = items;
	}

	public void giveBonus(Player player){
		player.getAssistants().add(items);
	}
}
