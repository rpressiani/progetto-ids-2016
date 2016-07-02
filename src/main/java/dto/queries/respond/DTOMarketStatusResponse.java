package dto.queries.respond;

import java.util.Iterator;
import java.util.Map;

import dto.DTOObject;
import dto.queries.DTOContract;

public class DTOMarketStatusResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7672161989409126013L;
	
	private final Map<String, DTOContract> contracts;
	
	public DTOMarketStatusResponse(Map<String, DTOContract> contracts) {
		this.contracts = contracts;
	}

	/**
	 * @return the contracts
	 */
	public Map<String, DTOContract> getContracts() {
		return contracts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("\n[SERVER] Market status:\n");
		for (Map.Entry<String, DTOContract> entry : this.contracts.entrySet()) {
			msg.append("[SERVER] Player: " + entry.getKey() + "\n");
			msg.append(entry.getValue());
		}
		
		return msg.toString();
	}
	
	

}