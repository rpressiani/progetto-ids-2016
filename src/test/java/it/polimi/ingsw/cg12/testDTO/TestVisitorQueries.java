package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.queries.VisitorQueries;
import model.GameState;
import model.player.Player;
import parser.Parser;

public class TestVisitorQueries {

	@Test
	public void testNullGameStateInConstructorThrowsException() {
		boolean thrown = false; 
		GameState gameState = null;
		Player player = new Player();
		try {
			VisitorQueries query = new VisitorQueries(gameState, player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		Player player2 = null; 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		try {
			VisitorQueries query = new VisitorQueries(gameState, player2); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
