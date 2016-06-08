package it.polimi.ingsw.cg12.testBonusable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusItem;
import model.bonusable.RegionCard;
import model.map.Region;
import model.player.Player;
import parser.Parser;

public class TestRegionCard {

	@Test
	public void testNullRegionInConstructorThrowsException() {
		boolean thrown = false; 
		Region region = null; 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		try {
			RegionCard card = new RegionCard(bonuses, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullBonusesInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<BonusItem> bonuses = null;  
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside");
		try {
			RegionCard card = new RegionCard(bonuses, region); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetRegionWorks() {
		Parser parser = new Parser();
		Player player = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();  
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		Region region = gameState.getMap().getRegions().get("seaside");
		RegionCard card = new RegionCard(bonuses, region); 
		Region temp = card.getRegion(); 
		assertEquals(temp, card.getRegion()); 
	}
}
