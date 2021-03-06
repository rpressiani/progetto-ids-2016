package it.polimi.ingsw.cg12.testModel.actions.inputBonus;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.inputBonus.GetAgainBonusPermission;
import model.bonusItem.BonusAgainPermission;
import model.bonusable.PermissionCard;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestGetAgainBonusPermission {

	@Test
	public void testNullCardInConstructorThrowsException() {
		boolean thrown = false; 
		PermissionCard card = null; 
		try {
			@SuppressWarnings("unused")
			GetAgainBonusPermission bonus = new GetAgainBonusPermission(card); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
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
		player.getBonusInputs().add(new BonusAgainPermission()); 
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		GetAgainBonusPermission bonus = new GetAgainBonusPermission(card);
		bonus.doAction(player, gameState);
		assertTrue(player.getBonusInputs().isEmpty()); 
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
		player.getBonusInputs().add(new BonusAgainPermission()); 
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		GetAgainBonusPermission bonus = new GetAgainBonusPermission(card);
		assertTrue(bonus.checkCondition(player, gameState)); 
	}

}
