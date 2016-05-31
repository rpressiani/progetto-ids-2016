package controller;

import client.ClientMessage;
import dto.actions.DTOAction;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.quick.DTOHireAssistant;
import model.GameState;
import model.actions.GeneralAction;
import model.actions.NullAction;
import model.actions.main.MainAction;
import model.actions.quick.QuickAction;
import model.player.Player;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<ClientMessage> {
	
	static DTOAction action1=new DTOBuyPermissionCard();
	static DTOAction action2=new DTOHireAssistant();
	
	private final GameState game;
	private final VisitorActions visitor;
	
	public Controller(GameState game) {
		if(game==null) {
			throw new NullPointerException("game should not be null"); 
		}
		
		this.game = game;
		this.visitor = new VisitorActions(game);
	}
	
	@Override
	public void update(ClientMessage msg){
		Observer.super.update(msg);
		
		if (msg.getMessage() instanceof DTOAction) {
			DTOAction action = (DTOAction) msg.getMessage();
			Player player = msg.getPlayer();
			player.move(action.accept(this.visitor, msg.getPlayer()), this.game);
			
		}
		
	}
}