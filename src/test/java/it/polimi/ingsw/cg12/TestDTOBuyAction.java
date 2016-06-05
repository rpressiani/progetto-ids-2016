package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.market.DTOBuyAction;

public class TestDTOBuyAction {

	@Test
	public void testNullStringInConstructorThrowsException() {
		boolean thrown = false; 
		String name = null; 
		try {
			DTOBuyAction action = new DTOBuyAction(name); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
