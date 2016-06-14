package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangePlayerStatus;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOScore;

public class TestDTOChangePlayerStatus {

	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = null;
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = new DTOScore(3);
		try {
			DTOChangePlayerStatus change = 
					new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = null; 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = new DTOScore(3);
		try {
			DTOChangePlayerStatus change = 
					new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullNobilityLevelInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = null;
		DTOScore score = new DTOScore(3);
		try {
			DTOChangePlayerStatus change = 
					new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullScoreInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = null;
		try {
			DTOChangePlayerStatus change = 
					new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCoins() {
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = new DTOScore(3);
		DTOChangePlayerStatus change = 
				new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score);
		assertEquals(coins, change.getCoins()); 
	}
	@Test
	public void testGetAssistants() {
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = new DTOScore(3);
		DTOChangePlayerStatus change = 
				new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score);
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void testGetNobilityLevel() {
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = new DTOScore(3);
		DTOChangePlayerStatus change = 
				new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score);
		assertEquals(nobilityLevel, change.getNobilityLevel()); 
	}
	@Test
	public void testGetScore() {
		DTOCoins coins = new DTOCoins(3);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(4);
		DTOScore score = new DTOScore(3);
		DTOChangePlayerStatus change = 
				new DTOChangePlayerStatus(coins, assistants, nobilityLevel, score);
		assertEquals(score, change.getScore()); 
	}

}
