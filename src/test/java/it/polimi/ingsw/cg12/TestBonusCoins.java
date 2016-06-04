package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusCoins;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusCoins {

	@Test
	public void testItemsLessThanZeroThrowsExceptionInConstructor() {
		boolean thrown = false; 
		int items = -1; 
		try {
			BonusCoins bonus = new BonusCoins(items); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInGiveBonusThrowsException() {
		boolean thrown = false; 
		int items = 2; 
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
		GameState gameState = new GameState(parser, players); 
		BonusCoins bonus = new BonusCoins(items); 
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
		int items = 2; 
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
		GameState gameState = new GameState(parser, players); 
		BonusCoins bonus = new BonusCoins(items); 
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
		int items = 2; 
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
		player.setNickname("Ciro");
		player.setColor(new Color("red"));
		player2.setNickname("Genny");
		player2.setColor(new Color("black"));
		player3.setNickname("Salvatore");
		player3.setColor(new Color("white"));
		player4.setNickname("Pietro");
		player4.setColor(new Color("blue"));
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		
		BonusCoins bonus = new BonusCoins(items); 
		int temp = player.getCoins().getItems();
		bonus.giveBonus(player, gameState);
		assertTrue(temp!=player.getCoins().getItems()); 
	}
}
