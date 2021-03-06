package it.polimi.ingsw.cg12.testModel.actions.main;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.map.Ancestry;
import model.map.City;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBuildEmporiumWithCard {
	
	@Test
	public void testIfCheckConditionWorks() {
		Parser parser = new Parser();
		Player player = new Player();
		player.setNickname("Kevin");
		player.setColor(new Color("blue"));
		Player player2 = new Player();
		player2.setNickname("Russel");
		player2.setColor(new Color("black"));
		Player player3 = new Player();
		player3.setNickname("Stephen");
		player3.setColor(new Color("white"));
		Player player4 = new Player();
		player4.setNickname("Klay");
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
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		HashSet<City> cities = new HashSet<City>();
		City city = gameState.getMap().getAllCitiesHashMap().get("A");
		cities.add(city); 
		PermissionCard card = new PermissionCard(bonuses, cities);
		BuildEmporiumWithCard action = new BuildEmporiumWithCard(card, city);
		assertTrue(action.checkCondition(player, gameState)); 
	}

}
