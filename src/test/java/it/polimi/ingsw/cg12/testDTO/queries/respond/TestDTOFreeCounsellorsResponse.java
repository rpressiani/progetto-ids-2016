package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dto.queries.respond.DTOFreeCounsellorsResponse;
import dto.utilities.DTOColor;
import dto.utilities.DTOColorCounter;

public class TestDTOFreeCounsellorsResponse {

	@Test
	public void testNullColorCounterInConstructorThrowsException() {
		boolean thrown = false; 
		DTOColorCounter garbageStatus = null;
		try {
			@SuppressWarnings("unused")
			DTOFreeCounsellorsResponse response = 
					new DTOFreeCounsellorsResponse(garbageStatus); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetGarbageStatus() {
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>();
		DTOColorCounter garbageStatus = new DTOColorCounter(structure);
		DTOFreeCounsellorsResponse response = 
				new DTOFreeCounsellorsResponse(garbageStatus); 
		assertEquals(garbageStatus, response.getGarbageStatus()); 
	}

}
