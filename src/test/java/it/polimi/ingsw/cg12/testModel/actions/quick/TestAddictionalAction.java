package it.polimi.ingsw.cg12.testModel.actions.quick;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.main.ElectCounsellor;
import model.actions.main.MainAction;
import model.actions.quick.AddictionalAction;
import model.council.GarbageState;
import model.map.Map;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestAddictionalAction {

	@Test
	public void testNullActionInConstructorThrowsException() {
		boolean thrown = false; 
		MainAction mainAction = null; 
		try {
			@SuppressWarnings("unused")
			AddictionalAction action = new AddictionalAction(mainAction); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfDoActionWorks() {
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		MainAction mainAction = new ElectCounsellor(region.getBalcony(), new Color("white")); 
		AddictionalAction action = new AddictionalAction(mainAction); 
		player.getAssistants().add(3);
		int temp = player.getAssistants().getItems(); 
		int temp2 = player.getCoins().getItems(); 
		action.doAction(player, gameState);
		assertTrue(temp==(player.getAssistants().getItems()+3) && temp2!=player.getCoins().getItems()); 
	}
/*	@Test
	public void testIfCheckConditionWorks() {
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		player2.getAssistants().add(6);
		player2.getCoins().add(10);
		MainAction mainAction = new ElectCounsellor(region, new Color("white")); 
		AddictionalAction action = new AddictionalAction(mainAction); 
		action.doAction(player2, gameState);
		boolean isMethodOk = false; 
		if(action.checkCondition(player2, gameState)) {
			isMethodOk = true; 
		}
		assertTrue(isMethodOk); 
	} */
	@Test
	public void testNullPlayerInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		MainAction mainAction = new ElectCounsellor(region.getBalcony(), new Color("white")); 
		AddictionalAction action = new AddictionalAction(mainAction);
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
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		MainAction mainAction = new ElectCounsellor(region.getBalcony(), new Color("white")); 
		AddictionalAction action = new AddictionalAction(mainAction);
		try {
			GameState gameState2 = null; 
			action.doAction(player2, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
