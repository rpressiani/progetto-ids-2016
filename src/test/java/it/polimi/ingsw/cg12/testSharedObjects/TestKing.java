package it.polimi.ingsw.cg12.testSharedObjects;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.map.City;
import model.map.Map;
import model.player.Player;
import model.sharedObjects.King;
import parser.Parser;

public class TestKing {

	@Test
	public void testNullParserInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Map map = gameState.getMap(); 
		try {
			Parser parser2 = null; 
			King king = new King(parser2, map); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullMapInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Map map = null; 
		try {
			King king = new King(parser, map); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testSetKingCityWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Map map = gameState.getMap();
		City city = map.getAllCitiesHashMap().get("A"); 
		King king = new King(parser, map); 
		king.setKingCity(city);
		assertTrue(city==king.getKingCity()); 
	}
	@Test
	public void testGetKingCityWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Map map = gameState.getMap();
		City city = map.getAllCitiesHashMap().get("A"); 
		King king = new King(parser, map); 
		king.setKingCity(city);
		City temp = king.getKingCity(); 
		assertTrue(temp==king.getKingCity()); 
	}

}
