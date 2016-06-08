package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import org.junit.Test;

import model.changes.ChangePlayerStatus;
import model.player.Assistants;
import model.player.Coins;
import model.player.NobilityLevel;
import model.player.Player;
import model.player.Score;

public class TestChangePlayerStatus {

	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false; 
		Player player = null; 
		try {
			ChangePlayerStatus change = new ChangePlayerStatus(player); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetCoinsWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		Coins temp = change.getCoins();
		assertEquals(temp, change.getCoins()); 
	}
	@Test
	public void testGetNobilityLevelWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		NobilityLevel temp = change.getNobilityLevel();
		assertEquals(temp, change.getNobilityLevel()); 
	}
	@Test
	public void testGetScoreWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		Score temp = change.getScore();
		assertEquals(temp, change.getScore()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		Assistants temp = change.getAssistants();
		assertEquals(temp, change.getAssistants()); 
	}
	

}
