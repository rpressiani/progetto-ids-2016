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
import model.sharedObjects.KingBonuses;
import parser.Parser;
import utilities.Color;

public class TestKingBonuses {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
			KingBonuses bonuses = new KingBonuses(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetKingBonuses() {
		Parser parser = new Parser(); 
		Player player = new Player("Matt", new Color("red")); 
		Player player2 = new Player("Dom", new Color("blue"));
		Player player3 = new Player("Chris", new Color("green"));
		Player player4 = new Player("Liam", new Color("white"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser);
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		GameState gameState = new GameState(parser, players);
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		KingBonuses temp = gameState.getKingBonuses(); 
		assertTrue(temp==gameState.getKingBonuses()); 
	}

}
