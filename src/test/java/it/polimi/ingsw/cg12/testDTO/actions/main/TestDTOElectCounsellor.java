package it.polimi.ingsw.cg12.testDTO.actions.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dto.actions.main.DTOElectCounsellor;
import dto.utilities.DTOColor;

public class TestDTOElectCounsellor {

	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		String balcony = new String("Lombardia"); 
		DTOColor color = null; 
		try {
			@SuppressWarnings("unused")
			DTOElectCounsellor action = new DTOElectCounsellor(balcony, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetColorWorks() {
		String balcony=new String("Campania");
		DTOColor color = new DTOColor("red");
		DTOElectCounsellor action = new DTOElectCounsellor(balcony, color); 
		DTOColor temp = action.getColor();
		assertEquals(temp, action.getColor()); 
	}

}
