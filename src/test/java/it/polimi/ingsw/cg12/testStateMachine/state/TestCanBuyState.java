package it.polimi.ingsw.cg12.testStateMachine.state;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.market.BuyAction;
import model.player.Player;
import model.stateMachine.state.CanBuyState;
import model.stateMachine.state.State;
import parser.Parser;
import utilities.Color;

public class TestCanBuyState {

	@Test
	public void testNullPlayerInTransitionThrowsException() {
		boolean thrown = false; 
		CanBuyState state = new CanBuyState(); 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		BuyAction action = new BuyAction(); 
		try {
			Player player2 = null; 
			state.transition(player2, action, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullActionInTransitionThrowsException() {
		boolean thrown = false; 
		CanBuyState state = new CanBuyState(); 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		BuyAction action = null; 
		try {
			state.transition(player, action, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInTransitionThrowsException() {
		boolean thrown = false; 
		CanBuyState state = new CanBuyState(); 
		Parser parser = new Parser(); 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		BuyAction action = new BuyAction(); 
		try {
			GameState gameState2 = null; 
			state.transition(player, action, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testCheckTurn() {
		Parser parser = new Parser(); 
		Player player = new Player();
		Player player2 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players);
		CanBuyState state = new CanBuyState();
		state.checkTurn(player, gameState);
		assertTrue(gameState.getCurrentPlayer()==player2); 
	}
	@Test
	public void testTransition() {
		
	}

}
