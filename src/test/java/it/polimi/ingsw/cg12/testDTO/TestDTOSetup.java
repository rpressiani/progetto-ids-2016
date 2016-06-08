package it.polimi.ingsw.cg12.testDTO;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.utilities.DTOColor;
import dto.utilities.DTOSetup;

public class TestDTOSetup {

	@Test
	public void testNullNicknameInConstructorThrowsException() {
		boolean thrown = false; 
		String nickname = null; 
		DTOColor color = new DTOColor("ciao"); 
		try {
			DTOSetup setup = new DTOSetup(nickname, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		String nickname = "Ciro"; 
		DTOColor color = null; 
		try {
			DTOSetup setup = new DTOSetup(nickname, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetNicknameWorks() {
		String nickname = "Genny"; 
		DTOColor color = new DTOColor("ciao"); 
		DTOSetup setup = new DTOSetup(nickname, color); 
		String temp = setup.getNickname(); 
		assertEquals(temp, setup.getNickname()); 
	}
	@Test
	public void testGetColorWorks() {
		String nickname = "Genny"; 
		DTOColor color = new DTOColor("ciao"); 
		DTOSetup setup = new DTOSetup(nickname, color); 
		DTOColor temp = setup.getColor();  
		assertEquals(temp, setup.getColor()); 
	}

}
