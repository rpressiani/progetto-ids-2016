package it.polimi.ingsw.cg12.testMarket;

import static org.junit.Assert.*;

import org.junit.Test;

import model.market.Contract;
import model.market.Market;
import model.player.Player;
import utilities.Color;

public class TestMarket {

	@Test
	public void testNullContractThrowsException() {
		boolean thrown = false; 
		Contract contract = null; 
		Market market = new Market(); 
		try {
			market.addContract(contract);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testAddContractEffectivelyAddsContract() {
		Player player = new Player();
		player.setNickname("Ciro");
		player.setColor(new Color("red"));
		Contract contract = new Contract(player); 
		Market market = new Market(); 
		market.addContract(contract);
		assertTrue(market.getContractSet().contains(contract));
	}
	@Test
	public void testNullBuyerThrowsException() {
		boolean thrown = false; 
		Player player = new Player();
		player.setNickname("Gennaro");
		player.setColor(new Color("black"));
		Player player2 = null; 
		Market market = new Market(); 
		Contract contract = new Contract(player); 
		try {
			market.acceptContract(contract, player2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
