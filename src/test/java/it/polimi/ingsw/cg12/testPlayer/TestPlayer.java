package it.polimi.ingsw.cg12.testPlayer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.MainAction;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.map.City;
import model.player.Coins;
import model.player.NobilityLevel;
import model.player.Player;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;
import utilities.Color;

public class TestPlayer {

	@Test
	public void testNullActionInMoveThrowsException() {
		boolean thrown = false;
		Parser parser = new Parser(); 
		MainAction action = null; 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		try {
			player.move(action, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInMoveThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities); 
		MainAction action = new BuildEmporiumWithCard(card, city); 
		GameState gameState2 = null; 
		try {
			player.move(action, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNegativeIdInPlayerThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("peter");
		player.setColor(new Color("green"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		try {
			player.initPlayer(gameState.getPoliticalDeck(), -2, parser);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullParserInInitPlayerThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("peter");
		player.setColor(new Color("green"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		try {
			Parser parser2 = null; 
			player.initPlayer(gameState.getPoliticalDeck(), 3, parser2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullDeckInInitPlayerThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("peter");
		player.setColor(new Color("green"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		@SuppressWarnings("unused")
		GameState gameState = new GameState(parser, players); 
		try {
			PoliticalRealDeck deck = null;  
			player.initPlayer(deck, 3, parser);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetNickname() {
		Player player = new Player();
		player.setNickname("Andy");
		String temp = player.getNickname(); 
		assertTrue(temp==player.getNickname()); 
	}
	@Test
	public void testSetNickname() {
		Player player = new Player();
		player.setNickname("Paul");
		assertEquals(player.getNickname(), "Paul");  
	}
	@Test
	public void testGetCoins() {
		Player player = new Player();
		Coins temp = player.getCoins();
		assertTrue(temp==player.getCoins()); 
	}
	@Test
	public void testGetNobilityLevel() {
		Player player = new Player(); 
		NobilityLevel temp = player.getNobilityLevel();
		assertTrue(temp==player.getNobilityLevel()); 
	}
	@Test
	public void testInitPlayerWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("peter");
		player.setColor(new Color("green"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 1, parser);
		assertTrue(player.getCoins().getItems()!=0 && player.getAssistants().getItems()!=0); 
	}

}
