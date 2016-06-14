package dto.queries.respond;

import java.util.Map.Entry;

import dto.DTOObject;
import dto.utilities.DTOColor;
import dto.utilities.DTOColorCounter;

public class DTOFreeCounsellorsResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4587558060574177689L;
	
	private final DTOColorCounter garbageStatus;
	
	/**
	 * @param garbageStatus
	 * @throws NullPointerException if garbageStatus is null
	 */
	public DTOFreeCounsellorsResponse(DTOColorCounter garbageStatus) {
		if(garbageStatus==null) {
			throw new NullPointerException("garbageStatus cannot be null"); 
		}
		this.garbageStatus = garbageStatus;
	}

	/**
	 * @return the garbageStatus
	 */
	public DTOColorCounter getGarbageStatus() {
		return garbageStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("\n[SERVER] Counsellor reserve status:");
		
		for (Entry<DTOColor, Integer> entry : this.garbageStatus.getStructure().entrySet()){
			msg.append("\n[SERVER]\t" + entry.getKey().getColorString() + ": " + entry.getValue());
		}
		msg.append("\n");
		
		return msg.toString();
	}
	
	

}
