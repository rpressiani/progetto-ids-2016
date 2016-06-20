package model.bonusable;

import java.util.ArrayList;
import java.util.Iterator;

import model.GameState;
import model.bonusItem.BonusItem;
import model.player.Player;

public abstract class Bonusable {
	private final ArrayList<BonusItem> bonuses;
	
	/**
	 * create the set of bonuses for a bonusable object
	 * @param bonuses can't be null
	 * @throws NullPointerException if bonuses is null
	 */
	public Bonusable(ArrayList<BonusItem> bonuses) {
		if(bonuses==null) {
			throw new NullPointerException("bonuses should not be null"); 
		}
		this.bonuses = bonuses;
	}
	
	/**
	 * check all bonuses to give to the player
	 * @param player can't be null
	 * @param gameState can't be null
	 * @throws NullPointerException if player is null
	 * @throws NullPointerException if gameState is null
	 */
	public void assignBonuses(Player player, GameState gameState){
		if(player==null) {
			throw new NullPointerException("player should not be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState should not be null"); 
		}
		
		Iterator<BonusItem> itr=bonuses.iterator();
		while(itr.hasNext()){
			itr.next().giveBonus(player, gameState);
		}
	}
	
	/**
	 * @return the bonuses
	 */
	public ArrayList<BonusItem> getBonuses() {
		return bonuses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bonusable [bonuses=" + bonuses + "]";
	}
	
}
