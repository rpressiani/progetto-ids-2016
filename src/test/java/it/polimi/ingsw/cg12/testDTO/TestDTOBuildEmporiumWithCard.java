package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.map.DTOCity;
import dto.utilities.DTOPermissionCard;

public class TestDTOBuildEmporiumWithCard {

	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		DTOCity city = null; 
		DTOPermissionCard card = new DTOPermissionCard(3); 
		try {
			DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCardInConstructorThrowsException() {
		boolean thrown = true; 
		DTOPermissionCard card = null; 
		DTOCity city = new DTOCity("Roma"); 
		try {
			DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfGetCityWorks() {
		DTOCity city = new DTOCity("Milano"); 
		DTOPermissionCard card = new DTOPermissionCard(4); 
		DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city);
		assertTrue(action.getCity()==city); 
	}
	@Test
	public void testIfGetPermissionCardWorks() {
		DTOCity city = new DTOCity("Milano"); 
		DTOPermissionCard card = new DTOPermissionCard(4); 
		DTOBuildEmporiumWithCard action = new DTOBuildEmporiumWithCard(card, city);
		assertTrue(action.getPermissionCard()==card); 
	}

}
