package it.polimi.ingsw.cg12.testMap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.GameState;
import model.council.Balcony;
import model.council.GarbageState;
import model.map.City;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import model.sharedObjects.PermissionDeck;
import parser.Parser;

public class TestRegion {

	@Test
	public void testNullConstructorThrowsException() {
		boolean thrown = false; 
		try {
			Region region = new Region(null, null, null, null); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetStringWorks() {
		Parser parser = new Parser(); 
		GarbageState garbage = new GarbageState(parser);
		Map map = new Map(parser, garbage);
		Region region = new Region("Lombardia", garbage, parser, map);
		assertEquals(region.getName(), "Lombardia");  
	}
	@Test
	public void testGetPermissionDeckWorks() {
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
		Region region = gameState.getMap().getRegions().get("seaside");
		PermissionDeck temp = region.getPermissionDeck();
		assertTrue(temp==region.getPermissionDeck()); 
	}
	@Test
	public void testGetBalconyWorks() {
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
		Region region = gameState.getMap().getRegions().get("seaside");
		Balcony temp = region.getBalcony(); 
		assertTrue(temp==region.getBalcony()); 
	}
	@Test
	public void testGetRegionCityWorks() {
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
		Region region = gameState.getMap().getRegions().get("seaside");
		Set<City> temp = region.getRegionCities(); 
		assertTrue(temp==region.getRegionCities()); 
	}
	@Test
	public void testGetNameWorks() {
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
		Region region = gameState.getMap().getRegions().get("seaside");
		String temp = region.getName();
		assertTrue(temp==region.getName()); 
	}
}
