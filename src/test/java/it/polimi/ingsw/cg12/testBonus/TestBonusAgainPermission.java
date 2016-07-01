package it.polimi.ingsw.cg12.testBonus;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.bonusItem.BonusAgainPermission;
import model.bonusItem.BonusInputItem;
import model.bonusable.PermissionCard;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestBonusAgainPermission {

	@Test
	public void testGiveBonusWorksWithNoPermissionCards() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Sergio");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		ArrayList<BonusInputItem> temp = player.getBonusInputs(); 
		BonusAgainPermission bonus = new BonusAgainPermission(); 
		bonus.giveBonus(player, gameState);
		assertTrue(temp==player.getBonusInputs()); 
	}
	@Test
	public void testGiveBonusWorksWithPermissionCards() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Sergio");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players);
		BonusAgainPermission bonus = new BonusAgainPermission(); 
		PermissionCard card = 
				gameState.getMap().getRegions().get("seaside").getPermissionDeck().getDeck().get(0);
		player.getPermissionHand().add(card); 
		bonus.giveBonus(player, gameState);
		assertTrue(player.getBonusInputs().contains(bonus)); 
	}

}
