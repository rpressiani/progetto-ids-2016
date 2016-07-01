package it.polimi.ingsw.cg12.testBonus;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusToken;
import model.map.City;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusToken {

	@Test
	public void testNegativeIntInConstructorInConstructorThrowsException() {
		boolean thrown = false; 
		try {
			@SuppressWarnings("unused")
			BonusToken bonus = new BonusToken(-2); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGiveBonusWorksWithNoBuiltCities() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		BonusToken bonus = new BonusToken(3); 
		//ArrayList<BonusInputItem> temp = player.getBonusInputs(); 
		bonus.giveBonus(player, gameState);
		assertTrue(player.getBonusInputs().isEmpty()); 
	}
	@Test
	public void testGiveBonusWorksWithBuiltCities() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		player.getBuiltCities().add(city); 
		BonusToken bonus = new BonusToken(3); 
		bonus.giveBonus(player, gameState);
		assertTrue(!player.getBonusInputs().contains(bonus)); 
	}

}
