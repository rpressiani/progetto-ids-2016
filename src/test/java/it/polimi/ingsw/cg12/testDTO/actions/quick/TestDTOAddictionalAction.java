package it.polimi.ingsw.cg12.testDTO.actions.quick;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dto.actions.main.DTOElectCounsellor;
import dto.actions.main.DTOMainAction;
import dto.actions.quick.DTOAddictionalAction;
import dto.utilities.DTOColor;

public class TestDTOAddictionalAction {

	@Test
	public void testNullActionInConstructorThrowsException() {
		boolean thrown = false; 
		DTOMainAction mainAction = null;
		try {
			@SuppressWarnings("unused")
			DTOAddictionalAction action = new DTOAddictionalAction(mainAction); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetActionWorks() {
		String balcony=new String("Lombardia"); 
		DTOColor color = new DTOColor("red"); 
		DTOMainAction mainAction = new DTOElectCounsellor(balcony, color);
		DTOAddictionalAction action = new DTOAddictionalAction(mainAction); 
		DTOMainAction temp = action.getAction(); 
		assertEquals(temp, action.getAction()); 
	}

}
