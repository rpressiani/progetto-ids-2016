package it.polimi.ingsw.cg12.testCouncil;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Queue;

import org.junit.Test;

import model.GameState;
import model.council.Balcony;
import model.council.BalconyState;
import model.council.Counsellor;
import model.council.GarbageState;
import model.player.Player;
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
			@SuppressWarnings("unused")
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
			@SuppressWarnings("unused")
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
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4);  
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony(); 
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
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony();
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
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony();
		try {
			Color color = null; 
			balcony.putCounsellor(color, garbageState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfGetBalconyWorks() {
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony();
		Queue<Counsellor> queue = balcony.getBalcony();
		assertTrue(queue==balcony.getBalcony()); 
	}
	@Test
	public void testIfGetNColorWorks() {
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony();
		Integer temp = balcony.getnColors();
		assertTrue(temp==balcony.getnColors()); 
	}
	@Test
	public void testIfGetBalconyStateWorks() {
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony();
		BalconyState temp = balcony.getBalconyState();
		assertTrue(temp==balcony.getBalconyState()); 
	}

}
