package it.polimi.ingsw.cg12.testDTO.playerInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOPlayer;
import dto.playerInfo.DTOScore;
import dto.utilities.DTOColor;

public class TestDTOPlayer {

	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = null;
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = new DTOScore(2);
		try {
			DTOPlayer player = new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = null;
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = new DTOScore(2);
		try {
			DTOPlayer player = new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testNullNobilityLevelInConstructorThrowsException() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = null;
		DTOScore score = new DTOScore(2);
		try {
			DTOPlayer player = new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testNullScoreInConstructorThrowsException() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = null;
		try {
			DTOPlayer player = new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testGetCoins() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = new DTOScore(2);
		DTOPlayer player = 
				new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score);
		assertEquals(coins, player.getCoins()); 
		
	}
	@Test
	public void testGetAssistants() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = new DTOScore(2);
		DTOPlayer player = 
				new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score);
		assertEquals(assistants, player.getAssistants()); 
	}
	@Test
	public void testGetNobilityLevel() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = new DTOScore(2);
		DTOPlayer player = 
				new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score);
		assertEquals(nobilityLevel, player.getNobilityLevel()); 
	}
	@Test
	public void testGetScore() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2);
		DTOAssistants assistants = new DTOAssistants(2);
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2);
		DTOScore score = new DTOScore(2);
		DTOPlayer player = 
				new DTOPlayer(id, nickname, color, coins, assistants, nobilityLevel, score);
		assertEquals(score, player.getScore()); 
	}

}
