package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusNobility;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusNobility {

	@Test
	public void testNullItemsThrowsException() {
		boolean thrown = false; 
		int items = -2; 
		BonusNobility bonus; 
		try {
			bonus = new BonusNobility(items); 
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
		BonusNobility bonus = new BonusNobility(2); 
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
		BonusNobility bonus = new BonusNobility(2); 
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
		BonusNobility bonus = new BonusNobility(2); 
		int temp = player.getNobilityLevel().getItems(); 
		bonus.giveBonus(player, gameState);
		assertTrue(temp!=player.getNobilityLevel().getItems()); 
	}

}
