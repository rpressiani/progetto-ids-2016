package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dto.actions.DTOChatAction;
import dto.actions.DTONullAction;
import dto.actions.DTOQuitAction;
import dto.actions.inputBonus.DTODoAgainAction;
import dto.actions.inputBonus.DTOGetAgainBonusPermission;
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
import model.actions.ChatAction;
import model.actions.NullAction;
import model.actions.QuitAction;
import model.actions.inputBonus.DoAgainAction;
import model.actions.inputBonus.GetAgainBonusPermission;
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
import model.council.Balcony;
import model.map.City;
import model.map.Region;
import model.market.Contract;
import model.player.Assistants;
import model.player.Coins;
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
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public BuyPermissionCard visit(DTOBuyPermissionCard DTOAction, Player player){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		ArrayList<Integer> structure=DTOAction.getProposal().getStructure();
		PoliticalContainer proposal=new PoliticalContainer(gameState.getParser(), structure);
		
		return new BuyPermissionCard(region, proposal, DTOAction.getIndex());
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public BuildEmporiumWithKing visit(DTOBuildEmporiumWithKing DTOAction, Player player){
		ArrayList<Integer> structure=DTOAction.getProposal().getStructure();
		PoliticalContainer proposal=new PoliticalContainer(gameState.getParser(), structure);
		City city=gameState.getMap().getAllCitiesHashMap().get(DTOAction.getCity().getName());
		
		return new BuildEmporiumWithKing(proposal, city);
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
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
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public ElectCounsellor visit(DTOElectCounsellor DTOAction){
		String colorString=DTOAction.getColor().getColorString();
		String balconyName=DTOAction.getBalcony();
		Color color = new Color(colorString);
		
		if(balconyName.equals("king")) return new ElectCounsellor(gameState.getKingBalcony(), color);
		
		else{
			Balcony balcony=null;
			if(gameState.getMap().getRegions().get(balconyName)!=null) balcony=gameState.getMap().getRegions().get(balconyName).getBalcony();
			return new ElectCounsellor(balcony, color);
		}
		
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public AddictionalAction visit(DTOAddictionalAction DTOAction, Player player){
		DTOMainAction action=DTOAction.getAction();
		MainAction realAction=null;
		
		if(action instanceof DTOBuildEmporiumWithCard) realAction=visit((DTOBuildEmporiumWithCard) action, player);
		if(action instanceof DTOBuildEmporiumWithKing) realAction=visit((DTOBuildEmporiumWithKing) action, player);
		if(action instanceof DTOBuyPermissionCard) realAction=visit((DTOBuyPermissionCard) action, player);
		if(action instanceof DTOElectCounsellor) realAction=visit((DTOElectCounsellor) action);
	
		return new AddictionalAction(realAction);
	}
	
	/**
	 * @param DTOAction
	 * @return 
	 */
	public SubstitutePermissionCards visit(DTOSubstitutePermissionCards DTOAction){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		
		return new SubstitutePermissionCards(region);	
	}
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public ElectCounsellorWithAssistant visit(DTOElectCounsellorWithAssistant DTOAction){
		String colorString=DTOAction.getColor().getColorString();
		String balconyName=DTOAction.getBalcony();
		Color color = new Color(colorString);
		
		if(balconyName.equals("king")) return new ElectCounsellorWithAssistant(gameState.getKingBalcony(), color);
		
		else{
			Balcony balcony=null;
			if(gameState.getMap().getRegions().get(balconyName)!=null) balcony=gameState.getMap().getRegions().get(balconyName).getBalcony();
			return new ElectCounsellorWithAssistant(balcony, color);
		}
	}
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public HireAssistant visit(DTOHireAssistant DTOAction){
		return new HireAssistant();
	}
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public NullAction visit(DTONullAction DTOAction){
		return new NullAction();
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public SellAction visit(DTOSellAction DTOAction, Player player){
		Coins sellCoins=new Coins(DTOAction.getSellCoins().getQuantity());
		Coins buyCoins=new Coins(DTOAction.getBuyCoins().getQuantity());
		
		Assistants sellAssistants=new Assistants(DTOAction.getSellAssistants().getQuantity());
		Assistants buyAssistants=new Assistants(DTOAction.getBuyAssistants().getQuantity());
		
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
		
		PoliticalContainer sellPoliticals=new PoliticalContainer(gameState.getParser(), DTOAction.getSellPoliticals().getStructure());
		PoliticalContainer buyPoliticals=new PoliticalContainer(gameState.getParser(), DTOAction.getBuyPoliticals().getStructure());
		
		return new SellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, buyCoins, buyAssistants, buyPermissions, buyPoliticals);
	}
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public BuyAction visit(DTOBuyAction DTOAction){
		Contract contract=null;
		List<Contract> contractList= new ArrayList<Contract>(gameState.getMarket().getContractSet());

		for(int i=0; i<contractList.size(); i++){
			if(DTOAction.getIdContract()==(contractList.get(i).getId())) contract=contractList.get(i);
		}
		
		return new BuyAction(contract);
	}
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public GetFreePermission visit(DTOGetFreePermission DTOAction){
		Region region=gameState.getMap().getRegions().get(DTOAction.getRegion().getName());
		
		return new GetFreePermission(region, DTOAction.getIndex());
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public GetFreeToken visit(DTOGetFreeToken DTOAction, Player player){
		Set<City> cities=new HashSet<City>();
		
		for(DTOCity c : DTOAction.getCities()){
			cities.add(gameState.getMap().getAllCitiesHashMap().get(c.getName()));
		}
		
		return new GetFreeToken(cities);
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public GetAgainBonusPermission visit(DTOGetAgainBonusPermission DTOAction, Player player){
		int idCard=DTOAction.getCard().getIdCard();
		PermissionCard card=null;
		List<PermissionCard> list= new ArrayList<PermissionCard>(player.getPermissionHand());
		
		for(int i=0; i<list.size(); i++){
			if(idCard==list.get(i).getIdCard()) card=list.get(i);
		}
		
		return new GetAgainBonusPermission(card);
	}
	
	/**
	 * @param DTOAction
	 * @param player
	 * @return
	 */
	public DoAgainAction visit(DTODoAgainAction DTOAction, Player player){
		DTOMainAction action=DTOAction.getAction();
		MainAction realAction=null;
		
		if(action instanceof DTOBuildEmporiumWithCard) realAction=visit((DTOBuildEmporiumWithCard) action, player);
		if(action instanceof DTOBuildEmporiumWithKing) realAction=visit((DTOBuildEmporiumWithKing) action, player);
		if(action instanceof DTOBuyPermissionCard) realAction=visit((DTOBuyPermissionCard) action, player);
		if(action instanceof DTOElectCounsellor) realAction=visit((DTOElectCounsellor) action);
	
		return new DoAgainAction(realAction);
	}
	
	/**
	 * @param DTOAction
	 * @return
	 */
	public QuitAction visit(DTOQuitAction DTOAction){
		return new QuitAction();
	}
	
	public ChatAction visit(DTOChatAction DTOAction){
		return new ChatAction(DTOAction.getMsg());
	}
}
