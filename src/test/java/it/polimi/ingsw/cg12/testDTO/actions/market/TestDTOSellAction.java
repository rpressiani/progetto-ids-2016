package it.polimi.ingsw.cg12.testDTO.actions.market;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import dto.actions.market.DTOSellAction;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOPermissionCardSelection;
import dto.utilities.DTOPoliticalContainer;

public class TestDTOSellAction {

	@Test
	public void testNegativeIntParameterInConstructorThrowsException() {
		boolean thrown = false; 
		int sellCoins = -1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		try {
			@SuppressWarnings("unused")
			DTOSellAction action = 
					new DTOSellAction(new DTOCoins(sellCoins), new DTOAssistants(sellAssistants), sellPermissions, sellPoliticals, 
							new DTOCoins(buyCoins), new DTOAssistants(buyAssistants), buyPermissions, buyPoliticals);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullSetInConstructorThrowsException() {
		boolean thrown = false; 
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		Set<DTOPermissionCardSelection> sellPermissions = null; 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		try {
			@SuppressWarnings("unused")
			DTOSellAction action = 
					new DTOSellAction(new DTOCoins(sellCoins), new DTOAssistants(sellAssistants), sellPermissions, sellPoliticals, 
							new DTOCoins(buyCoins), new DTOAssistants(buyAssistants), buyPermissions, buyPoliticals);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullArrayListInConstructorThrowsException() {
		boolean thrown = false; 
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = null;
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		try {
			@SuppressWarnings("unused")
			DTOSellAction action = 
					new DTOSellAction(new DTOCoins(sellCoins), new DTOAssistants(sellAssistants), sellPermissions, sellPoliticals, 
							new DTOCoins(buyCoins), new DTOAssistants(buyAssistants), buyPermissions, buyPoliticals);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetBuyCoins() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(coinsBuy, action.getBuyCoins()); 
	}
	@Test
	public void testGetSellCoins() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(coinsSell, action.getSellCoins()); 
	}
	@Test
	public void testGetBuyAssistants() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(assistantsBuy, action.getBuyAssistants()); 
	}
	@Test
	public void testGetSellAssistants() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(assistantsSell, action.getSellAssistants()); 
	}
	@Test
	public void testGetSellPermissions() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(sellPermissions, action.getSellPermissions()); 
	}
	@Test
	public void testGetBuyPermissions() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(buyPermissions, action.getBuyPermissions()); 
	}
	@Test
	public void testGetBuyPoliticals() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(buyPoliticals, action.getBuyPoliticals()); 
	}
	@Test
	public void testGetSellPoliticals() {
		int sellCoins = 1; 
		int buyCoins = 2; 
		int sellAssistants = 1; 
		int buyAssistants = 1; 
		DTOCoins coinsSell = new DTOCoins(sellCoins); 
		DTOAssistants assistantsSell = new DTOAssistants(sellAssistants); 
		DTOAssistants assistantsBuy = new DTOAssistants(buyAssistants); 
		DTOCoins coinsBuy = new DTOCoins(buyCoins); 
		Set<DTOPermissionCardSelection> sellPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		Set<DTOPermissionCardSelection> buyPermissions = 
				new HashSet<DTOPermissionCardSelection>(); 
		DTOPoliticalContainer sellPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOPoliticalContainer buyPoliticals = new DTOPoliticalContainer(new ArrayList<Integer>());
		DTOSellAction action = 
				new DTOSellAction(coinsSell, assistantsSell, sellPermissions, sellPoliticals, 
						coinsBuy, assistantsBuy, buyPermissions, buyPoliticals);
		assertEquals(sellPoliticals, action.getSellPoliticals()); 
	}
}
