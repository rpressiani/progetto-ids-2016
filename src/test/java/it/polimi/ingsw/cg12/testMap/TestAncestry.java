package it.polimi.ingsw.cg12.testMap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import model.GameState;
import model.bonusable.ColorCard;
import model.council.GarbageState;
import model.map.Ancestry;
import model.map.City;
import model.map.Map;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestAncestry {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Parser parser2 = null; 
		Color color = new Color("gold"); 
		GarbageState garbage = new GarbageState(parser); 
		Map map = new Map(parser, garbage); 
		try {
			@SuppressWarnings("unused")
			Ancestry ancestry = new Ancestry(color, parser2, map);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullMapThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Color color = new Color("gold"); 
		Map map = null; 
		try {
			@SuppressWarnings("unused")
			Ancestry ancestry = new Ancestry(color, parser, map);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Color color = null; 
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
		try {
			@SuppressWarnings("unused")
			Ancestry ancestry = new Ancestry(color, parser, gameState.getMap()); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetColorWorks() {
		Color color = new Color("gold"); 
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
		Ancestry ancestry = new Ancestry(color, parser, gameState.getMap());
		Color temp = ancestry.getColor(); 
		assertTrue(temp==ancestry.getColor()); 
	}
	@Test
	public void testGetColorCitiesWorks() {
		Color color = new Color("gold");
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
		Ancestry ancestry = new Ancestry(color, parser, gameState.getMap());
		Set<City> temp = ancestry.getColorCities();
		assertTrue(temp==ancestry.getColorCities()); 
	}
	@Test
	public void testGetColorBonusWorks() {
		Color color = new Color("gold");
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
		Ancestry ancestry = new Ancestry(color, parser, gameState.getMap());
		ColorCard temp = ancestry.getColorBonus();
		assertTrue(temp==ancestry.getColorBonus()); 
	}

}
