package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusAssistants;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusAssistants {

	@Test
	public void testNegativeItemsInConstructorThrowsException() {	
		boolean thrown = false; 
		int items = -2; 
		try {
			BonusAssistants bonus = new BonusAssistants(items); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInGiveBonusThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player("Marco", new Color("black")); 
		Player player2 = new Player("Sven", new Color("red")); 
		Player player3 = new Player("Carl", new Color("white")); 
		Player player4 = new Player("Richie", new Color("blue")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		BonusAssistants bonus = new BonusAssistants(23); 
		try {
			Player pl = null; 
			bonus.giveBonus(pl, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInGiveBonusThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player("Marco", new Color("black")); 
		Player player2 = new Player("Sven", new Color("red")); 
		Player player3 = new Player("Carl", new Color("white")); 
		Player player4 = new Player("Richie", new Color("blue")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		BonusAssistants bonus = new BonusAssistants(23); 
		try {
			GameState gameState2 = null; 
			bonus.giveBonus(player, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testIfGiveBonusWorks() {
		Parser parser = new Parser();
		Player player = new Player("Marco", new Color("black")); 
		Player player2 = new Player("Sven", new Color("red")); 
		Player player3 = new Player("Carl", new Color("white")); 
		Player player4 = new Player("Richie", new Color("blue")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		BonusAssistants bonus = new BonusAssistants(10);
		int temp = player3.getAssistants().getItems(); 
		bonus.giveBonus(player3, gameState);
		assertTrue(temp!=player3.getAssistants().getItems()); 
	}

}
