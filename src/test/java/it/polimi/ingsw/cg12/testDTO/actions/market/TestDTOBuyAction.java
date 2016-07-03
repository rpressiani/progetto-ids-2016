package it.polimi.ingsw.cg12.testDTO.actions.market;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.market.DTOBuyAction;

public class TestDTOBuyAction {

	@Test
	public void testNegativeIntegerInConstructorThrowsException() {
		boolean thrown = false;  
		try {
			@SuppressWarnings("unused")
			DTOBuyAction action = new DTOBuyAction(-1); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	
	@Test
	public void testGetIdContract() {
		int i=1; 
		DTOBuyAction action = new DTOBuyAction(i); 
		assertEquals(i, action.getIdContract()); 
	}

}
