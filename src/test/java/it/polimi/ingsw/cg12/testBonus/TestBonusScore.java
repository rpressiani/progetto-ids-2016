package it.polimi.ingsw.cg12.testBonus;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusScore;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusScore {

	@Test
	public void testNullItemsThrowException() {
		boolean thrown = false; 
		int items = -3; 
		try {
			BonusScore bonus = new BonusScore(items); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInGiveBonusThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		BonusScore bonus = new BonusScore(7);
		try {
			Player pl = null; 
			bonus.giveBonus(pl, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInGiveBonusThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		BonusScore bonus = new BonusScore(7);
		try {
			GameState gameState2 = null; 
			bonus.giveBonus(player4, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testIfGiveBonusWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		Player player2 = new Player(); 
		Player player3 = new Player(); 
		Player player4 = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		BonusScore bonus = new BonusScore(7);
		int temp = player2.getScore().getItems(); 
		bonus.giveBonus(player2, gameState);
		assertTrue(temp!=player2.getScore().getItems()); 
	}

}
