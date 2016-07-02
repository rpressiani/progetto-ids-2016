package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.changes.ChangeBuyPermissionCard;
import model.map.City;
import model.map.Region;
import model.player.Coins;
import model.player.Player;
import parser.Parser;

public class TestChangeBuyPermissionCard {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false;
		ArrayList<BonusItem> bonuses=new ArrayList<BonusItem>();
		HashSet<City> cities=new HashSet<City>();
		Coins coins = new Coins(); 
		Region region = null; 
		PermissionCard card=new PermissionCard(bonuses, cities);
		try {
			@SuppressWarnings("unused")
			ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		Coins coins = null; 
		ArrayList<BonusItem> bonuses=new ArrayList<BonusItem>();
		HashSet<City> cities=new HashSet<City>();
		PermissionCard card=new PermissionCard(bonuses, cities);
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		try {
			@SuppressWarnings("unused")
			ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegion() {
		Coins coins = new Coins(); 
		ArrayList<BonusItem> bonuses=new ArrayList<BonusItem>();
		HashSet<City> cities=new HashSet<City>();
		PermissionCard card=new PermissionCard(bonuses, cities);
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region, card);
		Region temp = change.getRegion(); 
		assertEquals(temp, change.getRegion()); 
	}
	@Test
	public void testGetCoins() {
		Coins coins = new Coins(); 
		ArrayList<BonusItem> bonuses=new ArrayList<BonusItem>();
		HashSet<City> cities=new HashSet<City>();
		PermissionCard card=new PermissionCard(bonuses, cities);
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeBuyPermissionCard change = new ChangeBuyPermissionCard(coins, region, card);
		Coins temp = change.getCoins();  
		assertEquals(temp, change.getCoins()); 
	}

}
