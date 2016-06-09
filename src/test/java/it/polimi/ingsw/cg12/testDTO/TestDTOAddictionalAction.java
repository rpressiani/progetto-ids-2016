package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.main.DTOElectCounsellor;
import dto.actions.main.DTOMainAction;
import dto.actions.quick.DTOAddictionalAction;
import dto.map.DTORegion;
import dto.utilities.DTOColor;

public class TestDTOAddictionalAction {

	@Test
	public void testNullActionInConstructorThrowsException() {
		boolean thrown = false; 
		DTOMainAction mainAction = null;
		try {
			DTOAddictionalAction action = new DTOAddictionalAction(mainAction); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetActionWorks() {
		DTORegion region = new DTORegion("Lombardia"); 
		DTOColor color = new DTOColor("red"); 
		DTOMainAction mainAction = new DTOElectCounsellor(region, color);
		DTOAddictionalAction action = new DTOAddictionalAction(mainAction); 
		DTOMainAction temp = action.getAction(); 
		assertEquals(temp, action.getAction()); 
	}

}
