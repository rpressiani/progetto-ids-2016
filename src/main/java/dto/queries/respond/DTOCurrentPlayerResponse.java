package dto.queries.respond;

import dto.DTOObject;
import dto.playerInfo.DTOPlayerBasic;

public class DTOCurrentPlayerResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3221188911388221123L;
	
	private final DTOPlayerBasic player;
	
	public DTOCurrentPlayerResponse(DTOPlayerBasic player) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		this.player = player;
	}

	/**
	 * @return the player
	 */
	public DTOPlayerBasic getPlayer() {
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
