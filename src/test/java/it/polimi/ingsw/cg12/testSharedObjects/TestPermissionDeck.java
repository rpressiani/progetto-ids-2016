package it.polimi.ingsw.cg12.testSharedObjects;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import model.GameState;
import model.bonusable.PermissionCard;
import model.council.GarbageState;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import model.sharedObjects.PermissionDeck;
import parser.Parser;
import utilities.Color;

public class TestPermissionDeck {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Parser parser2 = null; 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState);
		Region region = new Region("Lombardia", garbageState, parser, map); 
		try {
			@SuppressWarnings("unused")
			PermissionDeck deck = new PermissionDeck(parser2, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullRegionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Region region = null; 
		try {
			@SuppressWarnings("unused")
			PermissionDeck deck = new PermissionDeck(parser, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/* @Test
	public void TestIfShuffleDeckWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		player.setNickname("Deryck");
		player.setColor(new Color("black"));
		player2.setNickname("Steve");
		player2.setColor(new Color("red"));
		player3.setNickname("Cone");
		player3.setColor(new Color("white"));
		player4.setNickname("Dave");
		player4.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4);
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		PermissionDeck deck = gameState.getMap().getRegions().get("seaside").getPermissionDeck();
		deck.shuffleDeck(deck.getDeck());
		PermissionDeck deck2 = gameState.getMap().getRegions().get("seaside").getPermissionDeck();
		boolean isDifferent = false; 
		for(int i=0; i<deck2.getDeck().size(); i++) {
			if(deck2.getDeck().get(i).g!=deck.getDeck().get(i).getIdCard())
				isDifferent = true; 
		}
		assertTrue(isDifferent); 
	} */
	@Test
	public void testDrawCardWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		PermissionDeck deck = gameState.getMap().getRegions().get("seaside").getPermissionDeck();
		PermissionCard card = deck.getDeck().get(0); 
		deck.drawCard(deck.getDeck(), deck.getVisibleCards(), 0); 
		assertTrue(deck.getVisibleCards().contains(card)); 
	}
	@Test
	public void testGetDeckWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		PermissionDeck deck = gameState.getMap().getRegions().get("seaside").getPermissionDeck();
		LinkedList<PermissionCard> temp = deck.getDeck(); 
		assertTrue(temp==deck.getDeck()); 

	}

}
