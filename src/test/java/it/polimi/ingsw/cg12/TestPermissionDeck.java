package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusable.PermissionCard;
import model.council.GarbageState;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
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
			PermissionDeck deck = new PermissionDeck(parser, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/*@Test
	public void TestIfShuffleDeckWorks() {
		Parser parser = new Parser(); 
		Player player = new Player("Deryck", new Color("black")); 
		Player player2 = new Player("Cone", new Color("red"));
		Player player3 = new Player("Steve", new Color("grey")); 
		Player player4 = new Player("Dave", new Color("brown")); 
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
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		PermissionDeck deck = gameState.getMap().getRegions().get("seaside").getPermissionDeck();
		PermissionDeck deck2 = deck; 
		deck.shuffleDeck(deck.getDeck());
		boolean isDifferent = false; 
		for(int i=0; i<deck.getDeck().size(); i++) {
			if(deck.getDeck().get(i).getIdCard()!=deck.getDeck().get(i).getIdCard()) {
				isDifferent = true; 
				break; 
			}
		}
		assertTrue(isDifferent); 
	}*/

}
