package it.polimi.ingsw.cg12.testDTO.actions.main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.map.DTOCity;
import dto.utilities.DTOPoliticalContainer;

public class TestDTOBuildEmporiumWithKing {

	@Test
	public void testNullContainerInConstructorThrowsException() {
		boolean thrown = false; 
		DTOPoliticalContainer proposal = null; 
		DTOCity city = new DTOCity("Roma");
		try {
			@SuppressWarnings("unused")
			DTOBuildEmporiumWithKing action = new DTOBuildEmporiumWithKing(proposal, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure); 
		DTOCity city = null; 
		try {
			@SuppressWarnings("unused")
			DTOBuildEmporiumWithKing action = new DTOBuildEmporiumWithKing(proposal, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetContainerWorks() {
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure);
		DTOCity city = new DTOCity("Napoli"); 
		DTOBuildEmporiumWithKing action = new DTOBuildEmporiumWithKing(proposal, city);
		DTOPoliticalContainer temp = action.getProposal(); 
		assertEquals(temp, action.getProposal()); 
	}
	@Test
	public void testGetCityWorks() {
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure);
		DTOCity city = new DTOCity("Napoli"); 
		DTOBuildEmporiumWithKing action = new DTOBuildEmporiumWithKing(proposal, city);
		DTOCity temp = action.getCity(); 
		assertEquals(temp, action.getCity()); 
	}

}
