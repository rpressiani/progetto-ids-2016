package dto.queries.respond;

import java.util.Map.Entry;

import dto.DTOObject;
import dto.map.DTOCity;
import dto.playerInfo.DTOPlayerAdvanced;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCard;

public class DTOPlayerInfoAdvancedResponse extends DTOPlayerInfoResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6130665530126994732L;
	
	private final DTOPlayerAdvanced player;
	
	public DTOPlayerInfoAdvancedResponse(DTOPlayerAdvanced player) {
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
		for (Entry<DTOColor, Integer> entry : this.player.getPoliticalHand().getStructure().entrySet()){
			msg.append("\n[SERVER]\t" + entry.getKey().getColorString() + ": " + entry.getValue());
		}
		
		if (player.getPermissionCards().isEmpty()) {
			msg.append("\n[SERVER] You don't have any permission cards");
		} else {
			msg.append("\n[SERVER] Permission cards:");
			for (DTOPermissionCard permissionCard: player.getPermissionCards()) {
				msg.append("\n[SERVER]\t Card " + permissionCard.getIdCard() + ": cities -> ");
				for (DTOCity city: permissionCard.getCities()) {
					msg.append(city.getName() + " ");
				}
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
