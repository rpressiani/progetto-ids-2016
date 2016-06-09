package it.polimi.ingsw.cg12.testPlayer;

import static org.junit.Assert.*;

import org.junit.Test;

import model.player.Score;
import model.player.SimpleItem;

public class TestSimpleItem {

	@Test
	public void testIfConstructorPutsItemsToZero() {
		SimpleItem item = new Score();
		assertTrue(item.getItems()==0); 
	}
	@Test
	public void testIfAddWorks() {
		SimpleItem item = new Score();
		item.add(4);
		assertTrue(item.getItems()==4);  
	}
	@Test
	public void testGetItemWorks() {
		SimpleItem item = new Score();
		Integer temp = item.getItems();
		assertTrue(temp==item.getItems()); 
	}

}
