package it.polimi.ingsw.cg12.testPlayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.player.Coins;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestCoins {

	@Test
	public void testNegativeIntegerThrowsException() {
		boolean thrown = false; 
		try {
			@SuppressWarnings("unused")
			Coins coins = new Coins(-1); 
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testSubWorks() {
		Coins coins = new Coins(4); 
		coins.sub(2);
		assertTrue(coins.getItems()==2); 
	}
	@Test
	public void testAddWorks() {
		Coins coins = new Coins(4); 
		coins.add(2);
		assertTrue(coins.getItems()==6);  
	}
	/*@Test
	public void testVerifyAddWorks() {
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
		player.setNickname("AJ");
		player.setColor(new Color("white"));
		player2.setNickname("Karl");
		player2.setColor(new Color("black"));
		player3.setNickname("Luke");
		player3.setColor(new Color("red"));
		player4.setNickname("Kenny");
		player4.setColor(new Color("blue"));
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
			id++; 
		}
		Coins coins = player.getCoins(); 
		int temp1 = player.getCoins().getItems();  
		int temp2 = player2.getCoins().getItems();
		coins.makeExchange(coins, player, player2);
		assertTrue(player.getCoins().getItems()==0 && player2.getCoins().getItems()==(temp2+temp1)); 
	}*/
}
