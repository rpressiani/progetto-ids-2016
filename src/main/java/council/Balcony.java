/**
 * 
 */
package council;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import parser.Parser;
import utilities.Color;


/**
 * @author Riccardo Pressiani
 *
 */
public class Balcony {
	
	private Queue<Counsellor> balcony;
	private final Integer nCounsellors;
	private final Integer nColors;
	private final Integer nInitialReserveGroup;
	
//	Inserire una struttura per gestire la quantità di consiglieri
//	di un dato colore allo stesso modo di come sono gestite le carte politica
	
	public Balcony(CounsellorGarbage garbage, Parser parser ) {
		this.nCounsellors = parser.getCFGCouncil().getNCounsellors().intValue();
		this.balcony = new LinkedBlockingQueue<Counsellor>(nCounsellors);
		this.nInitialReserveGroup = parser.getCFGCouncil().getNInitialGroupReserve().intValue();
		this.nColors = parser.getCFGPoliticalDeck().getColor().size();
		
		for (int i = 0; i < nInitialReserveGroup; i++) {
			Color randomColor = getRandomCounsellor(garbage);
//			Color randomColor = new Color("red");
			this.balcony.add(new Counsellor(randomColor));
			garbage.remove(randomColor);
		}
	}
	
	public void electCounsellor(Color color, CounsellorGarbage garbage){
		garbage.add(this.balcony.element().getColor());
		this.balcony.remove();
		garbage.remove(color);
		this.balcony.add(new Counsellor(color));
	}
	
	private Color getRandomCounsellor(CounsellorGarbage garbage){
		Random rn = new Random();
		int selectedIndex = rn.nextInt(this.nColors);
		for (int i = 0; i < nColors; i++) {
			int groupCounter = garbage.getReserve().get(selectedIndex).getCounter();
			if (groupCounter > 0) {
				break;
			}
			else selectedIndex = (selectedIndex++) % garbage.getReserve().size();
		}
		
		return garbage.getReserve().get(selectedIndex).getColor();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Balcony [balcony=" + balcony + ", nCounsellors=" + nCounsellors + "]";
	}

}
