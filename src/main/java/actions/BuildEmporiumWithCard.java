package actions;

import bonusable.PermissionCard;
import gameState.GameState;
import map.City;
import player.Player;

public class BuildEmporiumWithCard extends PrimaryAction {

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
