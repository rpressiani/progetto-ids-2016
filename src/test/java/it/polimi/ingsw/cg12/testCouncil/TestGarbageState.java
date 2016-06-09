package it.polimi.ingsw.cg12.testCouncil;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.GarbageState;
import parser.Parser;

public class TestGarbageState {

	@Test
	public void testNullParserInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
			GarbageState garbageState = new GarbageState(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
