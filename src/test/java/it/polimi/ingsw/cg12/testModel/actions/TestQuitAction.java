package it.polimi.ingsw.cg12.testModel.actions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.QuitAction;
import model.player.Player;
import parser.Parser;

public class TestQuitAction {

	@Test
	public void testNullPlayerInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players); 
		QuitAction action = new QuitAction(); 
		try {
			Player player3 = null; 
			action.doAction(player3, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInDoActionThrowsException() {
		boolean thrown = false; 
		Player player = new Player();  
		GameState gameState = null; 
		QuitAction action = new QuitAction(); 
		try {
			action.doAction(player, gameState);
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
		Player player2 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players); 
		QuitAction action = new QuitAction(); 
		try {
			Player player3 = null; 
			action.checkCondition(player3, gameState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInCheckConditionThrowsException() {
		boolean thrown = false; 
		Player player = new Player();  
		GameState gameState = null; 
		QuitAction action = new QuitAction(); 
		try {
			action.checkCondition(player, gameState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testCheckConditionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		Player player2 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players); 
		QuitAction action = new QuitAction(); 
		assertTrue(action.checkCondition(player, gameState)); 
	}

}
