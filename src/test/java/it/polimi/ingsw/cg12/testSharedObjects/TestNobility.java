package it.polimi.ingsw.cg12.testSharedObjects;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import model.bonusable.NobilityBox;
import model.sharedObjects.Nobility;
import parser.Parser;

public class TestNobility {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
			@SuppressWarnings("unused")
			Nobility nobility = new Nobility(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetBoxesWorks() {
		Parser parser = new Parser(); 
		Nobility nobility = new Nobility(parser);
		HashMap<Integer,NobilityBox> temp = nobility.getBoxes();
		assertTrue(temp==nobility.getBoxes()); 
	}

}
