package model.stateMachine;

import model.GameState;
import model.actions.ChatAction;
import model.actions.NullAction;
import model.actions.QuitAction;
import model.actions.inputBonus.InputBonusAction;
import model.actions.main.MainAction;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.QuickAction;
import model.changes.ChangeMsg;
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
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" ,you can't do a MainAction now");
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", you can't do a MainAction now"));
		}
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
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" ,you can't do a QuickAction now"); 
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", you can't do a QuickAction now"));
		}
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
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" ,you can't pass the turn now");
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", you can't pass the turn now"));
		}
	}
	
	/**
	 * @param player current
	 * @param action mainAction to do
	 * @param gameState current game
	 * @throws NullPointerException if one(of more) of the parameters are null
	 */
	public default void transition(Player player, InputBonusAction action, GameState gameState) {
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" ,you can't choose a bonus now");
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", you can't choose a bonus now"));
		}
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
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" ,you can't sell items now");
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", you can't sell items now"));
		}
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
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" ,you can't buy items now");
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", you can't buy items now"));
		}
	}
	
	/**
	 * @param player
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if one(or more) of the parameters is null
	 */
	public default void transition(Player player, QuitAction action, GameState gameState){
		if(player==null || gameState==null) throw new NullPointerException("player/gameState cannot be null");
		
		action.doAction(player, gameState);
		System.out.println(player.getNickname()+" has disconnected");
	}
	
	/**
	 * 
	 * @param player
	 * @param action
	 * @param gameState
	 * @throws NullPointerException if one(or more) of the parameters is null
	 */
	public default void transition(Player player, ChatAction action, GameState gameState){
		if(player==null || gameState==null) throw new NullPointerException("player/gameState cannot be null");
		
		action.doAction(player, gameState);
		System.out.println(player.getNickname()+" wrote a message");
	}
	
	public default void checkTurn(Player player, GameState gameState){
		
	}
	
	public default boolean checkFinished(Player player, GameState gameState){
		if(player.getState() instanceof FinishedBuildingState) return true;
		else return false;
	}
}
