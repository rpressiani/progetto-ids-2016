package dto.queries;

import java.util.HashSet;
import java.util.Set;

import dto.DTOObject;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColorCounter;
import dto.utilities.DTOPermissionCard;

public class DTOContract implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8698606138965181943L;

	private final int id;
	private final String seller;
	
	private DTOCoins sellCoins = new DTOCoins(0);
	private DTOAssistants sellAssistants = new DTOAssistants(0);
	private Set<DTOPermissionCard> sellPermissions = new HashSet<DTOPermissionCard>();
	private DTOColorCounter sellPoliticals;
	
	private DTOCoins buyCoins = new DTOCoins(0);
	private DTOAssistants buyAssistants = new DTOAssistants(0);
	private Set<DTOPermissionCard> buyPermissions = new HashSet<DTOPermissionCard>();
	private DTOColorCounter buyPoliticals;
	
	public DTOContract(String seller, int id) {
		this.seller = seller;
		this.id = id;
	}

	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the sellCoins
	 */
	public DTOCoins getSellCoins() {
		return sellCoins;
	}

	/**
	 * @param sellCoins the sellCoins to set
	 */
	protected void setSellCoins(DTOCoins sellCoins) {
		this.sellCoins = sellCoins;
	}

	/**
	 * @return the sellAssistants
	 */
	public DTOAssistants getSellAssistants() {
		return sellAssistants;
	}

	/**
	 * @param sellAssistants the sellAssistants to set
	 */
	protected void setSellAssistants(DTOAssistants sellAssistants) {
		this.sellAssistants = sellAssistants;
	}

	/**
	 * @return the sellPermissions
	 */
	public Set<DTOPermissionCard> getSellPermissions() {
		return sellPermissions;
	}

	/**
	 * @param sellPermissions the sellPermissions to set
	 */
	protected void setSellPermissions(Set<DTOPermissionCard> sellPermissions) {
		this.sellPermissions = sellPermissions;
	}

	/**
	 * @return the sellPoliticals
	 */
	public DTOColorCounter getSellPoliticals() {
		return sellPoliticals;
	}

	/**
	 * @param sellPoliticals the sellPoliticals to set
	 */
	protected void setSellPoliticals(DTOColorCounter sellPoliticals) {
		this.sellPoliticals = sellPoliticals;
	}

	/**
	 * @return the buyCoins
	 */
	public DTOCoins getBuyCoins() {
		return buyCoins;
	}

	/**
	 * @param buyCoins the buyCoins to set
	 */
	protected void setBuyCoins(DTOCoins buyCoins) {
		this.buyCoins = buyCoins;
	}

	/**
	 * @return the buyAssistants
	 */
	public DTOAssistants getBuyAssistants() {
		return buyAssistants;
	}

	/**
	 * @param buyAssistants the buyAssistants to set
	 */
	protected void setBuyAssistants(DTOAssistants buyAssistants) {
		this.buyAssistants = buyAssistants;
	}

	/**
	 * @return the buyPermissions
	 */
	public Set<DTOPermissionCard> getBuyPermissions() {
		return buyPermissions;
	}

	/**
	 * @param buyPermissions the buyPermissions to set
	 */
	protected void setBuyPermissions(Set<DTOPermissionCard> buyPermissions) {
		this.buyPermissions = buyPermissions;
	}

	/**
	 * @return the buyPoliticals
	 */
	public DTOColorCounter getBuyPoliticals() {
		return buyPoliticals;
	}

	/**
	 * @param buyPoliticals the buyPoliticals to set
	 */
	protected void setBuyPoliticals(DTOColorCounter buyPoliticals) {
		this.buyPoliticals = buyPoliticals;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("[SERVER] Items to sell:\n");
		msg.append("[SERVER]\t Coins: " + sellCoins.getQuantity() + "\n");
		msg.append("[SERVER]\t Assistants: " + sellAssistants.getQuantity() + "\n");
		msg.append("[SERVER]\t Permission cards:\n");
		for (DTOPermissionCard dtoPermissionCard : sellPermissions) {
			msg.append("[SERVER]\t\t " + dtoPermissionCard + "\n");
		}
		msg.append(sellPoliticals);
		
		msg.append("\n[SERVER] Items to buy:\n");
		msg.append("[SERVER]\t Coins: " + buyCoins.getQuantity() + "\n");
		msg.append("[SERVER]\t Assistants: " + buyAssistants.getQuantity() + "\n");
		msg.append("[SERVER]\t Permission cards:\n");
		for (DTOPermissionCard dtoPermissionCard : buyPermissions) {
			msg.append("[SERVER]\t\t " + dtoPermissionCard + "\n");
		}
		msg.append(buyPoliticals);
		
		return msg.toString();
	}

}
