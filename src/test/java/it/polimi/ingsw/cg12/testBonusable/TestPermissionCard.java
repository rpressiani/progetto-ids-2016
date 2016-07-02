package it.polimi.ingsw.cg12.testBonusable;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.map.City;
import model.player.Player;

public class TestPermissionCard {

	@Test
	public void testNullBonusesInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<BonusItem> bonuses = null; 
		HashSet<City> cities = new HashSet<City>(); 
		try {
			@SuppressWarnings("unused")
			PermissionCard card = new PermissionCard(bonuses, cities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullHashSetInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = null; 
		try {
			@SuppressWarnings("unused")
			PermissionCard card = new PermissionCard(bonuses, cities); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullPlayerInMakeExchangeThrowsException() {
		boolean thrown = false; 
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		PermissionCard card = new PermissionCard(bonuses, cities); 
		try {
			Player player = null; 
			Player player2 = new Player(); 
			card.makeExchange(player, player2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testMakeExchange() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		PermissionCard card = new PermissionCard(bonuses, cities); 
		Player player = new Player(); 
		Player player2 = new Player(); 
		player.getPermissionHand().add(card); 
		card.makeExchange(player, player2);
		assertTrue(player2.getPermissionHand().contains(card) && !player.getPermissionHand().contains(card)); 
	}
	
	@Test
	public void testGetIdCard() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		PermissionCard card = new PermissionCard(bonuses, cities); 
		int temp = card.getIdCard(); 
		assertEquals(temp, card.getIdCard()); 
	}
	@Test
	public void testIsUsed() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		PermissionCard card = new PermissionCard(bonuses, cities);
		boolean temp = card.isUsed(); 
		assertEquals(temp, card.isUsed()); 
	}
	@Test
	public void testSetUsed() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		PermissionCard card = new PermissionCard(bonuses, cities);
		card.setUsed(true);
		assertTrue(card.isUsed()); 
	}
	@Test
	public void testGetCounter() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		@SuppressWarnings("unused")
		PermissionCard card = new PermissionCard(bonuses, cities);
		int temp = PermissionCard.getCounter(); 
		assertEquals(temp, PermissionCard.getCounter()); 
	}
	@Test
	public void testGetPossibleCities() {
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>(); 
		HashSet<City> cities = new HashSet<City>();
		PermissionCard card = new PermissionCard(bonuses, cities);
		Set<City> temp = card.getPossibleCities(); 
		assertEquals(temp, card.getPossibleCities()); 
	}

}
