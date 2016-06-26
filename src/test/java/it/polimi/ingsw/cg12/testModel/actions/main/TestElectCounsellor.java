package it.polimi.ingsw.cg12.testModel.actions.main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.main.ElectCounsellor;
import model.council.GarbageState;
import model.map.Map;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;
import utilities.Color;

public class TestElectCounsellor {

	@Test
	public void testIfDoActionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("Matt");
		player.setColor(new Color("black"));
		Player player2 = new Player();
		player2.setNickname("Mark");
		player2.setColor(new Color("white"));
		Player player3 = new Player();
		player3.setNickname("Tom");
		player3.setColor(new Color("orange"));
		Player player4 = new Player();
		player4.setNickname("Travis");
		player4.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(deck, id, parser);
			id++; 
		}
		int temp = player.getCoins().getItems(); 
		GameState gameState = new GameState(parser, players); 
		GarbageState garbageState = new GarbageState(parser); 
		Map map = new Map(parser, garbageState); 
		ElectCounsellor action = new ElectCounsellor(map.getRegions().get("seaside"), new Color("white"));
		action.doAction(player, gameState);
		assertTrue(temp==(player.getCoins().getItems()-4)); 
	}
}
