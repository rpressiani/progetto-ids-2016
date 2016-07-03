package it.polimi.ingsw.cg12.testModel.actions.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.main.BuyPermissionCard;
import model.bonusable.PermissionCard;
import model.council.Balcony;
import model.map.Region;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;
import model.politicalDeck.PoliticalHand;
import parser.Parser;
import utilities.Color;

public class TestBuyPermissionCard {

	@Test
	public void testNullContainerInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		int index = 2; 
		PoliticalContainer proposal = null; 
		try {
			@SuppressWarnings("unused")
			BuyPermissionCard action = new BuyPermissionCard(region, proposal, index);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfDoActionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
		}
		Region region = gameState.getMap().getRegions().get("seaside"); 
		int index = 0; 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(3); 
		structure.add(3); 
		structure.add(3); 
		structure.add(3); 
		structure.add(3); 
		structure.add(3); 
		structure.add(3); 
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		player.getCoins().add(10);
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(index);  
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, index);
		action.doAction(player, gameState);
		assertTrue(player.getPermissionHand().contains(card)); 
	}
	@Test
	public void testCheckHand() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		for(Player p : players) {
			p.initPlayer(gameState.getPoliticalDeck(), id, parser);
		}
		Region region = gameState.getMap().getRegions().get("seaside"); 
		int index = 0; 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		player.getCoins().add(10);
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, index); 
		assertFalse(action.checkHand(player.getPoliticalHand(), proposal)); 
	}
	@Test
	public void testNullContainerInCheckProposalThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Teo");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony();
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		PoliticalContainer proposal2 = null; 
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0); 
		try {
			action.checkProposal(proposal2, balcony); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullBalconyInCheckProposalThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("Teo");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		Balcony balcony = null;
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0); 
		try {
			action.checkProposal(proposal, balcony); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testCheckProposal() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ricky");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0);
		Balcony balcony = gameState.getMap().getRegions().get("seaside").getBalcony(); 
		assertFalse(action.checkProposal(proposal, balcony));
	}
	@Test
	public void testCalculateNumCards() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ricky");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0);
		int temp = 0;
		for(PoliticalCard c : proposal.getDeck()) {
			temp = temp + c.getNumCards(); 
		}
		assertEquals(temp, action.calculateNumCards(proposal)); 
	}
	@Test
	public void testHandExceptionInSubProposal() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ricky");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0);
		try {
			PoliticalHand hand = null; 
			action.subProposal(hand, proposal);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testProposalExceptionInSubProposal() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ricky");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0);
		try {
			PoliticalHand hand = player.getPoliticalHand(); 
			PoliticalContainer proposal2 = null; 
			action.subProposal(hand, proposal2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testCheckCondition() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ricky");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1); 
		structure.add(1);
		PoliticalContainer proposal = 
				new PoliticalContainer(parser, structure);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		BuyPermissionCard action = new BuyPermissionCard(region, proposal, 0);
		assertFalse(action.checkCondition(player, gameState)); 
	}
}
