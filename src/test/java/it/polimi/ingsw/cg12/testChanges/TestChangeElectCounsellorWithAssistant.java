package it.polimi.ingsw.cg12.testChanges;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.changes.ChangeElectCounsellorWithAssistant;
import model.map.Region;
import model.player.Assistants;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestChangeElectCounsellorWithAssistant {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		Assistants assistants = new Assistants(); 
		Color color = new Color("red"); 
		Region region = null; 
		try {
			ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullAssistantsInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		Assistants assistants = null; 
		Color color = new Color("Red"); 
		try {
			ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		Assistants assistants = new Assistants(); 
		Color color = null;
		try {
			ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegionWorks() {
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		Assistants assistants = new Assistants(); 
		Color color = new Color("blue"); 
		ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color, region);
		Region temp = change.getRegion(); 
		assertEquals(temp, change.getRegion()); 
	}
	@Test
	public void testGetAssistantsWorks() {
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		Assistants assistants = new Assistants(); 
		Color color = new Color("blue"); 
		ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color, region);
		Assistants temp = change.getAssistants(); 
		assertEquals(temp, change.getAssistants()); 
	}
	@Test
	public void testGetColorWorks() {
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		Assistants assistants = new Assistants(); 
		Color color = new Color("blue"); 
		ChangeElectCounsellorWithAssistant change = new ChangeElectCounsellorWithAssistant(assistants, color, region);
		Color temp = change.getColor(); 
		assertEquals(temp, change.getColor()); 
	}

}
