package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOPlayer;
import dto.playerInfo.DTOScore;
import dto.queries.respond.DTOPlayerInfoResponse;
import dto.utilities.DTOColor;

public class TestDTOPlayerInfoResponse {

	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false; 
		DTOPlayer player = null;
		try {
			DTOPlayerInfoResponse response = new DTOPlayerInfoResponse(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetPlayer() {
		int id = 1; 
		String nickname = "Noodles"; 
		DTOColor color = new DTOColor("red"); 
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		DTOPlayer player = new DTOPlayer(id, nickname, color, coins, 
				assistants, nobilityLevel, score); 
		DTOPlayerInfoResponse response = new DTOPlayerInfoResponse(player);
		assertEquals(player, response.getPlayer()); 
	}
	@Test
	public void testSecondConstructor() {
		DTOPlayerInfoResponse response = new DTOPlayerInfoResponse();
		assertTrue(response.getPlayer()==null); 
	}
	
}

