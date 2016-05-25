package model.politicalDeck;

import java.util.ArrayList;

import model.market.Marketable;
import model.player.Player;
import parser.Parser;

public class PoliticalMarketContainer extends PoliticalContainer implements Marketable {

	public PoliticalMarketContainer(Parser parser, ArrayList<Integer> structure) {
		super(parser, structure);
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
