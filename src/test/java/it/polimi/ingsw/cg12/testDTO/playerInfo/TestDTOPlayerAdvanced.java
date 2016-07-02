package it.polimi.ingsw.cg12.testDTO.playerInfo;

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
import dto.utilities.DTOColor;
import dto.utilities.DTOColorCounter;
import dto.utilities.DTOPermissionCard;

public class TestDTOPlayerAdvanced {

	@Test
	public void testNullPoliticalHandInConstructorThrowsException() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red");
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		//Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = null; 
		ArrayList<DTOPermissionCard> permissionCards = new ArrayList<DTOPermissionCard>(); 
		ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>(); 
		try {
			@SuppressWarnings("unused")
			DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, coins, 
					assistants, nobilityLevel, score, 
						politicalHand, permissionCards, builtCities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPermissionCardsInConstructorThrowsException() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red");
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = new DTOColorCounter(structure); 
		ArrayList<DTOPermissionCard> permissionCards = null; 
		ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>(); 
		try {
			@SuppressWarnings("unused")
			DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, coins, 
					assistants, nobilityLevel, score, 
						politicalHand, permissionCards, builtCities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void test() {
		boolean thrown = false; 
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red");
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = new DTOColorCounter(structure); 
		ArrayList<DTOPermissionCard> permissionCards = new ArrayList<DTOPermissionCard>(); 
		ArrayList<DTOCity> builtCities = null; 
		try {
			@SuppressWarnings("unused")
			DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, coins, 
					assistants, nobilityLevel, score, 
						politicalHand, permissionCards, builtCities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetPoliticalHand() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red");
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = new DTOColorCounter(structure); 
		ArrayList<DTOPermissionCard> permissionCards = new ArrayList<DTOPermissionCard>(); 
		ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>(); 
		DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, coins, 
				assistants, nobilityLevel, score, 
					politicalHand, permissionCards, builtCities);
		assertEquals(politicalHand, player.getPoliticalHand()); 
	}
	@Test
	public void testGetPermissionCards() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red");
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = new DTOColorCounter(structure); 
		ArrayList<DTOPermissionCard> permissionCards = new ArrayList<DTOPermissionCard>(); 
		ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>(); 
		DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, coins, 
				assistants, nobilityLevel, score, 
					politicalHand, permissionCards, builtCities);
		assertEquals(permissionCards, player.getPermissionCards());
	}
	@Test
	public void testGetBuiltCities() {
		int id = 1; 
		String nickname = "Ale"; 
		DTOColor color = new DTOColor("red");
		DTOCoins coins = new DTOCoins(2); 
		DTOAssistants assistants = new DTOAssistants(2); 
		DTONobilityLevel nobilityLevel = new DTONobilityLevel(2); 
		DTOScore score = new DTOScore(2); 
		Map<DTOColor, Integer> structure = new HashMap<DTOColor, Integer>(); 
		DTOColorCounter politicalHand = new DTOColorCounter(structure); 
		ArrayList<DTOPermissionCard> permissionCards = new ArrayList<DTOPermissionCard>(); 
		ArrayList<DTOCity> builtCities = new ArrayList<DTOCity>(); 
		DTOPlayerAdvanced player = new DTOPlayerAdvanced(id, nickname, color, coins, 
				assistants, nobilityLevel, score, 
					politicalHand, permissionCards, builtCities);
		assertEquals(builtCities, player.getBuiltCities()); 
	}

}