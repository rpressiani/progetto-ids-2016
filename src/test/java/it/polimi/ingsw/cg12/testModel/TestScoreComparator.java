package it.polimi.ingsw.cg12.testModel;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.ScoreComparator;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestScoreComparator {

	@Test
	public void testNullPlayerInConstructorThrowsException() {
		boolean thrown = false;
		ScoreComparator comparator = new ScoreComparator(); 
		Player player = new Player(); 
		Player player2 = null; 
		try {
			comparator.compare(player, player2); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfCompareWorks() {
		ScoreComparator comparator = new ScoreComparator(); 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		Player player2 = new Player(); 
		player2.setNickname("Ale");
		player2.setColor(new Color("black"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2);
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		player.getScore().add(20);
		assertTrue(comparator.compare(player, player2)<0);  
	}

}
