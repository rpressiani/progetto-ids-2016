package dto.queries.respond;

import dto.DTOObject;
import dto.playerInfo.DTOPlayer;

public class DTOCurrentPlayerResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3221188911388221123L;
	
	private final DTOPlayer player;
	
	public DTOCurrentPlayerResponse(DTOPlayer player) {
		this.player = player;
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
		return "\n[SERVER] CURRENT PLAYER: " + player.getNickname() + "\n";
	}

}
