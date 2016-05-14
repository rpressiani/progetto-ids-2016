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
public class BalconyState extends CouncilState {

	public BalconyState(Parser parser) {
		super(parser);
		for (int i = 0; i < this.getnColors(); i++) {
			this.getState().add(new CounsellorGroup(new Color(parser.getCFGPoliticalDeck().getPoliticalCard().get(i).getColor()), 0));
		}
	}
}
