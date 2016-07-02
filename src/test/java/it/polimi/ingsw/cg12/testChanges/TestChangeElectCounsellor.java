package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.changes.ChangeElectCounsellor;
import model.map.Region;
import model.player.Coins;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestChangeElectCounsellor {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		Coins coins = new Coins(); 
		Color color = new Color("red"); 
		Region region = null; 
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Coins coins = null; 
		Color color = new Color("red"); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Coins coins = new Coins(); 
		Color color = null; 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCoinsWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Coins coins = new Coins(); 
		Color color = new Color("red"); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color, region);
		Coins temp = change.getCoins();  
		assertEquals(change.getCoins(), temp); 
	}
	@Test
	public void testGetColorWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Coins coins = new Coins(); 
		Color color = new Color("red"); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color, region);
		Color temp = change.getColor();  
		assertEquals(change.getColor(), temp); 
	}
	@Test
	public void testGetRegionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Coins coins = new Coins(); 
		Color color = new Color("red"); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color, region);
		Region temp = change.getRegion(); 
		assertEquals(change.getRegion(), temp); 
	}

}
