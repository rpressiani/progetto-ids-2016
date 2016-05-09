/**
 * 
 */
package council;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import utilities.Color;


/**
 * @author Riccardo Pressiani
 *
 */
public class Balcony {
	
	private Queue<Counsellor> balcony;
	private final Integer nCounsellors;
	
//	Inserire una struttura per gestire la quantità di consiglieri
//	di un dato colore allo stesso modo di come sono gestite le carte politica
	
	public Balcony(CounsellorGarbage garbage /*, Parser parser, File file*/ ) {
		this.nCounsellors = 0 /*nCouncellor will be something like:
					parser.nCounsellors(file);*/;
		this.balcony = new LinkedBlockingQueue<Counsellor>(nCounsellors);
		
		for (int i = 0; i < nCounsellors; i++) {
			
			Color randomColor = getRandomCounsellor(garbage, nCounsellors);
			garbage.remove(randomColor);
			this.balcony.add(new Counsellor(randomColor));
			
		}
	}
	
	public void electCounsellor(Color color, CounsellorGarbage garbage){
		garbage.add(this.balcony.element().getColor());
		this.balcony.remove();
		garbage.remove(color);
		this.balcony.add(new Counsellor(color));
	}
	
	private Color getRandomCounsellor(CounsellorGarbage garbage, Integer nCounsellors){
		Random rn = new Random();
		int selectedIndex = rn.nextInt(nCounsellors);
		for (int i = 0; i < nCounsellors; i++) {
			int groupCounter = garbage.getReserve().get(selectedIndex).getCounter();
			if (groupCounter > 0) {
				break;
			}
			else selectedIndex = (selectedIndex++) % garbage.getReserve().size();
		}
		
		return garbage.getReserve().get(selectedIndex).getColor();
	}

}
