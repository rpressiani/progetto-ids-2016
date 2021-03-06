package it.polimi.ingsw.cg12.testDTO.playerInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOAssistants;

public class TestDTOAssistants {

	@Test
	public void testWrongQuantityInConstructorThrowsException() {
		boolean thrown = false; 
		int quantity = -3; 
		try {
			@SuppressWarnings("unused")
			DTOAssistants assistants = new DTOAssistants(quantity); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIFConstructorWorks() {
		boolean thrown = false;
		int quantity = 0; 
		try {
			@SuppressWarnings("unused")
			DTOAssistants assistants = new DTOAssistants(quantity); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
