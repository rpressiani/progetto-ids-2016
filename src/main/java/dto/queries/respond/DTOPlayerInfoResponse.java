package dto.queries.respond;

import dto.DTOObject;
import dto.playerInfo.DTOPlayer;

public class DTOPlayerInfoResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3776144158415835424L;
	
	private final boolean error;
	private final DTOPlayer player;
	
	public DTOPlayerInfoResponse(DTOPlayer player) {
		
		this.error = false;
		this.player = player;
	}
	
	public DTOPlayerInfoResponse() {
		this.error = true;
		this.player = new DTOPlayer(-1, new String("error"));
	}

	/**
	 * @return the player
	 */
	public DTOPlayer getPlayer() {
		return player;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (error) {
			StringBuilder error = new StringBuilder();
			error.append("\n[SERVER] The player requested doesn't exist\n");
			error.append("[SERVER] Type 'getplayers' to get the players' nickname list\n");
			return error.toString();
		} else {
			StringBuilder msg = new StringBuilder();
			msg.append("\n[SERVER] player exist, getting info\n");
			return msg.toString();
		}
	}

}
