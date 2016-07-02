package it.polimi.ingsw.cg12.testBonusable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.bonusItem.BonusItem;
import model.bonusable.NobilityBox;

public class TestNobilityBox {

	@Test
	public void testWrongLevelInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		int level = -1; 
		try {
			@SuppressWarnings("unused")
			NobilityBox box = new NobilityBox(bonuses, level); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetLevelWorks() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		int level = 2; 
		NobilityBox box = new NobilityBox(bonuses, level); 
		int temp = box.getLevel(); 
		assertEquals(temp, box.getLevel()); 
	}

}
