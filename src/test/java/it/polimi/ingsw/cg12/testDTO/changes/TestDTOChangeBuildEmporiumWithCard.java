package it.polimi.ingsw.cg12.testDTO.changes;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.changes.DTOChangeBuildEmporiumWithCard;
import dto.map.DTOCity;
import dto.playerInfo.DTOAssistants;
import dto.utilities.DTOPermissionCardSelection;

public class TestDTOChangeBuildEmporiumWithCard {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = null;
		DTOCity city = new DTOCity("Miami"); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3); 
		try {
			DTOChangeBuildEmporiumWithCard change = 
					new DTOChangeBuildEmporiumWithCard(assistants, city, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(3);
		DTOCity city = null; 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3); 
		try {
			DTOChangeBuildEmporiumWithCard change = 
					new DTOChangeBuildEmporiumWithCard(assistants, city, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testNullCardInConstructorThrowsException() {
		boolean thrown = false; 
		DTOAssistants assistants = new DTOAssistants(3);
		DTOCity city = new DTOCity("Miami"); 
		DTOPermissionCardSelection card = null; 
		try {
			DTOChangeBuildEmporiumWithCard change = 
					new DTOChangeBuildEmporiumWithCard(assistants, city, card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testGetAssistants() {
		DTOAssistants assistants = new DTOAssistants(3);
		DTOCity city = new DTOCity("Miami"); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3);
		DTOChangeBuildEmporiumWithCard change = 
				new DTOChangeBuildEmporiumWithCard(assistants, city, card); 
		assertEquals(assistants, change.getAssistants()); 
	}
	@Test
	public void testGetCity() {
		DTOAssistants assistants = new DTOAssistants(3);
		DTOCity city = new DTOCity("Miami"); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3);
		DTOChangeBuildEmporiumWithCard change = 
				new DTOChangeBuildEmporiumWithCard(assistants, city, card); 
		assertEquals(city, change.getCity()); 
	}
	@Test
	public void testGetCard() {
		DTOAssistants assistants = new DTOAssistants(3);
		DTOCity city = new DTOCity("Miami"); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3);
		DTOChangeBuildEmporiumWithCard change = 
				new DTOChangeBuildEmporiumWithCard(assistants, city, card); 
		assertEquals(card, change.getCard()); 
	}

}
