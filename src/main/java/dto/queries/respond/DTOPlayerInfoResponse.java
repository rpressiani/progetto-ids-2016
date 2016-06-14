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
	
	/**
	 * @param player
	 * @throws NullPointerException if player is null
	 */
	public DTOPlayerInfoResponse(DTOPlayer player) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		this.error = false;
		this.player = player;
	}
	
	public DTOPlayerInfoResponse() {
		this.error = true;
		this.player = null;
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
			
			msg.append("\n[SERVER] Nickname: " + player.getNickname() + " --> " + player.getColor().getColorString());
			msg.append("\n[SERVER] Coins: " + player.getCoins().getQuantity());
			msg.append("\n[SERVER] Assistants: " + player.getAssistants().getQuantity());
			msg.append("\n[SERVER] Nobility level: " + player.getNobilityLevel().getLevel());
			msg.append("\n[SERVER] Score: " + player.getScore().getLevel() + "\n");
			
			return msg.toString();
		}
	}

}
