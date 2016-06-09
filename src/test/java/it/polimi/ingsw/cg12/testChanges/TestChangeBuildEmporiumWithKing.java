package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.changes.ChangeBuildEmporiumWithKing;
import model.map.City;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestChangeBuildEmporiumWithKing {

	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = new Assistants(); 
		Coins coins = null;
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		try {
			ChangeBuildEmporiumWithKing change = new ChangeBuildEmporiumWithKing(coins, assistants, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = new Assistants(); 
		Coins coins = new Coins();
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		City city = null;
		try {
			ChangeBuildEmporiumWithKing change = new ChangeBuildEmporiumWithKing(coins, assistants, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = null; 
		Coins coins = new Coins();
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		try {
			ChangeBuildEmporiumWithKing change = new ChangeBuildEmporiumWithKing(coins, assistants, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCityWorks() {
		Assistants assistants = new Assistants(); 
		Coins coins = new Coins();
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		ChangeBuildEmporiumWithKing change = new ChangeBuildEmporiumWithKing(coins, assistants, city); 
		City temp = change.getCity(); 
		assertTrue(temp==change.getCity()); 
	}
	@Test
	public void testGetCoinsWorks() {
		Assistants assistants = new Assistants(); 
		Coins coins = new Coins();
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		ChangeBuildEmporiumWithKing change = new ChangeBuildEmporiumWithKing(coins, assistants, city); 
		Coins temp = change.getCoins(); 
		assertTrue(temp==change.getCoins()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Assistants assistants = new Assistants(); 
		Coins coins = new Coins();
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		ChangeBuildEmporiumWithKing change = new ChangeBuildEmporiumWithKing(coins, assistants, city); 
		Assistants temp = change.getAssistants(); 
		assertTrue(temp==change.getAssistants()); 
	}

}
