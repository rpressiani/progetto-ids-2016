package it.polimi.ingsw.cg12.testDTO.playerInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.playerInfo.DTOPlayerBasic;
import dto.utilities.DTOColor;

public class TestDTOPlayerBasic {

	@Test
	public void testNegativeIdInConstrutorThrowsExcpetion() {
		boolean thrown = false; 
		try {
			DTOPlayerBasic player = new DTOPlayerBasic(-1, "Ciro", new DTOColor("red")); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullNicknameInConstructorThrowsException() {
		boolean thrown = false; 
		String nickname = null; 
		try {
			DTOPlayerBasic player = new DTOPlayerBasic(1, nickname, new DTOColor("red")); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColoInConstructorThrowsException() {
		boolean thrown = false; 
		DTOColor color = null; 
		try {
			DTOPlayerBasic player = new DTOPlayerBasic(1, "Ciro", color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetId() {
		int id = 3;
		String nickname = "Ciro"; 
		DTOColor color = new DTOColor("red"); 
		DTOPlayerBasic player = new DTOPlayerBasic(id, "Ciro", color); 
		assertEquals(id, player.getSerialID()); 
	}
	@Test
	public void testGetNickname() {
		int id = 3;
		String nickname = "Ciro"; 
		DTOColor color = new DTOColor("red"); 
		DTOPlayerBasic player = new DTOPlayerBasic(id, "Ciro", color); 
		assertEquals(nickname, player.getNickname()); 
	}
	@Test
	public void testGetColor() {
		int id = 3;
		String nickname = "Ciro"; 
		DTOColor color = new DTOColor("red"); 
		DTOPlayerBasic player = new DTOPlayerBasic(id, "Ciro", color); 
		assertEquals(color, player.getColor()); 
	}

}
