package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.playerInfo.DTOPlayerBasic;
import dto.queries.respond.DTOPlayersListResponse;

public class TestDTOPlayersListResponse {

	@Test
	public void testNullArrayListInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<DTOPlayerBasic> players = null; 
		try {
			DTOPlayersListResponse response = 
					new DTOPlayersListResponse(players); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetPlayer() {
		ArrayList<DTOPlayerBasic> players = new ArrayList<DTOPlayerBasic>();
		DTOPlayersListResponse response = 
				new DTOPlayersListResponse(players);
		assertEquals(players, response.getPlayers()); 
	}

}
