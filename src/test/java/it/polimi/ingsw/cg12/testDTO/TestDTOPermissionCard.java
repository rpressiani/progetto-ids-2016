package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.utilities.DTOPermissionCardSelection;

public class TestDTOPermissionCard {

	@Test
	public void testNegativeIdThrowsException() {
		boolean thrown = false; 
		int id = -1; 
		try {
			DTOPermissionCardSelection card = new DTOPermissionCardSelection(id); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetIdWorks() {
		int id = 1; 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(id); 
		int temp = card.getIdCard(); 
		assertEquals(temp, card.getIdCard()); 
	}

}
