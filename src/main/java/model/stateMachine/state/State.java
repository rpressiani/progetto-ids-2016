package model.stateMachine.state;

import model.GameState;
import model.actions.NullAction;
import model.actions.main.MainAction;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.QuickAction;
import model.player.Player;

public interface State {
	
	/**
	 * @param player current
	 * @param action mainAction to do
	 * @param gameState current game
	 * @throws NullPointerException if one(of more) of the parameters are null
	 */
	public default void transition(Player player, MainAction action, GameState gameState) {
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true) System.out.println(player.getNickname()+" You can't do a MainAction now");
	}
	
	/**
	 * @param player
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if one(of more) of the parameters are null
	 */
	public default void transition(Player player, QuickAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true) System.out.println(player.getNickname()+" You can't do a QuickAction now"); 
	}
	
	/**
	 * @param player
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if one(of more) of the parameters are null
	 */
	public default void transition(Player player, NullAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true) System.out.println(player.getNickname()+" You can't do a NullAction now");
	}
	
	/**
	 * @param player
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if one(of more) of the parameters are null
	 */
	public default void transition(Player player, SellAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true) System.out.println(player.getNickname()+" You can't sell items now");
	}
	
	/**
	 * @param player
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if one(of more) of the parameters are null
	 */
	public default void transition(Player player, BuyAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true) System.out.println(player.getNickname()+" You can't buy items now");
		//player.setState(this);
	}
	
	public default void checkTurn(Player player, GameState gameState){
		
	}
	
	public void printOut(Player player, State state);
}
