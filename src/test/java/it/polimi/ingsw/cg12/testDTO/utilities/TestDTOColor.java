package it.polimi.ingsw.cg12.testDTO.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.utilities.DTOColor;

public class TestDTOColor {

	@Test
	public void testNullStringInConstructorThrowsException() {
		boolean thrown = false; 
		String string = null; 
		try {
			DTOColor color = new DTOColor(string); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetStringWorks() {
		String string = "ciao"; 
		DTOColor color = new DTOColor(string);
		String temp = color.getColorString(); 
		assertEquals(temp, color.getColorString()); 
	}

}
