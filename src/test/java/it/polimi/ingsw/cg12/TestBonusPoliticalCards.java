package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusPoliticalCards;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusPoliticalCards {

	@Test
	public void testWrongTimesToDrawInConstructorThrowsException() {
		boolean thrown = false; 
		int timesToDraw = -1; 
		try {
			BonusPoliticalCards bonus = new BonusPoliticalCards(timesToDraw); 
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
		player.setNickname("Altair");
		player.setColor(new Color("brown"));
		player2.setNickname("Ezio");
		player2.setColor(new Color("white"));
		player3.setNickname("Connor");
		player3.setColor(new Color("black"));
		player4.setNickname("Edward");
		player4.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players);
		BonusPoliticalCards bonus = new BonusPoliticalCards(3); 
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
		player.setNickname("Altair");
		player.setColor(new Color("brown"));
		player2.setNickname("Ezio");
		player2.setColor(new Color("white"));
		player3.setNickname("Connor");
		player3.setColor(new Color("black"));
		player4.setNickname("Edward");
		player4.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		GameState gameState = new GameState(parser, players);
		BonusPoliticalCards bonus = new BonusPoliticalCards(3); 
		try {
			GameState gameState2 = null; 
			bonus.giveBonus(player2, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
