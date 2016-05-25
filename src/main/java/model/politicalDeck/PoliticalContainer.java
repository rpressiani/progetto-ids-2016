package model.politicalDeck;

import java.util.ArrayList;
import java.util.Iterator;

import jaxb.CFGPoliticalCard;
import parser.Parser;

public class PoliticalContainer extends PoliticalDeck {

	public PoliticalContainer(Parser parser, ArrayList<Integer> structure) {
		super(parser);
		int i = 0;
		for (Iterator<CFGPoliticalCard> iterator = parser.getCFGPoliticalDeck().getPoliticalCard().iterator(); iterator.hasNext();) {
			CFGPoliticalCard cfgPoliticalCard = iterator.next();
			this.getDeck().add(new PoliticalCard(cfgPoliticalCard.getColor(), structure.get(i)));
			i++;
		}
	}
	
	

}
