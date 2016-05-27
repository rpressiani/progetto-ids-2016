package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.GarbageState;
import model.map.Map;
import model.map.Region;
import parser.Parser;

public class TestRegion {

	@Test
	public void testNullConstructorThrowsException() {
		boolean thrown = false; 
		try {
			Region region = new Region(null, null, null, null); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/*@Test
	public void testGetStringWorks() {
		Parser parser = new Parser(); 
		GarbageState garbage = new GarbageState(parser);
		Map map = new Map(parser, garbage);
		Region region = new Region("Lombardia", garbage, parser, map);
		assertEquals(region.getName(), "Lombardia");  
	}*/

}
