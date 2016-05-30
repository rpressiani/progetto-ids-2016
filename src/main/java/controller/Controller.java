package controller;

import client.ClientMessage;
import dto.actions.DTOAction;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.quick.DTOHireAssistant;
import model.GameState;
import model.actions.GeneralAction;
import model.actions.MainAction;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.player.Player;
import observer.Observer;
//import player.Player;

public class Controller implements Observer<ClientMessage> {
	
	static DTOAction action1=new DTOBuyPermissionCard();
	static DTOAction action2=new DTOHireAssistant();
	
	private final GameState game; 
	
	public Controller(GameState game) {
		if(game==null) {
			throw new NullPointerException("game should not be null"); 
		}
		this.game = game; 
	}
	
	@Override
	public void update(ClientMessage msg){
		Observer.super.update(msg);
		
		if (msg.getMessage() instanceof GeneralAction) {
			
			GeneralAction action = (GeneralAction) msg.getMessage();
			Player player = (Player) msg.getPlayer();
			
			if (action instanceof MainAction) {
				MainAction mainAction = (MainAction) action;
				player.move(mainAction, game);
			}
			
			if (action instanceof QuickAction) {
				QuickAction quickAction = (QuickAction) action;
				player.move(quickAction, game);
			}
			
			if (action instanceof NullAction) {
				NullAction nullAction = (NullAction) action;
				player.move(nullAction, game);
			}
			
		}
		
	}
	
	public static void main(String[] args){
		VisitorActions v=new VisitorActions();
		//action1.accept(v);
		//action2.accept(v);
	}
}
