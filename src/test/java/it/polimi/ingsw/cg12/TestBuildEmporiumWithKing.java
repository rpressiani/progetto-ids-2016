package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.main.BuildEmporiumWithKing;
import model.map.City;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;
import parser.Parser;
import utilities.Color;

public class TestBuildEmporiumWithKing {

	@Test
	public void testNullContainerInConstructorThrowsException() {
		boolean thrown = false; 
		PoliticalContainer proposal = null; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		ArrayList<Player> players = new ArrayList<Player>();  
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		try {
			BuildEmporiumWithKing action = new BuildEmporiumWithKing(proposal, city); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullCityInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player();
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 1, parser);
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(2); 
		structure.add(3);
		structure.add(4); 
		structure.add(5); 
		structure.add(6); 
		structure.add(7); 
		PoliticalContainer proposal = new PoliticalContainer(parser, structure); 
		City city = null; 
		try {
			BuildEmporiumWithKing action = 
					new BuildEmporiumWithKing(proposal, city);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
