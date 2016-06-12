package it.polimi.ingsw.cg12.testDTO.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.main.DTOElectCounsellor;
import dto.map.DTORegion;
import dto.utilities.DTOColor;

public class TestDTOElectCounsellor {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = null; 
		DTOColor color = new DTOColor("ciao"); 
		try {
			DTOElectCounsellor action = new DTOElectCounsellor(region, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		DTORegion region = new DTORegion("Lombardia"); 
		DTOColor color = null; 
		try {
			DTOElectCounsellor action = new DTOElectCounsellor(region, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetColorWorks() {
		DTORegion region = new DTORegion("Campania");
		DTOColor color = new DTOColor("red");
		DTOElectCounsellor action = new DTOElectCounsellor(region, color); 
		DTOColor temp = action.getColor();
		assertEquals(temp, action.getColor()); 
	}
	@Test
	public void testGetRegionWorks() {
		DTORegion region = new DTORegion("Campania");
		DTOColor color = new DTOColor("red");
		DTOElectCounsellor action = new DTOElectCounsellor(region, color); 
		DTORegion temp = action.getRegion(); 
		assertEquals(temp, action.getRegion()); 
	}

}
