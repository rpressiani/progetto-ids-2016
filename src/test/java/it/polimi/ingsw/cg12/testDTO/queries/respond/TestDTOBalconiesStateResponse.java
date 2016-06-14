package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dto.queries.respond.DTOBalconiesStateResponse;
import dto.utilities.DTOBalcony;

public class TestDTOBalconiesStateResponse {

	@Test
	public void testNullMapInConstructorThrowsException() {
		boolean thrown = false; 
		Map<String, DTOBalcony> balconies = null; 
		try {
			DTOBalconiesStateResponse response = new DTOBalconiesStateResponse(balconies); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetMap() {
		Map<String, DTOBalcony> balconies = new HashMap<String, DTOBalcony>();
		DTOBalconiesStateResponse response = new DTOBalconiesStateResponse(balconies);
		assertEquals(balconies, response.getBalconies()); 
	}

}
