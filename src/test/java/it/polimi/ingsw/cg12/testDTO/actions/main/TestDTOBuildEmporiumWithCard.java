package it.polimi.ingsw.cg12.testDTO.actions.main;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.map.DTOCity;
import dto.utilities.DTOPermissionCardSelection;

public class TestDTOBuildEmporiumWithCard {

	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCity city = null; 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(3); 
		try {
			@SuppressWarnings("unused")
			DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCardInConstructorThrowsException() {
		boolean thrown = true; 
		DTOPermissionCardSelection card = null; 
		DTOCity city = new DTOCity("Roma"); 
		try {
			@SuppressWarnings("unused")
			DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfGetCityWorks() {
		DTOCity city = new DTOCity("Milano"); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(4); 
		DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city);
		assertTrue(action.getCity()==city); 
	}
	@Test
	public void testIfGetPermissionCardWorks() {
		DTOCity city = new DTOCity("Milano"); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(4); 
		DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city);
		assertTrue(action.getPermissionCard()==card); 
	}

}
