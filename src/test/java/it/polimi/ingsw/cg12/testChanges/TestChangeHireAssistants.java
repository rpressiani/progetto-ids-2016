package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import org.junit.Test;

import model.changes.ChangeHireAssistants;
import model.player.Assistants;
import model.player.Coins;

public class TestChangeHireAssistants {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = null; 
		Coins coins = new Coins(); 
		try {
			ChangeHireAssistants change = new ChangeHireAssistants(assistants, coins); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCoinsInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = new Assistants(); 
		Coins coins = null; 
		try {
			ChangeHireAssistants change = new ChangeHireAssistants(assistants, coins);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testGetCoinsWorks() {
		Assistants assistants = new Assistants(); 
		Coins coins = new Coins();
		ChangeHireAssistants change = new ChangeHireAssistants(assistants, coins);
		Coins temp = change.getCoins(); 
		assertEquals(temp, change.getCoins()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Assistants assistants = new Assistants(); 
		Coins coins = new Coins();
		ChangeHireAssistants change = new ChangeHireAssistants(assistants, coins);
		Assistants temp = change.getAssistants();  
		assertEquals(temp, change.getAssistants()); 
	}

}
