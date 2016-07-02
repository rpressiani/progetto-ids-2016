package dto.utilities;

import java.util.Map;
import java.util.Map.Entry;

import dto.DTOObject;

public class DTOColorCounter implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1547245534944554302L;
	
	private final Map<DTOColor, Integer> structure;
	
	public DTOColorCounter(Map<DTOColor, Integer> structure) {
		if(structure==null) {
			throw new NullPointerException("structure cannot be null"); 
		}
		this.structure = structure;
	}

	/**
	 * @return the politicalHand
	 */
	public Map<DTOColor, Integer> getStructure() {
		return structure;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		for (Entry<DTOColor, Integer> entry : structure.entrySet()){
			msg.append("\n[SERVER]\t" + entry.getKey().getColorString() + ": " + entry.getValue());
		}
		
		return msg.toString();
	}
	
	

}
