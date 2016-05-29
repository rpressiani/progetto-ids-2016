package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.politicalDeck.PoliticalContainer;
import parser.Parser;

public class TestPoliticalContainer {

	@Test
	public void testNullStructureThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		ArrayList<Integer> structure = null; 
		try {
			PoliticalContainer container= new PoliticalContainer(parser, structure); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
