package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;	

import org.junit.Test;

import dto.changes.DTOChangePlayerStatus;
import dto.playerInfo.DTOPlayerAdvanced;


public class TestDTOChangePlayerStatus {

	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		
		DTOPlayerAdvanced player = null;
		
		try {
			DTOChangePlayerStatus change = 
					new DTOChangePlayerStatus(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}