package model.politicalDeck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jaxb.CFGPoliticalCard;
import model.market.Marketable;
import model.player.Player;
import parser.Parser;

public class PoliticalContainer extends PoliticalDeck implements Marketable {

	/**
	 * @param parser
	 * @param structure
	 * @throws NullPointerException if parser or structure are null
	 */
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
			}
			
		}
		
	}

	
	@Override
	public void makeExchange(Marketable m, Player fromPlayer, Player toPlayer) {
		if(fromPlayer==null || toPlayer==null) {
			throw new NullPointerException("both players should not be null"); 
		}
		
		PoliticalContainer proposal=(PoliticalContainer) m;
	
		for(int i=0; i<proposal.getDeck().size(); i++){
			fromPlayer.getPoliticalHand().getDeck().get(i).removeCards(proposal.getDeck().get(i).getNumCards());
			toPlayer.getPoliticalHand().getDeck().get(i).addCards(proposal.getDeck().get(i).getNumCards());
		}
		
	}

}
