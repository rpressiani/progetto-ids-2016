package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeElectCounsellor;
import dto.map.DTORegion;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;

public class TestDTOChangeElectCounsellor {

	@Test
	public void testNullCoinsInConstructorThrowsException() {	
		boolean thrown = false; 
		DTOCoins coins = null; 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellor change = 
					new DTOChangeElectCounsellor(coins, color, region); 
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
		DTORegion region = new DTORegion("Campania"); 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellor change = 
					new DTOChangeElectCounsellor(coins, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = null; 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellor change = 
					new DTOChangeElectCounsellor(coins, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCoins() {
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		DTOChangeElectCounsellor change = 
				new DTOChangeElectCounsellor(coins, color, region); 
		assertEquals(coins, change.getCoins()); 
	}
	@Test
	public void testGetColor() {
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		DTOChangeElectCounsellor change = 
				new DTOChangeElectCounsellor(coins, color, region); 
		assertEquals(color, change.getColor()); 
	}
	@Test
	public void testGetRegion() {
		DTOCoins coins = new DTOCoins(3); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		DTOChangeElectCounsellor change = 
				new DTOChangeElectCounsellor(coins, color, region); 
		assertEquals(region, change.getRegion()); 
	}

}
