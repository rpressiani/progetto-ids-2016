package it.polimi.ingsw.cg12.testDTO.playerInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTONobilityLevel;

public class TestDTONobilityLevel {

	@Test
	public void testWrongLevelInConstructorThrowsException() {
		boolean thrown = false; 
		int level = -2; 
		try {
			@SuppressWarnings("unused")
			DTONobilityLevel nobilityLevel = new DTONobilityLevel(level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfConstructorWorks() {
		boolean thrown = false; 
		int level = 0; 
		try {
			@SuppressWarnings("unused")
			DTONobilityLevel nobilityLevel = new DTONobilityLevel(level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
