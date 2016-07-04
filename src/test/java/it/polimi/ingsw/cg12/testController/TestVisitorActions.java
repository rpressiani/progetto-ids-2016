package it.polimi.ingsw.cg12.testController;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import controller.VisitorActions;
import dto.actions.DTOChatAction;
import dto.actions.DTONullAction;
import dto.actions.DTOQuitAction;
import dto.actions.inputBonus.DTODoAgainAction;
import dto.actions.inputBonus.DTOGetFreePermission;
import dto.actions.inputBonus.DTOGetFreeToken;
import dto.actions.main.DTOBuildEmporiumWithCard;
import dto.actions.main.DTOBuildEmporiumWithKing;
import dto.actions.main.DTOBuyPermissionCard;
import dto.actions.main.DTOElectCounsellor;
import dto.actions.main.DTOMainAction;
import dto.actions.market.DTOBuyAction;
import dto.actions.market.DTOSellAction;
import dto.actions.quick.DTOAddictionalAction;
import dto.actions.quick.DTOElectCounsellorWithAssistant;
import dto.actions.quick.DTOHireAssistant;
import dto.actions.quick.DTOSubstitutePermissionCards;
import dto.map.DTOCity;
import dto.map.DTORegion;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;
import model.GameState;
import model.actions.ChatAction;
import model.actions.NullAction;
import model.actions.QuitAction;
import model.actions.inputBonus.DoAgainAction;
import model.actions.inputBonus.GetFreePermission;
import model.actions.inputBonus.GetFreeToken;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.BuildEmporiumWithKing;
import model.actions.main.BuyPermissionCard;
import model.actions.main.ElectCounsellor;
import model.actions.market.BuyAction;
import model.actions.market.SellAction;
import model.actions.quick.AddictionalAction;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.actions.quick.HireAssistant;
import model.actions.quick.SubstitutePermissionCards;
import model.player.Player;
import parser.Parser;
import utilities.Color;

public class TestVisitorActions {

