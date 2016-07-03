package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.changes.ChangeElectCounsellorWithAssistant;
import model.player.Assistants;
import model.player.Player;
import utilities.Color;

public class TestChangeElectCounsellorWithAssistant {

	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		Assistants assistants = null; 
		Color color = new Color("Red"); 
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		Assistants assistants = new Assistants(); 
		Color color = null;
		try {
			@SuppressWarnings("unused")
			ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

	@Test
	public void testGetAssistantsWorks() {
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		Assistants assistants = new Assistants(); 
		Color color = new Color("blue"); 
		ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color);
		Assistants temp = change.getAssistants(); 
		assertEquals(temp, change.getAssistants()); 
	}
	@Test
	public void testGetColorWorks() {
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		Assistants assistants = new Assistants(); 
		Color color = new Color("blue"); 
		ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color);
		Color temp = change.getColor(); 
		assertEquals(temp, change.getColor()); 
	}

}
