package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.player.Player;
import model.sharedObjects.Nobility;
import parser.Parser;
import utilities.Color;

public class TestNobility {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
			Nobility nobility = new Nobility(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/*@Test
	public void testIfCheckNobilityWorks() {
		Parser parser = new Parser(); 
		Player player = new Player("Alessandro", new Color("blue")); 
		Player player2 = new Player("Marco", new Color("red")); 
		Player player3 = new Player("Carlo", new Color("black"));
		Player player4 = new Player("Matteo", new Color("grey")); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		Nobility nobility = gameState.getNobility();
		nobility.checkNobility(player4, gameState);
	}*/

}
