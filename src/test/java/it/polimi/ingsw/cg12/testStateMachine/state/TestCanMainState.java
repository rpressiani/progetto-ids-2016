package it.polimi.ingsw.cg12.testStateMachine.state;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.ElectCounsellor;
import model.bonusable.PermissionCard;
import model.council.CounsellorGroup;
import model.map.City;
import model.map.Region;
import model.player.Player;
import model.stateMachine.CanMainState;
import model.stateMachine.CanSellState;
import parser.Parser;
import utilities.Color;

public class TestCanMainState {

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
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		BuildEmporiumWithCard action = new BuildEmporiumWithCard(card, city); 
		CanMainState state = new CanMainState(); 
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
		BuildEmporiumWithCard action = null; 
		CanMainState state = new CanMainState(); 
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
		GameState gameState = new GameState(parser, players); 
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		BuildEmporiumWithCard action = new BuildEmporiumWithCard(card, city); 
		CanMainState state = new CanMainState(); 
		try {
			GameState gameState2 = null; 
			state.transition(player, action, gameState2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown);
	}
	@Test
	public void testTransitionWithMainActionWorks() {
		Parser parser = new Parser(); 
		Player player = new Player(); 
		player.setNickname("ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		Region region = gameState.getMap().getRegions().get("seaside"); 
		CounsellorGroup counsellorGroup = gameState.getCounsellorGarbage().getState().get(0);
		Color color = counsellorGroup.getColor(); 
		ElectCounsellor action = new ElectCounsellor(region.getBalcony(), color); 
		player.setState(new CanMainState());
		player.move(action, gameState);
		assertTrue(player.getState() instanceof CanSellState);  
	}
}
