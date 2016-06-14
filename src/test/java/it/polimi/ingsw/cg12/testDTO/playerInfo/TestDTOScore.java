package it.polimi.ingsw.cg12.testDTO.playerInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOScore;

public class TestDTOScore {

	@Test
	public void testWrongLevelInConstructorThrowsException() {
		boolean thrown = false; 
		int level = -1; 
		try {
			DTOScore score = new DTOScore(level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfConstructorWorks() {
		boolean thrown = false; 
		int level = 2; 
		try {
			DTOScore score = new DTOScore(level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertFalse(thrown); 
	}

}
