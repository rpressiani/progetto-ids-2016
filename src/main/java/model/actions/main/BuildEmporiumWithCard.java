package model.actions.main;

import model.GameState;
import model.bonusable.PermissionCard;
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
				
		for(City c : cityChosed.linkedCities(gameState.getMap(), player)){
			c.assignBonuses(player, gameState);
		}
		
		gameState.notifyObserver(player, new ChangeBuildEmporiumWithCard(new Assistants(assistantsToPay), cityChosed, cardChosed));
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
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
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
