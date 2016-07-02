package it.polimi.ingsw.cg12.testBonusable;

import static org.junit.Assert.*;

import org.junit.Test;

import model.bonusable.KingCard;


public class TestKingCard {

	@Test
	public void testNullBonusesInConstructorThrowsException() {
		boolean thrown = false; 
		try {
			@SuppressWarnings("unused")
			KingCard kingCard = new KingCard(null); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
