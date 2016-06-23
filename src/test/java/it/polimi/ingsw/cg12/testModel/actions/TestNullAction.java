package it.polimi.ingsw.cg12.testModel.actions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.NullAction;
import model.player.Player;
import parser.Parser;

public class TestNullAction {

	@Test
	public void testNullPlayerInDoActionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		NullAction action = new NullAction(); 
		try {
			Player player2 = null; 
			action.doAction(player2, gameState);
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
		NullAction action = new NullAction(); 
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
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		NullAction action = new NullAction(); 
		try {
			Player player2 = null; 
			action.checkCondition(player2, gameState); 
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
		NullAction action = new NullAction(); 
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
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		NullAction action = new NullAction(); 
		assertTrue(action.checkCondition(player, gameState)); 
	}

}
