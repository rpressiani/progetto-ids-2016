package it.polimi.ingsw.cg12.testModel.actions.inputBonus;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.GameState;
import model.actions.inputBonus.GetFreeToken;
import model.bonusItem.BonusToken;
import model.map.City;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestGetFreeToken {

	@Test
	public void testNullSetInConstructorThrowsException() {
		boolean thrown = false; 
		Set<City> cities = null; 
		try {
			@SuppressWarnings("unused")
			GetFreeToken bonus = new GetFreeToken(cities); 
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
		player.getBonusInputs().add(new BonusToken(2));  
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		Set<City> cities = new HashSet<City>(); 
		cities.add(city); 
		GetFreeToken bonus = new GetFreeToken(cities); 
		bonus.doAction(player, gameState);
		assertTrue(player.getBonusInputs().isEmpty()); 
	}
	@Test
	public void testCheckConditionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		player.getBonusInputs().add(new BonusToken(2));  
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		Set<City> cities = new HashSet<City>(); 
		cities.add(city); 
		GetFreeToken bonus = new GetFreeToken(cities); 
		assertTrue(!bonus.checkCondition(player, gameState)); 
	}

}
