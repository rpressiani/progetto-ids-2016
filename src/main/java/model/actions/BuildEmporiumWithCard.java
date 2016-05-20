package model.actions;

import model.GameState;
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
		if(cityChosed.hasBuiltHere(player)==false) player.getBuiltCities().add(cityChosed);
		if(cardChosed.isUsed()==false) cardChosed.setUsed(true);
	}
}