	@Test
	public void testNullGameSTateInConstructionThrowsException() {
		boolean thrown = false; 
		GameState gameState = null; 
		try {
			@SuppressWarnings("unused")
			VisitorActions visit = new VisitorActions(gameState); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testBuyPermissionCardVisitWorks() {
		Parser parser = new Parser(); 
		DTORegion region = new DTORegion("seaside"); 
		ArrayList<Integer> structure = new ArrayList<Integer>();
		structure.add(3);
		structure.add(3);
		structure.add(3);
		structure.add(3);
		structure.add(3);
		structure.add(3);
		structure.add(3);
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure); 
		DTOBuyPermissionCard DTOAction = new DTOBuyPermissionCard(region, proposal, 1); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("blue"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		player.initPlayer(gameState.getPoliticalDeck(), 0, parser);
		VisitorActions visitorActions = new VisitorActions(gameState); 
		BuyPermissionCard temp = visitorActions.visit(DTOAction, player);  
		assertTrue(temp!=null); 
	}
	@Test
	public void testBuildEmporiumWithKingVisit() {
		Parser parser = new Parser(); 
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer proposal = new DTOPoliticalContainer(structure); 
		DTOCity city = new DTOCity("A");
		DTOBuildEmporiumWithKing DTOAction = new DTOBuildEmporiumWithKing(proposal, city);
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState); 
		BuildEmporiumWithKing temp = visitorActions.visit(DTOAction, player);
		assertTrue(temp!=null); 
	}
	@Test
	public void testBuildEmporiumWithCardVisit() {
		Parser parser = new Parser(); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(1); 
		DTOCity city = new DTOCity("A"); 
		DTOBuildEmporiumWithCard DTOAction = new DTOBuildEmporiumWithCard(card, city); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		BuildEmporiumWithCard temp = visitorActions.visit(DTOAction, player); 
		assertTrue(temp!=null); 
	}
	@Test
	public void testElectCounsellorVisit() {
		Parser parser = new Parser(); 
		String balcony = "king";
		DTOColor color = new DTOColor("red"); 
		DTOElectCounsellor DTOAction = new DTOElectCounsellor(balcony, color); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		ElectCounsellor temp = visitorActions.visit(DTOAction);
		assertTrue(temp!=null); 		
	}
	@Test
	public void testAddictionalActionVisit() {
		Parser parser = new Parser(); 
		DTOMainAction DTOMain = new DTOElectCounsellor("king", new DTOColor("red")); 
		DTOAddictionalAction DTOAction = new DTOAddictionalAction(DTOMain); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		AddictionalAction temp = visitorActions.visit(DTOAction, player); 
		assertTrue(temp!=null); 
	}
	@Test
	public void testSubstitutePermissionCardVisit() {
		Parser parser = new Parser(); 
		DTORegion region = new DTORegion("seaside"); 
		DTOSubstitutePermissionCards DTOAction = new DTOSubstitutePermissionCards(region);
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof SubstitutePermissionCards); 
	}
	@Test
	public void testElectCounsellorWithAssistantVisit() {
		Parser parser = new Parser(); 
		DTOElectCounsellorWithAssistant DTOAction = new DTOElectCounsellorWithAssistant("king", new DTOColor("black"));
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof ElectCounsellorWithAssistant); 
	}
	@Test
	public void testHireAssistantVisit() {
		Parser parser = new Parser(); 
		DTOHireAssistant DTOAction = new DTOHireAssistant(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof HireAssistant); 
	}
	@Test
	public void testNullActionVisit() {
		Parser parser = new Parser(); 
		DTONullAction DTOAction = new DTONullAction(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof NullAction); 
	}
	@Test
	public void testSellActionVisit() {
		Parser parser = new Parser(); 
		DTOCoins sellCoins = new DTOCoins(1); 
		DTOAssistants sellAssistants = new DTOAssistants(1);
		Set<DTOPermissionCardSelection> sellPermissions = new HashSet<DTOPermissionCardSelection>();
		ArrayList<Integer> structure = new ArrayList<Integer>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(structure); 
		DTOCoins buyCoins = new DTOCoins(1); 
		DTOAssistants buyAssistants = new DTOAssistants(1); 
		Set<DTOPermissionCardSelection> buyPermissions = new HashSet<DTOPermissionCardSelection>();
		DTOPoliticalContainer buyPoliticals= new DTOPoliticalContainer(structure); 
		DTOSellAction DTOAction= 
				new DTOSellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, buyCoins, buyAssistants, buyPermissions, buyPoliticals);
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction, player) instanceof SellAction); 
	}
	@Test
	public void testBuyActionVisit() {
		Parser parser = new Parser(); 
		DTOBuyAction DTOAction = new DTOBuyAction(1); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof BuyAction);
	}
	@Test
	public void testGetFreePermissionVisit() {
		Parser parser = new Parser(); 
		DTORegion region = new DTORegion("seaside");
		DTOGetFreePermission DTOAction = new DTOGetFreePermission(region, 1); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof GetFreePermission); 
	}
	@Test
	public void testGetFreeTokenVisit() {
		Parser parser = new Parser(); 
		Set<DTOCity> cities = new HashSet<DTOCity>();
		DTOGetFreeToken DTOAction = new DTOGetFreeToken(cities);
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction, player) instanceof GetFreeToken); 
	}
	/* @Test
	public void testGetAgainBonusPermissionVisit() {
		Parser parser = new Parser(); 
		DTOPermissionCardSelection card = new DTOPermissionCardSelection(1); 
		DTOGetAgainBonusPermission DTOAction = new DTOGetAgainBonusPermission(card);
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		PermissionCard permissionCard = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(1);
		player.getPermissionHand().add(permissionCard); 
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction, player) instanceof GetAgainBonusPermission); 
	} */
	@Test
	public void testDoAgainActionVisit() {
		Parser parser = new Parser(); 
		DTOElectCounsellor elect = new DTOElectCounsellor("king", new DTOColor("white")); 
		DTODoAgainAction DTOAction = new DTODoAgainAction(elect); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction, player) instanceof DoAgainAction); 
	}
	@Test
	public void testQuitActionVisit() {
		Parser parser = new Parser(); 
		DTOQuitAction DTOAction = new DTOQuitAction(); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof QuitAction); 
	}
	@Test
	public void testChatActionVisit() {
		Parser parser = new Parser(); 
		DTOChatAction DTOAction = new DTOChatAction("hello"); 
		Player player = new Player(); 
		player.setNickname("Ale");
		player.setColor(new Color("red"));
		ArrayList<Player> players = new ArrayList<Player>(); 
		players.add(player); 
		GameState gameState = new GameState(parser, players); 
		int id = 0; 
		player.initPlayer(gameState.getPoliticalDeck(), id, parser);
		VisitorActions visitorActions = new VisitorActions(gameState);
		assertTrue(visitorActions.visit(DTOAction) instanceof ChatAction);
	}
}
