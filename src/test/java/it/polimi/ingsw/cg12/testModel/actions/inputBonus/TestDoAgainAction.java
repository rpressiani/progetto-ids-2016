package it.polimi.ingsw.cg12.testModel.actions.inputBonus;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.inputBonus.DoAgainAction;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.MainAction;
import model.bonusItem.BonusAddictionalAction;
import model.bonusable.PermissionCard;
import model.map.City;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestDoAgainAction {

	@SuppressWarnings("unused")
	@Test
	public void testNullActionInConstructorThrowsException() {
		boolean thrown = false; 
		MainAction action = null; 
		try {
			DoAgainAction againAction = new DoAgainAction(action); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testDoActionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);	
		player.getBonusInputs().add(new BonusAddictionalAction()); 
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		MainAction mainAction = new BuildEmporiumWithCard(card, city);
		DoAgainAction action = new DoAgainAction(mainAction); 
		action.doAction(player, gameState);
		assertTrue(player.getBuiltCities().contains(city)); 
	} 


}
