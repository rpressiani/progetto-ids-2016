/**
 * 
 */
package council;

import java.util.ArrayList;
import java.util.Iterator;

import parser.Parser;
import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class CounsellorGarbage {
	
	private ArrayList<CounsellorGroup> reserve;
	private Integer nColors;
	
	public CounsellorGarbage(Parser parser){
		this.reserve = new ArrayList<CounsellorGroup>();
		this.nColors = parser.getCFGPoliticalDeck().getColor().size();
		for (int i = 0; i < nColors; i++) {
			reserve.add(new CounsellorGroup(new Color(parser.getCFGPoliticalDeck().getColor().get(i)),
											parser.getCFGCouncil().getNInitialGroupReserve().intValue()));
		}
	}
	
	public void add(Color color){
		Iterator<CounsellorGroup> itr = reserve.iterator();
		while(itr.hasNext()){
			CounsellorGroup counsellorGroupItr = itr.next();
			if (counsellorGroupItr.getColor().equals(color)) {
				counsellorGroupItr.add();
			}
		}
	}

	public void remove(Color color){
		Iterator<CounsellorGroup> itr = reserve.iterator();
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
	public ArrayList<CounsellorGroup> getReserve() {
		return reserve;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CounsellorGarbage [reserve=" + reserve + ", nColors=" + nColors + "]";
	}

}
