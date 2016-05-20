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
	
	public void add(Color color){
		Iterator<CounsellorGroup> itr = state.iterator();
		while(itr.hasNext()){
			CounsellorGroup counsellorGroupItr = itr.next();
			if (counsellorGroupItr.getColor().equals(color)) {
				counsellorGroupItr.add();
			}
		}
	}

	public void remove(Color color){
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
