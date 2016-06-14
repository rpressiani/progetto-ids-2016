package it.polimi.ingsw.cg12.testDTO.utilities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.utilities.DTOBalcony;
import dto.utilities.DTOColor;

public class TestDTOBalcony {

	@Test
	public void testNullArrayListInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<DTOColor> balconyState = null;
		DTOBalcony balcony; 
		try {
			balcony = new DTOBalcony(balconyState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetBalconyState() {
		ArrayList<DTOColor> balconyState = new ArrayList<DTOColor>(); 
		DTOBalcony balcony = new DTOBalcony(balconyState); 
		assertEquals(balconyState, balcony.getBalconyState()); 
	}
}
