package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.Counsellor;
import utilities.Color;

public class TestCounsellor {

	@Test
	public void testNullColorThrowsException() {
		boolean thrown = false; 
		Color color = null; 
		try {
			Counsellor counsellor = new Counsellor(color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetColorWorks() {
		Color color = new Color("Red"); 
		Counsellor counsellor = new Counsellor(color); 
		assertEquals(counsellor.getColor().getStringID(), "Red"); 
	}

}
