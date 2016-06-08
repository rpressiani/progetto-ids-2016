package it.polimi.ingsw.cg12.testSharedObjects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import model.GameState;
import model.bonusable.NobilityBox;
import model.player.Player;
import model.sharedObjects.Nobility;
import parser.Parser;
import utilities.Color;

public class TestNobility {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
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
