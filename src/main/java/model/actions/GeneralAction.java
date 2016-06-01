package model.actions;

import model.GameState;
import model.player.Player;

public interface GeneralAction {
	
	/**
	 * player does the action
	 * @param player can't be null
	 * @param gameState can't be null
	 */
	public void doAction(Player player, GameState gameState); 
	
	/**
	 * 
	 * @param player can't be null
	 * @param gameState can't be null
	 * @return true if all preConditions for the move are respected
	 */
	public boolean checkCondition(Player player, GameState gameState);
	
	/**
	 * accept the move if the player is the current player
	 * @param player can't be null
	 * @param gameState can't be null
	 * @return true if player can do the move
	 */
	public default boolean acceptMove(Player player, GameState gameState){
		if(gameState.getCurrentPlayer()!=player){
			System.out.println("It's not your turn "+player.getNickname());
			return false;
		}
		
		else return true;
	}
}
