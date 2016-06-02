package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.council.Balcony;
import model.council.BalconyState;
import model.council.CouncilState;
import model.council.Counsellor;
import model.council.CounsellorGroup;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;
import utilities.Color;

public class TestBalcony {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		Parser parser2 = new Parser(); 
		GarbageState garbage = new GarbageState(parser2); 
		try {
			Balcony balcony = new Balcony(garbage, parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGarbageThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		GarbageState garbage = null; 
		try {
			Balcony balcony = new Balcony(garbage, parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}	
	@Test
	public void testIfPutCounsellorWorks() {
		Parser parser = new Parser();
		GarbageState garbageState = new GarbageState(parser); 
		Player player = new Player("Aiden", new Color("black")); 
		Player player2 = new Player("Ezio", new Color("white")); 
		Player player3 = new Player("Jason", new Color("red")); 
		Player player4 = new Player("Ajay", new Color("blue")); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = map.getRegions().get("seaside").getBalcony();
		balcony.putCounsellor(new Color("orange"), garbageState);
		boolean isMethodOk = false; 
		for(Counsellor c : balcony.getBalcony()) {
			if(c.getColor().getStringID()=="orange")
				isMethodOk = true; 
		}
		assertTrue(isMethodOk); 
	}
	@Test 
	public void testNullGarbageStateInPutCounsellorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		GarbageState garbageState = new GarbageState(parser); 
		Player player = new Player("Aiden", new Color("black")); 
		Player player2 = new Player("Ezio", new Color("white")); 
		Player player3 = new Player("Jason", new Color("red")); 
		Player player4 = new Player("Ajay", new Color("blue")); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = map.getRegions().get("seaside").getBalcony();
		try {
			GarbageState garbage2 = null; 
			balcony.putCounsellor(new Color("white"), garbage2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInPutCounsellorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		GarbageState garbageState = new GarbageState(parser); 
		Player player = new Player("Aiden", new Color("black")); 
		Player player2 = new Player("Ezio", new Color("white")); 
		Player player3 = new Player("Jason", new Color("red")); 
		Player player4 = new Player("Ajay", new Color("blue")); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = map.getRegions().get("seaside").getBalcony();
		try {
			Color color = null; 
			balcony.putCounsellor(color, garbageState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
