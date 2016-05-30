package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.bonusable.KingCard;


public class TestKingCard {

	@Test
	public void testNullBonusesInConstructorThrowsException() {
		boolean thrown = false; 
		try {
			KingCard kingCard = new KingCard(null); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
