package it.polimi.ingsw.cg12.testDTO.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.utilities.DTOPermissionCardSelection;

public class TestDTOPermissionCardSelection {

	@Test
	public void testNegativeIdInConstructorThrowsException() {
		boolean thrown = false; 
		try {
			@SuppressWarnings("unused")
			DTOPermissionCardSelection selection = 
					new DTOPermissionCardSelection(-2); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetId() {
		int id = 1; 
		DTOPermissionCardSelection selection = 
				new DTOPermissionCardSelection(id); 
		assertEquals(id, selection.getIdCard());
	}

}
