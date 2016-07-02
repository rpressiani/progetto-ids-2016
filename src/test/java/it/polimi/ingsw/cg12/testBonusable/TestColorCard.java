package it.polimi.ingsw.cg12.testBonusable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.bonusItem.BonusItem;
import model.bonusable.ColorCard;
import utilities.Color;

public class TestColorCard {

	@Test
	public void testNullBonusesInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<BonusItem> bonuses = null;
		Color color = new Color("red"); 
		try {
			@SuppressWarnings("unused")
			ColorCard card = new ColorCard(bonuses, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 		
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		Color color = null; 
		try {
			@SuppressWarnings("unused")
			ColorCard card = new ColorCard(bonuses, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetColorWorks() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		Color color = new Color("red");
		ColorCard card = new ColorCard(bonuses, color); 
		Color temp = card.getColor(); 
		assertEquals(temp, card.getColor()); 
	}

}
