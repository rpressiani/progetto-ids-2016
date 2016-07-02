package it.polimi.ingsw.cg12.testMarket;

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
			@SuppressWarnings("unused")
			Contract contract = new Contract(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNegativeNCoinsThrowException() {
		boolean thrown = false; 
		Player player = new Player();
		player.setNickname("Matt");
		player.setColor(new Color("black"));
		Contract contract = new Contract(player); 
		try {
			contract.sellCoins(-1);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPermissionCardThrowsException() {
		boolean thrown = false; 
		Player player = new Player();
		player.setNickname("Matt");
		player.setColor(new Color("black"));
		Contract contract = new Contract(player); 
		try {
			contract.buyPermissionCard(null);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
