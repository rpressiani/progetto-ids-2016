package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.player.Assistants;
import model.player.Player;
import utilities.Color;

public class TestAssistants {

	@Test
	public void testIllegalArgumentInConstructor() {
		boolean thrown = false; 
		Integer nAssistants = -3;
		try {
			Assistants assistants = new Assistants(nAssistants); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIllegalArgumentInSub() {
		boolean thrown = false; 
		Integer nAssistants = 10;
		Assistants assistants = new Assistants(nAssistants); 
		try {
			 assistants.sub(-1);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
