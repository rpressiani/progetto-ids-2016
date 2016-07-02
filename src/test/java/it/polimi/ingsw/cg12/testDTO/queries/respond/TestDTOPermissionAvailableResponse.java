package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import dto.queries.respond.DTOPermissionAvailableResponse;
import dto.utilities.DTOPermissionCard;

public class TestDTOPermissionAvailableResponse {

	@Test
	public void testNullMapInConstructorThrowsException() {
		boolean thrown = false; 
		Map<String, Set<DTOPermissionCard>> permissionPerRegion = null;
		try {
			@SuppressWarnings("unused")
			DTOPermissionAvailableResponse response = 
					new DTOPermissionAvailableResponse(permissionPerRegion); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetMap() {
		Map<String, Set<DTOPermissionCard>> permissionPerRegion = 
				new HashMap<String, Set<DTOPermissionCard>>(); 
		DTOPermissionAvailableResponse response = 
				new DTOPermissionAvailableResponse(permissionPerRegion); 
		assertEquals(permissionPerRegion, response.getPermissionPerRegion()); 
	}

}
