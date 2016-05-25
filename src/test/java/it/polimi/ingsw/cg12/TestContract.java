package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.market.Contract;
import model.player.Player;
import utilities.Color;

public class TestContract {

	@Test
	public void testNullPlayerThrowsException() {
		boolean thrown = false; 
		Player player = null; 
		try {
			Contract contract = new Contract(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNegativeNCoinsThrowException() {
		boolean thrown = false; 
		Player player = new Player("Ezio", new Color(4,5,6));
		Contract contract = new Contract(player); 
		try {
			contract.sellCoins(-1);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNegativeNAssistantsThrowException() {
		boolean thrown = false; 
		Player player = new Player("Matt", new Color(7,8,9));
		Contract contract = new Contract(player); 
		try {
			contract.sellAssistants(0);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
