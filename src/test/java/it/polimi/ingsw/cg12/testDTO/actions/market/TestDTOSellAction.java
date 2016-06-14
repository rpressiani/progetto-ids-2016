package it.polimi.ingsw.cg12.testDTO.actions.market;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import dto.actions.market.DTOSellAction;
import dto.utilities.DTOPermissionCardSelection;

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
		ArrayList<Integer> sellPoliticals = new ArrayList<Integer>(); 
		ArrayList<Integer> buyPoliticals = new ArrayList<Integer>(); 
		try {
			DTOSellAction action = 
					new DTOSellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, 
							buyCoins, buyAssistants, buyPermissions, buyPoliticals);
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
		ArrayList<Integer> sellPoliticals = new ArrayList<Integer>(); 
		ArrayList<Integer> buyPoliticals = new ArrayList<Integer>(); 
		try {
			DTOSellAction action = 
					new DTOSellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, 
							buyCoins, buyAssistants, buyPermissions, buyPoliticals);
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
		ArrayList<Integer> sellPoliticals = null; 
		ArrayList<Integer> buyPoliticals = new ArrayList<Integer>(); 
		try {
			DTOSellAction action = 
					new DTOSellAction(sellCoins, sellAssistants, sellPermissions, sellPoliticals, 
							buyCoins, buyAssistants, buyPermissions, buyPoliticals);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
