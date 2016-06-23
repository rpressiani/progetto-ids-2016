package it.polimi.ingsw.cg12.testModel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.council.Balcony;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import model.sharedObjects.King;
import model.sharedObjects.KingBonuses;
import model.sharedObjects.Nobility;
import parser.Parser;
import utilities.Color;

public class TestGameState {

	@Test
	public void testNullParameterInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		ArrayList<Player> players = null;
		try {
			@SuppressWarnings("unused")
			GameState gameState = new GameState(parser, players); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullParserInConstructorThrowsException() {
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
			@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
		Map map = new Map(parser, garbageState); 
		gameState.setCurrentPlayer(player2);
		gameState.nextPlayer(player2);
		assertTrue(gameState.getCurrentPlayer()==player3); 
	}
	@Test
	public void testGetMap() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Map temp = gameState.getMap(); 
		assertEquals(temp, gameState.getMap()); 
	}
	@Test
	public void testGetNobility() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Nobility temp = gameState.getNobility(); 
		assertEquals(temp, gameState.getNobility()); 
	}
	@Test
	public void testGetPoliticalDeck() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		PoliticalRealDeck temp = gameState.getPoliticalDeck();
		assertEquals(temp, gameState.getPoliticalDeck()); 
	}
	@Test
	public void testGetGarbage() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		PoliticalGarbage temp = gameState.getGarbage();
		assertEquals(temp, gameState.getGarbage()); 
	}
	@Test
	public void testGetKingBalcony() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Balcony temp = gameState.getKingBalcony();
		assertEquals(temp, gameState.getKingBalcony()); 
	}
	@Test
	public void testGetCounsellorGarbage() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		GarbageState temp = gameState.getCounsellorGarbage();
		assertEquals(temp, gameState.getCounsellorGarbage()); 
	}
	@Test
	public void testGetKingBonuss() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		KingBonuses temp = gameState.getKingBonuses();
		assertEquals(temp, gameState.getKingBonuses()); 
	}
	@Test
	public void testGetKing() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		King temp = gameState.getKing(); 
		assertEquals(temp, gameState.getKing()); 
	}
}
