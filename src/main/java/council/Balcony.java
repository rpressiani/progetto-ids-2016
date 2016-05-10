/**
 * 
 */
package council;

import java.util.Iterator;
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
	
	/**
	 * @return the balcony
	 */
	public Queue<Counsellor> getBalcony() {
		return balcony;
	}


	/**
	 * @return the balconyState
	 */
	public BalconyState getBalconyState() {
		return balconyState;
	}


	/**
	 * @return the nCounsellorsPerBalcony
	 */
	public Integer getnCounsellorsPerBalcony() {
		return nCounsellorsPerBalcony;
	}


	/**
	 * @return the nColors
	 */
	public Integer getnColors() {
		return nColors;
	}

	private Queue<Counsellor> balcony;
	private BalconyState balconyState;
	private final Integer nCounsellorsPerBalcony;
	private final Integer nColors;
	
	public Balcony(GarbageState garbage, Parser parser) {
		this.nCounsellorsPerBalcony = parser.getCFGCouncil().getNCounsellorsPerBalcony().intValue();
		this.balcony = new LinkedBlockingQueue<Counsellor>(nCounsellorsPerBalcony);
		this.nColors = parser.getCFGPoliticalDeck().getColor().size();
		
		for (int i = 0; i < nCounsellorsPerBalcony; i++) {
			Color randomColor = getRandomCounsellor(garbage);
//			Color randomColor = new Color("red");
			this.balcony.add(new Counsellor(randomColor));
			garbage.remove(randomColor);
		}
		this.balconyState = new BalconyState(parser);
		this.initBalconyState();
	}
	

	public void putCounsellor(Color color, GarbageState garbage){
		garbage.add(this.balcony.element().getColor());
		this.balconyState.remove(this.balcony.element().getColor());
		this.balcony.remove();
		garbage.remove(color);
		this.balcony.add(new Counsellor(color));
		this.balconyState.add(color);
	}
	
	private Color getRandomCounsellor(GarbageState garbage){
		Random rn = new Random();
		int selectedIndex = rn.nextInt(this.nColors);
		for (int i = 0; i < nColors; i++) {
			int groupCounter = garbage.getState().get(selectedIndex).getCounter();
//			System.out.println(groupCounter);
			if (groupCounter > 0) {
				break;
			}
			else selectedIndex = (selectedIndex++) % garbage.getState().size();
		}
		
		return garbage.getState().get(selectedIndex).getColor();
	}
	
	private void initBalconyState(){
		Iterator<Counsellor> itr = balcony.iterator();
		while(itr.hasNext()){
			Counsellor counsellorItr = itr.next();
			this.balconyState.add(counsellorItr.getColor());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Balcony [balconyState=" + balconyState + "]";
	}

}
