package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dto.changes.DTOChangeElectCounsellorWithAssistant;
import dto.playerInfo.DTOAssistants;
import dto.utilities.DTOColor;

public class TestDTOChangeElectCounsellorWithAssistant {


	@Test
	public void testNullAssistantsInConstructorThrowsException() {	
		boolean thrown = false; 
		DTOAssistants assistants = null;  
		DTOColor color = new DTOColor("red"); 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellorWithAssistant change = 
					new DTOChangeElectCounsellorWithAssistant(assistants, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(2);  
		DTOColor color = null; 
		try {
			@SuppressWarnings("unused")
			DTOChangeElectCounsellorWithAssistant change = 
					new DTOChangeElectCounsellorWithAssistant(assistants, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetAssistants() {
		DTOAssistants assistants = new DTOAssistants(2);  
		DTOColor color = new DTOColor("red"); 
		DTOChangeElectCounsellorWithAssistant change = 
				new DTOChangeElectCounsellorWithAssistant(assistants, color); 
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void testGetColor() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOColor color = new DTOColor("red"); 
		DTOChangeElectCounsellorWithAssistant change = 
				new DTOChangeElectCounsellorWithAssistant(assistants, color); 
		assertEquals(color, change.getColor()); 
	}
}
