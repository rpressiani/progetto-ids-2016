package it.polimi.ingsw.cg12.testStateMachine.state;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.quick.HireAssistant;
import model.player.Player;
import model.stateMachine.CanMainState;
import model.stateMachine.StartState;
import parser.Parser;
import utilities.Color;

public class TestStartState {

	@Test
	public void testCheckTurn() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("ale");
		player.setColor(new Color("red"));
		Player player2 = new Player();
		player2.setNickname("ricky");
		player2.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players); 
		StartState state = new StartState(); 
		state.checkTurn(player, gameState);
		assertEquals(gameState.getCurrentPlayer(), player2); 
	}
	@Test
	public void testTransition() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("ale");
		player.setColor(new Color("red"));
		Player player2 = new Player();
		player2.setNickname("ricky");
		player2.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		StartState state = new StartState(); 
		HireAssistant action = new HireAssistant();
		state.transition(player, action, gameState);
		assertTrue(player.getState() instanceof CanMainState); 
	}
}
