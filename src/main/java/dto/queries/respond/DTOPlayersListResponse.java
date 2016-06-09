package dto.queries.respond;

import java.util.ArrayList;

import dto.DTOObject;
import dto.playerInfo.DTOPlayerBasic;

public class DTOPlayersListResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2885308369967294362L;
	
	private final ArrayList<DTOPlayerBasic> players;
	
	public DTOPlayersListResponse(ArrayList<DTOPlayerBasic> players) {
		this.players = players;
	}

	/**
	 * @return the players
	 */
	public ArrayList<DTOPlayerBasic> getPlayers() {
		return players;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("\n[SERVER] Players logged in this match:");
		for (DTOPlayerBasic player : players) {
			msg.append("\n[SERVER] " + player.getNickname() + "\t->\t" + player.getColor().getColorString());
		}
		msg.append("\n");
		
		return msg.toString();
	}

}
