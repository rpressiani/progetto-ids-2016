package dto.utilities;

import java.util.HashSet;
import java.util.Set;

import dto.DTOObject;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;

public class DTOContract implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8698606138965181943L;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DTOContract [seller=" + seller + ", sellCoins=" + sellCoins + ", sellAssistants=" + sellAssistants
				+ ", sellPermissions=" + sellPermissions + ", sellPoliticals=" + sellPoliticals + ", buyCoins="
				+ buyCoins + ", buyAssistants=" + buyAssistants + ", buyPermissions=" + buyPermissions
				+ ", buyPoliticals=" + buyPoliticals + "]";
	}

	private final String seller;
	private DTOCoins sellCoins = new DTOCoins(0);
	private DTOAssistants sellAssistants = new DTOAssistants(0);
	private Set<DTOPermissionCard> sellPermissions = new HashSet<DTOPermissionCard>();
	private DTOPoliticalContainer sellPoliticals;
	
	private DTOCoins buyCoins = new DTOCoins(0);
	private DTOAssistants buyAssistants = new DTOAssistants(0);
	private Set<DTOPermissionCard> buyPermissions = new HashSet<DTOPermissionCard>();
	private DTOPoliticalContainer buyPoliticals;
	
	public DTOContract(String seller) {
		this.seller = seller;
	}

	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
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
	public void setSellCoins(DTOCoins sellCoins) {
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
	public void setSellAssistants(DTOAssistants sellAssistants) {
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
	public void setSellPermissions(Set<DTOPermissionCard> sellPermissions) {
		this.sellPermissions = sellPermissions;
	}

	/**
	 * @return the sellPoliticals
	 */
	public DTOPoliticalContainer getSellPoliticals() {
		return sellPoliticals;
	}

	/**
	 * @param sellPoliticals the sellPoliticals to set
	 */
	public void setSellPoliticals(DTOPoliticalContainer sellPoliticals) {
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
	public void setBuyCoins(DTOCoins buyCoins) {
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
	public void setBuyAssistants(DTOAssistants buyAssistants) {
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
	public void setBuyPermissions(Set<DTOPermissionCard> buyPermissions) {
		this.buyPermissions = buyPermissions;
	}

	/**
	 * @return the buyPoliticals
	 */
	public DTOPoliticalContainer getBuyPoliticals() {
		return buyPoliticals;
	}

	/**
	 * @param buyPoliticals the buyPoliticals to set
	 */
	public void setBuyPoliticals(DTOPoliticalContainer buyPoliticals) {
		this.buyPoliticals = buyPoliticals;
	}

}
