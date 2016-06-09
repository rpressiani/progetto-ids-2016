package dto.queries.respond;

import dto.DTOObject;

public class DTOPingResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4829973810784350744L;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder ping = new StringBuilder();
		ping.append("\n[SERVER] Ping received\n");
		ping.append("[SERVER] Client connected\n");
		ping.append("[SERVER] Server is responding\n");
		
		
		return ping.toString();
	}
	
	

}
