package bonusItem;
import player.Player;

public class BonusAssistants implements BonusItem {
	private final Integer items;
	
	public BonusAssistants(Integer items) {
		this.items = items;
	}

	public void giveBonus(Player player){
		player.getAssistants().add(items);
	}
}
