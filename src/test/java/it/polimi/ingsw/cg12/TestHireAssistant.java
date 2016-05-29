package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.quick.HireAssistant;
import model.council.GarbageState;
import model.map.Map;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;
import utilities.Color;

public class TestHireAssistant {

	@Test
	public void testHireAssistantsWorks() {
		Parser parser = new Parser(); 
		GarbageState garbageState = new GarbageState(parser); 
		Player player = new Player("Ciro", new Color("blue")); 
		Player player2 = new Player("Ivo", new Color("red"));
		Player player3 = new Player("Enzo", new Color("black"));
		Player player4 = new Player("Sergio", new Color("white"));
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		int id=0; 
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		players.add(player2); 
		players.add(player3); 
		players.add(player4); 
		for(Player p : players) {
			player.initPlayer(deck, id, parser);
			id++; 
		}
		Map map = new Map(parser, garbageState); 
		GameState gameState = new GameState(parser, players); 
		HireAssistant action = new HireAssistant();
		Integer tempCoins = player.getCoins().getItems(); 
		Integer tempAssistants = player.getAssistants().getItems(); 
		action.doAction(player, gameState);
		assertTrue(tempCoins!=player.getCoins().getItems() && tempAssistants!=player.getAssistants().getItems()); 
		
		
	}

}
