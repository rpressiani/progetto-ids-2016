/**
 * 
 */
package council;

import java.util.ArrayList;
import java.util.Iterator;

import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class CounsellorGarbage {
	
	private ArrayList<CounsellorGroup> reserve;
	
	public CounsellorGarbage(/*Parser parser, File file*/){
		this.reserve = new ArrayList<CounsellorGroup>();
//		Something like:
		
//		parser.initCounsellorGarbage(this.counsellorGarbage, file);
		
//		The instruction above will add to the counsellorGarbage the CounsellorGroup,
//		initialized with the data provided by the config file. 
	}
	
	public void add(Color color){
		Iterator<CounsellorGroup> itr = reserve.iterator();
		while(itr.hasNext()){
			if (itr.next().getColor().equals(color)) {
				itr.next().add();
			}
		}
	}

	public void remove(Color color){
		Iterator<CounsellorGroup> itr = reserve.iterator();
		while(itr.hasNext()){
			if (itr.next().getColor().equals(color)) {
				itr.next().remove();
			}
		}
	}
	
	/**
	 * @return the reserve
	 */
	public ArrayList<CounsellorGroup> getReserve() {
		return reserve;
	}

}
