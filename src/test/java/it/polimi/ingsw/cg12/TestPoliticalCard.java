package it.polimi.ingsw.cg12;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.politicalDeck.PoliticalCard;

public class TestPoliticalCard {

	@Test 
	public void testAdd4CardTo8ShouldBe12() {
		PoliticalCard card = new PoliticalCard("Blue", 8);
		card.addCards(4);
		assertTrue(card.getNumCards()==12); 
	}
	@Test
	public void testRemove4CardsFrom8() {
		PoliticalCard card = new PoliticalCard("Red", 8); 
		card.removeCards(4);
		assertTrue(card.getNumCards()==4); 
	}
	@Test
	public void testGetNumCards() {
		PoliticalCard card = new PoliticalCard("White", 11); 
		assertTrue(card.getNumCards()==11); 
	}
	@Test
	public void testGetNumCardsWithWrongValues() {
		PoliticalCard card = new PoliticalCard("Green", 21); 
		assertFalse(card.getNumCards()==20); 
	}
	@Test
	public void testCardsWithNegativeIndexThrowException() {
		boolean thrown = false; 
		PoliticalCard card; 
		try {
			card = new PoliticalCard("Red", -18); 
		} catch (IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testAddCardsWithNegativeIndexThrowException() {
		boolean thrown = false; 
		PoliticalCard card = new PoliticalCard("Green", 25); 
		try {
			card.addCards(-23);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testRemoveCardsWithNegativeIndexThrowException() {
		boolean thrown = false; 
		PoliticalCard card = new PoliticalCard("Red", 22);
		try {
			card.removeCards(-2);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testConstructorWithNullStringThrowsException() {
		boolean thrown = false; 
		PoliticalCard card; 
		try {
			card = new PoliticalCard(null, 23); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void TestGetStringColor() {
		PoliticalCard card = new PoliticalCard("Red", 28); 
		assertTrue(card.getColor()=="Red"); 
	}

}
