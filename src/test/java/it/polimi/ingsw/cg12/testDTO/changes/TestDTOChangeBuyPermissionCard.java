package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeBuyPermissionCard;
import dto.map.DTORegion;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOPermissionCardSelection;

public class TestDTOChangeBuyPermissionCard {

	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = null; 
		DTORegion region = new DTORegion("Ohio"); 
		DTOPermissionCardSelection card=new DTOPermissionCardSelection(1);
		try {
			DTOChangeBuyPermissionCard change = 
					new DTOChangeBuyPermissionCard(coins, region,card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = new DTOCoins(3); 
		DTORegion region = null; 
		DTOPermissionCardSelection card=new DTOPermissionCardSelection(1);
		try {
			DTOChangeBuyPermissionCard change = 
					new DTOChangeBuyPermissionCard(coins, region, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCoins() {
		DTOCoins coins = new DTOCoins(3); 
		DTORegion region = new DTORegion("California"); 
		DTOPermissionCardSelection card=new DTOPermissionCardSelection(1);
		DTOChangeBuyPermissionCard change = 
				new DTOChangeBuyPermissionCard(coins, region, card); 
		assertEquals(coins, change.getCoins()); 
	}
	@Test
	public void testGetRegion() {
		DTOCoins coins = new DTOCoins(3); 
		DTORegion region = new DTORegion("California"); 
		DTOPermissionCardSelection card=new DTOPermissionCardSelection(1);
		DTOChangeBuyPermissionCard change = 
				new DTOChangeBuyPermissionCard(coins, region, card); 
		assertEquals(region, change.getRegion()); 
	}
	

}
