package it.polimi.ingsw.cg12.testModel.actions.inputBonus;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import model.actions.inputBonus.GetFreeToken;
import model.map.City;

public class TestGetFreeToken {

	@Test
	public void testNullSetInConstructorThrowsException() {
		boolean thrown = false; 
		Set<City> cities = null; 
		try {
			@SuppressWarnings("unused")
			GetFreeToken bonus = new GetFreeToken(cities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testDoActionWorks() {
		
	}
	@Test
	public void testCheckConditionWorks() {
		
	}

}
