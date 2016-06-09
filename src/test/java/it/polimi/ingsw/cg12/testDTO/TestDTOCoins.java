package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOCoins;

public class TestDTOCoins {

	@Test
	public void testWrongQuantityInConstructorThrowsException() {
		boolean thrown = false; 
		int quantity = -1; 
		try {
			DTOCoins coins = new DTOCoins(quantity); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfConstructorWorks() {
		boolean thrown = false; 
		int quantity = 2; 
		try {
			DTOCoins coins = new DTOCoins(quantity); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
