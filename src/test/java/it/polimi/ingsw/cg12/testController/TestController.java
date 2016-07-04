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
}
