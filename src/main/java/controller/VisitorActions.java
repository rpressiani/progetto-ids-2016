package controller;

import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOChangePermissionCards;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.BuildEmporiumWithKing;
import model.actions.main.BuyPermissionCard;
import model.actions.main.ElectCounsellor;
import model.actions.quick.AddictionalAction;
import model.actions.quick.ChangePermissionCards;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.actions.quick.HireAssistant;
import model.bonusable.PermissionCard;
import model.player.Player;

public class VisitorActions {
	
	GameState gameState;
	
	public BuyPermissionCard visit(DTOBuyPermissionCard DTOAction){
		return null;
	}
	
	public BuildEmporiumWithKing visit(DTOBuildEmporiumWithKing DTOAction){
		return null;
	}
	
	public BuildEmporiumWithCard visit(DTOBuildEmporiumWithCard DTOAction, Player player){
		int idCard=DTOAction.getPermissionCard().getIdCard();
		String cityName=DTOAction.getCity().getName();
		
		PermissionCard card;
		
		//return new BuildEmporiumWithCard(cardChosed, cityChosed);
		
		return null;
	}
	
	public ElectCounsellor visit(DTOElectCounsellor DTOAction){
		return null;
	}
	
	public AddictionalAction visit(DTOAddictionalAction DTOAction){
		return null;
	}
	
	public ChangePermissionCards visit(DTOChangePermissionCards DTOAction){
		String regionString=DTOAction.getRegion().getName();
		
		return new ChangePermissionCards(gameState.getMap().getRegions().get(regionString));
	}
	
	public ElectCounsellorWithAssistant visit(DTOElectCounsellorWithAssistant DTOAction){
		String regionString=DTOAction.getRegion().getName();
		String colorString=DTOAction.getColor().getColorString();
		
		//return new ElectCounsellorWithAssistant(region, color);
		return null;
	}
	
	public HireAssistant visit(DTOHireAssistant DTOAction){
		return new HireAssistant();
	}
}


