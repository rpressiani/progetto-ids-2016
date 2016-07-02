package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import org.junit.Test;

import model.changes.ChangeMsg;

public class TestChangeMsg {

	@Test
	public void testNullStringInConstructorThrowsException() {
		boolean thrown = false; 
		String msg = null; 
		try {
			@SuppressWarnings("unused")
			ChangeMsg change = new ChangeMsg(msg); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetMsgWorks() {
		ChangeMsg change = new ChangeMsg("message");
		assertEquals(change.getMsg(), "message"); 
	}

}
