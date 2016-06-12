package it.polimi.ingsw.cg12.testDTO.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.map.DTORegion;
import dto.utilities.DTOColor;

public class TestDTOElectCounsellorWithAssistant {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = null; 
		DTOColor color = new DTOColor("red"); 
		try {
			DTOElectCounsellorWithAssistant action = new DTOElectCounsellorWithAssistant(region, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = new DTORegion("California"); 
		DTOColor color = null; 
		try {
			DTOElectCounsellorWithAssistant action = new DTOElectCounsellorWithAssistant(region, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegionWorks() {
		DTORegion region = new DTORegion("California"); 
		DTOColor color = new DTOColor("red"); 
		DTOElectCounsellorWithAssistant action = new DTOElectCounsellorWithAssistant(region, color);
		assertEquals(region, action.getRegion()); 
	}
	@Test
	public void testGetColorWorks() {
		DTORegion region = new DTORegion("California"); 
		DTOColor color = new DTOColor("red"); 
		DTOElectCounsellorWithAssistant action = new DTOElectCounsellorWithAssistant(region, color);
		assertEquals(color, action.getColor()); 
	}

}
