package it.polimi.ingsw.cg12.testPlayer;

import static org.junit.Assert.*;

import org.junit.Test;

import model.player.Score;

public class TestScore {

	@Test
	public void testIfConstructorWorks() {
		Score score = new Score();
		assertTrue(score.getItems()==0); 
	}

}
