package dto.queries.respond;

import dto.DTOObject;
import dto.map.DTOCity;
import dto.playerInfo.DTOPlayerAdvanced;
import dto.utilities.DTOPermissionCard;

public class DTOPlayerInfoAdvancedResponse extends DTOPlayerInfoResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6130665530126994732L;
	
	private final DTOPlayerAdvanced player;
	
	public DTOPlayerInfoAdvancedResponse(DTOPlayerAdvanced player) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		this.player = player;
	}

	/**
	 * @return the player
	 */
	public DTOPlayerAdvanced getPlayer() {
		return player;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append("\n[SERVER] Nickname: " + player.getNickname() + " --> " + player.getColor().getColorString());
		msg.append("\n[SERVER] Coins: " + player.getCoins().getQuantity());
		msg.append("\n[SERVER] Assistants: " + player.getAssistants().getQuantity());
		msg.append("\n[SERVER] Nobility level: " + player.getNobilityLevel().getLevel());
		msg.append("\n[SERVER] Score: " + player.getScore().getLevel());
		
		msg.append("\n[SERVER] Political cards:");
		msg.append(this.player.getPoliticalHand());
		
		if (player.getPermissionCards().isEmpty()) {
			msg.append("\n[SERVER] You don't have any permission cards");
		} else {
			msg.append("\n[SERVER] Permission cards:");
			for (DTOPermissionCard permissionCard: player.getPermissionCards()) {
				msg.append(permissionCard);
			}
		}
		
		if (player.getBuiltCities().isEmpty()) {
			msg.append("\n[SERVER] You haven't built anywhere yet");
		} else {
			msg.append("\n[SERVER] Emporium built in: ");
			for (DTOCity city: player.getBuiltCities()) {
				msg.append(city.getName() + " ");
			}
			msg.append("\n");
		}

		return msg.toString();
	}
	
	

}
