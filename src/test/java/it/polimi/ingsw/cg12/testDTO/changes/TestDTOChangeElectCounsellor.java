package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dto.changes.DTOChangeElectCounsellor;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;

public class TestDTOChangeElectCounsellor {

	@Test
	public void testNullCoinsInConstructorThrowsException() {	
		boolean thrown = false; 
		DTOCoins coins = null; 
		DTOColor color = new DTOColor("red"); 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellor change = 
					new DTOChangeElectCounsellor(coins, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = null; 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellor change = 
					new DTOChangeElectCounsellor(coins, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	
	@Test
	public void testGetCoins() {
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = new DTOColor("red"); 
		DTOChangeElectCounsellor change = 
				new DTOChangeElectCounsellor(coins, color); 
		assertEquals(coins, change.getCoins()); 
	}
	@Test
	public void testGetColor() {
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = new DTOColor("red"); 
		DTOChangeElectCounsellor change = 
				new DTOChangeElectCounsellor(coins, color); 
		assertEquals(color, change.getColor()); 
	}


}
