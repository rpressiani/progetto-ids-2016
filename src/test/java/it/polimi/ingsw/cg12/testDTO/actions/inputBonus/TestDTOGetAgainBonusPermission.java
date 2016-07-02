package it.polimi.ingsw.cg12.testDTO.actions.inputBonus;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.inputBonus.DTOGetAgainBonusPermission;
import dto.utilities.DTOPermissionCardSelection;

public class TestDTOGetAgainBonusPermission {

	@Test
	public void testNullCardInConstructorThrowsException() {
		boolean thrown = false; 
		DTOPermissionCardSelection card = null; 
		try {
			@SuppressWarnings("unused")
			DTOGetAgainBonusPermission action = new DTOGetAgainBonusPermission(card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCard() {
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3); 
		DTOGetAgainBonusPermission action = new DTOGetAgainBonusPermission(card);
		assertEquals(card, action.getCard()); 
	}

}
