package controller;

import client.ClientMessage;
import dto.actions.DTOAction;
import model.GameState;
import model.player.Player;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<ClientMessage> {
	private final GameState gameState;
	private final VisitorActions visitor;
	
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
		
		if (msg.getMessage() instanceof DTOAction) {
			DTOAction action = (DTOAction) msg.getMessage();
			Player player = msg.getPlayer();
			player.move(action.accept(this.visitor, msg.getPlayer()), this.gameState);	
		}
		
	}
}