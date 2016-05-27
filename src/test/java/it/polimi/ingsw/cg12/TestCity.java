package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.map.City;

public class TestCity {

	@Test
	public void testNullParametersInConstructorsThrowException() {
		boolean thrown = false; 
		try {
			City city = new City(null, null, null, null); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
