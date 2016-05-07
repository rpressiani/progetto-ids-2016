package bonusItem;
import player.Player;

public class BonusScore implements BonusItem {
	private final Integer items;
	
	public BonusScore(Integer items) {
		super();
		this.items = items;
	}

	public void giveBonus(Player player){
		player.getScore().add(items);
	}
}
