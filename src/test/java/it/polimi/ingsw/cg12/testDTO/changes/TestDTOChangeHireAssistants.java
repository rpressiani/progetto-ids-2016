package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeHireAssistants;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;

public class TestDTOChangeHireAssistants {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = null; 
		DTOCoins coins = new DTOCoins(3); 
		try {
			DTOChangeHireAssistants change = 
					new DTOChangeHireAssistants(assistants, coins); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(4); 
		DTOCoins coins = null; 
		try {
			DTOChangeHireAssistants change = 
					new DTOChangeHireAssistants(assistants, coins); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetAssistants() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = new DTOCoins(3); 
		DTOChangeHireAssistants change = 
				new DTOChangeHireAssistants(assistants, coins); 
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void getCoins() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = new DTOCoins(3); 
		DTOChangeHireAssistants change = 
				new DTOChangeHireAssistants(assistants, coins); 
		assertEquals(coins, change.getCoins());
	}

}
