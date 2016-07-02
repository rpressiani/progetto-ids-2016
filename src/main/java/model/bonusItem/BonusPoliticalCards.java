package model.bonusItem;
import model.GameState;
import model.changes.ChangeMsg;
import model.player.Player;

public class BonusPoliticalCards implements BonusItem {
	private final int timesToDraw;
	
	/**
	 * set the number of cards to draw
	 * @param timesToDraw can't be <=0
	 * @throws IllegalArgumentException if timesToDraw <=0
	 */
	public BonusPoliticalCards(int timesToDraw) {
		if(timesToDraw<=0) {
			throw new IllegalArgumentException("timesToDraw must be greater than zero"); 
		}
		this.timesToDraw = timesToDraw;
	}

	@Override
	public void giveBonus(Player player, GameState gameState){
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		int n=timesToDraw;
		
		for(int i=0; i<n; i++){
			player.getPoliticalHand().drawCard(gameState.getPoliticalDeck());
		}
		
		gameState.notifyObserver(player, new ChangeMsg("You drawed "+n+" bonus political cards"));
	}
	
	@Override
	public int getQuantity(){
		return this.timesToDraw;
	}
}
