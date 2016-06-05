package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTONobilityLevel;

public class TestDTONobilityLevel {

	@Test
	public void testWrongLevelInConstructorThrowsException() {
		boolean thrown = false; 
		int level = -2; 
		try {
			DTONobilityLevel nobilityLevel = new DTONobilityLevel(level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
	}
	@Test
	public void testIfConstructorWorks() {
		boolean thrown = false; 
		int level = 0; 
		try {
			DTONobilityLevel nobilityLevel = new DTONobilityLevel(level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
