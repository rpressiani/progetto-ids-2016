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
			@SuppressWarnings("unused")
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
		Coins temp = change.getPlayer().getCoins();
		assertEquals(temp, change.getPlayer().getCoins()); 
	}
	@Test
	public void testGetNobilityLevelWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		NobilityLevel temp = change.getPlayer().getNobilityLevel();
		assertEquals(temp, change.getPlayer().getNobilityLevel()); 
	}
	@Test
	public void testGetScoreWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		Score temp = change.getPlayer().getScore();
		assertEquals(temp, change.getPlayer().getScore()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Player player = new Player(); 
		ChangePlayerStatus change = new ChangePlayerStatus(player); 
		Assistants temp = change.getPlayer().getAssistants();
		assertEquals(temp, change.getPlayer().getAssistants()); 
	}
	

}
