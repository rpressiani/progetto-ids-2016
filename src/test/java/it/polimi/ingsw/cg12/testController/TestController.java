package it.polimi.ingsw.cg12.testController;

import static org.junit.Assert.*;


import org.junit.Test;

import controller.Controller;
import model.GameState;

public class TestController {

	@Test
	public void testNullGameStateInConstructorThrowsException() {
		boolean thrown = false; 
		GameState gameState = null; 
		try {
			@SuppressWarnings("unused")
			Controller controller = new Controller(gameState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/*@Test
	public void testIfUpdateWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Controller controller = new Controller(gameState); 
	} */
}
