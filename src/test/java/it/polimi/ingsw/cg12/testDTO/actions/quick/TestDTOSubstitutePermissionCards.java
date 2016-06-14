package it.polimi.ingsw.cg12.testDTO.actions.quick;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.quick.DTOSubstitutePermissionCards;
import dto.map.DTORegion;

public class TestDTOSubstitutePermissionCards {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = null;
		try {
			DTOSubstitutePermissionCards action = new DTOSubstitutePermissionCards(region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegionWorks() {
		DTORegion region = new DTORegion("Lombardia"); 
		DTOSubstitutePermissionCards action = new DTOSubstitutePermissionCards(region);  
		assertEquals(region, action.getRegion()); 
	}

}
