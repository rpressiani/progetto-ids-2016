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
			DTOSellAction action = 
					new DTOSellAction(new DTOCoins(sellCoins), new DTOAssistants(sellAssistants), sellPermissions, sellPoliticals, 
							new DTOCoins(buyCoins), new DTOAssistants(buyAssistants), buyPermissions, buyPoliticals);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
