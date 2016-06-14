package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dto.playerInfo.DTOPlayerBasic;
import dto.playerInfo.DTOScore;
import dto.queries.respond.DTOScoresResponse;
import dto.utilities.DTOColor;

public class TestDTOScoresResponse {

	@Test
	public void testNullMapInConstructorThrowsException() {
		boolean thrown = false; 
		Map<DTOPlayerBasic, DTOScore> scores = null;
		DTOPlayerBasic player = new DTOPlayerBasic(2, "Bryan", new DTOColor("red")); 
		try {
			DTOScoresResponse response = new DTOScoresResponse(scores, player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false; 
		Map<DTOPlayerBasic, DTOScore> scores = new HashMap<DTOPlayerBasic, DTOScore>();
		DTOPlayerBasic player = null; 
		try {
			DTOScoresResponse response = new DTOScoresResponse(scores, player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetScores() {
		Map<DTOPlayerBasic, DTOScore> scores = new HashMap<DTOPlayerBasic, DTOScore>();
		DTOPlayerBasic player = new DTOPlayerBasic(2, "Ciro", new DTOColor("red"));
		DTOScoresResponse response = new DTOScoresResponse(scores, player); 
		assertEquals(scores, response.getScores()); 
	}

}
