package it.polimi.ingsw.cg12.testCouncil;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.BalconyState;
import parser.Parser;

public class TestBalconyState {

	@Test
	public void testNullParserInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = null;
		try {
			@SuppressWarnings("unused")
			BalconyState state = new BalconyState(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
