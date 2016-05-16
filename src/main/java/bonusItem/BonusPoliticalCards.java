package bonusItem;
import player.Player;
import gameState.GameState;

public class BonusPoliticalCards implements BonusItem {
	
	public void giveBonus(Player player, GameState gameState){
		player.getPoliticalHand().drawCard(gameState.getPoliticalDeck());
	}
}
