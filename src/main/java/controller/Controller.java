package controller;

import client.socket.ClientMessage;
import dto.actions.DTOAction;
import model.GameState;
import model.player.Player;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<ClientMessage> {
	private final GameState gameState;
	private final VisitorActions visitor;
	
	/**
	 * @param gameState
	 * @throws NullPointerException if gameState is null
	 */
	public Controller(GameState gameState) {
		if(gameState==null) {
			throw new NullPointerException("game should not be null"); 
		}
		
		this.gameState = gameState;
		this.visitor = new VisitorActions(gameState);
	}
	
	@Override
	public void update(ClientMessage msg){
		Observer.super.update(msg);
		
		
		System.out.println("action received1");
		if (msg.getMessage() instanceof DTOAction) {
			System.out.println("action received2");
			DTOAction action = (DTOAction) msg.getMessage();
			Player player = msg.getPlayer();
			player.move(action.accept(this.visitor, msg.getPlayer()), this.gameState);	
		}
		
	}
}