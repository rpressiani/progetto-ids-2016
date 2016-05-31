package controller;

import client.ClientMessage;
import dto.actions.DTOAction;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.quick.DTOHireAssistant;
import model.GameState;
import model.player.Player;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<ClientMessage> {
	
	static DTOAction action1=new DTOBuyPermissionCard();
	static DTOAction action2=new DTOHireAssistant();
	
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