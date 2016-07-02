package it.polimi.ingsw.cg12.testDTO.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.map.DTORegion;

public class TestDTORegion {

	@Test
	public void testNullStringInConstructorThrowsException() {
		boolean thrown = false; 
		String name = null; 
		try {
			DTORegion region = new DTORegion(name); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfConstructorWorks() {
		boolean thrown = false; 
		String name = "Campania"; 
		try {
			DTORegion region = new DTORegion(name); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertFalse(thrown);
	}

}
