package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.quick.ChangePermissionCards;
import model.bonusable.PermissionCard;
import model.council.GarbageState;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestChangePermissionCards {

	@Test
	public void testNullRegionThrowsException() {
		boolean thrown = false; 
		Region region = null; 
		try {
			ChangePermissionCards action = new ChangePermissionCards(region); 
		}  catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test 
	public void testNullPlayerInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
		
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
		ChangePermissionCards action = new ChangePermissionCards(region); 
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
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
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
		GameState gameState2 = null; 
		Region region = map.getRegions().get("seaside");
		ChangePermissionCards action = new ChangePermissionCards(region);
		try {
			action.doAction(player2, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfDoActionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
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
		ChangePermissionCards action = new ChangePermissionCards(region); 
		int temp = player.getAssistants().getItems(); 
		action.doAction(player, gameState);
		assertTrue(temp>player.getAssistants().getItems()); 
	}
	@Test
	public void testExceptionInCheckCondition() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
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
		ChangePermissionCards action = new ChangePermissionCards(region); 
		try {
			Player pl = null; 
			action.checkCondition(pl, gameState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateThrowsExceptionInCheckCondition() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
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
		ChangePermissionCards action = new ChangePermissionCards(region); 
		GameState gameState2 = null; 
		try {
			action.checkCondition(player4, gameState2); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testCheckConditionReturnsFalseWithNoAssistants() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
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
		ChangePermissionCards action = new ChangePermissionCards(region); 
		boolean isMethodOk = false; 
		int temp = player2.getAssistants().getItems(); 
		player2.getAssistants().sub(temp);
		if(action.checkCondition(player2, gameState)) {
			isMethodOk = true; 
		}
		assertFalse(isMethodOk);  
	}
	@Test
	public void testCheckConditionReturnsTrueWithAtLeastOneAssistant() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
		player4.setColor(new Color("red"));
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
		ChangePermissionCards action = new ChangePermissionCards(region); 
		boolean isMethodOk = false; 
		if(action.checkCondition(player3, gameState)) {
			isMethodOk = true; 
		}
		assertTrue(isMethodOk);  
	}

}
