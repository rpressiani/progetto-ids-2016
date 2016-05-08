/**
 * 
 */
package council;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.xml.bind.JAXBContext;

import politicalDeck.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class Balcony {
	
	private Queue<Counsellor> balcony;
	private final Integer nCounsellors;
	
	public Balcony(CounsellorGarbage garbage /*, Parser parser, File file*/ ) {
		this.balcony = new LinkedList<Counsellor>();
		this.nCounsellors = 0 /*nCouncellor will be something like:
		 						parser.nCounsellors(file);*/;
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
			else selectedIndex = (selectedIndex++) % 4;
		}
		
		return garbage.getReserve().get(selectedIndex).getColor();
	}

}
