package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;
import utilities.Color;

public class TestGameState {

	@Test
	public void testNullParameterInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		ArrayList<Player> players = null;
		try {
			GameState gameState = new GameState(parser, players); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullParserrInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Parser parser2 = null;
		Player player = new Player();
		player.setNickname("Kurt");
		player.setColor(new Color("white"));
		Player player2 = new Player();
		player2.setNickname("Krist");
		player2.setColor(new Color("red"));
		Player player3 = new Player();
		player3.setNickname("Dave");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Courtney");
		player4.setColor(new Color("black"));
		ArrayList<Player> players = new ArrayList<Player>();
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		try {
			GameState gameState = new GameState(parser2, players); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testCurrentPlayer() {
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Kurt");
		player.setColor(new Color("white"));
		Player player2 = new Player();
		player2.setNickname("Krist");
		player2.setColor(new Color("red"));
		Player player3 = new Player();
		player3.setNickname("Dave");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Courtney");
		player4.setColor(new Color("black")); 
		ArrayList<Player> players = new ArrayList<Player>();
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		GarbageState garbageState = new GarbageState(parser); 
		GameState gameState = new GameState(parser, players); 
		Map map = new Map(parser, garbageState); 
		gameState.setCurrentPlayer(player2);
		assertTrue(gameState.getCurrentPlayer()==player2); 
	}
	@Test
	public void testNullParameterInSetPlayersThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Kurt");
		player.setColor(new Color("white"));
		Player player2 = new Player();
		player2.setNickname("Krist");
		player2.setColor(new Color("red"));
		Player player3 = new Player();
		player3.setNickname("Dave");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Courtney");
		player4.setColor(new Color("black")); 
		ArrayList<Player> players = new ArrayList<Player>();
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		ArrayList<Player> players2 = null; 
		GameState gameState = new GameState(parser, players); 
		try {
			gameState.setPlayers(players2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNextPlayer() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Kurt");
		player.setColor(new Color("white"));
		Player player2 = new Player();
		player2.setNickname("Krist");
		player2.setColor(new Color("red"));
		Player player3 = new Player();
		player3.setNickname("Dave");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Courtney");
		player4.setColor(new Color("black")); 
		ArrayList<Player> players = new ArrayList<Player>();
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		GameState gameState = new GameState(parser, players); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		gameState.setCurrentPlayer(player2);
		gameState.nextPlayer(player2);
		assertTrue(gameState.getCurrentPlayer()==player3); 
	}
}
