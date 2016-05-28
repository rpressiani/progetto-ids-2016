package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.GarbageState;
import model.map.Ancestry;
import model.map.Map;
import parser.Parser;
import utilities.Color;

public class TestAncestry {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Parser parser2 = null; 
		Color color = new Color("gold"); 
		GarbageState garbage = new GarbageState(parser); 
		Map map = new Map(parser, garbage); 
		try {
			Ancestry ancestry = new Ancestry(color, parser2, map);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullMapThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Color color = new Color("gold"); 
		GarbageState garbage = new GarbageState(parser); 
		Map map = null; 
		try {
			Ancestry ancestry = new Ancestry(color, parser, map);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
