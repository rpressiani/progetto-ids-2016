package it.polimi.ingsw.cg12.testDTO.utilities;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dto.utilities.DTOColor;
import dto.utilities.DTOColorCounter;

public class TestDTOColorCounter {

	@Test
	public void testNullMapInConstructorThrowsException() {
		boolean thrown = false; 
		Map<DTOColor, Integer> structure = null; 
		try {
			DTOColorCounter counter = new DTOColorCounter(structure); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetStructure() {
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>();
		DTOColorCounter counter = new DTOColorCounter(structure); 
		assertEquals(structure, counter.getStructure()); 
	}

}
