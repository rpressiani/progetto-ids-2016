package it.polimi.ingsw.cg12.testDTO.actions.quick;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.utilities.DTOColor;

public class TestDTOElectCounsellorWithAssistant {

	
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		String balcony=new String("California"); 
		DTOColor color = null; 
		try {
			@SuppressWarnings("unused")
			DTOElectCounsellorWithAssistant action = new DTOElectCounsellorWithAssistant(balcony, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	
	@Test
	public void testGetColorWorks() {
		String balcony=new String("California"); 
		DTOColor color = new DTOColor("red"); 
		DTOElectCounsellorWithAssistant action = new DTOElectCounsellorWithAssistant(balcony, color);
		assertEquals(color, action.getColor()); 
	}

}
