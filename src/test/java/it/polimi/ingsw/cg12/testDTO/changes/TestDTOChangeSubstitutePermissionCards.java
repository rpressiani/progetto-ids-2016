package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeSubstitutePermissionCards;
import dto.map.DTORegion;
import dto.playerInfo.DTOAssistants;

public class TestDTOChangeSubstitutePermissionCards {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = null; 
		DTORegion region = new DTORegion("Ohio"); 
		try {
			@SuppressWarnings("unused")
			DTOChangeSubstitutePermissionCards change = 
					new DTOChangeSubstitutePermissionCards(assistants,region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(3); 
		DTORegion region = null; 
		try {
			@SuppressWarnings("unused")
			DTOChangeSubstitutePermissionCards change = 
					new DTOChangeSubstitutePermissionCards(assistants,region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testGetAssistants() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTORegion region = new DTORegion("Ohio"); 
		DTOChangeSubstitutePermissionCards change = 
				new DTOChangeSubstitutePermissionCards(assistants,region);
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void testGetRegion() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTORegion region = new DTORegion("Ohio"); 
		DTOChangeSubstitutePermissionCards change = 
				new DTOChangeSubstitutePermissionCards(assistants,region);
		assertEquals(region, change.getRegion()); 
	}

}
