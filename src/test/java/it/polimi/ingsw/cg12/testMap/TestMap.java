package it.polimi.ingsw.cg12.testMap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusItem;
import model.council.GarbageState;
import model.map.Ancestry;
import model.map.City;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestMap {

	@Test
	public void testNullMapThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		Parser parser2 = new Parser(); 
		GarbageState garbage = new GarbageState(parser2);
		try {
			Map map = new Map(parser, garbage); 
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
			Map map = new Map(parser, garbage); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfGetAllCitiesHashMapWorks() {
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
		Map map = gameState.getMap(); 
		HashMap<String, City> temp = map.getAllCitiesHashMap();
		assertTrue(temp==map.getAllCitiesHashMap()); 
	}
	@Test
	public void testAddCityWorks() {
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
		Map map = gameState.getMap(); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		City cityToAdd = new City("NA", "Napoli", bonuses, map.getRegions().get("seaside"), map.getAncestries().get("gold")); 
		map.getGraph().addVertex(cityToAdd); 
		assertTrue(map.getGraph().containsVertex(cityToAdd)); 
	}
	@Test
	public void testGetGraphWorks() {
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
		Map map = gameState.getMap(); 
		UndirectedGraph<City, DefaultEdge> temp = map.getGraph();
		assertTrue(temp==map.getGraph()); 
	}
	@Test
	public void testAddLinkWorks() {
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
		Map map = gameState.getMap(); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		City cityToAdd = new City("NA", "Napoli", bonuses, map.getRegions().get("seaside"), map.getAncestries().get("gold"));
		City cityToAdd2 = new City("MI", "Milano", bonuses, map.getRegions().get("seaside"), map.getAncestries().get("gold"));
		map.getGraph().addVertex(cityToAdd); 
		map.getGraph().addVertex(cityToAdd2); 
		map.getGraph().addEdge(cityToAdd, cityToAdd2); 
		assertTrue((map.getGraph().containsEdge(cityToAdd, cityToAdd2))); 
	}
	@Test
	public void testNumericDistanceWorks() {
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
		Map map = gameState.getMap(); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		City cityToAdd = new City("NA", "Napoli", bonuses, map.getRegions().get("seaside"), map.getAncestries().get("gold"));
		City cityToAdd2 = new City("MI", "Milano", bonuses, map.getRegions().get("seaside"), map.getAncestries().get("gold"));
		map.getGraph().addVertex(cityToAdd); 
		map.getGraph().addVertex(cityToAdd2); 
		map.getGraph().addEdge(cityToAdd, cityToAdd2); 
		assertTrue(map.numericDistance(cityToAdd, cityToAdd2)==1); 
	}
	@Test
	public void testGetRegionWorks() {
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
		Map map = gameState.getMap();
		HashMap<String, Region> temp = map.getRegions(); 
		assertTrue(temp==map.getRegions()); 
	}
	@Test
	public void testGetAncestriesWorks() {
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
		Map map = gameState.getMap();
		HashMap<String, Ancestry> temp = map.getAncestries(); 
		assertTrue(temp==map.getAncestries()); 
	}
}
