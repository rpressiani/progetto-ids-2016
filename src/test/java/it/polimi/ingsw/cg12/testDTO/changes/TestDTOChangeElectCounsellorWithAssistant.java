package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeElectCounsellor;
import dto.changes.DTOChangeElectCounsellorWithAssistant;
import dto.map.DTORegion;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;

public class TestDTOChangeElectCounsellorWithAssistant {


	@Test
	public void testNullAssistantsInConstructorThrowsException() {	
		boolean thrown = false; 
		DTOAssistants assistants = null;  
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		try {
			DTOChangeElectCounsellorWithAssistant change = 
					new DTOChangeElectCounsellorWithAssistant(assistants, color, region); 
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
		DTORegion region = new DTORegion("Campania"); 
		try {
			DTOChangeElectCounsellorWithAssistant change = 
					new DTOChangeElectCounsellorWithAssistant(assistants, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(23); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = null; 
		try {
			DTOChangeElectCounsellorWithAssistant change = 
					new DTOChangeElectCounsellorWithAssistant(assistants, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetAssistants() {
		DTOAssistants assistants = new DTOAssistants(2);  
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		DTOChangeElectCounsellorWithAssistant change = 
				new DTOChangeElectCounsellorWithAssistant(assistants, color, region); 
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void testGetColor() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		DTOChangeElectCounsellorWithAssistant change = 
				new DTOChangeElectCounsellorWithAssistant(assistants, color, region); 
		assertEquals(color, change.getColor()); 
	}
	@Test
	public void testGetRegion() {
		DTOAssistants assistants = new DTOAssistants(2); 
		DTOColor color = new DTOColor("red"); 
		DTORegion region = new DTORegion("Campania"); 
		DTOChangeElectCounsellorWithAssistant change = 
				new DTOChangeElectCounsellorWithAssistant(assistants, color, region); 
		assertEquals(region, change.getRegion()); 
	}
}
