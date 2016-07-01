package it.polimi.ingsw.cg12.testBonus;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusNobility;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusNobility {

	@Test
	public void testNullItemsThrowsException() {
		boolean thrown = false; 
		int items = -2; 
		@SuppressWarnings("unused")
		BonusNobility bonus; 
		try {
			bonus = new BonusNobility(items); 
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
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		BonusNobility bonus = new BonusNobility(2); 
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
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		BonusNobility bonus = new BonusNobility(2); 
		try {
			GameState gameState2 = null; 
			bonus.giveBonus(player, gameState2);
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
		player.setNickname("John");
		player.setColor(new Color("white"));
		player2.setNickname("Paul");
		player2.setColor(new Color("yellow"));
		player3.setNickname("George");
		player3.setColor(new Color("blue"));
		player4.setNickname("Ringo");
		player4.setColor(new Color("red"));
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
		BonusNobility bonus = new BonusNobility(2); 
		int temp = player.getNobilityLevel().getItems(); 
		bonus.giveBonus(player, gameState);
		assertTrue(temp!=player.getNobilityLevel().getItems()); 
	}

}
