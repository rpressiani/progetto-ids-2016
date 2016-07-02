package it.polimi.ingsw.cg12.testDTO.playerInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOCoins;

public class TestDTOCoins {

	@Test
	public void testWrongQuantityInConstructorThrowsException() {
		boolean thrown = false; 
		int quantity = -1; 
		try {
			@SuppressWarnings("unused")
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
			@SuppressWarnings("unused")
			DTOCoins coins = new DTOCoins(quantity); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
