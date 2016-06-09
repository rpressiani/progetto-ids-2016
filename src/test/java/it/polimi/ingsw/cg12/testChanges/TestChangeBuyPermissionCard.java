package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.changes.ChangeBuyPermissionCard;
import model.map.Region;
import model.player.Coins;
import model.player.Player;
import parser.Parser;

public class TestChangeBuyPermissionCard {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false;
		Coins coins = new Coins(); 
		Region region = null; 
		try {
			ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		Coins coins = null; 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		try {
			ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegion() {
		Coins coins = new Coins(); 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region);
		Region temp = change.getRegion(); 
		assertEquals(temp, change.getRegion()); 
	}
	@Test
	public void testGetCoins() {
		Coins coins = new Coins(); 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region);
		Coins temp = change.getCoins();  
		assertEquals(temp, change.getCoins()); 
	}

}
