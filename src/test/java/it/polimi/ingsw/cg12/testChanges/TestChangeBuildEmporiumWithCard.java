package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.changes.ChangeBuildEmporiumWithCard;
import model.map.City;
import model.player.Assistants;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestChangeBuildEmporiumWithCard {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>();
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities); 
		try {
			Assistants assistants = null; 
			@SuppressWarnings("unused")
			ChangeBuildEmporiumWithCard change = new ChangeBuildEmporiumWithCard(assistants, city, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>();
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities); 
		try {
			City city2 = null; 
			@SuppressWarnings("unused")
			ChangeBuildEmporiumWithCard change = new ChangeBuildEmporiumWithCard(player.getAssistants(), city2, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPermissionCardInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>();
		cities.add(city); 
		try {
			PermissionCard card2 = null; 
			@SuppressWarnings("unused")
			ChangeBuildEmporiumWithCard change = new ChangeBuildEmporiumWithCard(player.getAssistants(), city, card2); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCityWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>();
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities); 
		ChangeBuildEmporiumWithCard change = new ChangeBuildEmporiumWithCard(player.getAssistants(), city, card); 
		City temp = change.getCity();
		assertTrue(temp==change.getCity()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>();
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities); 
		ChangeBuildEmporiumWithCard change = new ChangeBuildEmporiumWithCard(player.getAssistants(), city, card); 
		Assistants temp = change.getAssistants(); 
		assertTrue(temp==change.getAssistants()); 
	}
	@Test
	public void testGetCardWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		HashSet<City> cities = new HashSet<City>();
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities); 
		ChangeBuildEmporiumWithCard change = new ChangeBuildEmporiumWithCard(player.getAssistants(), city, card); 
		PermissionCard temp = change.getCard(); 
		assertTrue(temp==change.getCard()); 
	}
}
