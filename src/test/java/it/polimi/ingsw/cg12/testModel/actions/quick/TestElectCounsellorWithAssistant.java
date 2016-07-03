package it.polimi.ingsw.cg12.testModel.actions.quick;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.council.GarbageState;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestElectCounsellorWithAssistant {

	@Test
	public void testNullColorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		Region region = map.getRegions().get("seaside"); 
		Color color = null; 
		@SuppressWarnings("unused")
		ElectCounsellorWithAssistant action; 
		try {
			action = new ElectCounsellorWithAssistant(region.getBalcony(), color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/*@Test
	public void testIfDoActionWorks() {
		Parser parser = new Parser();
		
		Player player = new Player();
		player.setNickname("Alessandro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Riccardo");
		player2.setColor(new Color("grey"));
		Player player3 = new Player();
		player3.setNickname("Matteo");
		player3.setColor(new Color("red"));
		Player player4 = new Player();
		player4.setNickname("Stefano");
		player4.setColor(new Color("yellow"));
		
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		Region region = map.getRegions().get("seaside"); 
		ElectCounsellorWithAssistant action = 
				new ElectCounsellorWithAssistant(region, new Color("orange")); 
		int temp = player3.getAssistants().getItems(); 
		action.doAction(player3, gameState);
<<<<<<< HEAD
		assertTrue(temp==(player3.getAssistants().getItems()+1));  
	}
=======
		assertTrue(temp!=player3.getAssistants().getItems());  
	}*/

	/*@Test
	public void testIfCheckConditionWorks() {
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Alessandro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Riccardo");
		player2.setColor(new Color("grey"));
		Player player3 = new Player();
		player3.setNickname("Matteo");
		player3.setColor(new Color("red"));
		Player player4 = new Player();
		player4.setNickname("Stefano");
		player4.setColor(new Color("yellow")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		Region region = map.getRegions().get("seaside"); 
		ElectCounsellorWithAssistant action = 
				new ElectCounsellorWithAssistant(region, new Color("orange")); 
		boolean isMethodOk = false; 
		if(action.checkCondition(player2, gameState)) {
			isMethodOk = true; 
		}
		assertTrue(isMethodOk); 
	}*/
	@Test 
	public void testNullPlayerInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Alessandro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Riccardo");
		player2.setColor(new Color("grey"));
		Player player3 = new Player();
		player3.setNickname("Matteo");
		player3.setColor(new Color("red"));
		Player player4 = new Player();
		player4.setNickname("Stefano");
		player4.setColor(new Color("yellow")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		Region region = map.getRegions().get("seaside"); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		ElectCounsellorWithAssistant action = 
				new ElectCounsellorWithAssistant(region.getBalcony(), new Color("yellow")); 
		try {
			Player pl = null; 
			action.doAction(pl, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Alessandro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Riccardo");
		player2.setColor(new Color("grey"));
		Player player3 = new Player();
		player3.setNickname("Matteo");
		player3.setColor(new Color("red"));
		Player player4 = new Player();
		player4.setNickname("Stefano");
		player4.setColor(new Color("yellow")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		Region region = map.getRegions().get("seaside"); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		ElectCounsellorWithAssistant action = 
				new ElectCounsellorWithAssistant(region.getBalcony(), new Color("yellow")); 
		try {
			GameState gameState2 = null; 
			action.doAction(player, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInCheckConditionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Alessandro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Riccardo");
		player2.setColor(new Color("grey"));
		Player player3 = new Player();
		player3.setNickname("Matteo");
		player3.setColor(new Color("red"));
		Player player4 = new Player();
		player4.setNickname("Stefano");
		player4.setColor(new Color("yellow")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		Region region = map.getRegions().get("seaside"); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		ElectCounsellorWithAssistant action = 
				new ElectCounsellorWithAssistant(region.getBalcony(), new Color("yellow")); 
		try {
			Player pl = null; 
			action.checkCondition(pl, gameState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInCheckConditionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Alessandro");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Riccardo");
		player2.setColor(new Color("grey"));
		Player player3 = new Player();
		player3.setNickname("Matteo");
		player3.setColor(new Color("red"));
		Player player4 = new Player();
		player4.setNickname("Stefano");
		player4.setColor(new Color("yellow")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser);
		Map map = new Map(parser, garbageState); 
		Region region = map.getRegions().get("seaside"); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		ElectCounsellorWithAssistant action = 
				new ElectCounsellorWithAssistant(region.getBalcony(), new Color("yellow")); 
		try {
			GameState gameState2 = null; 
			action.checkCondition(player3, gameState2); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
