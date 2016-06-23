package it.polimi.ingsw.cg12.testModel.actions.inputBonus;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.actions.inputBonus.DoAgainAction;
import model.actions.main.MainAction;

public class TestDoAgainAction {

	@SuppressWarnings("unused")
	@Test
	public void testNullActionInConstructorThrowsException() {
		boolean thrown = false; 
		MainAction action = null; 
		try {
			DoAgainAction againAction = new DoAgainAction(action); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
