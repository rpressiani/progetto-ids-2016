package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.changes.ChangeElectCounsellor;
import model.player.Coins;
import model.player.Player;
import utilities.Color;

public class TestChangeElectCounsellor {

	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		Coins coins = null; 
		Color color = new Color("red"); 
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		Coins coins = new Coins(); 
		Color color = null; 
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCoinsWorks() {
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		Coins coins = new Coins(); 
		Color color = new Color("red"); 
		ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color);
		Coins temp = change.getCoins();  
		assertEquals(change.getCoins(), temp); 
	}
	@Test
	public void testGetColorWorks() {
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		Coins coins = new Coins(); 
		Color color = new Color("red"); 
		ChangeElectCounsellor change = new ChangeElectCounsellor(coins, color);
		Color temp = change.getColor();  
		assertEquals(change.getColor(), temp); 
	}

}
