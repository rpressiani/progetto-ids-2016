package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusPoliticalCards implements BonusItem {
	private final int timesToDraw;
	
	/**
	 * set the number of cards to draw
	 * @param timesToDraw can't be <=0
	 */
	public BonusPoliticalCards(int timesToDraw) {
		this.timesToDraw = timesToDraw;
	}

	@Override
	public void giveBonus(Player player, GameState gameState){
		int n=timesToDraw;
		
		for(int i=0; i<n; i++){
			player.getPoliticalHand().drawCard(gameState.getPoliticalDeck());
		}
	}
}
