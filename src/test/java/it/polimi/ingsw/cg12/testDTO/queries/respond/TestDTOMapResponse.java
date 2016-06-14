package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import dto.map.DTOCity;
import dto.playerInfo.DTOPlayerBasic;
import dto.queries.respond.DTOMapResponse;

public class TestDTOMapResponse {

	@Test
	public void testNullStringInConstructorThrowsException() {
		boolean thrown = false; 
		String cliDisplay = null; 
		Set<DTOCity> builtCities = new HashSet<DTOCity>();
		Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus = 
				new HashMap<DTOCity, Set<DTOPlayerBasic>>(); 
		try {
			DTOMapResponse response = 
					new DTOMapResponse(cliDisplay, builtCities, citiesStatus); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullSetInConstructorThroesException() {
		boolean thrown = false; 
		String cliDisplay = ""; 
		Set<DTOCity> builtCities = null;
		Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus = 
				new HashMap<DTOCity, Set<DTOPlayerBasic>>(); 
		try {
			DTOMapResponse response = 
					new DTOMapResponse(cliDisplay, builtCities, citiesStatus); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullMapInConstructorThrowsException() {
		boolean thrown = false; 
		String cliDisplay = ""; 
		Set<DTOCity> builtCities = new HashSet<DTOCity>();
		Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus = null; 
		try {
			DTOMapResponse response = 
					new DTOMapResponse(cliDisplay, builtCities, citiesStatus); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetSet() {
		String cliDisplay = "Hello"; 
		Set<DTOCity> builtCities = new HashSet<DTOCity>();
		Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus = 
				new HashMap<DTOCity, Set<DTOPlayerBasic>>();
		DTOMapResponse response = 
				new DTOMapResponse(cliDisplay, builtCities, citiesStatus);
		assertEquals(builtCities, response.getBuiltCities());
	}
	@Test
	public void testGetMap() {
		String cliDisplay = "Hello"; 
		Set<DTOCity> builtCities = new HashSet<DTOCity>();
		Map<DTOCity, Set<DTOPlayerBasic>> citiesStatus = 
				new HashMap<DTOCity, Set<DTOPlayerBasic>>();
		DTOMapResponse response = 
				new DTOMapResponse(cliDisplay, builtCities, citiesStatus);
		assertEquals(citiesStatus, response.getCitiesStatus());
	}
	

}
