package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOPlayerBasic;
import dto.queries.respond.DTOCurrentPlayerResponse;
import dto.utilities.DTOColor;

public class TestDTOCurrentPlayerResponse {

	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false; 
		DTOPlayerBasic player = null;
		try {
			@SuppressWarnings("unused")
			DTOCurrentPlayerResponse response = new DTOCurrentPlayerResponse(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetPlayer() {
		DTOPlayerBasic player = new DTOPlayerBasic(3, "Ciro", new DTOColor("red")); 
		DTOCurrentPlayerResponse response = new DTOCurrentPlayerResponse(player); 
		assertEquals(player, response.getPlayer()); 
	}

}
