package it.polimi.ingsw.cg12.testStateMachine.state;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.GameState;
import model.actions.market.SellAction;
import model.bonusable.PermissionCard;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;
import model.stateMachine.CanBuyState;
import model.stateMachine.CanSellState;
import parser.Parser;
import utilities.Color;

public class TestCanSellState {

	@Test
	public void testNullPlayerInTransitionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		CanSellState state = new CanSellState();
		Coins sellCoins = new Coins(0); 
		Assistants sellAssistants = new Assistants(0);
		Set<PermissionCard> sellPermissions = new HashSet<PermissionCard>(); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(0); 
		structure.add(0);
		structure.add(0); 
		structure.add(0); 
		structure.add(0); 
		structure.add(0); 
		structure.add(0); 
		PoliticalContainer sellPoliticals = new PoliticalContainer(parser, structure); 
		Coins buyCoins = new Coins(0); 
		Assistants buyAssistants = new Assistants(0);
		Set<PermissionCard> buyPermissions = new HashSet<PermissionCard>();
		PoliticalContainer buyPoliticals = new PoliticalContainer(parser, structure);
		SellAction action = new SellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, buyCoins, buyAssistants, buyPermissions, buyPoliticals); 
		try {
			Player player2 = null; 
			state.transition(player2, action, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullActionInTransitionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		CanSellState state = new CanSellState();
		SellAction action = null; 
		try {
			state.transition(player, action, gameState);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGameStateInTransitionThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		CanSellState state = new CanSellState();
		Coins sellCoins = new Coins(0); 
		Assistants sellAssistants = new Assistants(0);
		Set<PermissionCard> sellPermissions = new HashSet<PermissionCard>(); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(0); 
		structure.add(0);
		structure.add(0); 
		structure.add(0); 
		structure.add(0); 
		structure.add(0); 
		structure.add(0); 
		PoliticalContainer sellPoliticals = new PoliticalContainer(parser, structure); 
		Coins buyCoins = new Coins(0); 
		Assistants buyAssistants = new Assistants(0);
		Set<PermissionCard> buyPermissions = new HashSet<PermissionCard>();
		PoliticalContainer buyPoliticals = new PoliticalContainer(parser, structure);
		SellAction action = new SellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, buyCoins, buyAssistants, buyPermissions, buyPoliticals); 
		try {
			GameState gameState2 = null; 
			state.transition(player, action, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}


}
