package it.polimi.ingsw.cg12.testStateMachine.state;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.NullAction;
import model.actions.quick.HireAssistant;
import model.player.Player;
import model.stateMachine.CanQuickOrNullState;
import model.stateMachine.CanSellState;
import parser.Parser;
import utilities.Color;

public class TestCanQuickOrNullState {

	@Test
	public void testNullPlayerInTransitionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		CanQuickOrNullState state = new CanQuickOrNullState(); 
		HireAssistant action = new HireAssistant(); 
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
		Parser parser = new Parser();
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		CanQuickOrNullState state = new CanQuickOrNullState(); 
		HireAssistant action = null; 
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
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		CanQuickOrNullState state = new CanQuickOrNullState(); 
		HireAssistant action = new HireAssistant(); 
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
		Parser parser = new Parser();
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		CanQuickOrNullState state = new CanQuickOrNullState(); 
		HireAssistant action = new HireAssistant(); 
		player.getCoins().add(10);
		player.getAssistants().add(10);
		state.transition(player, action, gameState);
		assertTrue(player.getState() instanceof CanSellState); 
	}
	@Test
	public void testTransitionWithNullAction() {
		Parser parser = new Parser();
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		CanQuickOrNullState state = new CanQuickOrNullState(); 
		NullAction action = new NullAction(); 
		state.transition(player, action, gameState);
		assertTrue(player.getState() instanceof CanSellState); 
	}
}
