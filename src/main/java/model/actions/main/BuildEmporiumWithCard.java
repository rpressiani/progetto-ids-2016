package model.actions.main;

import model.GameState;
import model.bonusable.ColorCard;
import model.bonusable.PermissionCard;
import model.bonusable.RegionCard;
import model.changes.ChangeBuildEmporiumWithCard;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.map.City;
import model.player.Assistants;
import model.player.Player;

public class BuildEmporiumWithCard implements MainAction {

	private PermissionCard cardChosed;
	private City cityChosed;
	
	/**
	 * @param cardChosed
	 * @param cityChosed
	 * @throws NullPointerException if cardChosed or cityChosed are null
	 */
	public BuildEmporiumWithCard(PermissionCard cardChosed, City cityChosed) {
		this.cardChosed = cardChosed;
		this.cityChosed = cityChosed;	
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		int assistantsToPay=checkOtherEmporium(cityChosed, gameState);
				
		player.getBuiltCities().add(cityChosed);
		player.getAssistants().sub(assistantsToPay);
		cardChosed.setUsed(true);
		
		gameState.notifyObserver(player, new ChangeBuildEmporiumWithCard(new Assistants(assistantsToPay), cityChosed, cardChosed));
		
		for(City c : cityChosed.linkedCities(gameState.getMap(), player)){
			c.assignBonuses(player, gameState);
		}
		
		gameState.getNobility().checkNobility(player, gameState);
		
		if(player.getBuiltCities().containsAll(gameState.getMap().getRegions().get(cityChosed.getRegion().getName()).getRegionCities())){
			RegionCard card=gameState.getMap().getRegions().get(cityChosed.getRegion().getName()).getRegionBonus();
			
			if(card.isAssigned()==false){
				gameState.notifyObserver(player, new ChangeMsg("Congratulations, you got the "+cityChosed.getRegion().getName()+" bonus"));
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" got the "+cityChosed.getRegion().getName()+" bonus"));
				card.setAssigned(true);
				card.assignBonuses(player, gameState);
			}
			
			if(!gameState.getKingBonuses().getKingCards().isEmpty()){
				gameState.notifyObserver(player, new ChangeMsg("Congratulations, you got bonuses of a king card"));
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" got bonuses of a king card"));
				gameState.getKingBonuses().getKingCards().get(0).assignBonuses(player, gameState);
				gameState.getKingBonuses().getKingCards().remove(0);
			}
		}
		
		if(player.getBuiltCities().containsAll(gameState.getMap().getAncestries().get(cityChosed.getAncestry().getColor().getStringID()).getColorCities())){
			ColorCard card=gameState.getMap().getAncestries().get(cityChosed.getAncestry()).getColorCard();
			
			if(card.isAssigned()==false){
				gameState.notifyObserver(player, new ChangeMsg("Congratulations, you got the "+cityChosed.getAncestry().getColor().getStringID()+" bonus"));
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" got the "+cityChosed.getAncestry().getColor().getStringID()+" bonus"));
				card.setAssigned(true);
				card.assignBonuses(player, gameState);
			}
			
			if(!gameState.getKingBonuses().getKingCards().isEmpty()){
				gameState.notifyObserver(player, new ChangeMsg("Congratulations, you got bonuses of a king card"));
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" got bonuses of a king card"));
				gameState.getKingBonuses().getKingCards().get(0).assignBonuses(player, gameState);
				gameState.getKingBonuses().getKingCards().remove(0);
			}
		}
		
		gameState.getNobility().checkNobility(player, gameState);
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}
	
	/**
	 * @param city
	 * @param gameState
	 * @throws NullPointerException if city or gameState are null
	 * @return
	 */
	public int checkOtherEmporium(City city, GameState gameState){
		if(city==null) {
			throw new NullPointerException("city cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		int res=0;
		
		for(Player player : gameState.getPlayers()){
			if(player.getBuiltCities().contains(city)) res++;
		}
		
		return res;
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(cardChosed==null){
			gameState.notifyObserver(player, new ChangeMsg("You don't have the permission card you chosed or it doesn't exist"));
			return false;
		}
		
		if(cardChosed.isUsed()==true){
			gameState.notifyObserver(player, new ChangeMsg("You already used this permission card to build an emporium"));
			return false;
		}
		
		if(cityChosed==null){
			gameState.notifyObserver(player, new ChangeMsg("The city you chosed doesn't exist"));
			return false;
		}
		
		if(!cardChosed.getPossibleCities().contains(cityChosed)){
			gameState.notifyObserver(player, new ChangeMsg("The city you chosed doesn't appear in the card you chosed"));
			return false;
		}
		
		if(cityChosed.hasBuiltHere(player)==true){
			gameState.notifyObserver(player, new ChangeMsg("You already built an emporium in this city"));
			return false;
		}
		
		int assistantsToPay=checkOtherEmporium(cityChosed, gameState);
		
		if(assistantsToPay>player.getAssistants().getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to build in this city"));
			return false;
		}
		
		return true;
	}
}
