/**
 * 
 */
package model.council;

import parser.Parser;
import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class GarbageState extends CouncilState {

	/**
	 * Constructor
	 * Calls CouncilState constructor
	 * @param parser
	 * @throws NullPointerException if parser is null
	 */
	public GarbageState(Parser parser) {
		super(parser);
		for (int i = 0; i < this.getnColors(); i++) {
		this.getState().add(new CounsellorGroup(new Color(parser.getCFGPoliticalDeck().getPoliticalCard().get(i).getColor()),
											 		parser.getCFGCouncil().getNInitialGroupReserve().intValue()));
		}
	}
}
