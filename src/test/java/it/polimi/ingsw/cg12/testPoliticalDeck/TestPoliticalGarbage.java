package it.polimi.ingsw.cg12.testPoliticalDeck;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;
import model.politicalDeck.PoliticalGarbage;
import parser.Parser;
import utilities.Color;

public class TestPoliticalGarbage {

	@Test
	public void testNullParserInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
			@SuppressWarnings("unused")
			PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfToZeroPutsGarbageToZero() {
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		garbage.toZero();
		assertTrue(garbage.isEmpty()); 
	}
	@SuppressWarnings("null")
	@Test 
	public void testIfNullDeckThrowsException() {
		boolean thrown = false; 
		PoliticalGarbage garbage = null; 
		try {
			garbage.toZero(); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullProposalInAddThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		try {
			PoliticalContainer proposal = null; 
			garbage.add(proposal);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testAdd() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		PoliticalGarbage garbage = gameState.getGarbage(); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		PoliticalContainer proposal = new PoliticalContainer(parser, structure);
		garbage.add(proposal);
		assertTrue(garbage.getDeck().get(0).getNumCards()!=0); 
	}
}
