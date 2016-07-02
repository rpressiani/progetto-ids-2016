package it.polimi.ingsw.cg12.testDTO.actions.inputBonus;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.inputBonus.DTOGetFreePermission;
import dto.map.DTORegion;

public class TestDTOGetFreePermission {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = null; 
		try {
			@SuppressWarnings("unused")
			DTOGetFreePermission action = new DTOGetFreePermission(region, 1); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNegativeIndexInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = new DTORegion("Ohio"); 
		try {
			@SuppressWarnings("unused")
			DTOGetFreePermission action = new DTOGetFreePermission(region, -1); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegion() {
		DTORegion region = new DTORegion("Ohio");
		DTOGetFreePermission action = new DTOGetFreePermission(region, 2);
		assertEquals(region, action.getRegion()); 
	}
	@Test
	public void testGetIndex() {
		DTORegion region = new DTORegion("Ohio");
		int index = 2; 
		DTOGetFreePermission action = new DTOGetFreePermission(region, index);
		assertEquals(index, action.getIndex()); 
	}

}
