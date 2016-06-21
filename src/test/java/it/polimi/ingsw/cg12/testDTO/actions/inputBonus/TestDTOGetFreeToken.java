package it.polimi.ingsw.cg12.testDTO.actions.inputBonus;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import dto.actions.inputBonus.DTOGetFreeToken;
import dto.map.DTOCity;

public class TestDTOGetFreeToken {

	@Test
	public void testNullSetInConstructorThrowsException() {
		boolean thrown = false;
		Set<DTOCity> cities = null; 
		try {
			DTOGetFreeToken action = new DTOGetFreeToken(cities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);  
	}
	@Test
	public void testGetCities() {
		Set<DTOCity> cities = new HashSet<DTOCity>(); 
		DTOGetFreeToken action = new DTOGetFreeToken(cities); 
		assertEquals(cities, action.getCities()); 
	}

}
