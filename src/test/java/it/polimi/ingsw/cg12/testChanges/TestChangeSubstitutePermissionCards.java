package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.changes.ChangeSubstitutePermissionCards;
import model.map.Region;
import model.player.Assistants;
import model.player.Player;
import parser.Parser;

public class TestChangeSubstitutePermissionCards {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = new Assistants(); 
		Region region = null; 
		try {
			@SuppressWarnings("unused")
			ChangeSubstitutePermissionCards change = new ChangeSubstitutePermissionCards(assistants, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = null; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		try {
			@SuppressWarnings("unused")
			ChangeSubstitutePermissionCards change = new ChangeSubstitutePermissionCards(assistants, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegionWorks() {
		Assistants assistants = new Assistants(); 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeSubstitutePermissionCards change = new ChangeSubstitutePermissionCards(assistants, region); 
		Region temp = change.getRegion(); 
		assertEquals(temp, change.getRegion()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Assistants assistants = new Assistants(); 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		ChangeSubstitutePermissionCards change = new ChangeSubstitutePermissionCards(assistants, region); 
		Assistants temp = change.getAssistants();  
		assertEquals(temp, change.getAssistants()); 
	}

}
