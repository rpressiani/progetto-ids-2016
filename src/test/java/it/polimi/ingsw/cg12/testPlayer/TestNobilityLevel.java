package it.polimi.ingsw.cg12.testPlayer;

import static org.junit.Assert.*;

import org.junit.Test;

import model.player.NobilityLevel;

public class TestNobilityLevel {

	@Test
	public void testIfConstructorWorks() {
		NobilityLevel level = new NobilityLevel();
		assertTrue(level.getItems()==0); 
	}

}
