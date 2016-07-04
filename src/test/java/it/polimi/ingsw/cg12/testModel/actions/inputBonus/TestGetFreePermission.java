package it.polimi.ingsw.cg12.testModel.actions.inputBonus;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.inputBonus.GetFreePermission;
import model.bonusItem.BonusFreePermission;
import model.bonusable.PermissionCard;
import model.map.Region;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestGetFreePermission {

	@Test
	public void testDoAction() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		player.getBonusInputs().add(new BonusFreePermission()); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		GetFreePermission bonus = new GetFreePermission(region, 0);
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		bonus.doAction(player, gameState);
		assertTrue(player.getPermissionHand().contains(card)); 
	}
	@Test
	public void testCheckCondition() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		player.getBonusInputs().add(new BonusFreePermission()); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		GetFreePermission bonus = new GetFreePermission(region, 0);
		assertTrue(bonus.checkCondition(player, gameState)); 
	}

}
