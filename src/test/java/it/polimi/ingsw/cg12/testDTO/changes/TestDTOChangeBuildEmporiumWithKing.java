package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeBuildEmporiumWithKing;
import dto.map.DTOCity;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;

public class TestDTOChangeBuildEmporiumWithKing {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = null; 
		DTOCoins coins = new DTOCoins(3); 
		DTOCity city = new DTOCity("Oakland");
		try {
			@SuppressWarnings("unused")
			DTOChangeBuildEmporiumWithKing change = 
					new DTOChangeBuildEmporiumWithKing(assistants, coins, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = null; 
		DTOCity city = new DTOCity("Oakland");
		try {
			@SuppressWarnings("unused")
			DTOChangeBuildEmporiumWithKing change = 
					new DTOChangeBuildEmporiumWithKing(assistants, coins, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = new DTOCoins(3); 
		DTOCity city = null;
		try {
			@SuppressWarnings("unused")
			DTOChangeBuildEmporiumWithKing change = 
					new DTOChangeBuildEmporiumWithKing(assistants, coins, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetAssistants() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = new DTOCoins(3); 
		DTOCity city = new DTOCity("Cleveland");
		DTOChangeBuildEmporiumWithKing change = 
				new DTOChangeBuildEmporiumWithKing(assistants, coins, city);
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void testGetCoins() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = new DTOCoins(3); 
		DTOCity city = new DTOCity("Cleveland");
		DTOChangeBuildEmporiumWithKing change = 
				new DTOChangeBuildEmporiumWithKing(assistants, coins, city);
		assertEquals(coins, change.getCoins()); 
	}
	@Test
	public void test() {
		DTOAssistants assistants = new DTOAssistants(3); 
		DTOCoins coins = new DTOCoins(3); 
		DTOCity city = new DTOCity("Cleveland");
		DTOChangeBuildEmporiumWithKing change = 
				new DTOChangeBuildEmporiumWithKing(assistants, coins, city);
		assertEquals(city, change.getCity()); 
	}

}
