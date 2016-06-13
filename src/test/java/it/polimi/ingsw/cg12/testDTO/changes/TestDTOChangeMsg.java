package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeMsg;

public class TestDTOChangeMsg {

	@Test
	public void testNullStringInConstructorThrowsException() {
		boolean thrown = false; 
		String msg = null; 
		try {
			DTOChangeMsg change = new DTOChangeMsg(msg); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetString() {
		String msg = "ciao";
		DTOChangeMsg change = new DTOChangeMsg(msg); 
		assertEquals(msg, change.getMsg()); 
	}

}
