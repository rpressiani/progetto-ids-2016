package it.polimi.ingsw.cg12.testDTO.map;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.map.DTOCity;

public class TestDTOCity {

	@Test
	public void testNullNameInConstructorThrowsException() {
		boolean thrown = false; 
		String name = null; 
		try {
			DTOCity city = new DTOCity(name); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfConstructorWorks() {
		boolean thrown = false; 
		String name = "Napoli"; 
		try {
			DTOCity city = new DTOCity(name); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
