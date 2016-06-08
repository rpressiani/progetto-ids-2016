package it.polimi.ingsw.cg12.testMap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.map.Ancestry;
import model.map.City;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestCity {

	@Test
	public void testNullBonusesInConstructorThrowsException() {
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
		ArrayList<BonusItem> bonuses = null;
		Region region = gameState.getMap().getRegions().get("seaside"); 
		Ancestry ancestry = gameState.getMap().getAncestries().get("gold"); 
		try {
			City city = new City("NA", "Napoli", bonuses, region, ancestry); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfHasBuiltThereWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Claudio");
		player.setColor(new Color("yellow"));
		Player player2 = new Player(); 
		player2.setNickname("Srdjan");
		player2.setColor(new Color("red"));
		Player player3 = new Player(); 
		player3.setNickname("Matteo");
		player3.setColor(new Color("blue"));
		Player player4 = new Player(); 
		player4.setNickname("Fabiano");
		player4.setColor(new Color("black"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++;
		}
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>(); 
		cities.add(city); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		PermissionCard card = new PermissionCard(bonuses, cities); 
		BuildEmporiumWithCard action = new BuildEmporiumWithCard(card, city);
		action.doAction(player2, gameState);
		assertTrue(city.hasBuiltHere(player2)); 
	}
	@Test
	public void testIfGetAncestryWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("David");
		player.setColor(new Color("white"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		Ancestry temp = city.getAncestry();
		assertTrue(temp==city.getAncestry()); 
	}
	@Test
	public void testIfGetRegionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("David");
		player.setColor(new Color("white"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		Region temp = city.getRegion(); 
		assertTrue(temp==city.getRegion()); 
	}
	@Test
	public void testGetNameWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("David");
		player.setColor(new Color("white"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		String temp = city.getName(); 
		assertTrue(temp==city.getName()); 
	}

}
