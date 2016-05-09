/**
 * 
 */
package council;

import parser.Parser;
import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class GarbageState extends CouncilState {

	public GarbageState(Parser parser) {
		super(parser);
		for (int i = 0; i < this.getnColors(); i++) {
		this.getState().add(new CounsellorGroup(new Color(parser.getCFGPoliticalDeck().getColor().get(i)),
											 		parser.getCFGCouncil().getNInitialGroupReserve().intValue()));
		}
	}
}
