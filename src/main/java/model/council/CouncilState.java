/**
 * 
 */
package model.council;

import java.util.ArrayList;
import java.util.Iterator;

import parser.Parser;
import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public abstract class CouncilState {
	
	private ArrayList<CounsellorGroup> state;
	private Integer nColors;
	
	public CouncilState(Parser parser){
		this.state = new ArrayList<CounsellorGroup>();
		this.nColors = parser.getCFGPoliticalDeck().getNumColors().intValue();
	}
	
	/**
	 * @param color of the counsellor to add
	 * @throws NullPointerException if color is null
	 */
	public void add(Color color){
		if(color==null) {
			throw new NullPointerException("can't pass a null color"); 
		}
		Iterator<CounsellorGroup> itr = state.iterator();
		while(itr.hasNext()){
			CounsellorGroup counsellorGroupItr = itr.next();
			if (counsellorGroupItr.getColor().equals(color)) {
				counsellorGroupItr.add();
			}
		}
	}

	/**
	 * @param color of the counsellor to remove
	 * @throws NullPointerException if color is null
	 */
	public void remove(Color color){
		if(color==null) {
			throw new NullPointerException("can't remove with a null color"); 
		}
		Iterator<CounsellorGroup> itr = state.iterator();
		while(itr.hasNext()){
			CounsellorGroup counsellorGroupItr = itr.next();
			if (counsellorGroupItr.getColor().equals(color)) {
				counsellorGroupItr.remove();
			}
		}
	}
	
	/**
	 * @return the reserve
	 */
	public ArrayList<CounsellorGroup> getState() {
		return state;
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
		return "CouncilState [reserve=" + state + ", nColors=" + nColors + "]";
	}

}
