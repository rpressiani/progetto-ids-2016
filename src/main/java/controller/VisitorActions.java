package controller;

import java.util.ArrayList;
import java.util.List;

import dto.actions.DTONullAction;
import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.main.DTOMainAction;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOChangePermissionCards;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import model.GameState;
import model.actions.NullAction;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.BuildEmporiumWithKing;
import model.actions.main.BuyPermissionCard;
import model.actions.main.ElectCounsellor;
import model.actions.main.MainAction;
import model.actions.quick.AddictionalAction;
import model.actions.quick.ChangePermissionCards;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.actions.quick.HireAssistant;
import model.bonusable.PermissionCard;
import model.map.City;
import model.map.Region;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;
import utilities.Color;

public class VisitorActions {
	
	private GameState gameState;
	
	public VisitorActions(GameState gameState){
		this.gameState = gameState;
	}
	
	public BuyPermissionCard visit(DTOBuyPermissionCard DTOAction, Player player){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		ArrayList<Integer> structure=DTOAction.getProposal().getStructure();
		PoliticalContainer proposal=new PoliticalContainer(gameState.getParser(), structure);
		
		return new BuyPermissionCard(region, proposal, DTOAction.getIndex());
	}
	
	public BuildEmporiumWithKing visit(DTOBuildEmporiumWithKing DTOAction, Player player){
		ArrayList<Integer> structure=DTOAction.getProposal().getStructure();
		PoliticalContainer proposal=new PoliticalContainer(gameState.getParser(), structure);
		City city=gameState.getMap().getAllCitiesHashMap().get(DTOAction.getCity().getName());
		
		return new BuildEmporiumWithKing(proposal, city);
	}
	
	public BuildEmporiumWithCard visit(DTOBuildEmporiumWithCard DTOAction, Player player){
		int idCard=DTOAction.getPermissionCard().getIdCard();
		String cityName=DTOAction.getCity().getName();
		PermissionCard card=null;
		List<PermissionCard> list= new ArrayList<PermissionCard>(player.getPermissionHand());
		
		for(int i=0; i<list.size(); i++){
			if(idCard==list.get(i).getIdCard()) card=list.get(i);
		}
		
		return new BuildEmporiumWithCard(card, gameState.getMap().getAllCitiesHashMap().get(cityName));
	}
	
	public ElectCounsellor visit(DTOElectCounsellor DTOAction){
		String regionString=DTOAction.getRegion().getName();
		String colorString=DTOAction.getColor().getColorString();
		
		Region region = gameState.getMap().getRegions().get(regionString);
		Color color = new Color(colorString);
		
		return new ElectCounsellor(region, color);
	}
	
	public AddictionalAction visit(DTOAddictionalAction DTOAction, Player player){
		DTOMainAction action=DTOAction.getAction();
		MainAction realAction=null;
		
		if(action instanceof DTOBuildEmporiumWithCard) realAction=visit((DTOBuildEmporiumWithCard) action, player);
		if(action instanceof DTOBuildEmporiumWithKing) realAction=visit((DTOBuildEmporiumWithKing) action, player);
		if(action instanceof DTOBuyPermissionCard) realAction=visit((DTOBuyPermissionCard) action, player);
		if(action instanceof DTOElectCounsellor) realAction=visit((DTOElectCounsellor) action);
		
		return new AddictionalAction(realAction);
	}
	
	public ChangePermissionCards visit(DTOChangePermissionCards DTOAction){
		String regionString=DTOAction.getRegion().getName();
		return new ChangePermissionCards(gameState.getMap().getRegions().get(regionString));
		
	}
	
	public ElectCounsellorWithAssistant visit(DTOElectCounsellorWithAssistant DTOAction){
		String regionString=DTOAction.getRegion().getName();
		String colorString=DTOAction.getColor().getColorString();
		
		Region region = gameState.getMap().getRegions().get(regionString);
		Color color = new Color(colorString);
		
		return new ElectCounsellorWithAssistant(region, color);
	}
	
	public HireAssistant visit(DTOHireAssistant DTOAction){
		return new HireAssistant();
	}
	
	public NullAction visit(DTONullAction DTOAction){
		return new NullAction();
	}
}


