package it.polimi.ingsw.cg12.testStateMachine.state;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.market.BuyAction;
import model.market.Contract;
import model.player.Player;
import model.stateMachine.CanBuyState;
import parser.Parser;

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
		Contract contract = new Contract(player);
		BuyAction action = new BuyAction(contract); 
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
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		Contract contract = new Contract(player); 
		BuyAction action = new BuyAction(contract); 
		try {
			GameState gameState2 = null; 
			state.transition(player, action, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

	@Test
	public void testTransition() {
		
	}

}
