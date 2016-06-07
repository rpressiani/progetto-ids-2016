package it.polimi.ingsw.cg12.testPoliticalDeck;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;
import parser.Parser;
import utilities.Color;

public class TestPoliticalContainer {

	@Test
	public void testNullStructureThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		ArrayList<Integer> structure = null; 
		try {
			PoliticalContainer container= new PoliticalContainer(parser, structure); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullParserInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<Integer> structure = new ArrayList<Integer>();
		Parser parser = null; 
		try {
			PoliticalContainer container = new PoliticalContainer(parser, structure);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	/*@Test
	public void testMakeExchangeWorks() {
		Parser parser = new Parser();
		Player player = new Player(); 
		Player player2 = new Player(); 
		player.setNickname("Matt");
		player.setColor(new Color("red"));
		player2.setNickname("Nick");
		player2.setColor(new Color("white"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		GameState gameState = new GameState(parser, players);
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		PoliticalContainer container = new PoliticalContainer(parser, structure);
		int temp = player.getPoliticalHand().getDeck().get(0).getNumCards();
		container.makeExchange(player, player2);
		assertTrue(); 
	}*/

}
