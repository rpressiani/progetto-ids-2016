package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusPoliticalCards implements BonusItem {
	
	public void giveBonus(Player player, GameState gameState){
		player.getPoliticalHand().drawCard(gameState.getPoliticalDeck());
	}
}
