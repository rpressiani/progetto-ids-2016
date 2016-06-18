package model.politicalDeck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jaxb.CFGPoliticalCard;
import model.market.Marketable;
import model.player.Player;
import parser.Parser;

public class PoliticalContainer extends PoliticalDeck implements Marketable{

	public PoliticalContainer(Parser parser, ArrayList<Integer> structure) {
		super(parser);
		if(structure==null) {
			throw new NullPointerException("structure should not be null"); 
		}
		int i = 0;
		List<CFGPoliticalCard> cfgPoliticalCardList = parser.getCFGPoliticalDeck().getPoliticalCard();
		System.out.println(cfgPoliticalCardList);
		if (structure.size() == cfgPoliticalCardList.size()) {
			for (Iterator<CFGPoliticalCard> iterator = cfgPoliticalCardList.iterator(); iterator.hasNext();) {
				CFGPoliticalCard cfgPoliticalCard = iterator.next();
				this.getDeck().add(new PoliticalCard(cfgPoliticalCard.getColor(), structure.get(i)));
				i++;
			}
		} else {
			for (CFGPoliticalCard cfgPoliticalCard : cfgPoliticalCardList) {
				this.getDeck().add(new PoliticalCard(cfgPoliticalCard.getColor(), -1));
				System.out.println("go");
			}
			
		}
		
	}

	
	@Override
	public void makeExchange(Player fromPlayer, Player toPlayer) {
		if(fromPlayer==null || toPlayer==null) {
			throw new NullPointerException("both players should not be null"); 
		}
		int i = 0;
		for (PoliticalCard card : fromPlayer.getPoliticalHand().getDeck()) {
			card.removeCards(this.getDeck().get(i).getNumCards());
		}
		i = 0;
		for (PoliticalCard card : toPlayer.getPoliticalHand().getDeck()) {
			card.addCards(this.getDeck().get(i).getNumCards());
		}

	}

	@Override
	public boolean verifyAdd(Player player) {
		if(player==null) {
			throw new NullPointerException("player should not be null"); 
		}
		int i = 0;
		for (PoliticalCard card : player.getPoliticalHand().getDeck()) {
			if (card.getColor() != this.getDeck().get(i).getColor() || card.getNumCards() < this.getDeck().get(i).getNumCards()) {
				return false;
			}
		}
		return true;
	}
}
