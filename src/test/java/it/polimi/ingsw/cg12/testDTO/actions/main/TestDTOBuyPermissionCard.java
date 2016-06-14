package it.polimi.ingsw.cg12.testDTO.actions.main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.actions.main.DTOBuyPermissionCard;
import dto.map.DTORegion;
import dto.utilities.DTOPoliticalContainer;

public class TestDTOBuyPermissionCard {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = null; 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure); 
		try {
			DTOBuyPermissionCard action = new DTOBuyPermissionCard(region, proposal, 3); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullContainerInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = new DTORegion("Campania"); 
		DTOPoliticalContainer proposal = null; 
		try {
			DTOBuyPermissionCard action = new DTOBuyPermissionCard(region, proposal, 3); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testWrongIndexInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = new DTORegion("Lombardia"); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure); 
		try {
			DTOBuyPermissionCard action = new DTOBuyPermissionCard(region, proposal, -1); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegionWorks() {
		DTORegion region = new DTORegion("Lombardia"); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure);
		DTOBuyPermissionCard action = new DTOBuyPermissionCard(region, proposal, 2);
		DTORegion temp = action.getRegion(); 
		assertEquals(temp, action.getRegion()); 
	}
	@Test
	public void testGetContainerWorks() {
		DTORegion region = new DTORegion("Lombardia"); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure);
		DTOBuyPermissionCard action = new DTOBuyPermissionCard(region, proposal, 2);
		DTOPoliticalContainer temp = action.getProposal(); 
		assertEquals(temp, action.getProposal()); 
	}
	@Test
	public void testGetIndexWorks() {
		DTORegion region = new DTORegion("Lombardia"); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure);
		DTOBuyPermissionCard action = new DTOBuyPermissionCard(region, proposal, 2);
		int temp = action.getIndex(); 
		assertEquals(temp, action.getIndex());
	}
 
}
