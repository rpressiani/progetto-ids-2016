/**
 * 
 */
package model.council;

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
	private Queue<Counsellor> balcony;
	private BalconyState balconyState;
	private final Integer nCounsellorsPerBalcony;
	private final Integer nColors;
	
	/**
	 * @param garbage
	 * @param parser
	 * @throws NullPointerException if garbage or parser are null
	 */
	public Balcony(GarbageState garbage, Parser parser) {
		if(garbage==null) {
			throw new NullPointerException("cannot have a null garbage"); 
		}
		if(parser==null) {
			throw new NullPointerException("cannot have a null parser"); 
		}
		this.nCounsellorsPerBalcony = parser.getCFGCouncil().getNCounsellorsPerBalcony().intValue();
		this.balcony = new LinkedBlockingQueue<Counsellor>(nCounsellorsPerBalcony);
		this.nColors = parser.getCFGPoliticalDeck().getNumColors().intValue();
		
		for (int i = 0; i < nCounsellorsPerBalcony; i++) {
			Color randomColor = getRandomCounsellor(garbage);
			this.balcony.add(new Counsellor(randomColor));
			garbage.remove(randomColor);
		}
		this.balconyState = new BalconyState(parser);
		this.initBalconyState();
	}
	

	/**
	 * @param color of the garbage
	 * @param garbage counsellors not in the game 
	 * @throws NullPointerException if color is null
	 * @throws NullPointerException is garbage is null
	 */
	public void putCounsellor(Color color, GarbageState garbage){
		if(color==null) {
			throw new NullPointerException("counsellor color cannot be null"); 
		}
		if(garbage==null) {
			throw new NullPointerException("we should 'take' the counsellor from an existing garbage"); 
		}
		garbage.add(this.balcony.element().getColor());
		this.balconyState.remove(this.balcony.element().getColor());
		this.balcony.remove();
		garbage.remove(color);
		this.balcony.add(new Counsellor(color));
		this.balconyState.add(color);
	}
	
	/**
	 * @param garbage
	 * @return Color of the counsellor
	 * @throws NullPointerException if garbage is null
	 */
	private Color getRandomCounsellor(GarbageState garbage){
		if(garbage==null) {
			throw new NullPointerException("garbage cannot be null"); 
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Balcony [balconyState=" + balconyState + "]";
	}

}
