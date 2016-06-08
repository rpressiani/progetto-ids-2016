package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.utilities.DTOPoliticalContainer;

public class TestDTOPoliticalContainer {

	@Test
	public void testNullStructureInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<Integer> structure = null; 
		try {
			DTOPoliticalContainer container = new DTOPoliticalContainer(structure); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetStructureWorks() {
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer container = new DTOPoliticalContainer(structure);
		ArrayList<Integer> temp = container.getStructure(); 
		assertEquals(temp, container.getStructure()); 
	}
}
