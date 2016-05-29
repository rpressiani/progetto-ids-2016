package model.actions.main;

import model.GameState;
import model.actions.MainAction;
import model.bonusable.PermissionCard;
import model.map.City;
import model.player.Player;

public class BuildEmporiumWithCard extends MainAction {

	private PermissionCard cardChosed;
	private City cityChosed;
	
	public BuildEmporiumWithCard(PermissionCard cardChosed, City cityChosed) {
		super();
		if(cardChosed.getPossibleCities().contains(cityChosed)){
			this.cardChosed = cardChosed;
			this.cityChosed = cityChosed;
		}
		
		else throw new IllegalArgumentException("City chosed doesn't appear on the card chosed");
		//corretto lanciare eccezione sul costruttore?
	}

	public void doAction(Player player, GameState gameState) {
		int assistantsToPay=checkOtherEmporium(cityChosed, gameState);
		
		if(cityChosed.hasBuiltHere(player)==false && 
			assistantsToPay<=player.getAssistants().getItems() &&
			cardChosed.isUsed()==false){
				
				player.getBuiltCities().add(cityChosed);
				player.getAssistants().sub(assistantsToPay);
				cardChosed.setUsed(true);
				
				for(City c : cityChosed.linkedCities(gameState.getMap(), player)){
					c.assignBonuses(player, gameState);
				}
		}
	}
	
	public int checkOtherEmporium(City city, GameState gameState){
		int res=0;
		
		for(Player player : gameState.getPlayers()){
			if(player.getBuiltCities().contains(city)) res++;
		}
		
		return res;
	}
}
