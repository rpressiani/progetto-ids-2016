package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dto.map.DTOCity;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOPlayerAdvanced;
import dto.playerInfo.DTOScore;
import dto.queries.respond.DTOPlayerInfoAdvancedResponse;
import dto.utilities.DTOColor;
import dto.utilities.DTOColorCounter;
import dto.utilities.DTOPermissionCard;

public class TestDTOPlayerInfoAdvancedResponse {

	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false; 
		DTOPlayerAdvanced player = null;
		try {
			DTOPlayerInfoAdvancedResponse response = 
					new DTOPlayerInfoAdvancedResponse(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetPlayer() {
		int id = 1; 
		String nickname = "Dexter";
		DTOColor color = new DTOColor("red");
		DTOAssistants assistants = new DTOAssistants(2); 
		DTOCoins coins = new DTOCoins(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = new DTOColorCounter(structure); 
		ArrayList<DTOPermissionCard> permissionCards = 
				new ArrayList<DTOPermissionCard>();
		ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>();
		DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, 
				coins, assistants, nobilityLevel, score,
					politicalHand, permissionCards, builtCities); 
		DTOPlayerInfoAdvancedResponse response = 
				new DTOPlayerInfoAdvancedResponse(player);
		assertEquals(player, response.getPlayer()); 

	}

}
