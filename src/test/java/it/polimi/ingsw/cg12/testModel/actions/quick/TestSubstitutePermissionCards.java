package it.polimi.ingsw.cg12.testModel.actions.quick;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.quick.SubstitutePermissionCards;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestSubstitutePermissionCards {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		Region region = null; 
		try {
			SubstitutePermissionCards action = new SubstitutePermissionCards(region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside");
		SubstitutePermissionCards action = new SubstitutePermissionCards(region); 
		Player player2 = null; 
		try {
			action.doAction(player2, gameState);
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
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside");
		SubstitutePermissionCards action = new SubstitutePermissionCards(region); 
		GameState gameState2 = null;  
		try {
			action.doAction(player, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testDoActionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		Region region = gameState.getMap().getRegions().get("seaside");
		SubstitutePermissionCards action = new SubstitutePermissionCards(region); 
		int temp = player.getAssistants().getItems(); 
		action.doAction(player, gameState);
		assertTrue(temp==(player.getAssistants().getItems()+1)); 
	}
	@Test
	public void testCheckConditionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		Region region = gameState.getMap().getRegions().get("seaside");
		SubstitutePermissionCards action = new SubstitutePermissionCards(region); 
		assertTrue(action.checkCondition(player, gameState)); 
	}
	@Test
	public void testCheckCondition2() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		Region region = gameState.getMap().getRegions().get("seaside");
		SubstitutePermissionCards action = new SubstitutePermissionCards(region); 
		int temp = player.getAssistants().getItems(); 
		player.getAssistants().sub(temp);
		assertFalse(action.checkCondition(player, gameState)); 
	}

}
