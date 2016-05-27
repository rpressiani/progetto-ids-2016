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
		this.cardChosed = cardChosed;
		this.cityChosed = cityChosed;
	}

	public void doAction(Player player, GameState gameState) {
		int assistantsToPay=checkOtherEmporium(cityChosed, gameState);
		
		if(cityChosed.hasBuiltHere(player)==false && 
			assistantsToPay<=player.getAssistants().getItems()) player.getBuiltCities().add(cityChosed);
		if(cardChosed.isUsed()==false) cardChosed.setUsed(true);
	}
	
	public int checkOtherEmporium(City city, GameState gameState){
		int res=0;
		
		for(Player player : gameState.getPlayers()){
			if(player.getBuiltCities().contains(city)) res++;
		}
		
		return res;
	}
}
