package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dto.actions.DTONullAction;
import dto.actions.inputBonus.DTOGetFreePermission;
import dto.actions.inputBonus.DTOGetFreeToken;
import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.main.DTOMainAction;
import dto.actions.market.DTOBuyAction;
import dto.actions.market.DTOSellAction;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOSubstitutePermissionCards;
import dto.map.DTOCity;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import dto.utilities.DTOPermissionCardSelection;
import model.GameState;
import model.actions.NullAction;
import model.actions.inputBonus.GetFreePermission;
import model.actions.inputBonus.GetFreeToken;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.BuildEmporiumWithKing;
import model.actions.main.BuyPermissionCard;
import model.actions.main.ElectCounsellor;
import model.actions.main.MainAction;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.AddictionalAction;
import model.actions.quick.SubstitutePermissionCards;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.actions.quick.HireAssistant;
import model.bonusable.PermissionCard;
import model.map.City;
import model.map.Region;
import model.market.Contract;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;
import utilities.Color;

public class VisitorActions {
	
	private GameState gameState;
	
	/**
	 * @param gameState
	 * @throws NullPointerException if gameState is null
	 */
	public VisitorActions(GameState gameState) {
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
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
		City city=gameState.getMap().getAllCitiesHashMap().get(DTOAction.getCity().getName());
		PermissionCard card=null;
		List<PermissionCard> list= new ArrayList<PermissionCard>(player.getPermissionHand());
		
		for(int i=0; i<list.size(); i++){
			if(idCard==list.get(i).getIdCard()) card=list.get(i);
		}
		
		return new BuildEmporiumWithCard(card, city);
	}
	
	public ElectCounsellor visit(DTOElectCounsellor DTOAction){
		String colorString=DTOAction.getColor().getColorString();
		
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
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
	
	public SubstitutePermissionCards visit(DTOSubstitutePermissionCards DTOAction){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		return new SubstitutePermissionCards(region);	
	}
	
	public ElectCounsellorWithAssistant visit(DTOElectCounsellorWithAssistant DTOAction){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		String colorString=DTOAction.getColor().getColorString();
		
		Color color = new Color(colorString);
		
		return new ElectCounsellorWithAssistant(region, color);
	}
	
	public HireAssistant visit(DTOHireAssistant DTOAction){
		return new HireAssistant();
	}
	
	public NullAction visit(DTONullAction DTOAction){
		return new NullAction();
	}
	
	public SellAction visit(DTOSellAction DTOAction, Player player){
		int sellCoins=DTOAction.getSellCoins();
		int buyCoins=DTOAction.getBuyCoins();
		
		int sellAssistants=DTOAction.getSellAssistants();
		int buyAssistants=DTOAction.getBuyAssistants();
		
		Set<PermissionCard> sellPermissions = new HashSet<PermissionCard>();
		List<PermissionCard> myCards= new ArrayList<PermissionCard>(player.getPermissionHand());
		for(DTOPermissionCardSelection c : DTOAction.getSellPermissions()){
			int idCard=c.getIdCard();
			PermissionCard card=null;
			for(int i=0; i<myCards.size(); i++){
				if(idCard==myCards.get(i).getIdCard()) card=myCards.get(i);
			}
			sellPermissions.add(card);
		}
		
		Set<PermissionCard> buyPermissions = new HashSet<PermissionCard>();
		for(DTOPermissionCardSelection c : DTOAction.getBuyPermissions()){
			int idCard=c.getIdCard();
			PermissionCard card=null;
			for(Player p : gameState.getPlayers()){
				if(p!=player){
					List<PermissionCard> othersCards= new ArrayList<PermissionCard>(player.getPermissionHand());
					for(int i=0; i<othersCards.size(); i++){
						if(idCard==othersCards.get(i).getIdCard()) card=othersCards.get(i);
					}
				}
			}
			buyPermissions.add(card);
		}
		
		ArrayList<Integer> sellPoliticals=DTOAction.getSellPoliticals();
		ArrayList<Integer> buyPoliticals=DTOAction.getBuyPoliticals();
		
		return new SellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, buyCoins, buyAssistants, buyPermissions, buyPoliticals);
	}
	
	public BuyAction visit(DTOBuyAction DTOAction){
		Contract contract=null;
		List<Contract> contractList= new ArrayList<Contract>(gameState.getMarket().getContractSet());
	
		for(int i=0; i<contractList.size(); i++){
			if(DTOAction.getPlayerName().equals(contractList.get(i).getSeller())) contract=contractList.get(i);
		}
		
		return new BuyAction(contract);
	}
	
	public GetFreePermission visit(DTOGetFreePermission DTOAction){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		
		return new GetFreePermission(region, DTOAction.getIndex());
	}
	
	public GetFreeToken visit(DTOGetFreeToken DTOAction, Player player){
		Set<City> cities=new HashSet<City>();
		
		for(DTOCity c : DTOAction.getCities()){
			cities.add(gameState.getMap().getAllCitiesHashMap().get(c.getName()));
		}
		
		return new GetFreeToken(cities);
	}
}
